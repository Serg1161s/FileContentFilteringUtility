package date;

import file_writer.FileReaderUtility;

import java.io.IOException;
import java.util.List;

public class FillingDateBox {
    private static final int FLOAT_TYPE = 1;
    private static final int INTEGER_TYPE = 2;
    private static final int STR_TYPE = 3;

    public DateBox fillingDateBox(GetIncomingFilesReferences filesReferences) throws IOException {
        DateBox dateBox = new DateBox();
        List<String> stringList = new FileReaderUtility().fileReader(filesReferences);
        for (String str : stringList) {
            int type = detType(str);
            if (type == FLOAT_TYPE) dateBox.addDateFloat(str);
            if (type == INTEGER_TYPE) dateBox.addDateInteger(str);
            if (type == STR_TYPE && !str.isEmpty()) dateBox.addDateString(str);
        }
        return dateBox;
    }

    private int detType(String str) {
        if (isInteger(str)) return INTEGER_TYPE;
        if (isFloat(str)) return FLOAT_TYPE;
        return STR_TYPE;
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
