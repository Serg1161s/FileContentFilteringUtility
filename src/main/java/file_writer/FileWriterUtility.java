package file_writer;

import date.ReferenceChecker;
import date.DateBox;
import starter.ArgumentsForUtility;
import utility_exceptions.FileWrongTypeOfFileException;

import java.io.*;
import java.nio.file.Path;
import java.util.LinkedList;

public  class FileWriterUtility {
    private final static String FILE_NAME_FOR_FLOATS = "floats.txt";
    private final static String FILE_NAME_FOR_INTEGERS = "integers.txt";
    private final static String FILE_NAME_FOR_STRINGS = "strings.txt";

    public void fileWriter(DateBox dateBox, ArgumentsForUtility arguments) {
        String prefFile = checkPrefixForOutputFiles(arguments.getPrefixForFileName());
        Path path = Path.of(arguments.getFolderForResults(), prefFile);
        writerTo(dateBox.getFloatsList(), Path.of(path.toString(), FILE_NAME_FOR_FLOATS), arguments);
        writerTo(dateBox.getIntegerList(),Path.of(path.toString(), FILE_NAME_FOR_INTEGERS), arguments);
        writerTo(dateBox.getStringList(), Path.of(path.toString(), FILE_NAME_FOR_STRINGS), arguments);
    }
    public void writerTo(LinkedList<String> stringList, Path reference, ArgumentsForUtility arguments) {
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
            return  "";
            new FileWrongTypeOfFileException(" Prefix ( " + prefixForOutputFiles + ") should be without (.).The files saved without prefix");
        } else  {
            return  (ReferenceChecker.checkFileName(prefixForOutputFiles)) ? prefixForOutputFiles : "";
        }
    }

//    public static void setFolderForResults(String outputFolder) {
//        Path folder = Paths.get(outputFolder);
//        if (Files.isDirectory(folder)) {
//            FileWriterUtility.folderForRes = outputFolder;
//        } else {
//            if (isFileExist(folder)) {
//                FileWriterUtility.folderForRes = outputFolder;
//            } else {
//                FileWriterUtility.folderForRes = ArgumentsForUtility.ROOT_FOLDER;
//            }
//        }
//    }

//    private static boolean isFileExist(Path outputFolder) {
//        try {
//            Files.createDirectories(outputFolder);
//            return true;
//        } catch (IOException e) {
//            new SetRootFolderForOutputFilesException(outputFolder + " Folder was not created. Results is in : " + ArgumentsForUtility.ROOT_FOLDER);
//        }
//        return false;
//    }
}
