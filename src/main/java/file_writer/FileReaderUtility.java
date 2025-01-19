package file_writer;

import date.FileReferences;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class FileReaderUtility {
    public List<String> fileReader(FileReferences references) throws IOException {
        List<String> list = new ArrayList<>();
        for (int i=0 ; i < references.getPath().size(); i++ ){
            list.addAll(Files.lines(references.getPath().get(i)).toList());
        }
        return list;
    }
}
