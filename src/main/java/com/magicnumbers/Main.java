package com.magicnumbers;

import com.magicnumbers.extensionfinder.ExtensionFinder;
import com.magicnumbers.extension.Extension;
import com.magicnumbers.extension.ExtensionFromPath;
import com.magicnumbers.resultprovider.ResultMessage;
import com.magicnumbers.resultprovider.ResultProvider;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("No files provided");
        }

        ExtensionFinder extensionFinder = new ExtensionFinder();
        ResultProvider resultProvider = new ResultProvider();
        ResultMessage resultMessage;

        for (String filePath : args) {

            ExtensionFromPath extensionFromPath = extensionFinder.findExtensionFromPath(filePath);
            Extension extensionFromSignature = extensionFinder.findExtensionFromSignature(filePath);

            resultMessage = resultProvider.getResult(extensionFromPath, extensionFromSignature, filePath);
            resultMessage.print();
        }
    }
}