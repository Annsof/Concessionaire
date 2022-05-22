package ui;
import java.util.Scanner;
import model.Concessionaire;

public class Main{

    private Concessionaire conc;
    private Scanner sc;
    /**
     * Constructor method of main object
     */
    public Main(){
        TestCases testcases=new TestCases();
        conc = new Concessionaire(testcases.CasesVehicles());
        sc = new Scanner(System.in);
    }
    
    public static void main(String[]arg){
        System.out.println("Welcome to The Vehicle's Dealership");
        Main ppl= new Main();
        int option=0;
     do{
        option=ppl.showMenu();
        ppl.runMenu(option);
       }while(option!=0);
    }
    /**
     * Method that displays the menu on the screen
     * @return an integer with the option chosen by the user
     */
    public int showMenu(){
        System.out.println("Choose one of the following options to manage the vehicle's dealership\n"+
                                "(1)Register vehicles for sale\n"+
                                "(2)Generate selling price of a vehicle\n"+
                                "(3)Generate report of available vehicles\n"+
                                "(4)Search documents of a vehicle\n"+
                                "(5)Show parking map\n"+
                                "(6)Generate parking reports\n"+
                                "(0)Exit");
       int option=sc.nextInt();
       sc.nextLine();
       return option;
    }
    /**
     * Method that executes the menu option chosen by the user
     * @param option initialized with the option chosen by the user
     */
    public void runMenu(int option){
        switch(option){
            case 1:
            registerVehicle();
                break;
            case 2:
            generateAVehiclesPrice();
                break;
            case 3: 
            generateReport();
                break;
            case 4: 
            documentsOfVehicle();
                break;
            case 5: 
            System.out.println(conc.showParkingLot());
                break;
            case 6: 
            GenerateParkingReports();
                break;
            case 0:
            System.out.println("Bye!");
                break;
            default:
            
            break;
        }


    }
    /**
     * Method that shows on the screen the documents of a vehicle given an id
     */
    public void documentsOfVehicle(){
        System.out.println("Enter the id of the vehicle to generate its documents");
        String id=sc.nextLine();
        System.out.println(conc.lookUpVehiculesDocuments(id)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
    /**
     * Method that shows on the screen the sale price of a vehicle given an id
     */
    public void generateAVehiclesPrice(){
        System.out.println("Enter the id of the vehicle to generate its sale price");
        String id=sc.nextLine();
        System.out.println(conc.lookUpVehiculesSalePrice(id)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
    /**
     * Method that registers a new vehicle at the dealership
     */
    public void registerVehicle(){
        double gasCapacity=0,bateryLife=0,soatPrice=0,coverPrice=0,gasLevels=0,certificatePrice=0,propetyCardPrice=0,mileage=0;
        String licensePlate="", id="";
        int typeOfCar=0,numDoors=0,typeOfGas=0,typeOfCharger=0,soatYear=0,certificateYear=0,propetyCardYear=0;
        boolean isPolarized=false, returned=false;

        System.out.println("Registering vehicle");

        System.out.println("What is the id of the vehicle");
        id=sc.nextLine();
        if(-1==conc.getVehicule(id)){

        
        System.out.println("What is the base price of the vehicle");
        double basePrice=sc.nextDouble();
        sc.nextLine();

        System.out.println("What is the brand of the vehicle (EXAMPLE: KIA)");
        String brand=sc.nextLine();

        System.out.println("What is the year that the vehicule was fabricated");
        int year=sc.nextInt();
        sc.nextLine();

        System.out.println("What is the model of the vehicle (EXAMPLE: RIO)");
        String model=sc.nextLine();

        System.out.println("How much is the cylinder capacity of the vehicle (EXAMPLE: 1000");
        double cylinderCapacity=sc.nextDouble();
        sc.nextLine();

        System.out.println("What is the state of the vehicle\n"+
                            "(0)Used"+
                            "(1)New");
        int isNew=sc.nextInt();
        sc.nextLine();
        while (isNew<0 || isNew>1){
            System.out.println("Enter a valid answer");
            System.out.println("What is the state of the vehicle\n"+
                            "(0)Used"+
                            "(1)New");
        isNew=sc.nextInt();
        sc.nextLine();
        }
        if (isNew==0){
            System.out.println("What is the mileage of the vehicle");
            mileage=sc.nextDouble();
            sc.nextLine();  

            System.out.println("What is the license plate of the vehicle");
            licensePlate=sc.nextLine();

            System.out.println("What is the year of the SOAT?");
            soatYear=sc.nextInt();
            sc.nextLine();

            System.out.println("What is the price of the SOAT?");
            soatPrice=sc.nextDouble();
            sc.nextLine(); 

            System.out.println("What is the price amount of vehicle coverage of the SOAT");
            coverPrice=sc.nextDouble();
            sc.nextLine();

            System.out.println("What are the gas levels of the vehicle");
            gasLevels=sc.nextDouble();
            sc.nextLine();
             
            System.out.println("What is the year of the technical mecanical certificate?");
            certificateYear=sc.nextInt();
            sc.nextLine();

            System.out.println("What is the price of the technical mecanical certificate?");
            certificatePrice=sc.nextDouble();
            sc.nextLine(); 
    
            System.out.println("What is the year of the propety card of the vehicle?");
            propetyCardYear=sc.nextInt();
            sc.nextLine();
    
            System.out.println("What is the price of the technical mecanical certificate?");
            propetyCardPrice=sc.nextDouble();
            sc.nextLine(); 
       } 
        
        System.out.println("What type of vehicle will you register?\n"+
                            "(1)A motorCycle\n"+
                            "(2)A hybrid car\n"+
                            "(3)An electric car\n"+
                            "(4)A gas car\n");
        int option1 = sc.nextInt();
        sc.nextLine();
        while (option1<1 || option1>4){
            System.out.println("Enter a valid answer");
            System.out.println("What type of vehicle will you register?\n"+
                            "(1)A motorCycle\n"+
                            "(2)A hybrid car\n"+
                            "(3)An electric car\n"+
                            "(4)A gas car\n");
            option1 = sc.nextInt();
            sc.nextLine();
        }
        if(option1==2 ||option1==3 ||option1==4){
            System.out.println("What is the number of car doors");
            numDoors=sc.nextInt();
            System.out.println("Is the car polarized? (true/false)");
            isPolarized=sc.nextBoolean();
            System.out.println("What type of car is the vehicle?\n"+
                            "(1)Sedan\n"+
                            "(2)Pick up truck\n");
            typeOfCar = sc.nextInt();
            sc.nextLine();
        while (typeOfCar<1 || typeOfCar>2){
            System.out.println("Enter a valid answer");
            System.out.println("What type of car is the vehicle?\n"+
                            "(1)Sedan\n"+
                            "(2)Pick up truck\n");
            typeOfCar = sc.nextInt();
            sc.nextLine();
        }
        }  
        switch(option1){
            case 1:
           System.out.println("What is the capacity of the gas tank");
            gasCapacity=sc.nextDouble();
            System.out.println("What is the type of motorcycle\n"+
                                "(1)Standard\n"+
                                "(2)Sport\n"+
                                "(3)Scooter\n"+
                                "(4)Cross\n");
            int typeOfMotorCycle=sc.nextInt();
            sc.nextLine();
            while (typeOfMotorCycle<1 || typeOfMotorCycle>4){
                System.out.println("Enter a valid answer");
                System.out.println("What is the type of motorcycle\n"+
                                "(1)Standard\n"+
                                "(2)Sport\n"+
                                "(3)Scooter\n"+
                                "(4)Cross\n");
                typeOfMotorCycle=sc.nextInt();
                sc.nextLine();
            }
            returned=conc.registerVehicle(id, basePrice,  brand,  model, year,  cylinderCapacity,  mileage,  isNew,  licensePlate, coverPrice, soatYear, soatPrice,  gasLevels,  certificateYear,  certificatePrice,  propetyCardYear,  propetyCardPrice, gasCapacity,  typeOfMotorCycle);
            if (returned){
            System.out.println("You have registered successfully");
            }else{
            System.out.println("Failed to register");
            }  
                break;
            case 2:
            System.out.println("What is the capacity of the gas tank");
            gasCapacity=sc.nextDouble();
            System.out.println("what's the battery life of the hybrid car");
            bateryLife=sc.nextDouble();
            System.out.println("What type of batery does the hybrid car has?\n"+
                                "(1)Fast\n"+
                                "(2)Normal\n");
            typeOfCharger=sc.nextInt();
            sc.nextLine();
            while (typeOfCharger<1 || typeOfCharger>2){
                System.out.println("Enter a valid answer");
                System.out.println("What type of batery does the hybrid car has?\n"+
                "(1)Fast\n"+
                "(2)Normal\n");
                typeOfCharger=sc.nextInt();
                sc.nextLine();
            }
            System.out.println("What type of gasoline does the hybrid car has?\n"+
                                "(1)Extra\n"+
                                "(2)Current\n"+
                                "(3)Diesel\n");
            typeOfGas=sc.nextInt();
            sc.nextLine();
            while (typeOfGas<1 || typeOfGas>3){
                System.out.println("Enter a valid answer");
                System.out.println("What type of gasoline does the hybrid car has?\n"+
                                "(1)Extra\n"+
                                "(2)Current\n"+
                                "(3)Diesel\n");
                typeOfGas=sc.nextInt();
                sc.nextLine();
            }
            returned=conc.registerVehicle(id, basePrice,  brand,  model, year,  cylinderCapacity,  mileage,  isNew,  licensePlate, coverPrice, soatYear, soatPrice,  gasLevels,  certificateYear,  certificatePrice,  propetyCardYear,  propetyCardPrice, typeOfCar, numDoors,  isPolarized, gasCapacity, bateryLife, typeOfGas,  typeOfCharger);
            if (returned){
            System.out.println("You have registered successfully");
            }else{
            System.out.println("Failed to register");
            }  
                break;
            case 3:
            System.out.println("what's the battery life of the electric car");
            bateryLife=sc.nextDouble();
            System.out.println("What type of batery does the electric car has?\n"+
                                "(1)Fast\n"+
                                "(2)Normal\n");
            typeOfCharger=sc.nextInt();
            sc.nextLine();
            while (typeOfCharger<1 || typeOfCharger>2){
                System.out.println("Enter a valid answer");
                System.out.println("What type of batery does the hybrid car has?\n"+
                "(1)Fast\n"+
                "(2)Normal\n");
                typeOfCharger=sc.nextInt();
                sc.nextLine();
            }
            returned=conc.registerVehicle(id, basePrice,  brand,  model, year,  cylinderCapacity,  mileage,  isNew,  licensePlate, coverPrice, soatYear, soatPrice,  gasLevels,  certificateYear,  certificatePrice,  propetyCardYear,  propetyCardPrice, typeOfCar, numDoors,  isPolarized,  typeOfCharger, bateryLife);
            if (returned){
            System.out.println("You have registered successfully");
            }else{
            System.out.println("Failed to register");
            }  
                break;
            case 4:
            System.out.println("What is the capacity of the gas tank");
            gasCapacity=sc.nextDouble();
            System.out.println("What type of gasoline does the gas car has?\n"+
                                "(1)Extra\n"+
                                "(2)Current\n"+
                                "(3)Diesel\n");
            typeOfGas=sc.nextInt();
            sc.nextLine();
            while (typeOfGas<1 || typeOfGas>3){
                System.out.println("Enter a valid answer");
                System.out.println("What type of gasoline does the hybrid car has?\n"+
                                "(1)Extra\n"+
                                "(2)Current\n"+
                                "(3)Diesel\n");
                typeOfGas=sc.nextInt();
                sc.nextLine();
            }
            returned=conc.registerVehicle(id,basePrice,brand, model, year, cylinderCapacity,  mileage,  isNew,  licensePlate, coverPrice, soatYear, soatPrice,  gasLevels,  certificateYear,  certificatePrice,  propetyCardYear,  propetyCardPrice,typeOfCar, numDoors, isPolarized,gasCapacity,typeOfGas);
            if (returned){
            System.out.println("You have registered successfully");
            }else{
            System.out.println("Failed to register");
            }  
            break;
        }
        }else{
            System.out.println("This vehicle id has already been registered");
        }
    }
    /**
     * method that generates reports of vehicles in the dealer given certain conditions by the user
     */
    public void generateReport(){
        int option2=0, option3=0;
        System.out.println("Generate report according to the following criteria\n"+
                            "(1)Vehicle type\n"+
                            "(2)Fuel type\n"+
                            "(3)New or used\n"+
                            "(4)Show all vehicles\n");
        int option=sc.nextInt();
        sc.nextLine();
        while (option<1 || option>4){
            System.out.println("Enter a valid answer");
            System.out.println("Generate report according to the following criteria\n"+
                            "(1)Vehicle type\n"+
                            "(2)Fuel type\n"+
                            "(3)New or used\n"+
                            "(4)Show all vehicles\n");
            option=sc.nextInt();
            sc.nextLine();
        }
        switch(option){
            case 1:
            System.out.println("Generate report according to the following criteria\n"+
                            "(1)Car\n"+
                            "(2)MotorCycle\n"); 
            option2=sc.nextInt();
            sc.nextLine();
            while (option2<1 || option2>2){
                System.out.println("Enter a valid answer");
                System.out.println("Generate report according to the following criteria\n"+
                            "(1)Car\n"+
                            "(2)MotorCycle\n"); 
                option2=sc.nextInt();
                sc.nextLine();
            }

            switch(option2){
                case 1:
                    System.out.println("Generate report according to the following criteria\n"+
                            "(1)Gasoline car\n"+
                            "(2)Electric Car\n"+
                            "(3)Hybrid car\n"+
                            "(4)All Cars\n"); 
                     option3=sc.nextInt();
                    sc.nextLine();
                    while (option3<1 || option3>2){
                        System.out.println("Enter a valid answer");
                        System.out.println("Generate report according to the following criteria\n"+
                            "(1)Gasoline car\n"+
                            "(2)Electric Car\n"+
                            "(3)Hybrid car\n"+
                            "(4)All Cars\n"); 
                        option3=sc.nextInt();
                        sc.nextLine();
                    }
                switch(option3){
                    case 1:
                        System.out.println("========================================================\nGASOLINE CARS\n"+conc.generateReportGasCar()+"\n");
                    break;
                    case 2:
                        System.out.println("========================================================\nELECTRIC CARS\n"+conc.generateReportElectricCars()+"\n");
                    break;
                    case 3:
                        System.out.println("========================================================\nHYBRID CARS\n"+conc.generateReportHybridCar()+"\n");
                    break;
                    case 4: 
                        System.out.println("========================================================\nGASOLINE CARS\n"+conc.generateReportGasCar()+"\n========================================================\nELECTRIC CARS\n"+conc.generateReportElectricCars()+"\n========================================================\nHYBRID CARS\n"+conc.generateReportHybridCar()+"\n");
                    break;
                }
            
                break;
                case 2:
                System.out.println("========================================================\nMOTORCYCLEs\n"+conc.generateReportMotorCycle()+"\n");
                break;
            }

            break;
            case 2:
            System.out.println("Generate report according to the following criteria\n"+
                            "(1)Extra\n"+
                            "(2)Current\n"+
                            "(3)Diesel\n"+
                            "(4)Show all types of fuel"); 
            option2=sc.nextInt();
            sc.nextLine();
            while (option2<1 || option2>2){
                System.out.println("Enter a valid answer");
                System.out.println("Generate report according to the following criteria\n"+
                            "(1)Extra\n"+
                            "(2)Current\n"+
                            "(3)Diesel\n"+
                            "(4)Show all types of fuel"); 
                option2=sc.nextInt();
                sc.nextLine();
            }
            
                switch(option2){
                    case 1:
                        System.out.println("========================================================\nEXTRA FUEL\n"+conc.generateReportExtraGas()+"\n");
                    break;
                    case 2:
                        System.out.println("========================================================\nCURRENT FUEL\n"+conc.generateReportCurrentGas()+"\n");
                    break;
                    case 3:
                        System.out.println("========================================================\nDIESEL FUEL\n"+conc.generateReportDieselGas()+"\n");
                    break;
                    case 4: 
                        System.out.println("========================================================\nEXTRA FUEL\n"+conc.generateReportExtraGas()+"\n========================================================\nCURRENT FUEL\n"+conc.generateReportCurrentGas()+"\n========================================================\nDIESEL FUEL\n"+conc.generateReportDieselGas()+"\n");
                    break;
                }
            break;
            case 3:
            System.out.println("Generate report according to the following criteria\n"+
                            "(1)New\n"+
                            "(2)Used\n"); 
            option2=sc.nextInt();
            sc.nextLine();
            while (option2<1 || option2>2){
                System.out.println("Enter a valid answer");
                System.out.println("Generate report according to the following criteria\n"+
                            "(1)New\n"+
                            "(2)Used\n"); 
                option2=sc.nextInt();
                sc.nextLine();
            }
            
                switch(option2){
                    case 1:
                        System.out.println("========================================================\nNEW CARS\n"+conc.generateReportNew()+"\n");
                    break;
                    case 2:
                        System.out.println("========================================================\nUSED CARS\n"+conc.generateReportUSed()+"\n");
                    break;
                }
            break;
            case 4:
            System.out.println(conc.generateReportVehicles());
            break;

        }
        
    }
    /**
     * Method that generates reports of the vehicles that are in the parking lot given certain conditions by the user
     */
    public void GenerateParkingReports(){
        int option2=0;
        System.out.println("Generate report according to the following criteria\n"+
                            "(1)Vehicle models per year in the parking lot\n"+
                            "(2)Data from oldest and newest vehicle\n"+
                            "(3)Parking lot occupancy rate\n"+
                            "(4)Information of a vehicle given a position in the parking lot\n");
        int option=sc.nextInt();
        sc.nextLine();
        while (option<1 || option>4){
            System.out.println("Enter a valid answer");
            System.out.println("Generate report according to the following criteria\n"+
                                "(1)Vehicle models per year in the parking lot\n"+
                                "(2)Data from oldest and newest vehicle\n"+
                                "(3)Parking lot occupancy rate\n"+
                                "(4)Information of a vehicle given a position in the parking lot\n");
            option=sc.nextInt();
            sc.nextLine();
        }
        switch(option){
            case 1:
            System.out.println("Generate report according to the following criteria\n"+
                                "(1)Model 2014 Vehicles\n"+
                                "(2)Model 2013 Vehicles\n"+
                                "(3)Model 2012 Vehicles\n"+
                                "(4)Model 2011 Vehicles\n"+
                                "(5)Model 2010 and below Vehicles\n");
            option2=sc.nextInt();
            sc.nextLine();
            while (option2<1 || option2>5){
                System.out.println("Enter a valid answer");
                System.out.println("Generate report according to the following criteria\n"+
                                "(1)Model 2014 Vehicles\n"+
                                "(2)Model 2013 Vehicles\n"+
                                "(3)Model 2012 Vehicles\n"+
                                "(4)Model 2011 Vehicles\n"+
                                "(5)Model 2010 and below Vehicles\n");
                option2=sc.nextInt();
                sc.nextLine();
            }

            switch(option2){
                case 1:
                    System.out.println("========================================================\nALL 2014 VEHICLES\n"+conc.generateReportParkingLotyears(2014));
                break;
                case 2:
                System.out.println("========================================================\nALL 2014 VEHICLES\n"+conc.generateReportParkingLotyears(2013));
                break;
                case 3:
                System.out.println("========================================================\nALL 2014 VEHICLES\n"+conc.generateReportParkingLotyears(2012));
                break;
                case 4:
                System.out.println("========================================================\nALL 2014 VEHICLES\n"+conc.generateReportParkingLotyears(2011));
                break;
                case 5:
                System.out.println("========================================================\nALL 2014 VEHICLES\n"+conc.generateReportParkingLotyears(2010));
                break;
            }

            break;
            case 2:      
             System.out.println("========================================================\nNEWEST CAR(s)\n"+conc.generateReportParkingNewest()+"\n========================================================\nOLDEST CAR(S)\n"+conc.generateReportParkingOldest());   
            break;
            case 3:
            System.out.println("========================================================\n"+conc.generateReportParkingOccupancy());
            break;
            case 4:
            System.out.println("Enter the number of the parking lot number to look for its vehicle information");
            int number=sc.nextInt();
            sc.nextLine();
            while (number<1 || number>51){
                System.out.println("Enter a valid answer");
                System.out.println("Enter the number of the parking lot number to look for its vehicle information (The available parking spaces are between 1 and 50)");
                number=sc.nextInt();
                sc.nextLine();
            }
            System.out.println(conc.lookForVehicleInParkingLot(number));
            break;


        }
        
    }
}