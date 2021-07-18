package ExtensionVerifier;

import java.io.IOException;

public interface IFileExtensionGetter {
    String getExtension(String filePath, String extensionFromPath) throws IOException;
}
