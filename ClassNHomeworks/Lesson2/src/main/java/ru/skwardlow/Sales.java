package ru.skwardlow;

public class Sales {
    private String sales;
    private String prices;

    Sales(){}
    Sales(String sale, String price){
        setSales(sale);
        setPrices(price);
    }

    private void setSales(String sales) {
        this.sales = sales;
    }

    public String getSales() {
        return sales;
    }

    private void setPrices(String prices) {
        this.prices = prices;
    }

    public String getPrices() {
        return prices;
    }
}
