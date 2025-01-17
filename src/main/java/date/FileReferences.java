package date;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReferences {
    private List<Path> p;
    public FileReferences(){
        this.p = new ArrayList<>();
    }
    public void addReference(String folderRef, String fileName){
      this.p.add(Paths.get(folderRef, fileName));
    }
    public List<Path> getPath() {
        return p;
    }
}
