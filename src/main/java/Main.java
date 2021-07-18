import ExtensionVerifier.ExtensionVerifier;

public class Main {
    public static void main(String[] args) {
        ExtensionVerifier verifier = new ExtensionVerifier(args);
        verifier.verifyFiles();
    }
}