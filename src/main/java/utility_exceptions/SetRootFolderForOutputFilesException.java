package utility_exceptions;

import starter.ArgumentsForUtility;

import java.io.IOException;

public class SetRootFolderForOutputFilesException extends RuntimeException {
    public SetRootFolderForOutputFilesException(String massage,ArgumentsForUtility arguments) {
        System.out.println("____________________________________________________");
        System.out.println("SetRootFolderForOutputFilesException");
        System.out.println(DuplicateReferenceException.ANSI_RED + "File = " + massage + " - was not set for output file, \n"
                +"folder for results is " + arguments.getRootFolder()
                +DuplicateReferenceException.ANSI_RESET);
        System.out.println("____________________________________________________");

    }
}
