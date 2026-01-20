package file_writer;

import date.ReferenceChecker;
import date.DateBox;
import starter.ArgumentsForUtility;
import utility_exceptions.FileWrongTypeOfFileException;
import utility_exceptions.SetRootFolderForOutputFilesException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Set;

public  class FileWriterUtility {
    private final static String FILE_NAME_FOR_FLOATS = "floats.txt";
    private final static String FILE_NAME_FOR_INTEGERS = "integers.txt";
    private final static String FILE_NAME_FOR_STRINGS = "strings.txt";
    private static String prefixForOutputFiles = "";
    private static boolean reWrite = false;
    private static String folderForRes;

    public void fileWriter(DateBox dateBox) {

        writerTo(dateBox.getFloatsList(), folderForRes + "\\" + prefixForOutputFiles + FILE_NAME_FOR_FLOATS);
        writerTo(dateBox.getIntegerList(), folderForRes + "\\" + prefixForOutputFiles + FILE_NAME_FOR_INTEGERS);
        writerTo(dateBox.getStringList(), folderForRes + "\\" + prefixForOutputFiles + FILE_NAME_FOR_STRINGS);
    }
    public void writerTo(LinkedList<String> stringList, String reference) {
        if(stringList.isEmpty())return;
        try (FileWriter fileWriter = new FileWriter(reference, reWrite)){
            for(String str:stringList) {
                fileWriter.write(str + "\n");
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void setReWrite(boolean reWrite) {
        FileWriterUtility.reWrite = reWrite;
    }

    public static void setPrefixForOutputFiles(String prefixForOutputFiles) {
        if(prefixForOutputFiles.contains(".")) {
            FileWriterUtility.prefixForOutputFiles = "";
            new FileWrongTypeOfFileException(" Prefix ( " + prefixForOutputFiles + ") should be without (.).The files saved without prefix");
        }else if(prefixForOutputFiles != ""){
            FileWriterUtility.prefixForOutputFiles = (ReferenceChecker.checkFileName(prefixForOutputFiles)) ? prefixForOutputFiles : "";
        }
    }

    public static void setFolderForResults(String outputFolder) {
        Path folder = Paths.get(outputFolder);
        if (Files.isDirectory(folder)) {
            FileWriterUtility.folderForRes = outputFolder;
        } else {
            if (isFileExist(folder)) {
                FileWriterUtility.folderForRes = outputFolder;
            } else {
                FileWriterUtility.folderForRes = ArgumentsForUtility.ROOT_FOLDER;
            }
        }
    }

    private static boolean isFileExist(Path outputFolder) {
        try {
            Files.createDirectories(outputFolder);
            return true;
        } catch (IOException e) {
            new SetRootFolderForOutputFilesException(outputFolder + " Folder was not created. Results is in : " + ArgumentsForUtility.ROOT_FOLDER);
        }
        return false;
    }
}
