package date;

import utility_exceptions.DuplicateReferenceException;
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
        if (ReferenceChecker.checkFileExist(incomingReferenceForLoadFile)  ) {
            if (this.p.contains(incomingReferenceForLoadFile)) {
                new DuplicateReferenceException(incomingReferenceForLoadFile);
            } else {
                this.p.add(incomingReferenceForLoadFile);
            }
        }
    }
    public Set<Path> getPath() {
        return p;
    }
}
