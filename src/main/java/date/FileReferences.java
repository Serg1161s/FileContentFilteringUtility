package date;

import utility_exceptions.DuplicateReferenceException;
import utility_exceptions.FileNotFoundEx;

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
        if(Files.exists(incomingReferenceForLoadFile)) {
            if (this.p.contains(incomingReferenceForLoadFile)) {
                new DuplicateReferenceException(incomingReferenceForLoadFile);
            } else {
                this.p.add(incomingReferenceForLoadFile);
            }
        } else {
            new FileNotFoundEx(incomingReferenceForLoadFile);
        }
    }
    public Set<Path> getPath() {
        return p;
    }
}
