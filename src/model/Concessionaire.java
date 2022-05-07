package model;
import java.util.ArrayList;

public class Concessionaire{
    private ArrayList<Vehicle> vehicles;
    public Concessionaire(){
        this.vehicles = new ArrayList<Vehicle>();
    }
    public Concessionaire(ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
    }
    public boolean registerVehicle(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, boolean isNew, String licensePlate,double coverPrice,int soatYear,double soatPrice, double gasLevels, int certificateYear, double certificatePrice, int propetyCardYear, double propetyCardPrice,int typeOfCar,int numDoors, boolean isPolarized,double tankCapacity,int typeOfGas){
       //Gasoline
        boolean out=false;
        CarType carType=null;
        switch(typeOfCar){
            case 1:
            carType=CarType.SEDAN;
            break;
            case 2:
            carType=CarType.PICKUP_TRUCK;
            break;
        }
        GasType gasType=null;
        switch(typeOfGas){
            case 1:
            gasType=GasType.EXTRA;
            break;
            case 2:
            gasType=GasType.CURRENT;
            break;
            case 3:
            gasType=GasType.DIESEL;
            break;
        }
        this.vehicles.add(new GasCar(id, basePrice, brand, model, year, cylinderCapacity, mileage, isNew, licensePlate, new SOAT(soatPrice,soatYear,coverPrice), new TechnicalMechanical(certificatePrice,certificateYear,gasLevels), new PropertyCard(propetyCardPrice,propetyCardYear), carType, numDoors, isPolarized, tankCapacity, gasType));
        out=true;
        return out;
    }
    public boolean registerVehicle(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, boolean isNew, String licensePlate,double coverPrice,int soatYear,double soatPrice, double gasLevels, int certificateYear, double certificatePrice, int propetyCardYear, double propetyCardPrice,int typeOfCar,int numDoors, boolean isPolarized,double tankCapacity,double bateryLife,int typeOfGas, int typeOfCharger){
        //Hybrid
        boolean out=false;
        CarType carType=null;
        switch(typeOfCar){
            case 1:
            carType=CarType.SEDAN;
            break;
            case 2:
            carType=CarType.PICKUP_TRUCK;
            break;
        }
        GasType gasType=null;
        switch(typeOfGas){
            case 1:
            gasType=GasType.EXTRA;
            break;
            case 2:
            gasType=GasType.CURRENT;
            break;
            case 3:
            gasType=GasType.DIESEL;
            break;
        }
        ChargerType chargerType=null;
        switch(typeOfCharger){
            case 1:
            chargerType=ChargerType.FAST;
            break;
            case 2:
            chargerType=ChargerType.NORMAL;
            break;
        }
        this.vehicles.add(new HybridCar(id,basePrice,brand,model,year,cylinderCapacity,mileage,isNew,licensePlate, new SOAT(soatPrice,soatYear,coverPrice), new TechnicalMechanical(certificatePrice,certificateYear,gasLevels), new PropertyCard(propetyCardPrice,propetyCardYear), carType, numDoors,  isPolarized, bateryLife,  tankCapacity,  gasType,  chargerType));
        return out;
    }
    public boolean registerVehicle(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, boolean isNew, String licensePlate,double coverPrice,int soatYear,double soatPrice, double gasLevels, int certificateYear, double certificatePrice, int propetyCardYear, double propetyCardPrice,int typeOfCar,int numDoors, boolean isPolarized, int typeOfCharger,double bateryLife){
       //Electric
        boolean out=false;
        CarType carType=null;
        switch(typeOfCar){
            case 1:
            carType=CarType.SEDAN;
            break;
            case 2:
            carType=CarType.PICKUP_TRUCK;
            break;
        }
        ChargerType chargerType=null;
        switch(typeOfCharger){
            case 1:
            chargerType=ChargerType.FAST;
            break;
            case 2:
            chargerType=ChargerType.NORMAL;
            break;
        }                                                                                                                                                                       
        this.vehicles.add( 
        new ElectricCar(id, basePrice,brand,model,year,cylinderCapacity,mileage,isNew,licensePlate, 
            new SOAT(soatPrice,soatYear,coverPrice), 
            new TechnicalMechanical(certificatePrice,certificateYear,gasLevels), 
            new PropertyCard(propetyCardPrice,propetyCardYear), 
            carType, numDoors,  isPolarized, bateryLife, chargerType));
        out=true;
        return out;
    }
    public boolean registerVehicle(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, boolean isNew, String licensePlate,double coverPrice,int soatYear,double soatPrice, double gasLevels, int certificateYear, double certificatePrice, int propetyCardYear, double propetyCardPrice,double gasCapacity, int typeOfMotorCycle){
        //MotorCycle
        boolean out=false;
        MotorCycleType motorCycleType=null;
        switch(typeOfMotorCycle){
            case 1:
            motorCycleType=MotorCycleType.STANDARD;
            break;
            case 2:
            motorCycleType=MotorCycleType.SPORT;
            break;
            case 3:
            motorCycleType=MotorCycleType.SCOOTER;
            break;
            case 4:
            motorCycleType=MotorCycleType.CROSS;
            break;
        }
        this.vehicles.add(new MotorCycle(id,basePrice, brand, model, year, cylinderCapacity, mileage, isNew, licensePlate, new SOAT(soatPrice,soatYear,coverPrice), new TechnicalMechanical(certificatePrice,certificateYear,gasLevels), new PropertyCard(propetyCardPrice,propetyCardYear), gasCapacity, motorCycleType));
        out=true;
        return out;
    }
    public String generateReportVehicles(){
        String out="";
        for(int i=0;i<vehicles.size();i++){
			if(!vehicles.get(i).toString().equals("") && !vehicles.isEmpty()){
				out+=vehicles.get(i).toString();
			}
		}
        return out;
    }
}