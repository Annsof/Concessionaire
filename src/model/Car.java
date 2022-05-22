package model;

public abstract class Car extends Vehicle{
    private int numDoors;
    private boolean isPolarized;
    private CarType typeOfCar;
    /**
     * Constructor method of the abstract car class
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
     */
    public Car(String id, double basePrice, String brand, String model,int year, double cylinderCapacity, double mileage, int isNew, String licensePlate,SOAT soat,TechnicalMechanical certificate,PropertyCard propertyCard,CarType typeOfCar,int numDoors, boolean isPolarized) {
        super(id,basePrice, brand, model, year, cylinderCapacity, mileage, isNew, licensePlate, soat, certificate, propertyCard);
        this.typeOfCar=typeOfCar;
        this.numDoors = numDoors;
        this.isPolarized = isPolarized;
    }
    @Override
    public String toString(){
        return super.toString()+"\nNumber of Doors: "+numDoors+"\nIs the car polarized: "+isPolarized+"\nThe type of car is: "+typeOfCar;
    }
    public CarType getTypeOfCar() {
        return this.typeOfCar;
    }

    public void setTypeOfCar(CarType typeOfCar) {
       this.typeOfCar = typeOfCar;
    }
    public int getNumDoors() {
        return this.numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public boolean isIsPolarized() {
        return this.isPolarized;
    }

    public boolean getIsPolarized() {
        return this.isPolarized;
    }

    public void setIsPolarized(boolean isPolarized) {
        this.isPolarized = isPolarized;
    }
}