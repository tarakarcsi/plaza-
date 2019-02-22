package com.codecool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ShopImpl implements Shop {

    private String name;
    private String owner;
    private boolean isOpen = true;
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

        List<Product> productList = new ArrayList<>();

        for(long barcode : products.keySet()) {
            if(products.get(barcode).getQuantity() > 1){
                for(int i = 0; i < products.get(barcode).getQuantity(); i++) {
                    productList.add(products.get(barcode).getProduct());
                }
            }else if(products.get(barcode).getQuantity() == 1) {
                productList.add(products.get(barcode).getProduct());
            }
        }
        return productList;
    }

    @Override
    public Product findByName(String name) {

        for(long barcode : products.keySet()) {
            if(products.get(barcode).getProduct().getName().equals(name)) {
                return products.get(barcode).getProduct();
            }
        }
        return null;
    }

    @Override
    public boolean hasProduct(long barcode) {

        if(products.get(barcode).getQuantity() > 0) {
            return true;
        }else
            return false;
    }

    @Override
    public float getPrice(long barcode) {
        for(long key : products.keySet()) {
            if(key == barcode) {
                return products.get(key).getPrice();
            }
        }
        return 0;
    }

    @Override
    public void addNewProduct(Product product, int quantity, float price) {

        products.put(product.getBarcode(), new ShopEntryImpl(product, quantity, price));
    }

    @Override
    public void addProduct(long barcode, int quantity) {

        products.get(barcode).increaseQuantity(quantity);
    }

    @Override
    public Product buyProduct(long barcode) {

        products.get(barcode).decreaseQuantity(1);
        return products.get(barcode).getProduct();
    }

    @Override
    public List<Product> buyProducts(long barcode, int quantity) {

        List<Product> buyList = new ArrayList<>();

        for(int i = 0; i < quantity; i++) {
            buyList.add(products.get(barcode).getProduct());
        }
        return buyList;
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
            this.quantity = this.quantity + amount;
        }

        public void decreaseQuantity(int amount) {
            this.quantity = this.quantity - amount;
        }
    }
}
