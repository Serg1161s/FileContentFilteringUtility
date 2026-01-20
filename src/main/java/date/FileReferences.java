package date;

import utility_exceptions.DuplicateReferenceException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileReferences {
    private Set<Path> paths;
    public FileReferences(){
        this.paths = new HashSet<>();
    }
    public void addReference(String folderRef, String fileName){
        Path incomingReferenceForLoadFile = Paths.get(folderRef, fileName);
        if (ReferenceChecker.checkFileExist(incomingReferenceForLoadFile)  ) {
            if (this.paths.contains(incomingReferenceForLoadFile)) {
                new DuplicateReferenceException(incomingReferenceForLoadFile);
            } else {
                this.paths.add(incomingReferenceForLoadFile);
            }
        }
    }
    public Set<Path> getPaths() {
        return paths;
    }
}
