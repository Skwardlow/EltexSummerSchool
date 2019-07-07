package ru.skwardlow;

public class Sales {
    private String sale;
    private String price;

    Sales(){}
    Sales(String sale, String price){
        setSale(sale);
        setPrice(price);
    }

    private void setSale(String sale) {
        this.sale = sale;
    }

    public String getSale() {
        return sale;
    }

    private void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
}
