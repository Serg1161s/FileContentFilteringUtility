package file_writer;

import date.DateBox;

import java.io.*;
import java.util.List;

public  class FileWriterUtility {
    private final static String FILE_NAME_FOR_FLOATS = "floats.txt";
    private final static String FILE_NAME_FOR_INTEGERS = "integers.txt";
    private final static String FILE_NAME_FOR_STRINGS = "strings.txt";
    private static String prefixForOutputFiles;
    private static boolean rewriteFile = false;
    private static String rootFolder;

    public void fileWriter(DateBox dateBox) {

        writerTo(dateBox.getFloatsList(),rootFolder + "\\" + prefixForOutputFiles + FILE_NAME_FOR_FLOATS);
        writerTo(dateBox.getIntegerList(),rootFolder + "\\" + prefixForOutputFiles + FILE_NAME_FOR_INTEGERS);
        writerTo(dateBox.getStringList(),rootFolder  + "\\" + prefixForOutputFiles + FILE_NAME_FOR_STRINGS);
    }
    public void writerTo(List<String> stringList, String reference) {
        if(stringList.isEmpty())return;
        try (FileWriter fileWriter = new FileWriter(reference,rewriteFile)){
            for(String str:stringList) {
                fileWriter.write(str + "\n");
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }

    }

    public static void setRewriteFile(boolean rewriteFile) {
        FileWriterUtility.rewriteFile = rewriteFile;
    }

    public static void setPrefixForOutputFiles(String prefixForOutputFiles) {
        FileWriterUtility.prefixForOutputFiles = prefixForOutputFiles;
    }

    public static void setRootFolder(String rootFolder) {
        FileWriterUtility.rootFolder = rootFolder;
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
