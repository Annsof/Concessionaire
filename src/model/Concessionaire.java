package model;
import java.util.ArrayList;
import java.util.Calendar;
  

public class Concessionaire{
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Vehicle> parkingLotVehicles;
    private ArrayList<Vehicle> allUsedVehicles;
    private Vehicle[][] parkingLot;
    /**
     * This method is the constructor of the dealer controller object.
     */
    public Concessionaire(){
        this.vehicles = new ArrayList<Vehicle>();
        this.parkingLotVehicles = new ArrayList<Vehicle>();
        this.allUsedVehicles = new ArrayList<Vehicle>();
        this.parkingLot=new Vehicle[10][5];
    }
    /**
     * This method is the constructor of the dealer controller object.
     * @param vehicles Receive a fix of vehicles as test cases
     */
    public Concessionaire(ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
        this.parkingLotVehicles = new ArrayList<Vehicle>();
        this.allUsedVehicles = new ArrayList<Vehicle>();
        this.parkingLot= new Vehicle[10][5];
    
    }
    /**
     * Generates the report of the newest vehicles that are in the parking lot
     * @return A string that contains the information of the vehicles of the most current year
     */
    public String generateReportParkingNewest(){
        String out="";
        int newest=-1, index=-1;
        saveVehicles();
        if(!parkingLotVehicles.isEmpty()){
        for (int i=0;i<parkingLotVehicles.size();i++){
            if(!parkingLotVehicles.get(i).toString().equals("") && parkingLotVehicles.get(i).getYear()>newest){
                newest=parkingLotVehicles.get(i).getYear();
                out=parkingLotVehicles.get(i).toString();
                index=i;
            }
        }
        for (int i=0;i<parkingLotVehicles.size();i++){
            if(!parkingLotVehicles.get(i).toString().equals("") && parkingLotVehicles.get(i).getYear()==parkingLotVehicles.get(index).getYear() && parkingLotVehicles.get(i)!=parkingLotVehicles.get(index)){
                out+=parkingLotVehicles.get(i).toString();
            }
        }
    } else {
        out="There are no available cars in the parking lot at the moment\n";
    }
        return out;
    }
    /**
     * Generates the information of a vehicle located in a certain position of the parking lot
     * @param number receives the position number of the vehicle from which the information is being sought
     * @return A string of the vehicle being searched for or a string informing the user that no vehicle was found
     */
    public String lookForVehicleInParkingLot(int number){
        String out="";
        Vehicle[][] parkingLot=saveVehicles();
        int rowNum=0;
        if (number>5){
            rowNum=(int)(number/5);
        }
        int columnNum=(number%5);
        if (columnNum!=0){
            columnNum-=1;
        }
        System.out.println(columnNum);
        System.out.println(rowNum);
        if(parkingLot[rowNum][columnNum]==null){
            out="At the moment there is no vehicle in this parking lot position";
        }else{
            out=parkingLot[rowNum][columnNum].toString();
        }
        return out;
    }
    /**
     * Generate the parking lot occupancy report
     * @return A string with the occupancy level of the parking lot or with a message warning that there are no vehicles in the parking lot
     */
    public String generateReportParkingOccupancy(){
        String out="";
        saveVehicles();
        if(!parkingLotVehicles.isEmpty()){
            out="The parking occupancy rate is: "+parkingLotVehicles.size()*100/50+"% with "+parkingLotVehicles.size()+" vehicles in the parking lot\n";
        }else{
            out="There are no available cars in the parking lot at the moment\n";
        }
        return out;
    }
    /**
     * Generates the report of the oldest vehicles that are in the parking lot
     * @return A string that contains the information of the oldest vehicles
     */
    public String generateReportParkingOldest(){
        String out="";
        int oldest=1000000000, index=-1;
        saveVehicles();
        if(!parkingLotVehicles.isEmpty()){
        for (int i=0;i<parkingLotVehicles.size();i++){
            if(!parkingLotVehicles.get(i).toString().equals("") && parkingLotVehicles.get(i).getYear()<oldest){
                oldest=parkingLotVehicles.get(i).getYear();
                out=parkingLotVehicles.get(i).toString();
                index=i;
            }
        }
        for (int i=0;i<parkingLotVehicles.size();i++){
            if(!parkingLotVehicles.get(i).toString().equals("") && parkingLotVehicles.get(i).getYear()==parkingLotVehicles.get(index).getYear() && parkingLotVehicles.get(i)!=parkingLotVehicles.get(index)){
                out+=parkingLotVehicles.get(i).toString();
            }
        }
    } else {
        out="There are no available cars in the parking lot at the moment\n";
    }
        return out;
    }
    /**
     * Generates a report with the information of each vehicle found in a given year by the user
     * @param year The year for which information is being sought
     * @return A string with the information of the vehicles of a given year, or that there are no vehicles in the parking lot or of the year being searched
     */
    public String generateReportParkingLotyears(int year){
        String out="";
        Vehicle[][] parkingLot=saveVehicles();
        if(parkingLotVehicles.isEmpty()){
            out="There are no available cars in the parking lot at the moment\n";
             }else{
                 if (year<2011){
                    for (int rowNum=0; rowNum<parkingLot.length; rowNum ++) {
                        for (int columnNum=0; columnNum<parkingLot[0].length; columnNum++) {
                            if(parkingLot[rowNum][columnNum]!=null&& parkingLot[rowNum][columnNum].getYear()<2011){
                                out+=parkingLot[rowNum][columnNum].toString();
                        }
                    }
                    }
                 }else{
                for (int rowNum=0; rowNum<parkingLot.length; rowNum ++) {
                    for (int columnNum=0; columnNum<parkingLot[0].length; columnNum++) {
                        if(parkingLot[rowNum][columnNum]!=null&& parkingLot[rowNum][columnNum].getYear()==year){
                            out+=parkingLot[rowNum][columnNum].toString();
                    }
                }
                }
            }
            if(out.equals("")){
                out="There are no available cars of the year "+year+" in the parking lot at the moment\n";
            }
            }
        return out;
    }
    /**
     * It shows on the screen the occupation of the parking lot
     * @return It shows on the screen the occupation of the parking lot with the number of the parking lot and the type of vehicle that is in it.
     */
    public String showParkingLot(){
        String out="";
        saveVehicles();
        allUsedVehicles();
        if(parkingLotVehicles.size()==allUsedVehicles.size()){
            out+="All vehicles have been added to the parking lot\n";
        }else{
            out+="All vehicles have not been added to the parking lot\n";
        } 
        out+="HC - Hybrid Car | GC - Gas Car | EC - Electric Car | MC - MotorCycle \n __________________ __________________ __________________ __________________ __________________\n|                  |                  |                  |                  |                  |\n|       2014       |       2013       |       2012       |       2011       |   2010 & below   |\n|__________________|__________________|__________________|__________________|__________________|\n";
		for (int rowNum=0; rowNum< parkingLot.length; rowNum++ ) { 
		    for (int rowOfRowNum=0; rowOfRowNum<6; rowOfRowNum++ ) { 
			    for (int columnNum = 0; columnNum < parkingLot[0].length; columnNum++) { 
            	if (columnNum!=parkingLot[0].length-1){
                    out+=parkingLotOptions(rowNum,columnNum,rowOfRowNum);
            	} else if (columnNum==parkingLot[0].length-1){
            	    out+=parkingLotOptions(rowNum,columnNum,rowOfRowNum)+"|\n";  
            	}
            	
            	
			}
		}
		
    }
        return out;
    }
    /**
     * Builds the shape of the parking lot on the screen depending on the iteration in the row and the car in the matrix at a certain point
     * @param rowNum initialized with the row in which the path is found
     * @param columnNum initialized with the column in which the path is found
     * @param rowOfRowNum initialized with row iteration
     * @return Depending on the iteration of the row and the vehicle in the vehicle array, it returns its corresponding figure
     */
    public String parkingLotOptions(int rowNum, int columnNum, int rowOfRowNum){
        int numParking=rowNum*5+columnNum+1;
                    String numofParkingLot="";
                    if(numParking<10){
                        numofParkingLot="0"+numParking;
                    }else{
                        numofParkingLot=""+numParking;
                    }
        String type="";
        int option1 =0;
        int option2 =0;
        int option3 =0;
        int option4 =0;
        int option5 =0;
        int out=0;
    
            if(parkingLot[rowNum][columnNum]==null){
                    option1 =0;
                    option2 =0;
                    option3 =0;
                    option4 =0;
                    option5 =8;
                }else if(parkingLot[rowNum][columnNum] instanceof Car){
                    option1 =1;
                    option2 =2;
                    option3 =3;
                    option4 =4;
                    option5 =9;
                    if(parkingLot[rowNum][columnNum] instanceof HybridCar ){
                    type="HC";
                    }
                    if(parkingLot[rowNum][columnNum] instanceof GasCar ){
                        type="GC";
                    }
                    if(parkingLot[rowNum][columnNum] instanceof ElectricCar ){
                        type="EC";
                    }
                }else if(parkingLot[rowNum][columnNum] instanceof MotorCycle){
                    option1 =0;
                    option2 =0;
                    option3 =5;
                    option4 =6;
                    option5 =9;
                    type="MC";
                }
            String[] figures = {"|                  ","|     ______       ","|    /|_||_\\`.__   ","|   (   _ __ _ _\\  ","|  __`-(o)__(o)__  ","|       /___       ","|   __(o)==(o)`_   "," __________________","|_"+numofParkingLot+"_|        |____","|_"+numofParkingLot+"_|        |_"+type+"_"};
    
        if(rowOfRowNum==5){
        out=7;
        }else if(rowOfRowNum==0){
        out=option5;  
        }else if(rowOfRowNum==1){
        out=option1;
        }else if(rowOfRowNum==2){
        out=option2;
        }else if(rowOfRowNum==3){
        out=option3; 
        }else if(rowOfRowNum==4){
        out=option4;
        }
    
    return figures[out];
}   
    /**
     * The method that create the arrangement of used and old vehicles
     * @return A list of all used and old dealership vehicles
     */
    public ArrayList<Vehicle> allUsedVehicles(){
        if(!allUsedVehicles.isEmpty()){
            allUsedVehicles.clear();
        }
        for (int i=0;i<vehicles.size();i++){
            if(!vehicles.get(i).toString().equals("") && vehicles.get(i).getIsNew()==0 && vehicles.get(i).getYear()<2015){
                this.allUsedVehicles.add(vehicles.get(i));
            }
        }
        return this.allUsedVehicles;
    }
    /**
     * A method that organizes the vehicles in the parking matrix in their respective column depending on the year and if it is used
     * @return a vehicle matrix which organizes the vehicles depending on whether it is used and what year it is
     */
    public Vehicle[][] saveVehicles(){
        if(!parkingLotVehicles.isEmpty()){
            parkingLotVehicles.clear();
        }
        for (int rowNum=0; rowNum<parkingLot.length; rowNum ++) {
            for (int columnNum=0; columnNum<parkingLot[0].length; columnNum++) {
                parkingLot[rowNum][columnNum]=null;
            }
        } 
        if(vehicles.isEmpty()){
            parkingLot= new Vehicle[10][5];
         }else{
            for (int columnNum=0;columnNum<parkingLot[0].length;columnNum++){
                for (int rowNum=0;rowNum<parkingLot.length;rowNum++){
                    if(columnNum==0){
                        for(int i=0;i<vehicles.size();i++){
                        if(vehicles.get(i).getIsNew()==0 && vehicles.get(i).getYear()==2014 && !parkingLotVehicles.contains(vehicles.get(i)) ){
                            if(parkingLot[rowNum][columnNum]==null){
                            this.parkingLotVehicles.add(vehicles.get(i));
                            parkingLot[rowNum][columnNum]=vehicles.get(i);
                            }
                        }
                        }
                    } 
                    if(columnNum==1){
                        for(int i=0;i<vehicles.size();i++){
                        if( vehicles.get(i).getIsNew()==0 && vehicles.get(i).getYear()==2013 && !parkingLotVehicles.contains(vehicles.get(i))){
                            if(parkingLot[rowNum][columnNum]==null){
                                this.parkingLotVehicles.add(vehicles.get(i));
                                parkingLot[rowNum][columnNum]=vehicles.get(i);
                                }
                        }
                        }
                    } 
                    if(columnNum==2){
                        for(int i=0;i<vehicles.size();i++){
                        if(vehicles.get(i).getIsNew()==0 && vehicles.get(i).getYear()==2012 && !parkingLotVehicles.contains(vehicles.get(i))){
                            if(parkingLot[rowNum][columnNum]==null){
                                this.parkingLotVehicles.add(vehicles.get(i));
                                parkingLot[rowNum][columnNum]=vehicles.get(i);
                                }
                        }
                        }
                    } 
                    if(columnNum==3){
                        for(int i=0;i<vehicles.size();i++){
                        if(vehicles.get(i).getIsNew()==0 && vehicles.get(i).getYear()==2011 && !parkingLotVehicles.contains(vehicles.get(i))){
                            if(parkingLot[rowNum][columnNum]==null){
                                this.parkingLotVehicles.add(vehicles.get(i));
                                parkingLot[rowNum][columnNum]=vehicles.get(i);
                                }
                        }
                        }
                    } 
                    if(columnNum==4){
                        for(int i=0;i<vehicles.size();i++){
                        if(vehicles.get(i).getIsNew()==0 && vehicles.get(i).getYear()<2011 && !parkingLotVehicles.contains(vehicles.get(i))){
                            if(parkingLot[rowNum][columnNum]==null){
                                this.parkingLotVehicles.add(vehicles.get(i));
                                parkingLot[rowNum][columnNum]=vehicles.get(i);
                                }
                        }
                        
                    } 
                }
                }
            }
		}
        return this.parkingLot;
    }
    /**
     * Method that registers gasoline-type cars and adds them to the dealer's list of vehicles
     * @param id initialized with the vehicle identification code a String
     * @param basePrice Needs to have the base price of the vehicle a double
     * @param brand String with the name of the manufacturer or make of the vehicle
     * @param model A string with the vehicle model name
     * @param year an integer with the year of the vehicle
     * @param cylinderCapacity a double with the cylinder capacity of the vehicle
     * @param mileage a double with the mileage of the vehicle
     * @param isNew an integer where 0 is used and 1 is new
     * @param licensePlate A chain with the vehicle plate in case it is used
     * @param coverPrice a double with the hedge price of the SOAT in case it is used
     * @param soatYear an integer with the year of the SOAT in case it is used
     * @param soatPrice a double with the price of SOAT in case it is used
     * @param gasLevels a double with the gas levels of the vehicle in case it is used
     * @param certificateYear an integer with the year of the vehicle's mechanical technician certificate if it is used
     * @param certificatePrice a double with the price of the certificate of the mechanical technician of the vehicle in case it is used
     * @param propetyCardYear an integer with the year of the vehicle ownership card in case it is used
     * @param propetyCardPrice double the price of the vehicle ownership card in case it is used
     * @param typeOfCar An integer of the type of car that is where 1 is a sedan and 2 is a van
     * @param numDoors an integer with the number of vehicle doors
     * @param isPolarized A boolean being true if the vehicle is polarized, and false if it is not polarized.
     * @param tankCapacity a double with the vehicle's tank capacity
     * @param typeOfGas an integer being 1 extra type gasoline, 2 being regular gasoline and 3 diesel gasoline of the vehicle
     * @return A boolean being true that the vehicle was registered and false that no vehicle was registered
     */
    public boolean registerVehicle(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, int isNew, String licensePlate,double coverPrice,int soatYear,double soatPrice, double gasLevels, int certificateYear, double certificatePrice, int propetyCardYear, double propetyCardPrice,int typeOfCar,int numDoors, boolean isPolarized,double tankCapacity,int typeOfGas){
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
    /**
     * Method that registers hybrid-type cars and adds them to the dealer's list of vehicles
     * @param id initialized with the vehicle identification code a String
     * @param basePrice Needs to have the base price of the vehicle a double
     * @param brand String with the name of the manufacturer or make of the vehicle
     * @param model A string with the vehicle model name
     * @param year an integer with the year of the vehicle
     * @param cylinderCapacity a double with the cylinder capacity of the vehicle
     * @param mileage a double with the mileage of the vehicle
     * @param isNew an integer where 0 is used and 1 is new
     * @param licensePlate A chain with the vehicle plate in case it is used
     * @param coverPrice a double with the hedge price of the SOAT in case it is used
     * @param soatYear an integer with the year of the SOAT in case it is used
     * @param soatPrice a double with the price of SOAT in case it is used
     * @param gasLevels a double with the gas levels of the vehicle in case it is used
     * @param certificateYear an integer with the year of the vehicle's mechanical technician certificate if it is used
     * @param certificatePrice a double with the price of the certificate of the mechanical technician of the vehicle in case it is used
     * @param propetyCardYear an integer with the year of the vehicle ownership card in case it is used
     * @param propetyCardPrice double the price of the vehicle ownership card in case it is used
     * @param typeOfCar An integer of the type of car that is where 1 is a sedan and 2 is a van
     * @param numDoors an integer with the number of vehicle doors
     * @param isPolarized A boolean being true if the vehicle is polarized, and false if it is not polarized.
     * @param tankCapacity a double with the vehicle's tank capacity
     * @param bateryLife a double with the battery life of the vehicle
     * @param typeOfGas an integer being 1 extra type gasoline, 2 being regular gasoline and 3 diesel gasoline of the vehicle
     * @param typeOfCharger an integer with 1 being a fast type battery charger and 2 being a normal type
     * @return A boolean being true that the vehicle was registered and false that no vehicle was registered
     */
    public boolean registerVehicle(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, int isNew, String licensePlate,double coverPrice,int soatYear,double soatPrice, double gasLevels, int certificateYear, double certificatePrice, int propetyCardYear, double propetyCardPrice,int typeOfCar,int numDoors, boolean isPolarized,double tankCapacity,double bateryLife,int typeOfGas, int typeOfCharger){
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
    /**
     * Method that registers electric-type cars and adds them to the dealer's list of vehicles
     * @param id initialized with the vehicle identification code a String
     * @param basePrice Needs to have the base price of the vehicle a double
     * @param brand String with the name of the manufacturer or make of the vehicle
     * @param model A string with the vehicle model name
     * @param year an integer with the year of the vehicle
     * @param cylinderCapacity a double with the cylinder capacity of the vehicle
     * @param mileage a double with the mileage of the vehicle
     * @param isNew an integer where 0 is used and 1 is new
     * @param licensePlate A chain with the vehicle plate in case it is used
     * @param coverPrice a double with the hedge price of the SOAT in case it is used
     * @param soatYear an integer with the year of the SOAT in case it is used
     * @param soatPrice a double with the price of SOAT in case it is used
     * @param gasLevels a double with the gas levels of the vehicle in case it is used
     * @param certificateYear an integer with the year of the vehicle's mechanical technician certificate if it is used
     * @param certificatePrice a double with the price of the certificate of the mechanical technician of the vehicle in case it is used
     * @param propetyCardYear an integer with the year of the vehicle ownership card in case it is used
     * @param propetyCardPrice double the price of the vehicle ownership card in case it is used
     * @param typeOfCar An integer of the type of car that is where 1 is a sedan and 2 is a van
     * @param numDoors an integer with the number of vehicle doors
     * @param isPolarized A boolean being true if the vehicle is polarized, and false if it is not polarized.
     * @param typeOfCharger an integer with 1 being a fast type battery charger and 2 being a normal type
     * @param bateryLife a double with the battery life of the vehicle
     * @return A boolean being true that the vehicle was registered and false that no vehicle was registered
     */
    public boolean registerVehicle(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, int isNew, String licensePlate,double coverPrice,int soatYear,double soatPrice, double gasLevels, int certificateYear, double certificatePrice, int propetyCardYear, double propetyCardPrice,int typeOfCar,int numDoors, boolean isPolarized, int typeOfCharger,double bateryLife){
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
    /**
     * Method that registers motorcycles and adds them to the dealer's list of vehicles
     * @param id initialized with the vehicle identification code a String
     * @param basePrice Needs to have the base price of the vehicle a double
     * @param brand String with the name of the manufacturer or make of the vehicle
     * @param model A string with the vehicle model name
     * @param year an integer with the year of the vehicle
     * @param cylinderCapacity a double with the cylinder capacity of the vehicle
     * @param mileage a double with the mileage of the vehicle
     * @param isNew an integer where 0 is used and 1 is new
     * @param licensePlate A chain with the vehicle plate in case it is used
     * @param coverPrice a double with the hedge price of the SOAT in case it is used
     * @param soatYear an integer with the year of the SOAT in case it is used
     * @param soatPrice a double with the price of SOAT in case it is used
     * @param gasLevels a double with the gas levels of the vehicle in case it is used
     * @param certificateYear an integer with the year of the vehicle's mechanical technician certificate if it is used
     * @param certificatePrice a double with the price of the certificate of the mechanical technician of the vehicle in case it is used
     * @param propetyCardYear an integer with the year of the vehicle ownership card in case it is used
     * @param propetyCardPrice double the price of the vehicle ownership card in case it is used
     * @param gasCapacity a double with the vehicle's tank capacity
     * @param typeOfMotorCycle an integer being 1 standard type motorcycle, 2 being sport, 3 being scooter and 4 being cross
     * @return A boolean being true that the vehicle was registered and false that no vehicle was registered
     */
    public boolean registerVehicle(String id,double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, int isNew, String licensePlate,double coverPrice,int soatYear,double soatPrice, double gasLevels, int certificateYear, double certificatePrice, int propetyCardYear, double propetyCardPrice,double gasCapacity, int typeOfMotorCycle){
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
    /**
     * A method that searches the array of vehicles for a vehicle given an id
     * @param id initialized with the vehicle identification code a String
     * @return an integer with the index of the vehicle in the dealer's vehicle array in case it was found or -1 meaning it was not found
     */
    public int getVehicule(String id){
        int indexFinder = -1;
        for(int i=0;i<vehicles.size();i++){
        if(!vehicles.isEmpty() && vehicles.get(i).getId().equals(id)){
            indexFinder=i;
        }
    }
    return indexFinder;
    }
    /**
     * Method searches for the documents of a vehicle given an id
     * @param id initialized with the vehicle identification code a String
     * @return A chain with the information of the documents in case the vehicle is used or if it is new inform him that the vehicle does not have documents
     */
    public String lookUpVehiculesDocuments(String id){
        String out="";
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int index=getVehicule(id);
        if(index==-1){
            out="The vehicle that you are looking for could not be found";
        }else{
            Vehicle vehicle=vehicles.get(getVehicule(id));
            if(vehicle.getIsNew()==0){ //used
                out="\nINFO DOCUMENTS OF VEHICLE"+id+vehicle.getSoat().toString()+"\nWith a SOAT code of: "+vehicle.getSoat().generateCode()+vehicle.getCertificate().toString()+"\nWith a Technical Mechanical Certificate code of: "+vehicle.getCertificate().generateCode()+vehicle.getPropertyCard().toString()+"\nWith a propety card code of"+vehicle.getPropertyCard().generateCode();
            } else{
                out="\nINFO DOCUMENTS OF VEHICLE"+id+"\nAs it is new, it does not have a SOAT nor a property card\ntThe price of obtaining these documents will be reflected in the cost of selling the vehicle\nAnd its technical-mechanical inspection certificate is from the current year: "+year;
            }
        }
        
        return out;
    }
    /**
     * Method that generates the sale price of a vehicle given a certain id
     * @param id initialized with the vehicle identification code a String
     * @return A string with the vehicle sale price information in case it is found or a message that the vehicle could not be found
     */
    public String lookUpVehiculesSalePrice(String id){
        String out="";
        int index=getVehicule(id);
        if(index==-1){
            out="The vehicle that you are looking for could not be found";
        }else{
            out="\nThe selling price of the vehicle: "+id+" is of "+String.format("%.2f",vehicles.get(index).calcSellingPrice());
        }
        return out;
    }
    /**
     * Method that generates the report of all vehicles in the dealership
     * @return
     */
    public String generateReportVehicles(){
        String out="";
        if(vehicles.isEmpty()){
        out="There are no available cars in the moment";
         }else{
            for(int i=0;i<vehicles.size();i++){
			if(!vehicles.get(i).toString().equals("")){
				out+=vehicles.get(i).toString();
			}
            }
		}
        return out;
    }
    /**
     * Method that generates the report of all electric cars in the dealership
     * @return A string with the report of all electric cars in the dealership
     */
    public String generateReportElectricCars(){
        String out="";
        if(vehicles.isEmpty()){
            out="There are no available cars in the moment";
             }else{
                for(int i=0;i<vehicles.size();i++){
                    if(!vehicles.get(i).toString().equals("") && vehicles.get(i) instanceof ElectricCar){
                        out+=vehicles.get(i).toString();
                    }
                }
                if (out.equals("")){
                    out="There are no available electric cars in the moment";
                }
            }
        return out;
    }
    /**
     * Method that generates the report of all gasoline cars in the dealership
     * @return A string with the report of all gasoline cars in the dealership
     */
    public String generateReportGasCar(){
        String out="";
        if(vehicles.isEmpty()){
            out="There are no available cars in the moment";
             }else{
                for(int i=0;i<vehicles.size();i++){
                    if(!vehicles.get(i).toString().equals("") && vehicles.get(i) instanceof GasCar){
                        out+=vehicles.get(i).toString();
                    }
                }
                if (out.equals("")){
                    out="There are no available gasoline cars in the moment";
                }
            }
        return out;
    }
    /**
     * Method that generates the report of all hybrid cars in the dealership
     * @return A string with the report of all hybrid cars in the dealership
     */
    public String generateReportHybridCar(){
        String out="";
        if(vehicles.isEmpty()){
            out="There are no available cars in the moment";
             }else{
                for(int i=0;i<vehicles.size();i++){
                    if(!vehicles.get(i).toString().equals("") && vehicles.get(i) instanceof HybridCar){
                        out+=vehicles.get(i).toString();
                    }
                }
                if (out.equals("")){
                    out="There are no available hybrid cars in the moment";
                }
            }
        return out;
    }
    /**
     * Method that generates the report of all motorcycles in the dealership
     * @return A string with the report of all motorcycles in the dealership
     */
    public String generateReportMotorCycle(){
        String out="";
        if(vehicles.isEmpty()){
            out="There are no available cars in the moment";
             }else{
                for(int i=0;i<vehicles.size();i++){
                    if(!vehicles.get(i).toString().equals("") && vehicles.get(i) instanceof MotorCycle){
                        out+=vehicles.get(i).toString();
                    }
                }
                if (out.equals("")){
                    out="There are no available motorCycles cars in the moment";
                }
            }
        return out;
    }
    /**
     * Method that generates the report of all vehicles with extra type gasoline
     * @return A string with the report of all vehicles with extra type gasoline
     */
    public String generateReportExtraGas(){
        String out="";
        if(vehicles.isEmpty()){
            out="There are no available cars in the moment";
             }else{
                for(int i=0;i<vehicles.size();i++){
                    if(!vehicles.get(i).toString().equals("")  && vehicles.get(i) instanceof HybridCar){
                        if ( ((HybridCar)vehicles.get(i)).getTypeOfGas()==GasType.EXTRA){
                            out+=vehicles.get(i).toString();
                        }
                    } else if(!vehicles.get(i).toString().equals("")  && vehicles.get(i) instanceof GasCar){
                        if ( ((GasCar)vehicles.get(i)).getTypeOfGas()==GasType.EXTRA){
                            out+=vehicles.get(i).toString();
                        }
                    }
                }
                if (out.equals("")){
                    out="There are no available cars with the extra type of fuel in the moment";
                }
            }
        return out;
    }
    /**
     * Method that generates the report of all vehicles with regular type gasoline
     * @return A string with the report of all vehicles with regular type gasoline
     */
    public String generateReportCurrentGas(){
        String out="";
        if(vehicles.isEmpty()){
            out="There are no available cars in the moment";
             }else{
                for(int i=0;i<vehicles.size();i++){
                    if(!vehicles.get(i).toString().equals("")  && vehicles.get(i) instanceof HybridCar){
                        if ( ((HybridCar)vehicles.get(i)).getTypeOfGas()==GasType.CURRENT){
                            out+=vehicles.get(i).toString();
                        }
                    } else if(!vehicles.get(i).toString().equals("")  && vehicles.get(i) instanceof GasCar){
                        if ( ((GasCar)vehicles.get(i)).getTypeOfGas()==GasType.CURRENT){
                            out+=vehicles.get(i).toString();
                        }
                    }
                }
                if (out.equals("")){
                    out="There are no available cars with the current type of fuel in the moment";
                }
            }
        return out;
    }
    /**
     * Method that generates the report of all vehicles with diesel type gasoline
     * @return A string with the report of all vehicles with diesel type gasoline
     */
    public String generateReportDieselGas(){
        String out="";
        if(vehicles.isEmpty()){
            out="There are no available cars in the moment";
             }else{
                for(int i=0;i<vehicles.size();i++){
                    if(!vehicles.get(i).toString().equals("")  && vehicles.get(i) instanceof HybridCar){
                        if ( ((HybridCar)vehicles.get(i)).getTypeOfGas()==GasType.DIESEL){
                            out+=vehicles.get(i).toString();
                        }
                    } else if(!vehicles.get(i).toString().equals("")  && vehicles.get(i) instanceof GasCar){
                        if ( ((GasCar)vehicles.get(i)).getTypeOfGas()==GasType.DIESEL){
                            out+=vehicles.get(i).toString();
                        }
                    }
                }
                if (out.equals("")){
                    out="There are no available cars with the diesel type of fuel in the moment";
                }
            }
        return out;
    }
    /**
     * Method that generates the report of all new vehicles in the dealership
     * @return A string with the report of all new vehicles in the dealership
     */
    public String generateReportNew(){
        String out="";
        if(vehicles.isEmpty()){
            out="There are no available cars in the moment";
             }else{
                for(int i=0;i<vehicles.size();i++){
                    if(!vehicles.get(i).toString().equals("") && vehicles.get(i).getIsNew()==1){
                        out+=vehicles.get(i).toString();
                    }
                }
                if (out.equals("")){
                    out="There are no available new cars in the moment";
                }
            }
        return out;
    }
    /**
     * Method that generates the report of all old vehicles in the dealership
     * @return A string with the report of all old vehicles in the dealership
     */
    public String generateReportUSed(){
        String out="";
        if(vehicles.isEmpty()){
            out="There are no available cars in the moment";
             }else{
                for(int i=0;i<vehicles.size();i++){
                    if(!vehicles.get(i).toString().equals("") && vehicles.get(i).getIsNew()==0){
                        out+=vehicles.get(i).toString();
                    }
                }
                if (out.equals("")){
                    out="There are no available used cars in the moment";
                }
            }
        return out;
    }
    
}