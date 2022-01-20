package com.magicnumbers.extension;

/**
 * Contains supported extension types
 *
 * @author Adam Niemiec
 */
public enum Extension {
    GIF("47494638"),
    JPG("FFD8FF"),
    PNG("89504E470D0A1A0A"),
    PDF("255044462D"),
    TXT("text"),
    UNSUPPORTED("");

    private final String magicNumber;

    Extension(String value){
        this.magicNumber = value;
    }

    public String getMagicNumber() {
        return magicNumber;
    }
}