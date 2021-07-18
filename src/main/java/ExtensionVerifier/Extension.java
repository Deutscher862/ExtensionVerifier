package ExtensionVerifier;

public enum Extension {
    GIF("47494638"),
    JPG("FFD8FF"),
    PDF("255044462D"),
    PNG("89504E470D0A1A0A"),
    DOC("D0CF11E0A1B11AE1"),
    DOCX("504B0304"),
    HTML("68746D6C3E"),
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
            case PDF -> "pdf";
            case PNG -> "png";
            case DOC -> "doc";
            case DOCX -> "docx";
            case HTML -> "html";
            case TXT -> "txt";
        };
    }
}