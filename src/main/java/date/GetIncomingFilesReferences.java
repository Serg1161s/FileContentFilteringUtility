package date;

import utility_exceptions.DuplicateReferenceException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GetIncomingFilesReferences {
    private final Set<Path> pathToIncomingFiles;

    public GetIncomingFilesReferences(){
        this.pathToIncomingFiles = new HashSet<>();
    }
    public void addReference(String folderRef, String fileName){
        Path incomingReferenceForLoadFile = Paths.get(folderRef, fileName);
        if (new ReferenceChecker().checkFileExist(incomingReferenceForLoadFile)  ) {
            if (this.pathToIncomingFiles.contains(incomingReferenceForLoadFile)) {
                new DuplicateReferenceException(incomingReferenceForLoadFile);
            } else {
                this.pathToIncomingFiles.add(incomingReferenceForLoadFile);
            }
        }
    }
    public Set<Path> getPaths() {
        return pathToIncomingFiles;
    }
}
