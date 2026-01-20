package date;

import java.util.HashSet;
import java.util.LinkedList;

public class DateBox {
    private LinkedList<String> integerList;
    private LinkedList<String> floatsList;
    private LinkedList<String> stringList;
    private Double sum = 0.0;
    private Double max = Double.MIN_VALUE;
    private Double min = Double.MAX_VALUE;
    private Double average = 0.0;
    private int stringSizeMin = Integer.MAX_VALUE;
    private int stringSizeMax = Integer.MIN_VALUE;
    private boolean fullStatistics = false;
    private boolean shortStatistics = true;
    private int countFloat = 0;
    private int countString = 0;

    public DateBox() {
        this.floatsList = new LinkedList<>();
        this.integerList = new LinkedList<>();
        this.stringList = new LinkedList<>();
        this.sum = getSum();
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

    public void getFullStatistics(){
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


    public void setFullStatistics(boolean fullStatistics) {
        this.fullStatistics = fullStatistics;
    }

    public  void setShortStatistics(boolean shortStatistics) {
        this.shortStatistics = shortStatistics;
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

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public int getStringSizeMin() {
        return stringSizeMin;
    }

    public void setStringSizeMin(int stringSizeMin) {
        this.stringSizeMin = stringSizeMin;
    }

    public int getStringSizeMax() {
        return stringSizeMax;
    }

    public void setStringSizeMax(int stringSizeMax) {
        this.stringSizeMax = stringSizeMax;
    }

    public int getCountFloat() {
        return countFloat;
    }

    public void setCountFloat(int countFloat) {
        this.countFloat = countFloat;
    }

    public int getCountString() {
        return countString;
    }

    public void setCountString(int countString) {
        this.countString = countString;
    }

    public boolean isShortStatistics() {
        return shortStatistics;
    }

    public boolean isFullStatistics() {
        return fullStatistics;
    }
}
