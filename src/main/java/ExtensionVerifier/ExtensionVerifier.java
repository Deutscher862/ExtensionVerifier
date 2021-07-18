package ExtensionVerifier;

import java.io.*;
import java.util.ArrayList;

public class ExtensionVerifier {
    private final String[] files;
    private static ArrayList<String> handledExtensions;
    private static ExtensionFromPathGetter extensionFromPathGetter;
    private static ExtensionFromFileGetter extensionFromFileGetter;

    public ExtensionVerifier(String[] fileNames) {
        this.files = fileNames;
        ExtensionVerifier.handledExtensions = new ArrayList<>();
        ExtensionVerifier.extensionFromPathGetter = new ExtensionFromPathGetter();
        ExtensionVerifier.extensionFromFileGetter = new ExtensionFromFileGetter();

        for (Extension e : Extension.values()) {
            handledExtensions.add(e.toString());
        }
    }

    public void verifyFiles() throws IOException {
        System.out.println("=====================================================================\n");
        if (files.length == 0) {
            System.out.println("No files provided");
            return;
        }
        for (String filePath : files) {
            System.out.println("Checking file from path: " + filePath);
            verifyFile(filePath);
        }
        System.out.println("\n=====================================================================");
    }

    private void verifyFile(String filePath) throws IOException {
        String extensionFromPath = extensionFromPathGetter.getExtension(filePath, null);

        if (!handledExtensions.contains(extensionFromPath))
            throw new IllegalArgumentException("File can not be handled");

        String actualExtension = extensionFromFileGetter.getExtension(filePath, extensionFromPath);

        System.out.println("given extension: " + extensionFromPath
                        + " actual extension: " + actualExtension);

        if (extensionFromPath.equals(actualExtension))
            System.out.println("OK");
        else
            throw new IllegalArgumentException("Invalid extension provided");
    }
}