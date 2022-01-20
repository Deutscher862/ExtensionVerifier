package com.magicnumbers.resultprovider;

/**
 * Contains various results of comparison
 *
 * @author Adam Niemiec
 */
enum Result {
    MATCH("OK"),
    INVALID("Provided extension is invalid"),
    UNSUPPORTED("Provided extension is not supported");

    private final String message;

    Result(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message + "\n";
    }
}
