package model;
import java.util.Calendar;

public class ElectricCar extends Car implements BatteryConsumption{
    private double bateryLife;
    private ChargerType typeOfCharger;

     /**
    * Constructor method of the electric car object
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
     * @param typeOfCar An integer of the type of car that is where 1 is a sedan and 2 is a van
     * @param numDoors an integer with the number of vehicle doors
     * @param isPolarized A boolean being true if the vehicle is polarized, and false if it is not polarized.
     * @param typeOfCharger an integer with 1 being a fast type battery charger and 2 being a normal type
     * @param bateryLife a double with the battery life of the vehicle
    */
    public ElectricCar(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, int isNew, String licensePlate,SOAT soat,TechnicalMechanical certificate,PropertyCard propertyCard,CarType typeOfCar,int numDoors, boolean isPolarized,double bateryLife, ChargerType typeOfCharger) {
        super(id,basePrice, brand, model, year, cylinderCapacity, mileage, isNew, licensePlate, soat, certificate, propertyCard, typeOfCar, numDoors, isPolarized);
        this.bateryLife = bateryLife;
        this.typeOfCharger = typeOfCharger;
    }
    @Override
    public double calcSellingPrice(){
        double finalPrice=super.getBasePrice()*1.2;
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
    public String toString(){
        return super.toString()+"\nBatery life: "+bateryLife+"\nTankCapacity: "+"\nType of charger: "+typeOfCharger+"\nBattery consumption: "+calcBatteryConsumption()+"\n\nSALE VALUE OF THE CAR IS: "+String.format("%.2f",calcSellingPrice())+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    }
    @Override
    public double calcBatteryConsumption(){
        double out=0;
        if(typeOfCharger==ChargerType.FAST){
            out=(bateryLife+13)*(super.getCylinderCapacity()/100);
        }else if(typeOfCharger==ChargerType.NORMAL){
            out=(bateryLife+18)*(super.getCylinderCapacity()/100);
        }
        return out;
    };

    public double getBateryLife() {
        return this.bateryLife;
    }

    public void setBateryLife(double bateryLife) {
        this.bateryLife = bateryLife;
    }

    public ChargerType getTypeOfCharger() {
        return this.typeOfCharger;
    }

    public void setTypeOfCharger(ChargerType typeOfCharger) {
        this.typeOfCharger = typeOfCharger;
    }


}