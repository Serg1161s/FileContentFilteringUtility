package utility_exceptions;

import java.nio.file.Path;

public class DuplicateReferenceException extends RuntimeException {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public DuplicateReferenceException(Path duplicateRef) {
        System.out.println("____________________________________________________");
        System.out.println("DuplicateReferenceException");
        System.out.println(ANSI_RED + "Duplicate Reference = " + duplicateRef + " - this File was not added" + ANSI_RESET);
        System.out.println("____________________________________________________");
    }
}
