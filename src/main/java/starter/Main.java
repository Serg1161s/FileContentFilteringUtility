package starter;

import date.DateBox;
import date.FileReferences;
import date.FillingDateBox;
import date.GetFileReferences;
import file_writer.FileWriterUtility;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        DateBox dateBox = readDate();
        saveDateFromDateBoxe(dateBox);
        DateBox.getAllCounts();
        dateBox.fullStatistics();
    }

    private static void saveDateFromDateBoxe(DateBox dateBox) {
        FileWriterUtility fileWriterUtility = new FileWriterUtility();
        String folderForSaveDate = "C:\\Users\\Asus\\Documents\\GitHub\\FileContentFilteringUtility\\";
        fileWriterUtility.fileWriter(dateBox,folderForSaveDate);
    }


    private static DateBox readDate() throws IOException {
        FileReferences filesReferences = new GetFileReferences().getFilesReferences();
        DateBox dateBox = new FillingDateBox().fillingDateBox(filesReferences);
        return dateBox;
    }



}