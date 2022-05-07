package ui;
import java.util.Scanner;
import model.Concessionaire;

public class Main{

    private Concessionaire conc;
    private Scanner sc;

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
    public void runMenu(int option){
        switch(option){
            case 1:
            registerVehicle();
                break;
            case 2: 
                break;
            case 3: 
            generateReport();
                break;
            case 4: 
                break;
            case 5: 
                break;
            case 6: 
                break;
            case 0:
            System.out.println("Bye!");
                break;
        }


    }
    public void registerVehicle(){
        double gasCapacity=0,bateryLife=0,soatPrice=0,coverPrice=0,gasLevels=0,certificatePrice=0,propetyCardPrice=0,mileage=0;
        String licensePlate="", id="";
        int typeOfCar=0,numDoors=0,typeOfGas=0,typeOfCharger=0,soatYear=0,certificateYear=0,propetyCardYear=0;
        boolean isPolarized=false, returned=false;

        System.out.println("Registering vehicle");

        System.out.println("What is the id of the vehicle");
        id=sc.nextLine();

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

        System.out.println("Is the vehicle new? (true/false)");
        boolean isNew=sc.nextBoolean();
        sc.nextLine();

        if (isNew==false){
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
            System.out.println("What type of gasoline does the hybrid car has?\n"+
                                "(1)Extra\n"+
                                "(2)Current\n"+
                                "(3)Diesel\n");
            typeOfGas=sc.nextInt();
            sc.nextLine();
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
            returned=conc.registerVehicle(id,basePrice,brand, model, year, cylinderCapacity,  mileage,  isNew,  licensePlate, coverPrice, soatYear, soatPrice,  gasLevels,  certificateYear,  certificatePrice,  propetyCardYear,  propetyCardPrice,typeOfCar, numDoors, isPolarized,gasCapacity,typeOfGas);
            if (returned){
            System.out.println("You have registered successfully");
            }else{
            System.out.println("Failed to register");
            }  
            break;
        }

    }
    public void generateReport(){
        System.out.println(conc.generateReportVehicles());
        /**
        int option2=0, option3=0;
        System.out.println("Generate report according to the following criteria\n"+
                            "(1)Vehicle type\n"+
                            "(2)Fuel type\n"+
                            "(3)New or used"+
                            "(4)Show all vehicles");
        int option=sc.nextInt();
        sc.nextLine();
        switch(option){
            case 1:
            System.out.println("Generate report according to the following criteria\n"+
                            "(1)Car\n"+
                            "(2)MotorCycle\n"); 
            option2=sc.nextInt();
            sc.nextLine();

            switch(option2){
                case 1:

                break;
                case 2:
                break;
            }

            break;
            case 2:
            break;
            case 3:
            break;
            case 4:
            System.out.println(conc.generateReportVehicles());
            break;

        }
        */
    }
}