package com.magicnumbers.extensionfinder;

import com.magicnumbers.extension.Extension;
import com.magicnumbers.extension.ExtensionFromPath;

/**
 * Verifies file extension form its path
 *
 * @author Adam Niemiec
 */
class VerifierFromPath {

    ExtensionFromPath findExtension(String filePath) {
        int i = filePath.lastIndexOf('.');
        if (i > 0)
            filePath = filePath.substring(i + 1);

        Extension enumExtension = changeExtensionToEnum(filePath.toUpperCase());
        return new ExtensionFromPath(enumExtension, filePath);
    }

    private Extension changeExtensionToEnum(String extensionFromPath){
        Extension extension;
        try {
            extension = Extension.valueOf(extensionFromPath);
        } catch (IllegalArgumentException e) {
            return Extension.UNSUPPORTED;
        }
        return extension;
    }
}