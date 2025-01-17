package file_writer;

import date.DateBox;

import java.io.*;
import java.util.List;

public  class FileWriterUtility {
    private final static String FILE_NAME_FOR_FLOATS = "floats.txt";
    private final static String FILE_NAME_FOR_INTEGERS = "integers.txt";
    private final static String FILE_NAME_FOR_STRINGS = "strings.txt";

    public void fileWriter(DateBox dateBox, String saveFolder) {

        writerTo(dateBox.getFloatsList(),saveFolder + FILE_NAME_FOR_FLOATS);
        writerTo(dateBox.getIntegerList(),saveFolder + FILE_NAME_FOR_INTEGERS);
        writerTo(dateBox.getStringList(),saveFolder  + FILE_NAME_FOR_STRINGS);
    }
    public void writerTo(List<String> stringList, String wayTo) {
        if(stringList.isEmpty())return;
        try (FileWriter fileWriter = new FileWriter(wayTo)){
            for(String str:stringList) {
                fileWriter.write(str + "\n");
            }
        } catch(IOException e){
            throw new RuntimeException(e);
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
