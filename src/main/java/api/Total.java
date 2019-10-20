package api;

public class Total {

    private String month;
    private double total;

    public Total(String month, double total)
    {
        this.setMonth(month);
        this.setTotal(total);
    }

    public void setMonth(String month) { this.month = month; }

    public String getMonth() {
        return month;
    }

    public void setTotal(double total) { this.total = total; }

    public double getTotal() {
        return total;
    }
}
