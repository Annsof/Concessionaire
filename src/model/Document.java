package model;
import java.util.Random;

public abstract class Document{
    private double price;
    private int year;

    public Document(double price, int year) {
        this.price = price;
        this.year = year;
    }
    public int[][] imageCreator(){
        int [][] matrix = new int[4][4];
        for (int rowNum=0; rowNum<matrix.length; rowNum ++) {
            for (int columnNum=0; columnNum<matrix[0].length; columnNum++) {
                Random random = new Random();
                int number = random.nextInt(100);
                matrix[rowNum][columnNum]=number;
            }
        }
        return matrix;
    }
    public abstract String generateCode();
    public abstract String toString();

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}