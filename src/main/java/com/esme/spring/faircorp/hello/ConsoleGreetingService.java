package com.esme.spring.faircorp.hello;

public class ConsoleGreetingService {
    public void sayHello() {
        GreetingService greetingService = new GreetingService() {
        };
        System.out.println("Hello " +
                greetingService.greet();
    }

    public void greet(String spring) {
    }
}