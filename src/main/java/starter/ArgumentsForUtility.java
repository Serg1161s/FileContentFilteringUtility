package starter;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.SubParameter;
import date.DateBox;
import date.GetFileReferences;
import file_writer.FileWriterUtility;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Parameters(separators = "=")
public class ArgumentsForUtility {
    @Parameter(names = {"--RootFolder"}, description = "Основная папка (Место расположения файлов для конвертации) :")
    private String rootFolder = getRootFolder();
 @Parameter(names = {"-o","--folderForResults"}, description = "Заданный путь к папке с результатом")
 private String folderForResults = rootFolder;
 @Parameter(names = {"-p","--prefixForFileName"}, description = "Префикс к имени файлов с результатоми")
 private String prefixForFileName ="";
 @Parameter(names = {"-s","--shortStatistics"}, description = "Короткая статистика")
 private Boolean shortStatistics = false;
 @Parameter(names = {"-a","--reWrite"}, description = "Режим добавление в существующие файлы(По умолчаниию перезаписываются) ")
 private Boolean reWrite = false;
 @Parameter(names = {"-f","--fullStatistics"}, description = "Полная статистика")
 private Boolean fullStatistics = false ;
 @Parameter(names = "-",converter = FileConverter.class, description = "Входящие файлы")
 private List<File> incomingFiles = new ArrayList<>();
 @Parameter(names = {"-h", "--help"}, help = true)
 private boolean help;


 public void setParameters() {
     GetFileReferences.setFolderForIncomingFiles(getRootFolder());
     GetFileReferences.setIncomingFileName(incomingFiles);
     FileWriterUtility.setRootFolder(folderForResults);
     FileWriterUtility.setPrefixForOutputFiles(prefixForFileName);
     FileWriterUtility.setRewriteFile(reWrite);
     DateBox.setFullStatistics(fullStatistics);
     DateBox.setShortStatistics(shortStatistics);

     printSelectedParameters();
 }

    private void printSelectedParameters() {
        System.out.println("Used parameters : ");
        System.out.println("rootFolder = " + rootFolder);
        System.out.println("folderForResults = " + folderForResults);
        System.out.println("prefixForFileName = " + prefixForFileName);
        System.out.println("shortStatistics = " + shortStatistics);
        System.out.println("fullStatistics = " + fullStatistics);
        System.out.println("reWrite = " + reWrite);
        System.out.println("incomingFiles = " + incomingFiles);
    }

    public boolean isHelp() {
        return help;
    }

    private String getRootFolder() {
        try {
            return new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
        } catch (Exception e) {;
            System.out.println("Root Folder was not find");
            e.printStackTrace();
        }
        return null;
    }
    public class FileConverter implements IStringConverter<File> {
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
}
