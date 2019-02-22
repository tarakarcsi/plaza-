package com.codecool;

public class ClothingProduct extends Product {

    private String material;
    private String type;

    public ClothingProduct(long barcode, String name, String manufacturer, String material, String type) {
        super(barcode, name, manufacturer);
        this.material = material;
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public String getType() {
        return type;
    }
}
