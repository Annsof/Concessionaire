package model;
import java.util.Calendar;

public class MotorCycle extends Vehicle implements GasConsumption{
    private double gasCapacity;
    private MotorCycleType typeOfMotorCycle;

    /**
     * Constructor method of the motorcycle object
     * @param id initialized with the vehicle identification code a String
     * @param basePrice Needs to have the base price of the vehicle a double
     * @param brand String with the name of the manufacturer or make of the vehicle
     * @param model A string with the vehicle model name
     * @param year an integer with the year of the vehicle
     * @param cylinderCapacity a double with the cylinder capacity of the vehicle
     * @param mileage a double with the mileage of the vehicle
     * @param isNew an integer where 0 is used and 1 is new
     * @param licensePlate A chain with the vehicle plate in case it is used
     * @param soat a soat type object with the information of the soat document of the vehicle in case it is used
     * @param certificate a mechanical technical type object with the information of the mechanical technical document of the vehicle in case it is used
     * @param propertyCard a property card type object with the information of the vehicle property card document in case it is used
     * @param gasCapacity a double with the vehicle's tank capacity
     * @param typeOfMotorCycle an integer being 1 standard type motorcycle, 2 being sport, 3 being scooter and 4 being cross
     */
    public MotorCycle(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, int isNew, String licensePlate,SOAT soat,TechnicalMechanical certificate,PropertyCard propertyCard,double gasCapacity, MotorCycleType typeOfMotorCycle) {
        super(id,basePrice, brand, model, year, cylinderCapacity, mileage, isNew, licensePlate, soat, certificate, propertyCard);
        this.gasCapacity = gasCapacity;
        this.typeOfMotorCycle = typeOfMotorCycle;
    }
    @Override
    public String toString(){
        return  super.toString()+"\nTankCapacity: "+gasCapacity+"\nType of motorcycle: "+typeOfMotorCycle+"\nGas consumption: "+calcGasConsumption()+"\n\nSALE VALUE OF THE MOTORCYCLE IS: "+String.format("%.2f",calcSellingPrice())+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    }
    @Override
    public double calcSellingPrice(){
        double finalPrice=super.getBasePrice()*1.04;
        int year = Calendar.getInstance().get(Calendar.YEAR);
       if((super.getCertificate().getYear()!=year && super.getIsNew()==0)||(super.getSoat().getYear()!=year)){
           finalPrice+=500000;
        }
        if (super.getIsNew()==0){
         finalPrice-= (super.getBasePrice()*0.1);
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