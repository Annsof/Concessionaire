package model;
import java.util.Calendar;

public abstract class Vehicle{
    private String id;
    private double basePrice;
    private String brand;
    private String model;
    private int year;
    private double cylinderCapacity;
    private double mileage;
    private int isNew;
    private String licensePlate;
    private SOAT soat;
    private TechnicalMechanical certificate;
    private PropertyCard propertyCard;

    public Vehicle(String id,double basePrice, String brand, String model, int year, double cylinderCapacity, double mileage, int isNew, String licensePlate,SOAT soat,TechnicalMechanical certificate,PropertyCard propertyCard) {
        this.basePrice = basePrice;
        this.brand = brand;
        this.model = model;
        this.year=year;
        this.id=id;
        this.cylinderCapacity = cylinderCapacity;
        this.mileage = mileage;
        this.isNew = isNew;
        this.licensePlate = licensePlate; 
        this.soat=soat;
        this.certificate=certificate;
        this.propertyCard=propertyCard;
    }
    public double calcSellingPrice(){
        return 0;
    }

    @Override
    public String toString(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (isNew==0){
       return "\nVEHICLE'S INFO\n\n"+"Vehicle id:"+id+"\nBase price: "+String.format("%.2f",basePrice)+"\nBrand: "+brand+"\nYear:"+year+"\nModel:"+model+"\nCylinder capacity: "+cylinderCapacity+"\nMiliage: "+mileage+"\nIs the car new? False"+"\nLicence plate "+licensePlate+"\nINFO DOCUMENTS"+soat.toString()+certificate.toString()+propertyCard.toString();
        } else{
        return "\nVEHICLE'S INFO\n\n"+"Vehicle id:"+id+"\nBase price: "+String.format("%.2f",basePrice)+"\nBrand: "+brand+"\nYear:"+year+"\nModel:"+model+"\nCylinder capacity: "+cylinderCapacity+"\nMiliage: "+mileage+"\nIs the car new? True"+"\nINFO DOCUMENTS\nAs it is new, it does not have a SOAT nor a property card\ntThe price of obtaining these documents will be reflected in the cost of selling the vehicle\nAnd its technical-mechanical inspection certificate is from the current year: "+currentYear+"\nLicence plate: none";
        }
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    



}