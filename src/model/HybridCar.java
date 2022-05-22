package model;
import java.util.Calendar;

public class HybridCar extends Car implements GasConsumption, BatteryConsumption{
    private double bateryLife;
    private double tankCapacity;
    private GasType typeOfGas;
    private ChargerType typeOfCharger;
    /**
     * Constructor method of the hybridcar object
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
     * @param tankCapacity a double with the vehicle's tank capacity
     * @param bateryLife a double with the battery life of the vehicle
     * @param typeOfGas an integer being 1 extra type gasoline, 2 being regular gasoline and 3 diesel gasoline of the vehicle
     * @param typeOfCharger an integer with 1 being a fast type battery charger and 2 being a normal type
     */
    public HybridCar(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, int isNew, String licensePlate,SOAT soat,TechnicalMechanical certificate,PropertyCard propertyCard,CarType typeOfCar,int numDoors, boolean isPolarized,double bateryLife, double tankCapacity, GasType typeOfGas, ChargerType typeOfCharger) {
        super(id,basePrice, brand, model, year, cylinderCapacity, mileage, isNew, licensePlate, soat, certificate, propertyCard, typeOfCar, numDoors, isPolarized);
        this.bateryLife = bateryLife;
        this.tankCapacity = tankCapacity;
        this.typeOfGas = typeOfGas;
        this.typeOfCharger = typeOfCharger;
    }
    @Override
    public double calcSellingPrice(){
        double finalPrice=super.getBasePrice()*1.15;
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
        return super.toString()+"\nBatery life: "+bateryLife+"\nTankCapacity: "+tankCapacity+"\nType of gas: "+typeOfGas+"\nType of charger: "+typeOfCharger+"\nGas consumption: "+calcGasConsumption()+"Battery consumption: "+calcBatteryConsumption()+"\n\nSALE VALUE OF THE CAR IS: "+String.format("%.2f",calcSellingPrice())+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    }
    @Override
    public double calcBatteryConsumption(){
        double out=0;
        if(typeOfCharger==ChargerType.FAST){
            out=bateryLife*(super.getCylinderCapacity()/200);
        }else if(typeOfCharger==ChargerType.NORMAL){
            out=(bateryLife+7)*(super.getCylinderCapacity()/200);
        }
        return out;
    };
    @Override
    public double calcGasConsumption(){
        return tankCapacity/(super.getCylinderCapacity()/180);
    };


    public double getBateryLife() {
        return this.bateryLife;
    }

    public void setBateryLife(double bateryLife) {
        this.bateryLife = bateryLife;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public GasType getTypeOfGas() {
        return this.typeOfGas;
    }

    public void setTypeOfGas(GasType typeOfGas) {
        this.typeOfGas = typeOfGas;
    }

    public ChargerType getTypeOfCharger() {
        return this.typeOfCharger;
    }

    public void setTypeOfCharger(ChargerType typeOfCharger) {
        this.typeOfCharger = typeOfCharger;
    }

}