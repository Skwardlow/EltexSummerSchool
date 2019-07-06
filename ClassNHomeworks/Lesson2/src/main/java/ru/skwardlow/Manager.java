package ru.skwardlow;

import java.util.ArrayList;

public class Manager extends User {
    private ArrayList sales = new ArrayList();

    public Manager(){
        super();
    }

    public Manager(byte id, String fio, String phone, String mailbox, ArrayList sales){
        super(id,fio,phone,mailbox);
        setSales(sales);

    }

    private void setSales(ArrayList sales) {
        this.sales = sales;
    }

    public ArrayList getSales() {
        return sales;
    }

}
