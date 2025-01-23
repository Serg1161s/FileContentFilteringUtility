package utility_exceptions;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileNotFoundEx extends FileNotFoundException {
    private Path notFoundReference;

    public FileNotFoundEx(Path notFoundReference) {
        if(Files.isRegularFile(notFoundReference)){
            System.out.println("____________________________________________________");
            System.out.println("FileNotFoundEx - Wrong Type of reference");
            System.out.println(DuplicateReferenceException.ANSI_RED + "File = " + notFoundReference + " - wrong Type of Reference" +DuplicateReferenceException.ANSI_RESET);
            System.out.println("____________________________________________________");
        }
       else {
            System.out.println("____________________________________________________");
            System.out.println("FileNotFoundEx - not found Reference");
           System.out.println(DuplicateReferenceException.ANSI_RED + "Reference = " + notFoundReference + " - this File was not added because not found" + DuplicateReferenceException.ANSI_RESET);
           System.out.println("____________________________________________________");
       }
    }
}
