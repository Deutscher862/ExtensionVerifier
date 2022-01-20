package com.magicnumbers.extensionfinder;

import com.magicnumbers.extension.Extension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * Verifies file extension from its signature
 *
 * @author Adam Niemiec
 */
class VerifierFromSignature implements Finder {
    private final TextFileVerifier textFileVerifier = new TextFileVerifier();
    private final MagicNumberExtractor magicNumberExtractor = new MagicNumberExtractor();

    @Override
    public Extension findExtension(String filePath) {
        List<Byte> byteList;

        try {
            byte[] bytes = Files.readAllBytes(Path.of(filePath));

            byteList = List.of(changeToGeneric(bytes));
        } catch (IOException e) {
            Finder.informAboutFileNotFound(filePath);
            return Extension.UNSUPPORTED;
        }

        String header = magicNumberExtractor.getHeader(byteList);
        return verifyExtension(header, filePath);
    }

    private Byte[] changeToGeneric(byte[] bytes) {
        var result = new Byte[bytes.length];
        Arrays.setAll(result, x -> bytes[x]);
        return result;
    }

    private Extension findExtensionInSupportedFiles(String header) {
        Extension extensionFromHeader = Extension.UNSUPPORTED;
        for (Extension currentExtension : Extension.values()) {
            String magicNumber = currentExtension.getMagicNumber();
            if (header.startsWith(magicNumber)) extensionFromHeader = currentExtension;
        }
        return extensionFromHeader;
    }

    Extension verifyExtension(String header, String filePath) {
        Extension extension = findExtensionInSupportedFiles(header.toUpperCase());
        if (extension == Extension.UNSUPPORTED) {
            extension = textFileVerifier.findExtension(filePath);
        }
        return extension;
    }
}