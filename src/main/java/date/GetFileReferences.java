package date;

import java.io.File;
import java.util.List;

public class GetFileReferences {
    private static String folderForIncomingFiles;
    private static List<File> incomingFileName;

    public FileReferences getFilesReferences(){
        FileReferences filesReferences = new FileReferences();
        for (File  name : incomingFileName) {
            if(ReferenceChecker.nameChecker(name.toString())) {
                filesReferences.addReference(folderForIncomingFiles, name.toString());
            }
        }
        return filesReferences;
    }

    public static void setFolderForIncomingFiles(String folderForStat) {
           folderForIncomingFiles = folderForStat;
    }

    public static void setIncomingFileName(List<File> incomingFileName) {
        GetFileReferences.incomingFileName = incomingFileName;
    }
}


