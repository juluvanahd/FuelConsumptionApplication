package api;

import java.math.BigDecimal;

public class Total {

    private String month;
    private BigDecimal total;

    public Total(String month, BigDecimal total)
    {
        this.setMonth(month);
        this.setTotal(total);
    }

    public void setMonth(String month) { this.month = month; }

    public String getMonth() {
        return month;
    }

    public void setTotal(BigDecimal total) { this.total = total; }

    public BigDecimal getTotal() {
        return total;
    }
}
