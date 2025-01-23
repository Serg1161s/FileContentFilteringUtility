package date;

import java.util.HashSet;
import java.util.LinkedList;

public class DateBox {
    private LinkedList<String> integerList;
    private LinkedList<String> floatsList;
    private LinkedList<String> stringList;
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

    public DateBox() {
        this.floatsList = new LinkedList<>();
        this.integerList = new LinkedList<>();
        this.stringList = new LinkedList<>();
    }

    public void DateBoxAddAll(DateBox another){
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
                +"Total of inputted Numbers = " + countFloat+ ";\n Number max = " + ((max == Double.MIN_VALUE) ? 0:max)  + ";  \n Number min = " + ((min== Double.MAX_VALUE) ? 0 : min )+ "; \n sum of the numbers = " + sum + "; \n average of the numbers = " + average);
        System.out.println("String statistic : \n"
                +"Total of inputted String = "+countString+";\n Maximum string size = " + ((stringSizeMax == Integer.MIN_VALUE)? 0 : stringSizeMax )+ ";\n Minimum string size = " + ((stringSizeMin == Integer.MAX_VALUE)?0:stringSizeMin));
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


    public static void setFullStatistics(boolean fullStatistics) {
        DateBox.fullStatistics = fullStatistics;
    }

    public static void setShortStatistics(boolean shortStatistics) {
        DateBox.shortStatistics = shortStatistics;
    }

    public LinkedList<String> getFloatsList() {
        return floatsList;
    }

    public LinkedList<String> getIntegerList() {
        return integerList;
    }

    public LinkedList<String> getStringList() {
        return stringList;
    }
}
