package org.sandboxpowered.api.addon;

import com.electronwill.nightconfig.core.Config;
import com.github.zafarkhaja.semver.Version;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.Internal;

import javax.annotation.Nullable;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@Internal
public class AddonSpec implements AddonInfo {
    private static final Pattern MODID_PATTERN = Pattern.compile("[a-z0-9-_]{4,15}");
    private static final Predicate<String> MODID_PREDICATE = MODID_PATTERN.asPredicate();
    private final String addonId;
    private final Version version;
    private final String title;
    private final String description;
    private final String mainClass;
    private final List<String> authors;
    private final String url;
    private final LoadingSide side;
    private final URL path;
    private final Map<String, Boolean> platforms;

    private AddonSpec(String addonId, Version version, @Nullable String title, String description, String mainClass, List<String> authors, String url, LoadingSide side, URL path, Map<String, Boolean> platforms) {
        this.path = path;
        this.platforms = platforms;
        if (!MODID_PREDICATE.test(addonId))
            throw new IllegalArgumentException(String.format("addon ID '%s' does not match regex requirement '%s'", addonId, MODID_PATTERN.pattern()));
        this.addonId = addonId;
        this.version = version;
        if (title == null || title.isEmpty())
            title = addonId;
        this.title = title;
        this.description = description;
        this.mainClass = mainClass;
        if (authors.isEmpty())
            throw new IllegalArgumentException("authors does not meet minimum list requirement of 1");
        this.authors = authors;
        this.url = url;
        this.side = side;
    }

    public static AddonSpec from(Config config, URL path) {
        String id = config.get("id");
        Version version = Version.valueOf(config.get("version"));
        String title = config.contains("title") ? config.get("title") : id;
        String description = config.contains("description") ? config.get("description") : "";
        String mainClass = config.get("entrypoint");
        List<String> authors = config.get("authors");
        String url = config.contains("url") ? config.get("url") : "";
        String sideS = config.contains("side") ? config.get("side") : "COMMON";
        LoadingSide side = sideS.equalsIgnoreCase("CLIENT") ? LoadingSide.CLIENT : sideS.equalsIgnoreCase("SERVER") ? LoadingSide.SERVER : LoadingSide.COMMON;
        Map<String, Boolean> platforms = config.contains("platforms") ? config.get("platforms") : Collections.emptyMap();
        return new AddonSpec(id, version, title, description, mainClass, authors, url, side, path, platforms);
    }

    @Override
    public String getId() {
        return addonId;
    }

    @Override
    public Version getVersion() {
        return version;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getMainClass() {
        return mainClass;
    }

    @Override
    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public LoadingSide getSide() {
        return side;
    }

    @Override
    public URL getPath() {
        return path;
    }

    public Map<String, Boolean> getPlatforms() {
        return platforms;
    }

    @Override
    public PlatformSupport getPlatformSupport(Identity platform) {
        return platforms.containsKey(platform.toString()) ? platforms.get(platform.toString()) ? PlatformSupport.YES : PlatformSupport.NO : PlatformSupport.MAYBE;
    }
}