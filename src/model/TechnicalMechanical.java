package model;

public class TechnicalMechanical extends Document{

    private double gasLevel;

    public TechnicalMechanical(double price, int year, double gasLevel) {
        super(price,year);
        this.gasLevel = gasLevel;
    }

    public double getGasLevel() {
        return this.gasLevel;
    }

    public void setGasLevel(double gasLevel) {
        this.gasLevel = gasLevel;
    }

    @Override
    public String toString(){
        return "\nThe technical mechanical certificate of the vehicle of the year "+super.getYear()+" has a price of: "+super.getPrice()+" and a gas level of "+gasLevel;
    }

    @Override
    public String generateCode(){
        String code ="";
        int[][] matrix=super.imageCreator();
        //We go through each column of the top row
        for(int columnNum = 0; columnNum<matrix[0].length; columnNum++){
            code += " "+matrix[0][columnNum];
        }
        //We obtain from the second row onwards the penultimate position obtained from the previous row, becoming the new last position aka traversed in z
        int rowNum=1;
        for(int columnNum = matrix[0].length -2 ; columnNum>0; columnNum--){
            code += " "+matrix[rowNum][columnNum];
                if(rowNum<matrix.length -1){
                    rowNum++;
                }
        }
        //We go through each column of the bottom row
        for(int i = 0; i<matrix[0].length; i++){
            code += " "+matrix[matrix.length-1][i];
        }
        return code;
    }
    
}