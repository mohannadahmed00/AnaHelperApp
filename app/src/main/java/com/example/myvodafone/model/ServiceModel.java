package com.example.myvodafone.model;

import java.util.ArrayList;

public class ServiceModel {
    public String name,code,price,type,overView;
    public ArrayList<ServiceModel> codes;
    public ArrayList<String> notes;


    public ServiceModel(String name, ArrayList<ServiceModel> codes, ArrayList<String> notes) {
        this.name = name;
        this.codes = codes;
        this.notes = notes;
    }




    public ServiceModel(String code, String price, String type, String overView) {
        this.code = code;
        this.price = price;
        this.type = type;
        this.overView = overView;
    }
}
