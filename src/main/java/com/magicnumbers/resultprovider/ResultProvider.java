package com.magicnumbers.resultprovider;

import com.magicnumbers.extension.Extension;
import com.magicnumbers.extension.ExtensionFromPath;

public class ResultProvider {
    private final ExtensionComparator comparator = new ExtensionComparator();

    public ResultMessage getResult(ExtensionFromPath extensionFromPath, Extension extensionFromSignature, String filePath) {
        return comparator.compareExtensionsAndGetResult(extensionFromPath, extensionFromSignature, filePath);
    }
}
