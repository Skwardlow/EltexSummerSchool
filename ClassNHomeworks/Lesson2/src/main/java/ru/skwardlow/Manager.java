package ru.skwardlow;

import java.util.ArrayList;

public class Manager extends User {
    private ArrayList sales = new ArrayList();

    Manager(){
        super();
    }

    Manager(byte id, String fio, String phone, String mailbox, String[] items, String[] prices){
        super(id,fio,phone,mailbox);
        setSales(items,prices);


    }

    private void setSales(String[] items, String[] prices) {
        sales = new ArrayList();
        if (items.length != prices.length){
            System.out.println( "Sales and prices mismatch");
        }
        else {
            for (int i=0; i< items.length; i++){
                String currItem = items[i];
                String currPrice = prices[i];
                //sales.add(new Sales(currItem,currPrice));

            }

        }
    }

    public ArrayList getSales() {
        return sales;
    }

}
