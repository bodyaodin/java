package com.webservice;

import com.webservice.config.Connection;
import com.webservice.managers.Manager;

public class Test {
    public static void main(String[] args) {

        Connection connection = new Connection();

        Manager manager = new Manager(connection);

        manager.saveAllCountriesInfo();

    }
}
