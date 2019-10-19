package api;

import javax.persistence.*;

@Entity
@Table(name="data")
public class Data {
    @Id
    @Column(name="driverID")
    private int driverID;
    @Column(name="fuelType")
    private String fuelType;
    @Column(name="price")
    private double price;
    @Column(name="liters")
    private double liters;
    @Column(name="date")
    private String date;

    public Data() {  }

    public Data(int id, String fuelType, double price, double liters, String date) {
        this.setDriverID(id);
        this.setFuelType(fuelType);
        this.setPrice(price);
        this.setLiters(liters);
        this.setDate(date);
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getFuelType() { return fuelType; }

    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public double getPrice() { return price; }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLiters() {
        return liters;
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Data{" +
                "driverID=" + driverID +
                ", fuelType='" + fuelType + '\'' +
                ", price='" + price + '\'' +
                ", liters='" + liters + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
