package com.jisus;

public class Company {

    private static Company instance = new Company();

    public static Company getInstance() {
        if(null == instance)
            instance = new Company();
        return instance;
    }

    private Company() {}
}
