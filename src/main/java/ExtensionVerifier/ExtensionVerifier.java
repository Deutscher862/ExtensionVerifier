package ExtensionVerifier;

import java.io.*;
import java.util.ArrayList;

public class ExtensionVerifier {
    private final String[] files;
    private final ArrayList<String> handledExtensions;
    private final FileExtensionGetter fileExtensionGetter;

    public ExtensionVerifier(String[] fileNames) {
        this.files = fileNames;
        this.fileExtensionGetter = new FileExtensionGetter();
        this.handledExtensions = new ArrayList<>();

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
        String extensionFromPath = fileExtensionGetter.getExtensionFromName(filePath);

        if (!handledExtensions.contains(extensionFromPath))
            throw new IllegalArgumentException("File can not be handled");

        Extension extensionFromFile = fileExtensionGetter.getActualExtension(filePath, extensionFromPath);
        String actualExtension;
        if (extensionFromFile == null)
            actualExtension = "other";
        else
            actualExtension = extensionFromFile.toString();

        System.out.println("given extension: " + extensionFromPath
                + " actual extension: " + actualExtension);

        if (extensionFromPath.equals(actualExtension))
            System.out.println("OK");
        else
            throw new IllegalArgumentException("Invalid extension provided");
    }
}