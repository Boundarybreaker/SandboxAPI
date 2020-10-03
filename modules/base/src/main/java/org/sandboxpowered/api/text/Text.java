package org.sandboxpowered.api.text;

import com.google.common.annotations.Beta;
import org.sandboxpowered.internal.InternalService;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

@Beta
public interface Text extends Message, Iterable<Text> {

    static Text literal(String text) {
        return InternalService.getInstance().createLiteralText(text);
    }

    static Text translatable(String text) {
        return InternalService.getInstance().createTranslatedText(text);
    }

    Text setStyle(Style style);

    Style getStyle();

    default void append(String string) {
        this.append(literal(string));
    }

    void append(Text text);

    String asString();

    String asFormattedString();

    String asTruncatedString(int sections);

    List<Text> getSiblings();

    Stream<Text> stream();

    Stream<Text> streamCopied();

    Text copy();

    Text deepCopy();

    Text styled(Consumer<Style> styleConsumer);

    Text formatted(Formatting... formatting);

    Text formatted(Formatting formatting);

    //TODO: copyWithoutChildren and Serializer?
}