package se.iths.martin.plugin;

import se.iths.martin.spi.Adress;
import se.iths.martin.spi.GET;
import se.iths.martin.spi.Greetings;

import java.net.ResponseCache;

@Adress("/hello")
public class SwedishGreeting implements Greetings {

    public SwedishGreeting() {
        System.out.println("SwedishGreeting constructor.");
    }

    @GET
    public void helloGet() {
        System.out.println("Sweden says Hej from our own method get");
    }


    @Override
    public void printYourGreeting() {
        System.out.println("Sweden says Hej!");
    }

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
