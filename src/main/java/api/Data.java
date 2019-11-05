package api;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

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
    private BigDecimal price;
    @Column(name="liters")
    private BigDecimal liters;
    @Column(name="date")
    private Date date;

    private BigDecimal totalPrice;

    public Data() {  }

    public Data(int driverID, String fuelType, BigDecimal price, BigDecimal liters, Date date, BigDecimal totalPrice) {
        this.setDriverID(driverID);
        this.setFuelType(fuelType);
        this.setPrice(price);
        this.setLiters(liters);
        this.setDate(date);
        this.setTotalPrice(totalPrice);
    }

    public int getDriverID() { return driverID; }

    public void setDriverID(int driverID) { this.driverID = driverID; }

    public String getFuelType() { return fuelType; }

    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public BigDecimal getLiters() { return liters; }

    public void setLiters(BigDecimal liters) { this.liters = liters; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public BigDecimal getTotalPrice() { return totalPrice; }

    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
}
