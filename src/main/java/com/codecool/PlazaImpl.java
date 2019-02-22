package com.codecool;

import java.util.List;

public class PlazaImpl implements Plaza{

    private List<Shop> shops;
    private boolean isOpen = true;

    public PlazaImpl () {

    }

    @Override
    public void addShop(Shop shop) {
        this.shops.add(shop);
    }

    @Override
    public List<Shop> getShops() {
        return this.shops;
    }

    @Override
    public void removeShop(Shop shop) {
        shops.remove(shop);
    }

    @Override
    public Shop findShopByName(String name) {
        for(int i = 0; i < shops.size(); i++) {
            if(shops.get(i).getName().equals(name)) {
                return shops.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean isOpen() {
        return this.isOpen;
    }

    @Override
    public void open() {
        this.isOpen = true;
    }

    @Override
    public void close() {
        this.isOpen = false;
    }
}
