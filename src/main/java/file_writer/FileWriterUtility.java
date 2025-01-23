package file_writer;

import date.ReferencesBox;
import starter.ArgumentsForUtility;
import utility_exceptions.FileWrongTypeOfFileException;
import utility_exceptions.SetRootFolderForOutputFilesException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public  class FileWriterUtility {
    private final static String FILE_NAME_FOR_FLOATS = "floats.txt";
    private final static String FILE_NAME_FOR_INTEGERS = "integers.txt";
    private final static String FILE_NAME_FOR_STRINGS = "strings.txt";
    private static String prefixForOutputFiles;
    private static boolean continueToUseOutputFile = false;
    private static String rootFolder;

    public void fileWriter(ReferencesBox dateBox) {

        writerTo(dateBox.getFloatsList(),rootFolder + "\\" + prefixForOutputFiles + FILE_NAME_FOR_FLOATS);
        writerTo(dateBox.getIntegerList(),rootFolder + "\\" + prefixForOutputFiles + FILE_NAME_FOR_INTEGERS);
        writerTo(dateBox.getStringList(),rootFolder  + "\\" + prefixForOutputFiles + FILE_NAME_FOR_STRINGS);
    }
    public void writerTo(List<String> stringList, String reference) {
        if(stringList.isEmpty())return;
        try (FileWriter fileWriter = new FileWriter(reference, continueToUseOutputFile)){
            for(String str:stringList) {
                fileWriter.write(str + "\n");
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void setContinueToUseOutputFile(boolean continueToUseOutputFile) {
        FileWriterUtility.continueToUseOutputFile = continueToUseOutputFile;
    }

    public static void setPrefixForOutputFiles(String prefixForOutputFiles) {
        if (Files.isRegularFile(Paths.get(ArgumentsForUtility.ROOT_FOLDER,prefixForOutputFiles+FILE_NAME_FOR_FLOATS))) {
            FileWriterUtility.prefixForOutputFiles = prefixForOutputFiles;
        } else {
            new FileWrongTypeOfFileException("The file with Prefix ( " + prefixForOutputFiles + " ) do not possible to create the file created without prefix " );
            FileWriterUtility.prefixForOutputFiles = "";
        }
    }

    public static void setRootFolder(String rootFolder) {
        if (!rootFolder.endsWith("\\")){
            rootFolder +="\\";
        }
        Path rootFol = Paths.get(rootFolder);
        if(Files.isDirectory(rootFol)){
            isFileExist(rootFol);
            FileWriterUtility.rootFolder= rootFolder;
        } else {
            FileWriterUtility.rootFolder= ArgumentsForUtility.ROOT_FOLDER;
            new SetRootFolderForOutputFilesException(rootFolder + " the way is not Regular. " );
        }
    }

    private static void isFileExist(Path rootFol) {
        if (!Files.exists(rootFol)){
            try {
                Files.createDirectories(rootFol);
            } catch (IOException e) {
                new SetRootFolderForOutputFilesException(rootFol + " Folder was not created. ");
            }
        }
    }

    public static String getFileNameForFloats() {
        return FILE_NAME_FOR_FLOATS;
    }

    public static String getFileNameForIntegers() {
        return FILE_NAME_FOR_INTEGERS;
    }

    public static String getFileNameForStrings() {
        return FILE_NAME_FOR_STRINGS;
    }


}
