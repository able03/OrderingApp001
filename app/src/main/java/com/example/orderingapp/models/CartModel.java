package com.example.orderingapp.models;

public class CartModel
{
    private int cart_id;
    private int product_id;
    private String product_name;
    private double price;
    private int qty;
    private int imgRID;

    public CartModel(int cart_id, int product_id, String product_name, double price, int qty, int imgRID)
    {
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.qty = qty;
        this.imgRID = imgRID;
    }

    public int getCart_id()
    {
        return cart_id;
    }

    public int getProduct_id()
    {
        return product_id;
    }

    public String getProduct_name()
    {
        return product_name;
    }

    public double getPrice()
    {
        return price;
    }

    public int getQty()
    {
        return qty;
    }

    public int getImgRID()
    {
        return imgRID;
    }
}
