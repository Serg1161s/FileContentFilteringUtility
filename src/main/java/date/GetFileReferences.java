package date;

import starter.ArgumentsForUtility;

import java.io.File;

public class GetFileReferences {
    public GetIncomingFilesReferences getFilesReferences(ArgumentsForUtility arguments) {
        GetIncomingFilesReferences filesReferences = new GetIncomingFilesReferences();
        for (File name : arguments.getIncomingFiles()) {
            if (ReferenceChecker.nameChecker(name.toString())) {
                filesReferences.addReference(arguments.getRootFolder(), name.toString());
            }
        }
        return filesReferences;
    }
}


