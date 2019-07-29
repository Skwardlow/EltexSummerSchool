package ru.skwardlow;

import lombok.Getter;
import lombok.Setter;

class Sales {
    @Getter
    @Setter
    private String sale;
    @Setter
    @Getter
    private String price;

    Sales() {

    }

    Sales(String sale, String price) {
        this.sale = sale;
        this.price = price;
    }
}