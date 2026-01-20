package file_writer;

import date.FileReferences;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class FileReaderUtility {
    public LinkedList<String> fileReader(FileReferences references) throws IOException {
        LinkedList<String> list = new LinkedList<>();
        for(Path path: references.getPaths()){
            list.addAll(Files.lines(path).toList());
        }
        return list;
    }
}
