package model;

public abstract class Car extends Vehicle{
    private int numDoors;
    private boolean isPolarized;
    private CarType typeOfCar;

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