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
        for (Path path : references.getPath()) {
            list = Files.lines(path).toList();
        }
        return list;
    }
}
