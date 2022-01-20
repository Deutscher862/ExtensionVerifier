package com.magicnumbers.extensionfinder;

import com.magicnumbers.extension.Extension;

/**
 * Provides method to verify file extension
 *
 * @author Adam Niemiec
 */
interface Finder {
    Extension findExtension(String filePath);

    static void informAboutFileNotFound(String filePath) {
        System.err.println("File " + filePath + " not found");
    }
}