package starter;

import java.io.File;
import java.net.URISyntaxException;

public class GetRootFolder {
    public String getRoot() {
        try {
            return new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
        } catch (URISyntaxException e) {
            System.out.println("Root Folder was not found");
        }
        return null;
    }
}
