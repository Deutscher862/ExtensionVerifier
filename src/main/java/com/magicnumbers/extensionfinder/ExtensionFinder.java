package com.magicnumbers.extensionfinder;

import com.magicnumbers.extension.Extension;
import com.magicnumbers.extension.ExtensionFromPath;

/**
 * Provides extension finding
 *
 * @author Adam Niemiec
 */
public class ExtensionFinder {
    private final VerifierFromPath verifierFromPath = new VerifierFromPath();
    private final VerifierFromSignature verifierFromSignature = new VerifierFromSignature();

    public ExtensionFromPath findExtensionFromPath(String filePath) {
        return verifierFromPath.findExtension(filePath);
    }

    public Extension findExtensionFromSignature(String filePath) {
        return verifierFromSignature.findExtension(filePath);
    }
}