package com.codecool;

import java.util.List;

public interface Plaza {

    public List<Shop> getShops();

    public void addShop(Shop shop);

    public void removeShop(Shop shop);

    public Shop findShopByName(String name);

    public boolean isOpen();

    public void open();

    public void close();

}
