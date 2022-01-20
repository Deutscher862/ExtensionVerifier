package com.magicnumbers.extensionfinder;

import com.magicnumbers.extension.Extension;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Checks if file has a txt extension
 *
 * @author Adam Niemiec
 */
class TextFileVerifier implements Finder {

    private String findMimeType(String filePath) {
        FileSystem fileSystems = FileSystems.getDefault();
        Path path = fileSystems.getPath(filePath);
        String type = "";
        try {
            type = Files.probeContentType(path);
        } catch (IOException | NullPointerException exception) {
            Finder.informAboutFileNotFound(filePath);
        }
        return type;
    }

    @Override
    public Extension findExtension(String filePath) {
        String type = findMimeType(filePath);

        if (type.equals("text/plain"))
            return Extension.TXT;
        return Extension.UNSUPPORTED;
    }
}