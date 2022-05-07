package model;
import java.util.Calendar;

public class HybridCar extends Car implements GasConsumption, BatteryConsumption{
    private double bateryLife;
    private double tankCapacity;
    private GasType typeOfGas;
    private ChargerType typeOfCharger;

    public HybridCar(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, boolean isNew, String licensePlate,SOAT soat,TechnicalMechanical certificate,PropertyCard propertyCard,CarType typeOfCar,int numDoors, boolean isPolarized,double bateryLife, double tankCapacity, GasType typeOfGas, ChargerType typeOfCharger) {
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
        if((super.getSoat().getYear()!=year)||(super.getCertificate().getYear()!=year && super.getIsNew()!=true)){
            finalPrice+=500000;
        }
        if (super.getIsNew()==false){
            finalPrice+= -(super.getBasePrice()*0.1);
        }
        return finalPrice;
    }
    @Override
    public String toString(){
        return super.toString()+"\nBatery life: "+bateryLife+"\nTankCapacity: "+tankCapacity+"\nType of gas: "+typeOfGas+"\nType of charger: "+typeOfCharger+"\nGas consumption: "+calcGasConsumption()+"Battery consumption: "+calcBatteryConsumption()+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
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