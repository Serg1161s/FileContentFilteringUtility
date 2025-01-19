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
 @Parameter(names = {"-o","--folderForResults"}, description = "Путь к папке с результатом")
 private String folderForResults = getRootFolder();
 @Parameter(names = {"-p","--prefixForFileName"}, description = "Префикс к имени файла")
 private String prefixForFileName ="";
 @Parameter(names = {"-s","--shortStatistics"}, description = "Короткая статистика")
 private Boolean shortStatistics = false;
 @Parameter(names = {"-a","--reWrite"}, description = "Перезапись Файла")
 private Boolean reWrite = false;
 @Parameter(names = {"-f","--fullStatistics"}, description = "Полная статистика")
 private Boolean fullStatistics = false ;
 @Parameter(names = "-",converter = FileConverter.class, description = "Входящие файлы")
 private List<File> incomingFiles = new ArrayList<>();
 @SubParameter

    private String arg1;
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
        System.out.println("folderForResults = " + folderForResults);
        System.out.println("prefixForFileName = " + prefixForFileName);
        System.out.println("shortStatistics = " + shortStatistics);
        System.out.println("fullStatistics = " + fullStatistics);
        System.out.println("reWrite = " + reWrite);
        System.out.println("incomingFiles = " + incomingFiles);
    }

    private String getRootFolder() {
        try {
            return new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
        } catch (Exception e) {
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
}
