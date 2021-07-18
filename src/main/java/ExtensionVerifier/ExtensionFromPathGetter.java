package ExtensionVerifier;

public class ExtensionFromPathGetter implements IFileExtensionGetter{
    @Override
    public String getExtension(String filePath, String extensionFromPath) {
        for (int i = filePath.length() - 1; i >= 0; i--) {
            if (filePath.charAt(i) == '.' || filePath.charAt(i) == '/')
                return filePath.substring(i + 1);
        }
        return filePath;
    }
}
