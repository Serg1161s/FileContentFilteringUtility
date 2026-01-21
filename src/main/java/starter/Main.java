package starter;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import date.DateBox;
import date.GetIncomingFilesReferences;
import date.FillingDateBox;
import date.GetFileReferences;
import file_writer.FileWriterUtility;
import java.io.IOException;


public class Main {
    static void main(String[] args) throws IOException {
        ArgumentsForUtility arguments = setSystemOptions(args);
        runApp(arguments);
    }

    private static void runApp(ArgumentsForUtility arguments) throws IOException {
        DateBox dateBox = readDate(arguments);
        saveDateFromDateBox(dateBox,arguments);
        dateBox.getStatistics();
    }

    private static ArgumentsForUtility setSystemOptions(String[] args) {
        ArgumentsForUtility arguments = new ArgumentsForUtility();
        JCommander jCommander = new JCommander(arguments);
        try {
            jCommander.parse(args);
        } catch (ParameterException exception) {
            System.out.println("Введена неправильная опция при запуске. Смотри подсказку ниже.");
            System.out.println(exception.getMessage());
            showUsage(jCommander);
        }
        if (arguments.isHelp()) {
            showUsage(jCommander);
        }
         arguments.printSelectedParameters();

        return arguments;
    }

    private static void showUsage(JCommander jCommander) {
        jCommander.usage();
        System.exit(0);
    }

    private static DateBox readDate(ArgumentsForUtility arguments) throws IOException {
        GetIncomingFilesReferences filesReferences = new GetFileReferences().getFilesReferences(arguments);
        return new FillingDateBox().fillingDateBox(filesReferences);
    }

    private static void saveDateFromDateBox(DateBox dateBox, ArgumentsForUtility arguments) {
        FileWriterUtility fileWriterUtility = new FileWriterUtility();
        fileWriterUtility.fileWriter(dateBox,arguments);
    }
}