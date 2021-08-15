package ExtensionVerifier;

public enum Extension {
    GIF("47494638"),
    JPG("FFD8FF"),
    PDF("255044462D"),
    PNG("89504E470D0A1A0A"),
    DOC("D0CF11E0A1B11AE1"),
    DOCX("504B0304"),
    HTML("68746D6C3E"),
    TXT("EFBBBF");

    private final String value;

    Extension(String s) {
        this.value = s;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}