package starter;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import date.DateBox;
import date.FileReferences;
import date.FillingDateBox;
import date.GetFileReferences;
import file_writer.FileWriterUtility;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        setSystemOptions(args);
        DateBox dateBox = readDate();
        saveDateFromDateBox(dateBox);
        DateBox.getFullStatistics();
        dateBox.getStatistics();
    }

    private static void setSystemOptions(String[] args) {
        ArgumentsForUtility arguments = new ArgumentsForUtility();
        JCommander jCommander = new JCommander(arguments);
               try{
                   jCommander.parse(args);
               } catch (ParameterException exception){
                   System.out.println("Введена неправильная опция при запуске. Смотри подсказку ниже.");
                   System.out.println(exception.getMessage());
                   showUsage(jCommander);
               }
               if(arguments.isHelp()){
                   showUsage(jCommander);
               }

        arguments.setParameters();
    }

    private static void showUsage(JCommander jCommander) {
        jCommander.usage();
        System.exit(0);
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