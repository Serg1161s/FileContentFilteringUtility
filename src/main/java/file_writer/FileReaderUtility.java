package file_writer;

import date.DateBox;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileReaderUtility {

    public DateBox fileReader(String folderForReadDate) {
        DateBox dateBox = new DateBox();
        try (BufferedReader buffer = new BufferedReader(new FileReader(folderForReadDate))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                int type = detType(line);
                if (type == 1) dateBox.addDateFloat(line);
                if (type == 2) dateBox.addDateInteger(line);
                if (type == 3) dateBox.addDateString(line);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return dateBox;
    }
    private int detType(String str){
        if(isInteger(str)) return 2;
        if(isFloat(str)) return 1;
        return 3;
    }

    private boolean isFloat(String str) {
       try {
           Double.parseDouble(str);
           return true;
       } catch (NumberFormatException ex){
           return false;
       }

    }
    private boolean isInteger(String str) {
        return str.matches("[+-]?[0-9]+");
    }
}
