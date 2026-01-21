package starter;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import date.BoxForIncomingDateFromFiles;
import date.GetIncomingFilesReferences;
import date.FillingBoxForIncomingDate;
import date.GetFileReferences;
import file_writer.FileWriterUtility;
import java.io.IOException;


public class Main {
    static void main(String[] args) throws IOException {
        ArgumentsForUtility arguments = setSystemOptions(args);
        runFileContentFilteringUtility(arguments);
    }

    private static void runFileContentFilteringUtility(ArgumentsForUtility arguments) throws IOException {
        BoxForIncomingDateFromFiles dateBox = readDateFromIncomingFiles(arguments);
        saveDateInToFileFromDateBox(dateBox,arguments);
        dateBox.getStatistics(arguments);
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

    private static BoxForIncomingDateFromFiles readDateFromIncomingFiles(ArgumentsForUtility arguments) throws IOException {
        GetIncomingFilesReferences filesReferences = new GetFileReferences().getFilesReferences(arguments);
        return new FillingBoxForIncomingDate().fillingDateBox(filesReferences);
    }

    private static void saveDateInToFileFromDateBox(BoxForIncomingDateFromFiles dateBox, ArgumentsForUtility arguments) {
        FileWriterUtility fileWriterUtility = new FileWriterUtility();
        fileWriterUtility.fileWriter(dateBox,arguments);
    }
}