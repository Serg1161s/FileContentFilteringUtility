package date;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DateBox {
    private List<String> integerList;
    private List<String> floatsList;
    private List<String> stringList;
    private static Double sum = 0.0;
    private static Double average = 0.0;
    private static Double max = Double.MIN_VALUE;
    private static Double min = Double.MAX_VALUE;


    private static int countInt;
    private static int countFloat;
    private static int countString;
    public DateBox() {
        this.floatsList = new ArrayList<>();
        this.integerList = new ArrayList<>();;
        this.stringList = new ArrayList<>();;
    }
    public void DateBoxAddAll(DateBox another){
        this.floatsList.addAll(another.getFloatsList());
        this.integerList.addAll(another.getIntegerList());;
        this.stringList.addAll(another.getStringList());
    }
    public static void getAllCounts(){
        System.out.println("Total of the elements = " + (countFloat + countInt + countString));

    }
    public void fullStatistics(){
        getIntegers();
        getFloats();

        getAllCounts();
    }

    private void getFloats() {
        for(String num: floatsList){
            float n = Float.valueOf(num);
            max = Math.max(max,n);
            min = Math.min(min,n);
            sum = Double.sum(sum,n);
        }
        System.out.println("Float number max = " + max + "; Float number min = " + min + "; sum of the Float numbers = " + sum + "; average of the Float numbers = " + sum/countFloat);
    }

    private void getIntegers() {

        for(String num: integerList){
            var n = Long.valueOf(num);
            max = Math.max(max,n);
            min = Math.min(min,n);
            sum +=Double.sum(sum,n);

        }
        System.out.println("Integer number max = " + max + "; Integer number min = " + min + "; sum of the Integer numbers = " + sum + "; average of the Integer numbers = " + sum/(countInt+countFloat));
    }

    public void addDateFloat(String num){
        floatsList.add(num);
        countFloat++;
    }
    public void addDateString(String str){
        stringList.add(str);
        countString++;
    }
    public void addDateInteger(String num){
        integerList.add(num);
        countInt++;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public List<String> getIntegerList() {
        return integerList;
    }

    public List<String> getFloatsList() {
        return floatsList;
    }

    public static int getCountFloat() {
        return countFloat;
    }

    public static int getCountInt() {
        return countInt;
    }

    public static int getCountString() {
        return countString;
    }
}
