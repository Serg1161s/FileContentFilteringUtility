package org.example;


import date.DateBox;
import file_writer.FileReaderUtility;
import file_writer.FileWriterUtility;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {

        FileWriterUtility fileWriterUtility = new FileWriterUtility();
        FileReaderUtility fileReaderUtility = new FileReaderUtility();
        String folderForSaveDate = "C:\\Users\\Asus\\Documents\\GitHub\\FileContentFilteringUtility\\";
        List<String> fileForLoadDate = new LinkedList<>();
                fileForLoadDate.add("C:\\Users\\Asus\\Documents\\GitHub\\FileContentFilteringUtility\\DateFileFrom1.txt");
                fileForLoadDate.add("C:\\Users\\Asus\\Documents\\GitHub\\FileContentFilteringUtility\\DateFileFrom2.txt");
        DateBox dateBox = new DateBox();
        for (String str: fileForLoadDate ) {
            fillingDateBox(dateBox, fileReaderUtility, str, fileWriterUtility, folderForSaveDate);
        }
        DateBox.getAllCounts();
        dateBox.fullStatistics();
    }

    private static void fillingDateBox(DateBox dateBox, FileReaderUtility fileReaderUtility, String folderForLoadDate, FileWriterUtility fileWriterUtility, String folderForSaveDate) {
        try {
            dateBox.DateBoxAddAll(fileReaderUtility.fileReader(folderForLoadDate));
            fileWriterUtility.fileWriter(dateBox, folderForSaveDate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}