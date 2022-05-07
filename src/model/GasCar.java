package model;
import java.util.Calendar;

public class GasCar extends Car implements GasConsumption{
    private double tankCapacity;
    private GasType typeOfGas;
    private boolean godHelp;

    public GasCar(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, boolean isNew, String licensePlate,SOAT soat,TechnicalMechanical certificate,PropertyCard propertyCard,CarType typeOfCar,int numDoors, boolean isPolarized,double tankCapacity,GasType typeOfGas) {
       super(id,basePrice, brand, model, year,cylinderCapacity, mileage, isNew, licensePlate,soat,certificate,propertyCard,typeOfCar,numDoors,isPolarized);
        this.tankCapacity = tankCapacity;
        this.typeOfGas=typeOfGas;
        this.godHelp=true;
        System.out.println("VIENDO QUE PASA EN CARRO A sadasdsadassad" + godHelp);
    }
    @Override
    public double calcSellingPrice(){
        System.out.println("es nuevo AAAAAAAAAAAAAAAAAAAAAAAAAAA"+godHelp);
        double finalPrice=super.getBasePrice();
        int year = Calendar.getInstance().get(Calendar.YEAR);
       // if((super.getSoat().getYear()!=year)||(super.getCertificate().getYear()!=year && super.getIsNew()!=true)){
         //   finalPrice+=500000;
        //}
        if (super.getIsNew()==false){
         finalPrice-= (super.getBasePrice()*0.1);
        }
        return finalPrice;
    }
    @Override
    public String toString(){
        System.out.println("LO MISMO PERO EN UN METODO NO ABSTRACTO "+godHelp);
        return super.toString()+"\nTankCapacity: "+tankCapacity+"\nType of gas: "+typeOfGas+"\nGas consumption: "+calcGasConsumption()+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    }
    @Override
    public double calcGasConsumption(){
        return tankCapacity/(super.getCylinderCapacity()/150);
    }

    public GasType getTypeOfGas() {
        return this.typeOfGas;
    }

    public void setTypeOfGas(GasType typeOfGas) {
        this.typeOfGas = typeOfGas;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
    
}