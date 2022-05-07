package ui; 
import model.*;
import java.util.ArrayList;

public class TestCases {

    private ArrayList<Vehicle> vehicles;
    public TestCases(){}
    public ArrayList<Vehicle> CasesVehicles(){
        this.vehicles = new ArrayList<Vehicle>();
        this.vehicles.add(new GasCar("123",35000000, "Kia", "Rio",2016,1200,15000, true, "DIU 530",new SOAT(150000,2022,5000000),new TechnicalMechanical(70000,2019,150),new PropertyCard(100000,2020),CarType.SEDAN,4,true,700,GasType.CURRENT));
        return vehicles;
    }
}