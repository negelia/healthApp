package com.example.praktika;

public class Model {
    private String name;
    private String DisResult;

    public Model (String name, String DisResult){
        this.name = name;
        this.DisResult = DisResult;
    }
    public String getDisResult(){return DisResult;}

    public String  getName(){return  name;}
}
