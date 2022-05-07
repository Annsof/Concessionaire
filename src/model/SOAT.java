package model;

public class SOAT extends Document{

    private double coverPrice;

    public SOAT(double price, int year,double coverPrice) {
        super(price,year);
        this.coverPrice = coverPrice;
    }

    public double getCoverPrice() {
        return this.coverPrice;
    }

    public void setCoverPrice(double coverPrice) {
        this.coverPrice = coverPrice;
    }
    @Override
    public String toString(){
        return "\nThe SOAT certificate of the vehicle of the year "+super.getYear()+" has a price of: "+super.getPrice()+" and a coverage cost of of "+coverPrice;
    }
    @Override
    public String generateCode(){
    String code ="";
    int[][] matrix=super.imageCreator();
        //Here we loop through each row onwards starting from the initial row for the entire column 0
        for(int rowNum = 0; rowNum<matrix.length; rowNum++){
            code += " "+matrix[rowNum][0];
        }
        //And then we go through each column of the bottom row without counting the initial value again so as not to repeat it
        for (int columnNum = 1; columnNum < matrix[0].length; columnNum++){
            code += " "+matrix[matrix.length-1][columnNum];
        } 
        return code;
    }

    
    
    
}