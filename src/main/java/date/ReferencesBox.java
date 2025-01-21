package date;

import java.util.ArrayList;
import java.util.List;

public class ReferencesBox {
    private List<String> integerList;
    private List<String> floatsList;
    private List<String> stringList;
    private static Double sum = 0.0;
    private static Double max = Double.MIN_VALUE;
    private static Double min = Double.MAX_VALUE;
    private static Double average = 0.0;
    private static int stringSizeMin = Integer.MAX_VALUE;
    private static int stringSizeMax = Integer.MIN_VALUE;
    private static boolean fullStatistics;
    private static boolean shortStatistics;

    private static int countFloat;
    private static int countString;

    public ReferencesBox() {
        this.floatsList = new ArrayList<>();
        this.integerList = new ArrayList<>();;
        this.stringList = new ArrayList<>();;
    }

    public void DateBoxAddAll(ReferencesBox another){
        this.floatsList.addAll(another.getFloatsList());
        this.integerList.addAll(another.getIntegerList());;
        this.stringList.addAll(another.getStringList());
    }

    public void getStatistics(){
        if (shortStatistics) getShortStatistics();
        if (fullStatistics) getFullStatistics();
    }

    public static void getFullStatistics(){
        System.out.println("____________________________________________________");
        System.out.println("Full statistics \n"
                +"Numbers statistic : \n"
                +"Total of inputted Numbers = " + countFloat+ ";\n Number max = " + max + ";  \n Number min = " + min + "; \n sum of the numbers = " + sum + "; \n average of the numbers = " + average);
        System.out.println("String statistic : \n"
                +"Total of inputted String = "+countString+";\n Maximum string size = " + stringSizeMax + ";\n Minimum string size = " + stringSizeMin);
        System.out.println("____________________________________________________");
    }

    private void getShortStatistics() {
        System.out.println("____________________________________________________");
        System.out.println("Short statistics \n");
        System.out.println("Total of the elements = " + (countFloat + countString));
        System.out.println("____________________________________________________");
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

    public static boolean isFullStatistics() {
        return fullStatistics;
    }

    public static void setFullStatistics(boolean fullStatistics) {
        ReferencesBox.fullStatistics = fullStatistics;
    }

    public static boolean isShortStatistics() {
        return shortStatistics;
    }

    public static void setShortStatistics(boolean shortStatistics) {
        ReferencesBox.shortStatistics = shortStatistics;
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
