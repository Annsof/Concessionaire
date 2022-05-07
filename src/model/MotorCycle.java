package model;
import java.util.Calendar;

public class MotorCycle extends Vehicle implements GasConsumption{
    private double gasCapacity;
    private MotorCycleType typeOfMotorCycle;

    public MotorCycle(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, boolean isNew, String licensePlate,SOAT soat,TechnicalMechanical certificate,PropertyCard propertyCard,double gasCapacity, MotorCycleType typeOfMotorCycle) {
        super(id,basePrice, brand, model, year, cylinderCapacity, mileage, isNew, licensePlate, soat, certificate, propertyCard);
        this.gasCapacity = gasCapacity;
        this.typeOfMotorCycle = typeOfMotorCycle;
    }
    @Override
    public String toString(){
        return  super.toString()+"\nTankCapacity: "+gasCapacity+"\nType of motorcycle: "+typeOfMotorCycle+"\nGas consumption: "+calcGasConsumption()+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    }
    @Override
    public double calcSellingPrice(){
        double finalPrice=super.getBasePrice()*1.04;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        //if((super.getSoat().getYear()!=year)||(super.getCertificate().getYear()!=year && super.getIsNew()!=true)){
       //     finalPrice+=500000;
        //}
        if (super.getIsNew()==false){
            finalPrice+= -(super.getBasePrice()*0.02);
        }
        return finalPrice;
    }
    @Override
    public double calcGasConsumption(){
        return gasCapacity/(super.getCylinderCapacity()/75);
    };

    public double getGasCapacity() {
        return this.gasCapacity;
    }

    public void setGasCapacity(double gasCapacity) {
        this.gasCapacity = gasCapacity;
    }

    public MotorCycleType getTypeOfMotorCycle() {
        return this.typeOfMotorCycle;
    }

    public void setTypeOfMotorCycle(MotorCycleType typeOfMotorCycle) {
        this.typeOfMotorCycle = typeOfMotorCycle;
    }


    
}