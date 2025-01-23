package date;

import utility_exceptions.DuplicateReferenceException;
import utility_exceptions.FileNotFoundEx;
import utility_exceptions.FileWrongTypeOfFileException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileReferences {
    private Set<Path> p;
    public FileReferences(){
        this.p = new HashSet<>();
    }
    public void addReference(String folderRef, String fileName){
        Path incomingReferenceForLoadFile = Paths.get(folderRef, fileName);
        if (checkReference(incomingReferenceForLoadFile, fileName)){
            if (this.p.contains(incomingReferenceForLoadFile)) {
                new DuplicateReferenceException(incomingReferenceForLoadFile);
            } else {
                this.p.add(incomingReferenceForLoadFile);
            }
        }
    }

    private static boolean checkReference(Path incomingReferenceForLoadFile, String filename) {
        if (!checkExtension(filename) || !checkFileExist(incomingReferenceForLoadFile)) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean checkFileExist(Path incomingReferenceForLoadFile) {
        if(Files.exists(incomingReferenceForLoadFile)) return true;
        new FileNotFoundEx(incomingReferenceForLoadFile);
        return false;
    }

    private static boolean checkExtension(String filename) {
        if (filename.endsWith(".txt")) {
            return true;
        }
        new FileWrongTypeOfFileException("File = " + filename +  " - was not added because the wrong Type of File");
        return false;
    }

    public Set<Path> getPath() {
        return p;
    }
}
