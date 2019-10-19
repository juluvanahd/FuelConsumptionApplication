package api;

import javax.persistence.*;

@Entity
@Table(name="data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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

    private double totalPrice;

    public Data() {  }

    public Data(int driverID, String fuelType, double price, double liters, String date, double totalPrice) {
        this.setDriverID(driverID);
        this.setFuelType(fuelType);
        this.setPrice(price);
        this.setLiters(liters);
        this.setDate(date);
        this.setTotalPrice(totalPrice);
    }

    public Data(int id,int driverID, String fuelType, double price, double liters, String date, double totalPrice) {
        this.setId(id);
        this.setDriverID(driverID);
        this.setFuelType(fuelType);
        this.setPrice(price);
        this.setLiters(liters);
        this.setDate(date);
        this.setTotalPrice(totalPrice);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", driverID='" + driverID + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", price='" + price + '\'' +
                ", liters='" + liters + '\'' +
                ", date='" + date + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                '}';
    }
}
