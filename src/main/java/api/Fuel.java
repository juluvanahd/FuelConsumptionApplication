package api;

import java.math.BigDecimal;
import java.util.BitSet;

public class Fuel {

    private String month;
    private String fuelType;
    private BigDecimal liters;
    private BigDecimal totalPrice;
    private BigDecimal averagePrice;

    public Fuel(String month, String fuelType, BigDecimal liters, BigDecimal averagePrice, BigDecimal totalPrice)
    {
        this.setMonth(month);
        this.setFuelType(fuelType);
        this.setLiters(liters);
        this.setAveragePrice(averagePrice);
        this.setTotalPrice(totalPrice);
    }

    public void setMonth(String month) { this.month = month; }

    public String getMonth() {
        return month;
    }

    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public String getFuelType() {
        return fuelType;
    }

    public void setLiters(BigDecimal liters) { this.liters = liters; }

    public BigDecimal getLiters() {
        return liters;
    }

    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) { this.averagePrice = averagePrice; }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }
}
