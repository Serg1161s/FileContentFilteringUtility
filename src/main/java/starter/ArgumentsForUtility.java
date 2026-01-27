package starter;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Parameters(separators = "=")
public class ArgumentsForUtility {

    private final String ROOT_FOLDER = new GetRootFolder().getRoot();

    @Parameter(names = {"--RootFolder"}, description = "Основная папка (Место расположения файлов для конвертации) :")
    private String rootFolder = ROOT_FOLDER;
    @Parameter(names = {"-o", "--folderForResults"}, description = "Заданный путь к папке с результатом")
    private String folderForResults = ROOT_FOLDER;
    @Parameter(names = {"-p", "--prefixForFileName"}, description = "Префикс к имени файлов с результатами")
    private String prefixForFileName = "";
    @Parameter(names = {"-s", "--shortStatistics"}, description = "Короткая статистика")
    private Boolean shortStatistics = false;
    @Parameter(names = {"-a", "--reWrite"}, description = "Режим добавление в существующие файлы(По умолчанию перезаписываются) ")
    private Boolean reWrite = false;
    @Parameter(names = {"-f", "--fullStatistics"}, description = "Полная статистика")
    private Boolean fullStatistics = true;
    @Parameter(names = "-", converter = FileConverter.class, description = "Входящие файлы. После тире перечислить имена файлов для сортировки через запятую ")
    private List<File> incomingFiles = new ArrayList<>();
    @Parameter(names = {"-h", "--help"}, help = true)
    private boolean help;

    public void printSelectedParameters() {
        System.out.println("Used parameters : ");
        System.out.println("--rootFolder = " + rootFolder);
        System.out.println("--folderForResults = " + folderForResults);
        System.out.println("--prefixForFileName = " + ((prefixForFileName.isEmpty())? "без префикса": prefixForFileName) );
        System.out.println("--shortStatistics = " + shortStatistics);
        System.out.println("--FullStatistics = " + fullStatistics);
        System.out.println("--reWrite = " + reWrite);
        System.out.println("--incomingFiles = " + incomingFiles);
    }
    public boolean isHelp() {
        return help;
    }

    private static class FileConverter implements IStringConverter<File> {
        @Override
        public File convert(String value) {
            return new File(value);
        }
    }
    @Override
    public String toString() {
        return "ArgumentsForUtility{" +
                "folderForResults='" + folderForResults + '\'' +
                ", fullStatistics=" + fullStatistics +
                ", help=" + help +
                ", incomingFiles=" + incomingFiles +
                ", prefixForFileName='" + prefixForFileName + '\'' +
                ", reWrite=" + reWrite +
                ", shortStatistics=" + shortStatistics +
                '}';
    }
    public String getRootFolder (){
        new GetRootFolder().getRoot();
        return rootFolder;
    }
    public String getFolderForResults() {
        return folderForResults;
    }
    public String getPrefixForFileName() {
        return prefixForFileName;
    }
    public Boolean getShortStatistics() {
        return shortStatistics;
    }
    public Boolean getReWrite() {
        return reWrite;
    }
    public Boolean getFullStatistics() {
        return fullStatistics;
    }
    public List<File> getIncomingFiles() {
        return incomingFiles;
    }
    public void setHelp(boolean help) {
        this.help = help;
    }
}
