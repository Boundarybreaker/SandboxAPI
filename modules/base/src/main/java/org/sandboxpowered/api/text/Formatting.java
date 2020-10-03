package org.sandboxpowered.api.text;

import org.sandboxpowered.internal.InternalService;

import java.util.OptionalInt;

public interface Formatting {
    Formatting BLACK = get("BLACK");
    Formatting DARK_BLUE = get("DARK_BLUE");
    Formatting DARK_GREEN = get("DARK_GREEN");
    Formatting DARK_AQUA = get("DARK_AQUA");
    Formatting DARK_RED = get("DARK_RED");
    Formatting DARK_PURPLE = get("DARK_PURPLE");
    Formatting GOLD = get("GOLD");
    Formatting GRAY = get("GRAY");
    Formatting DARK_GRAY = get("DARK_GRAY");
    Formatting BLUE = get("BLUE");
    Formatting GREEN = get("GREEN");
    Formatting AQUA = get("AQUA");
    Formatting RED = get("RED");
    Formatting LIGHT_PURPLE = get("LIGHT_PURPLE");
    Formatting YELLOW = get("YELLOW");
    Formatting WHITE = get("WHITE");
    Formatting OBFUSCATED = get("OBFUSCATED");
    Formatting BOLD = get("BOLD");
    Formatting STRIKETHROUGH = get("STRIKETHROUGH");
    Formatting UNDERLINE = get("UNDERLINE");
    Formatting ITALIC = get("ITALIC");
    Formatting RESET = get("RESET");

    //TODO: getFormatAtEnd?

    int getColorIndex();

    boolean isModifier();

    boolean isColor();

    OptionalInt getColorValue();

    boolean affectsGlyphWidth();

    String getName();

    String toString();

    String strip(String toStrip);

    //TODO: byName, byColorIndex, byCode, getNames

    static Formatting get(String name) {
        return InternalService.getInstance().getFormatting(name);
    }
}