package org.sandboxpowered.sandbox.api.util.text;

import org.sandboxpowered.sandbox.api.util.Mono;

public interface Style {

    Mono<Formatting> getColor();

    boolean isBold();

    boolean isItalic();

    boolean isStrikethrough();

    boolean isUnderlined();

    boolean isObfuscated();

    boolean isEmpty();

    //TODO: getClickEvent, getHoverEvent (as monos)

    Mono<String> getInsertion();

    Style setColor(Formatting formatting);

    Style setBold(boolean bold);

    Style setItalic(boolean italic);

    Style setStrikethrough(boolean strikethrough);

    Style setUnderlined(boolean underlined);

    Style setObfuscated(boolean obfuscated);

    //TODO: setClickEvent, setHoverEvent

    Style setInsertion(String insertion);

    Style setParent(Style parent);

    String asString();

    Style getParent();

    //TODO: have impl do the toString, equals, hashCode

    Style deepCopy();

    Style copy();

    //TODO: Serializer?
}
