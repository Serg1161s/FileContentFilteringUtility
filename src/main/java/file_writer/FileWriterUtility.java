package file_writer;

import date.ReferenceChecker;
import date.BoxForIncomingDateFromFiles;
import starter.ArgumentsForUtility;
import utility_exceptions.FileWrongTypeOfFileException;
import utility_exceptions.SetRootFolderForOutputFilesException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public  class FileWriterUtility {
    private final static String FILE_NAME_FOR_FLOATS = "floats.txt";
    private final static String FILE_NAME_FOR_INTEGERS = "integers.txt";
    private final static String FILE_NAME_FOR_STRINGS = "strings.txt";

    public void fileWriter(BoxForIncomingDateFromFiles dateBox, ArgumentsForUtility arguments) {
        String prefixForOutputFiles = checkPrefixForOutputFiles(arguments.getPrefixForFileName());
        String folderForRes = setFolderForResults(arguments);

        writerTo(dateBox.getFloatsList(), Path.of(folderForRes,prefixForOutputFiles + FILE_NAME_FOR_FLOATS), arguments);
        writerTo(dateBox.getIntegerList(),Path.of(folderForRes,prefixForOutputFiles + FILE_NAME_FOR_INTEGERS), arguments);
        writerTo(dateBox.getStringList(), Path.of(folderForRes,prefixForOutputFiles + FILE_NAME_FOR_STRINGS), arguments);
    }
    private void writerTo(LinkedList<String> stringList, Path reference, ArgumentsForUtility arguments) {
        if(stringList.isEmpty())return;
        try (FileWriter fileWriter = new FileWriter(reference.toString(), arguments.getReWrite())){
            for(String str:stringList) {
                fileWriter.write(str + "\n");
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    private String checkPrefixForOutputFiles(String prefixForOutputFiles) {
        if (prefixForOutputFiles.isEmpty()) {return "";}
        if (prefixForOutputFiles.contains(".")) {
            new FileWrongTypeOfFileException(" Prefix ( " + prefixForOutputFiles + ") should be without (.).The files saved without prefix");
            return  "";
        } else  {
            return  (ReferenceChecker.checkFileName(prefixForOutputFiles)) ? prefixForOutputFiles : "";
        }
    }

    private String setFolderForResults(ArgumentsForUtility arguments) {
        Path folder = Path.of(arguments.getFolderForResults());
        if (Files.isDirectory(folder) || isFileExist(folder, arguments)) {
           return arguments.getFolderForResults();
        } else {
            return arguments.getRootFolder();
        }

    }

    private static boolean isFileExist(Path outputFolder, ArgumentsForUtility arguments ) {
        try {
            Files.createDirectories(outputFolder);
            return true;
        } catch (IOException e) {
            new SetRootFolderForOutputFilesException (outputFolder + " Folder was not created. Results is in : " + arguments.getRootFolder(), arguments);
        }
        return false;
    }
}
