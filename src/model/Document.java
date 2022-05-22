package model;
import java.util.Random;

public abstract class Document{
    private double price;
    private int year;
    /**
     * Constructor method of the abstract class document
     * @param price initialized with a double of the price of the document
     * @param year initialized with an integer of the year of the document
     */
    public Document(double price, int year) {
        this.price = price;
        this.year = year;
    }
    /**
     * Method that fills a 4x4 square array of numbers with random numbers
     * @return A 4x4 square number matrix with random numbers
     */
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
   /**
    * Method that generates the code of the document depending on the matrix and the route that is made to obtain it
    * @return A string with the code depending on the type of document
    */ 
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