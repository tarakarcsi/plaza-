package com.codecool;

import java.util.List;
import java.util.Map;


public class ShopImpl implements Shop {

    private String name;
    private String owner;
    private boolean isOpen = true;
    private List<Product> productList;

    private Map<Long, ShopImpl.ShopEntryImpl> products;

    public ShopImpl(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public void open() {
        this.isOpen = true;
    }

    @Override
    public void close() {
        this.isOpen = false;
    }

    @Override
    public List<Product> getProducts() {
        return this.productList;
    }

    @Override
    public Product findByName(String name) {
        for(int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().equals(name)) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean hasProduct(long barcode) {
        return false;
    }

    @Override
    public float getPrice(long barcode) {

    }

    private class ShopEntryImpl {

        private Product product;
        private int quantity;
        private float price;

        private ShopEntryImpl(Product product, int quantity, float price) {
            this.product = product;
            this.quantity = quantity;
            this.price = price;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public float getPrice() {
            return price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public void increaseQuantity(int amount) {

        }

        public void decreaseQuantity(int amount) {

        }
    }
}
