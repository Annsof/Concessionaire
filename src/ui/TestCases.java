package ui; 
import model.*;
import java.util.ArrayList;

public class TestCases {

    private ArrayList<Vehicle> vehicles;
    public TestCases(){}

    public ArrayList<Vehicle> CasesVehicles(){
        this.vehicles = new ArrayList<Vehicle>();
        this.vehicles.add(new GasCar("123",35000000, "Kia", "Rio",2009,1200,15000, 0, "DIU 530",new SOAT(150000,2022,5000000),new TechnicalMechanical(70000,2022,150),new PropertyCard(100000,2020),CarType.SEDAN,4,true,700,GasType.DIESEL));
        this.vehicles.add(new GasCar("124",35000000, "Kia", "Rio",2009,1200,15000, 0, "DIU 530",new SOAT(150000,2022,5000000),new TechnicalMechanical(70000,2022,150),new PropertyCard(100000,2020),CarType.SEDAN,4,true,700,GasType.DIESEL));
        this.vehicles.add(new GasCar("125",35000000, "Kia", "Rio",2013,1200,15000, 0, "DIU 530",new SOAT(150000,2022,5000000),new TechnicalMechanical(70000,2022,150),new PropertyCard(100000,2020),CarType.SEDAN,4,true,700,GasType.DIESEL));
        this.vehicles.add(new GasCar("126",35000000, "Kia", "Rio",2013,1200,15000, 0, "DIU 530",new SOAT(150000,2022,5000000),new TechnicalMechanical(70000,2022,150),new PropertyCard(100000,2020),CarType.SEDAN,4,true,700,GasType.DIESEL));
        this.vehicles.add(new GasCar("127",35000000, "Kia", "Rio",2013,1200,15000, 0, "DIU 530",new SOAT(150000,2022,5000000),new TechnicalMechanical(70000,2022,150),new PropertyCard(100000,2020),CarType.SEDAN,4,true,700,GasType.DIESEL));



        this.vehicles.add(new GasCar("128",35000000, "Kia", "Rio",2016,1200,15000, 0, "DIU 530",new SOAT(150000,2022,5000000),new TechnicalMechanical(70000,2022,150),new PropertyCard(100000,2020),CarType.SEDAN,4,true,700,GasType.DIESEL));




        this.vehicles.add(new GasCar("129",35000000, "Kia", "Rio",2013,1200,15000, 0, "DIU 530",new SOAT(150000,2022,5000000),new TechnicalMechanical(70000,2022,150),new PropertyCard(100000,2020),CarType.SEDAN,4,true,700,GasType.DIESEL));
        this.vehicles.add(new GasCar("130",35000000, "Kia", "Rio",2013,1200,15000, 0, "DIU 530",new SOAT(150000,2022,5000000),new TechnicalMechanical(70000,2022,150),new PropertyCard(100000,2020),CarType.SEDAN,4,true,700,GasType.DIESEL));
        this.vehicles.add(new GasCar("131",35000000, "Kia", "Rio",2013,1200,15000, 0, "DIU 530",new SOAT(150000,2022,5000000),new TechnicalMechanical(70000,2022,150),new PropertyCard(100000,2020),CarType.SEDAN,4,true,700,GasType.DIESEL));
        this.vehicles.add(new GasCar("132",35000000, "Kia", "Rio",2013,1200,15000, 0, "DIU 530",new SOAT(150000,2022,5000000),new TechnicalMechanical(70000,2022,150),new PropertyCard(100000,2020),CarType.SEDAN,4,true,700,GasType.DIESEL));
        this.vehicles.add(new GasCar("133",35000000, "Kia", "Rio",2013,1200,15000, 0, "DIU 530",new SOAT(150000,2022,5000000),new TechnicalMechanical(70000,2022,150),new PropertyCard(100000,2020),CarType.SEDAN,4,true,700,GasType.DIESEL));
        this.vehicles.add(new GasCar("134",35000000, "Kia", "Rio",2013,1200,15000, 0, "DIU 530",new SOAT(150000,2022,5000000),new TechnicalMechanical(70000,2022,150),new PropertyCard(100000,2020),CarType.SEDAN,4,true,700,GasType.DIESEL));

        this.vehicles.add(new MotorCycle("136", 10000000, "yamaha", "ninja",2012 , 1000, 10, 0,"4AJ", new SOAT(150000,2022,5000000), new TechnicalMechanical(70000,2022,150), new PropertyCard(100000,2020), 10, MotorCycleType.SPORT));
        this.vehicles.add(new MotorCycle("137", 10000000, "yamaha", "ninja",2012 , 1000, 10, 0,"4AJ", new SOAT(150000,2022,5000000), new TechnicalMechanical(70000,2022,150), new PropertyCard(100000,2020), 10, MotorCycleType.SPORT));

        this.vehicles.add(new HybridCar("138",50000000,"Hyundai", "Tucson",2013,2000,0,0,"",new SOAT(0, 0, 0), new TechnicalMechanical(0, 0, 0),new PropertyCard(0, 0),CarType.PICKUP_TRUCK,4,false,50,150,GasType.EXTRA,ChargerType.FAST)); 
        

        this.vehicles.add(new HybridCar("139",50000000,"Hyundai", "Tucson",2014,2000,0,0,"",new SOAT(0, 0, 0), new TechnicalMechanical(0, 0, 0),new PropertyCard(0, 0),CarType.PICKUP_TRUCK,4,false,50,150,GasType.EXTRA,ChargerType.FAST));

        return vehicles;
    }
}