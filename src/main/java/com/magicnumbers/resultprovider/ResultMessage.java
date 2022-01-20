package com.magicnumbers.resultprovider;

import com.magicnumbers.extension.Extension;
import com.magicnumbers.extension.ExtensionFromPath;

import java.util.Locale;

/**
 * @author Adam Niemiec
 */
public class ResultMessage {
    private final StringBuilder message = new StringBuilder();

    ResultMessage(String filePath, ExtensionFromPath extensionFromPath, Extension extensionFromSignature, Result result) {
        this.message.append(filePath)
                .append("\n")
                .append("Extension from path: ")
                .append(extensionFromPath.textExtension())
                .append(" Actual extension: ")
                .append(extensionFromSignature.name().toLowerCase(Locale.ROOT))
                .append("\n")
                .append(result);
    }

    public void print(){
        System.out.println(message);
    }
}