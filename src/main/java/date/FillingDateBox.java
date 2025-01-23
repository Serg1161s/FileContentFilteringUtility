package date;

import file_writer.FileReaderUtility;
import java.io.IOException;
import java.util.List;

public class FillingDateBox {
    public ReferencesBox fillingDateBox(FileReferences filesReferences) throws IOException {
        ReferencesBox dateBox = new ReferencesBox();
        List<String> stringList = new FileReaderUtility().fileReader(filesReferences);
        for (String str : stringList) {
            int type = detType(str);
            if (type == 1) dateBox.addDateFloat(str);
            if (type == 2) dateBox.addDateInteger(str);
            if (type == 3 && !str.isEmpty()) dateBox.addDateString(str);
        }
        return dateBox;
    }

    private int detType(String str) {
        if (isInteger(str)) return 2;
        if (isFloat(str)) return 1;
        return 3;
    }

    private boolean isFloat(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isInteger(String str) {
        return str.matches("[+-]?[0-9]+");
    }
}
