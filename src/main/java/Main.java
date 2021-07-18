import ExtensionVerifier.ExtensionVerifier;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ExtensionVerifier verifier = new ExtensionVerifier(args);
        verifier.verifyFiles();
    }
}