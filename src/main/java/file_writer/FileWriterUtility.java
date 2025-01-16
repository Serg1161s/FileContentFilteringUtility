package file_writer;

import date.DateBox;

import java.io.*;
import java.util.List;

public  class FileWriterUtility {
    private static String fileNameForFloats = "floats.txt";
    private static String fileNameForIntegers = "integers.txt";
    private static String fileNameForStrings = "strings.txt";

    public void fileWriter(DateBox dateBox, String saveFolder) {

        writerTo(dateBox.getFloatsList(),saveFolder + fileNameForFloats);
        writerTo(dateBox.getIntegerList(),saveFolder + fileNameForIntegers);
        writerTo(dateBox.getStringList(),saveFolder  + fileNameForStrings);
    }
    public void writerTo(List<String> stringList, String wayTo) {
        try (FileWriter fileWriter = new FileWriter(wayTo)){
            for(String str:stringList) {
                fileWriter.write(str + "\n");
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }

    }

    public static String getFileNameForFloats() {
        return fileNameForFloats;
    }

    public static void setFileNameForFloats(String fileNameForFloats) {
        FileWriterUtility.fileNameForFloats = fileNameForFloats;
    }

    public static String getFileNameForIntegers() {
        return fileNameForIntegers;
    }

    public static void setFileNameForIntegers(String fileNameForIntegers) {
        FileWriterUtility.fileNameForIntegers = fileNameForIntegers;
    }

    public static String getFileNameForStrings() {
        return fileNameForStrings;
    }

    public static void setFileNameForStrings(String fileNameForStrings) {
        FileWriterUtility.fileNameForStrings = fileNameForStrings;
    }
}
