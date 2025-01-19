package starter;

import com.beust.jcommander.JCommander;
import date.DateBox;
import date.FileReferences;
import date.FillingDateBox;
import date.GetFileReferences;
import file_writer.FileWriterUtility;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        ArgumentsForUtility arguments = new ArgumentsForUtility();
        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);
        arguments.setParameters();




        DateBox dateBox = readDate();
        saveDateFromDateBox(dateBox);
        DateBox.getAllCounts();
        dateBox.fullStatistics();
    }

    private static void saveDateFromDateBox(DateBox dateBox) {
        FileWriterUtility fileWriterUtility = new FileWriterUtility();
        fileWriterUtility.fileWriter(dateBox);
    }


    private static DateBox readDate() throws IOException {
        FileReferences filesReferences = new GetFileReferences().getFilesReferences();
        DateBox dateBox = new FillingDateBox().fillingDateBox(filesReferences);
        return dateBox;
    }



}