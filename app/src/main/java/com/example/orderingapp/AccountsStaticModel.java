package com.example.orderingapp;

public class AccountsStaticModel
{
    private static int account_id;
    private static String name;
    private static String address;
    private static String email;
    private static String contact;
    private static String bday;
    private static String user_type;

    public AccountsStaticModel(int account_id, String name, String address, String email, String contact, String bday, String user_type) {
        this.account_id = account_id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.bday = bday;
        this.user_type = user_type;
    }

    public static int getAccount_id() {
        return account_id;
    }

    public static String getName() {
        return name;
    }

    public static String getAddress() {
        return address;
    }

    public static String getEmail() {
        return email;
    }

    public static String getContact() {
        return contact;
    }

    public static String getBday() {
        return bday;
    }

    public static String getUser_type() {
        return user_type;
    }
}
