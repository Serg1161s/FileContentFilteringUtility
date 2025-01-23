package utility_exceptions;

import java.util.SortedMap;

public class FileWrongTypeOfFileException extends RuntimeException {

    public FileWrongTypeOfFileException(String message) {
        System.out.println("____________________________________________________");
        System.out.println("FileWrongTypeOfFileException");
        System.out.println(DuplicateReferenceException.ANSI_RED +  message + DuplicateReferenceException.ANSI_RESET);
        System.out.println("____________________________________________________");
    }
}
