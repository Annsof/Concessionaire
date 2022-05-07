package model;
import java.util.Calendar;

public abstract class Vehicle{
    private String id;
    private double basePrice;
    private double salePrice;
    private String brand;
    private String model;
    private int year;
    private double cylinderCapacity;
    private double mileage;
    private boolean isNew;
    private String licensePlate;
    private SOAT soat;
    private TechnicalMechanical certificate;
    private PropertyCard propertyCard;

    public Vehicle(String id,double basePrice, String brand, String model, int year, double cylinderCapacity, double mileage, boolean isNew, String licensePlate,SOAT soat,TechnicalMechanical certificate,PropertyCard propertyCard) {
        this.basePrice = basePrice;
        this.salePrice = calcSellingPrice();
        this.brand = brand;
        this.model = model;
        this.year=year;
        this.cylinderCapacity = cylinderCapacity;
        this.mileage = mileage;
        this.isNew = isNew;
        this.licensePlate = licensePlate; 
        this.soat=soat;
        this.certificate=certificate;
        this.propertyCard=propertyCard;
    }
    public abstract double calcSellingPrice();

    @Override
    public String toString(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if (isNew==false){
       return "\nVEHICLE'S INFO\n"+"Vehicle id:"+id+"\nBase price: "+String.format("%.2f",basePrice)+"\nSale price: "+String.format("%.2f",salePrice)+"\nBrand: "+brand+"\nModel:"+model+"\nCylinder capacity: "+cylinderCapacity+"\nMiliage: "+mileage+"\nIs the car new? "+isNew+"\nLisence plate "+licensePlate+"\nINFO DOCUMENTS"+soat.toString()+certificate.toString()+propertyCard.toString()+"The car has a selling price of: "+salePrice;
        } else{
        return "\nVEHICLE'S INFO\n"+"Vehicle id:"+id+"\nBase price: "+String.format("%.2f",basePrice)+"\nSale price: "+String.format("%.2f",salePrice)+"\nBrand: "+brand+"\nModel:"+model+"\nCylinder capacity: "+cylinderCapacity+"\nMiliage: "+mileage+"\nIs the car new? "+isNew+"\nINFO DOCUMENTS\nAs it is new, it does not have a SOAT or a property card\ntThe price of obtaining these documents will be reflected in the cost of selling the vehicle\nAnd its technical-mechanical inspection certificate is from the current year: "+year;
        }
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public SOAT getSoat() {
        return this.soat;
    }

    public void setSoat(SOAT soat) {
        this.soat = soat;
    }

    public TechnicalMechanical getCertificate() {
        return this.certificate;
    }

    public void setCertificate(TechnicalMechanical certificate) {
        this.certificate = certificate;
    }

    public PropertyCard getPropertyCard() {
        return this.propertyCard;
    }

    public void setPropertyCard(PropertyCard propertyCard) {
        this.propertyCard = propertyCard;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }                                                                                                                                          

    public double getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCylinderCapacity() {
        return this.cylinderCapacity;
    }

    public void setCylinderCapacity(double cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public double getMileage() {
        return this.mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    



}