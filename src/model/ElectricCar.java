package model;
import java.util.Calendar;

public class ElectricCar extends Car implements BatteryConsumption{
    private double bateryLife;
    private ChargerType typeOfCharger;

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