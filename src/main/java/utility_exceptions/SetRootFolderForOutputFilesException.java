package utility_exceptions;

import starter.ArgumentsForUtility;

import java.io.IOException;

public class SetRootFolderForOutputFilesException extends RuntimeException {
    public SetRootFolderForOutputFilesException(String massage) {
        System.out.println("____________________________________________________");
        System.out.println("SetRootFolderForOutputFilesException");
        System.out.println(DuplicateReferenceException.ANSI_RED + "File = " + massage + " - was not set to output file" +DuplicateReferenceException.ANSI_RESET);
        System.out.println("____________________________________________________");

    }
}
