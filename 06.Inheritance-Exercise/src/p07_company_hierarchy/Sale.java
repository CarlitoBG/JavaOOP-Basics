package p07_company_hierarchy;

import java.util.Date;

class Sale {

    private String productName;
    private Date date;
    private double price;

    Sale(String productName, Date date, double price) {
        this.setProductName(productName);
        this.date = date;
        this.setPrice(price);
    }

    private void setProductName(String productName) {
        if (productName == null || productName.trim().isEmpty() || productName.length() < 3){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.productName = productName;
    }

    private void setPrice(double price) {
        if (price < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.price = price;
    }
}