package date;

import java.util.ArrayList;
import java.util.List;

public class DateBox {
    private List<String> integerList;
    private List<String> floatsList;
    private List<String> stringList;
    private static Double sum = 0.0;
    private static Double max = Double.MIN_VALUE;
    private static Double min = Double.MAX_VALUE;
    private static Double average = 0.0;
    private static int stringSizeMin = Integer.MAX_VALUE;
    private static int stringSizeMax = Integer.MIN_VALUE;

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
        System.out.println("Total of the elements = " + (countFloat + countString));

    }
    public void fullStatistics(){
        getStatistics();
        getAllCounts();
    }

    private void getStatistics() {
        System.out.println("Float number max = " + max + "; Float number min = " + min + "; sum of the Float numbers = " + sum + "; average of the Float numbers = " + average);
        System.out.println("Maximum string size = " + stringSizeMax + "; Minimum string size = " + stringSizeMin);
    }



    public void addDateFloat(String num){
        floatsList.add(num);
        countFloat++;
        sum += Double.parseDouble(num);
        min = Math.min(min, Double.parseDouble(num));
        max = Math.max(max,Double.parseDouble(num));
        average = sum/countFloat;
    }
    public void addDateString(String str){
        stringList.add(str);
        countString++;
        stringSizeMax = Math.max(stringSizeMax, str.length());
        stringSizeMin = Math.min(stringSizeMin, str.length());


    }
    public void addDateInteger(String num){
        integerList.add(num);
        countFloat++;
        sum += Double.parseDouble(num);
        min = Math.min(min, Double.parseDouble(num));
        max = Math.max(max,Double.parseDouble(num));
        average = sum/countFloat;
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


    public static int getCountString() {
        return countString;
    }
}
