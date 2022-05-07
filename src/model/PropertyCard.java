package model;

public class PropertyCard extends Document{


    public PropertyCard(double price, int year) {
        super(price,year);
    }
    @Override
    public String toString(){
        return "\nThe propety card certificate of the vehicle of the year "+super.getYear()+" has a price of: "+super.getPrice();
    }
    @Override
    public String generateCode(){
        String code ="";
        int[][] matrix=super.imageCreator();
        //We start the tour from the last column of the last row, from this we are going to obtain the data of the 
        //positions in the matrix that fulfill that the sum of the position of the column and row is even
        for(int ronNum = matrix.length-1; ronNum>=0; ronNum--){
          for(int columnNum= matrix[0].length-1; columnNum>=0;columnNum--){
             if((ronNum+columnNum)%2==0 && (ronNum+columnNum)!=0){
                code += " "+matrix[ronNum][columnNum];
              }
          }
        }
        return code;
    }
    
}