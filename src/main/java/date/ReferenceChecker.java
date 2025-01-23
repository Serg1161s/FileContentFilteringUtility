package date;

import utility_exceptions.FileNotFoundEx;
import utility_exceptions.FileWrongTypeOfFileException;

import java.nio.file.Files;
import java.nio.file.Path;

public class ReferenceChecker {
    public static final String REGEX_PATTERN = "^[A-Za-z0-9_.]{1,244}$";

    public static boolean nameChecker(String fileName) {
        if (!checkFileName(fileName)) {
            new FileWrongTypeOfFileException("The file name is incorrect " + fileName);
            return false;
        }
        if (!checkFileTye(fileName)) {
            new FileWrongTypeOfFileException(" The file type is wrong. Required is (*.txt). But your file is: " + fileName);
            return false;
        }
        return true;
    }

    public static boolean checkFileTye(String fileName) {
        if (fileName.length() < 5) {
            return false;
        }
        return fileName.endsWith(".txt");
    }

    public static boolean checkFileName(String fileName) {
        if (fileName == null) {
            return false;
        }
        return fileName.matches(REGEX_PATTERN);
    }

    public static boolean checkFileExist(Path incomingReferenceForLoadFile) {
        if(Files.exists(incomingReferenceForLoadFile)) return true;
        new FileNotFoundEx(incomingReferenceForLoadFile);
        return false;
    }
}
