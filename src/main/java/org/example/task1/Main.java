package org.example.task1;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- СЦЕНАРІЙ 1: Робота з Міжнародним метеосервісом ---");
        InternationalWeatherService interService = new InternationalWeatherService();

        MeteoData adapter1 = new InternationalWeatherAdapter(interService);


        ControlCenter controlCenter = new ControlCenter();
        controlCenter.makeTakeoffDecision(adapter1);

        System.out.println("\n--- СЦЕНАРІЙ 2: Підключення другого умовного сервісу ---");

        SecondWeatherService secondService = new SecondWeatherService();
        MeteoData adapter2 = new SecondWeatherAdapter(secondService);


        controlCenter.makeTakeoffDecision(adapter2);
    }
}