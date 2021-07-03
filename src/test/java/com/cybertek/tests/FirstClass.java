package com.cybertek.tests;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import org.openqa.selenium.remote.CapabilityType;

public class FirstClass {

    public static void main(String[] args) {

        System.out.println("Hello World");

        // Faker object oluşturacagız.
        Faker faker = new Faker();  // Faker nesnesi java için dummy yani sahte datalar üreten bir kütüphanedir.R
        System.out.println(faker.name().fullName()); // her defasında rastgele bir ad soyad verir.
        System.out.println(faker.name().name());
        System.out.println(faker.harryPotter().character());

        // fake American express card numarası üretir.
        System.out.println(faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS));



    }

}
