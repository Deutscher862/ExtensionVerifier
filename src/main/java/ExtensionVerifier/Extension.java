package ExtensionVerifier;

public enum Extension {
    GIF("47494638"),
    JPG("FFD8FF"),
    TXT("text");

    private final String value;

    Extension(String s) {
        this.value = s;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return switch (this) {
            case GIF -> "gif";
            case JPG -> "jpg";
            case TXT -> "txt";
        };
    }
}