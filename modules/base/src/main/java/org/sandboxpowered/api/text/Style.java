package org.sandboxpowered.api.text;

import java.util.Optional;

public interface Style {

    Optional<Formatting> getColor();

    boolean isBold();

    boolean isItalic();

    boolean isStrikethrough();

    boolean isUnderlined();

    boolean isObfuscated();

    boolean isEmpty();

    //TODO: getClickEvent, getHoverEvent (as monos)

    Optional<String> getInsertion();

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
