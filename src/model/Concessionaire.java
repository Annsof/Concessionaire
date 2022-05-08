package model;
import java.util.ArrayList;
import java.util.Calendar;
  

public class Concessionaire{
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Vehicle> parkingLotVehicles;
    private ArrayList<Vehicle> allUsedVehicles;

    public Concessionaire(){
        this.vehicles = new ArrayList<Vehicle>();
        this.parkingLotVehicles = new ArrayList<Vehicle>();
        this.allUsedVehicles = new ArrayList<Vehicle>();
    }
    public Concessionaire(ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
        this.parkingLotVehicles = new ArrayList<Vehicle>();
        this.allUsedVehicles = new ArrayList<Vehicle>();
    
    }
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
    public String lookForVehicleInParkingLot(int number){
        String out="";
        Vehicle[][] parkingLot=saveVehicles();
        int rowNum=(int)(number/5);
        int columnNum=(number%5)-1;
        if(parkingLot[rowNum][columnNum]==null){
            out="At the moment there is no vehicle in this parking lot position";
        }else{
            out=parkingLot[rowNum][columnNum].toString();
        }
        return out;
    }
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
            }
        return out;
    }
    public String showParkingLot(){
        String out="";
        Vehicle[][] parkingLot=saveVehicles();
        ArrayList<Vehicle> allUsedVehicles=allUsedVehicles();
        String[] figures = {"                  ","     ______       ","    /|_||_\\`.__   ","   (   _ __ _ _\\  ","  __`-(o)__(o)__  ","       /___       ","   __(o)==(o)`_   "};
		if(parkingLotVehicles.size()==allUsedVehicles.size()){
            out+="All vehicles have been added to the parking lot\n";
        }else{
            out+="All vehicles have not been added to the parking lot\n";
        }
        for (int rowNum=0; rowNum<parkingLot.length; rowNum++){
		    for (int columnNum=0; columnNum<parkingLot[0].length; columnNum++){
                out+=" __________________";  
		    }
		    out+="\n" ;
		    int counter =0;
		    int counter1 =0;
		    int counter2 =0;
		    int counter3 =0;
		    int counter4 =0;
		    
		    int option =0;
		    int option1 =0;
		    int option2 =0;
		    int option3 =0;
		    
		    for (int columnNum=0; columnNum<parkingLot[0].length; columnNum++){
            	    for (int columnNum1=0; columnNum1<parkingLot[0].length; columnNum1++){
            	    if(parkingLot[rowNum][columnNum1]==null){
            	        option =0;
            	        option1 =0;
            		    option2 =0;
            		    option3 =0;
            	    }else if(parkingLot[rowNum][columnNum1] instanceof Car){
            	        option =1;
            	        option1 =2;
            		    option2 =3;
            		    option3 =4;
            	    }else if(parkingLot[rowNum][columnNum1] instanceof MotorCycle){
            	        option =0;
            	        option1 =0;
            		    option2 =5;
            		    option3 =6;
            	    }
            	    int numParking=rowNum*5+columnNum1+1;
	                String numofParkingLot="";
	                if(numParking<10){
	                    numofParkingLot="0"+numParking;
	                }else{
	                    numofParkingLot=""+numParking;
	                }
                	    if(columnNum1==parkingLot[0].length-1 && counter1==0){
                	        out+="|_"+numofParkingLot+"_|             |\n" ;
                	        counter1++;
                	    }else if(columnNum1==parkingLot[0].length-1 && counter1==1){
                	        out+="|"+figures[option]+"|\n" ;
                	        counter1++;
                	    }else if(columnNum1==parkingLot[0].length-1 && counter1==2){
                	        out+="|"+figures[option1]+"|\n" ;
                	        counter1++;
                	    }else if(columnNum1==parkingLot[0].length-1 && counter1==3){
                	        out+="|"+figures[option2]+"|\n" ;
                	        counter1++;
                	    }else if(columnNum1==parkingLot[0].length-1 && counter1==4){
                	        out+="|"+figures[option3]+"|\n" ;
                	        counter1++;
                	    }else if(columnNum1==parkingLot[0].length-2 && counter2==0){
                	        out+="|_"+numofParkingLot+"_|             " ;
                	        counter2++;
                	    }else if(columnNum1==parkingLot[0].length-2 && counter2==1){
                	        out+="|"+figures[option] ;
                	        counter2++;
                	    }else if(columnNum1==parkingLot[0].length-2 && counter2==2){
                	        out+="|"+figures[option1] ;
                	        counter2++;
                	    }else if(columnNum1==parkingLot[0].length-2 && counter2==3){
                	        out+="|"+figures[option2] ;
                	        counter2++;
                	    }else if(columnNum1==parkingLot[0].length-2 && counter2==4){
                	        out+="|"+figures[option3] ;
                	        counter2++;
                	    }else if(columnNum1==parkingLot[0].length-3 && counter3==0){
                	        out+="|_"+numofParkingLot+"_|             " ;
                	        counter3++;
                	    }else if(columnNum1==parkingLot[0].length-3 && counter3==1){
                	        out+="|"+figures[option] ;
                	        counter3++;
                	    }else if(columnNum1==parkingLot[0].length-3 && counter3==2){
                	        out+="|"+figures[option1] ;
                	        counter3++;
                	    }else if(columnNum1==parkingLot[0].length-3 && counter3==3){
                	        out+="|"+figures[option2] ;
                	        counter3++;
                	    }else if(columnNum1==parkingLot[0].length-3 && counter3==4){
                	        out+="|"+figures[option3] ;
                	        counter3++;
                	    } else if(columnNum1==parkingLot[0].length-4 && counter4==0){
                	        out+="|_"+numofParkingLot+"_|             " ;
                	        counter4++;
                	    }else if(columnNum1==parkingLot[0].length-4 && counter4==1){
                	        out+="|"+figures[option] ;
                	        counter4++;
                	    }else if(columnNum1==parkingLot[0].length-4 && counter4==2){
                	        out+="|"+figures[option1] ;
                	        counter4++;
                	    }else if(columnNum1==parkingLot[0].length-4 && counter4==3){
                	        out+="|"+figures[option2] ;
                	        counter4++;
                	    }else if(columnNum1==parkingLot[0].length-4 && counter4==4){
                	        out+="|"+figures[option3] ;
                	        counter4++;
                	    }else if(columnNum1==parkingLot[0].length-5 && counter==0){
                	        out+="|_"+numofParkingLot+"_|             " ;
                	        counter++;
                	    }else if(columnNum1==parkingLot[0].length-5 && counter==1){
                	        out+="|"+figures[option] ;
                	        counter++;
                	    }else if(columnNum1==parkingLot[0].length-5 && counter==2){
                	        out+="|"+figures[option1] ;
                	        counter++;
                	    }else if(columnNum1==parkingLot[0].length-5 && counter==3){
                	        out+="|"+figures[option2] ;
                	        counter++;
                	    }else if(columnNum1==parkingLot[0].length-5 && counter==4){
                	        out+="|"+figures[option3] ;
                	        counter++;
                	    }
            	    }
		    }
		 if (rowNum==parkingLot.length-1){
		     for (int columnNum=0; columnNum<parkingLot[0].length; columnNum++){
            	        out+=" __________________";
            	    }
		 }
	    }
        return out;
    }
    public ArrayList<Vehicle> allUsedVehicles(){
        for (int i=0;i<vehicles.size();i++){
            if(!vehicles.get(i).toString().equals("") && vehicles.get(i).getIsNew()==0 && vehicles.get(i).getYear()<2015){
                this.allUsedVehicles.add(vehicles.get(i));
            }
        }
        return this.allUsedVehicles;
    }
    public Vehicle[][] saveVehicles(){
        Vehicle[][] parkingLot= new Vehicle[10][5];
        if(!parkingLotVehicles.isEmpty()){
            parkingLotVehicles=new ArrayList<Vehicle>();
        }
        if(vehicles.isEmpty()){
            parkingLot= new Vehicle[10][5];
         }else{
            for (int columnNum=0;columnNum<parkingLot[0].length;columnNum++){
                for (int rowNum=0;rowNum<parkingLot.length;rowNum++){
                    if(columnNum==0){
                        for(int i=0;i<vehicles.size();i++){
                        if(!vehicles.get(i).toString().equals("") && vehicles.get(i).getIsNew()==0 && vehicles.get(i).getYear()==2014 && !parkingLotVehicles.contains(vehicles.get(i))){
                            if(parkingLot[rowNum][columnNum]==null){
                            this.parkingLotVehicles.add(vehicles.get(i));
                            parkingLot[rowNum][columnNum]=vehicles.get(i);
                            }
                        }
                        }
                    } 
                    if(columnNum==1){
                        for(int i=0;i<vehicles.size();i++){
                        if(!vehicles.get(i).toString().equals("") && vehicles.get(i).getIsNew()==0 && vehicles.get(i).getYear()==2013 && !parkingLotVehicles.contains(vehicles.get(i))){
                            if(parkingLot[rowNum][columnNum]==null){
                                this.parkingLotVehicles.add(vehicles.get(i));
                                parkingLot[rowNum][columnNum]=vehicles.get(i);
                                }
                        }
                        }
                    } 
                    if(columnNum==2){
                        for(int i=0;i<vehicles.size();i++){
                        if(!vehicles.get(i).toString().equals("") && vehicles.get(i).getIsNew()==0 && vehicles.get(i).getYear()==2012 && !parkingLotVehicles.contains(vehicles.get(i))){
                            if(parkingLot[rowNum][columnNum]==null){
                                this.parkingLotVehicles.add(vehicles.get(i));
                                parkingLot[rowNum][columnNum]=vehicles.get(i);
                                }
                        }
                        }
                    } 
                    if(columnNum==3){
                        for(int i=0;i<vehicles.size();i++){
                        if(!vehicles.get(i).toString().equals("") && vehicles.get(i).getIsNew()==0 && vehicles.get(i).getYear()==2011 && !parkingLotVehicles.contains(vehicles.get(i))){
                            if(parkingLot[rowNum][columnNum]==null){
                                this.parkingLotVehicles.add(vehicles.get(i));
                                parkingLot[rowNum][columnNum]=vehicles.get(i);
                                }
                        }
                        }
                    } 
                    if(columnNum==4){
                        for(int i=0;i<vehicles.size();i++){
                        if(!vehicles.get(i).toString().equals("") && vehicles.get(i).getIsNew()==0 && vehicles.get(i).getYear()<2011 && !parkingLotVehicles.contains(vehicles.get(i))){
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
        /**
        for (int rowNum=0; rowNum<parkingLot.length; rowNum ++) {
            for (int columnNum=0; columnNum<parkingLot[0].length; columnNum++) {
                if(parkingLot[rowNum][columnNum]==null){
                    out+=0);
                } else{
                    out+=1);
                }
            }
            System.out.println();
        }
        */
        return parkingLot;
    }
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
    public int getVehicule(String id){
        int indexFinder = -1;
        for(int i=0;i<vehicles.size();i++){
        if(!vehicles.isEmpty() && vehicles.get(i).getId().equals(id)){
            indexFinder=i;
        }
    }
    return indexFinder;
    }
    public String lookUpVehiculesDocuments(String id){
        String out="";
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Vehicle vehicle=vehicles.get(getVehicule(id));
        int index=getVehicule(id);
        if(index==-1){
            out="The vehicle that you are looking for could not be found";
        }else{
            if(vehicle.getIsNew()==0){ //used
                out="\nINFO DOCUMENTS OF VEHICLE"+id+vehicle.getSoat().toString()+"\nWith a SOAT code of: "+vehicle.getSoat().generateCode()+vehicle.getCertificate().toString()+"\nWith a Technical Mechanical Certificate code of: "+vehicle.getCertificate().generateCode()+vehicle.getPropertyCard().toString()+"\nWith a propety card code of"+vehicle.getPropertyCard().generateCode();
            } else{
                out="\nINFO DOCUMENTS OF VEHICLE"+id+"\nAs it is new, it does not have a SOAT nor a property card\ntThe price of obtaining these documents will be reflected in the cost of selling the vehicle\nAnd its technical-mechanical inspection certificate is from the current year: "+year;
            }
        }
        
        return out;
    }
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