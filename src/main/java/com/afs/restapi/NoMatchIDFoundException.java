package com.afs.restapi;

import java.util.function.Supplier;

public class NoMatchIDFoundException extends RuntimeException {
    public NoMatchIDFoundException(){
        super("No match ID.");
    }
}
