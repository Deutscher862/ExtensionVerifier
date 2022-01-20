package com.magicnumbers.resultprovider;

import com.magicnumbers.extension.Extension;
import com.magicnumbers.extension.ExtensionFromPath;

/**
 * Compares files extensions
 *
 * @author Adam Niemiec
 */
class ExtensionComparator {

    ResultMessage compareExtensionsAndGetResult(ExtensionFromPath extensionFromPath, Extension extensionFromSignature, String filePath) {
        Result actualResult = Result.INVALID;

        if (extensionFromPath.enumExtension() == extensionFromSignature) {
            actualResult = Result.MATCH;
        }

        if (extensionFromSignature == Extension.UNSUPPORTED)
           actualResult = Result.UNSUPPORTED;

        return new ResultMessage(filePath, extensionFromPath, extensionFromSignature, actualResult);
    }
}