package utility_exceptions;

import java.util.SortedMap;

public class FileWrongTypeOfFileException extends RuntimeException {

    public FileWrongTypeOfFileException(String message) {
        System.out.println("____________________________________________________");
        System.out.println("FileWrongTypeOfFileException");
        System.out.println(DuplicateReferenceException.ANSI_RED + "File = " + message + " - was not added because the wrong Type of File" +DuplicateReferenceException.ANSI_RESET);
        System.out.println("____________________________________________________");
    }
}
