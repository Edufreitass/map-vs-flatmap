package com.javatechie;

import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {

    public static void main(String[] args) {
        List<Customer> customers = EkartDataBase.getAll();

        // List<Customer> convert to List<String> -> Data Transformation
        // mapping : customer -> customer.getEmail()
        // customer -> customer.getEmail() ->> one to one mapping
        List<String> emails = customers.stream()
                .map(customer -> customer.getEmail())
                .collect(Collectors.toList());
        // OUTPUT: [john@gmail.com, smith@gmail.com, peter@gmail.com, kely@gmail.com]
        System.out.println(emails);

        // customer -> customer.getPhoneNumbers() ->> one to many mapping
        List<List<String>> phoneNumbers = customers.stream()
                .map(customer -> customer.getPhoneNumbers())
                .collect(Collectors.toList());
        // OUTPUT: [[397937955, 21654725], [89563865, 2487238947], [38946328654, 3286487236], [389246829364, 948609467]]
        System.out.println(phoneNumbers);

        // List<Customer> convert to List<String> -> Data Transformation
        // mapping : customer -> phone Numbers
        // customer -> customer.getPhoneNumbers() ->> one to many mapping
        List<String> phones = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        // OUTPUT: [397937955, 21654725, 89563865, 2487238947, 38946328654, 3286487236, 389246829364, 948609467]
        System.out.println(phones);
    }
}
