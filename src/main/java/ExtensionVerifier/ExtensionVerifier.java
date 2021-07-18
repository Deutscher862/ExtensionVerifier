package ExtensionVerifier;

import java.util.ArrayList;

public class ExtensionVerifier {
    private final String[] files;
    private final FileExtensionGetter fileExtensionGetter;
    private final ArrayList<String> handledExtensions;

    public ExtensionVerifier(String[] filePaths) {
        this.files = filePaths;
        this.fileExtensionGetter = new FileExtensionGetter();
        this.handledExtensions = new ArrayList<>();

        for (Extension e : Extension.values()) {
            handledExtensions.add(e.toString());
        }
    }

    public void verifyFiles(){
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

    private void verifyFile(String filePath){
    }
}