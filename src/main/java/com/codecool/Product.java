package com.codecool;

public abstract class Product {

    private long barcode;
    private String name;
    private String manufacturer;

    public Product(long barcode, String name, String manufacturer) {
        this.barcode = barcode;
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public long getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
