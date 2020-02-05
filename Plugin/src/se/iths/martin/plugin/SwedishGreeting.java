package se.iths.martin.plugin;

import se.iths.martin.spi.Greetings;

public class SwedishGreeting implements Greetings {

    public SwedishGreeting(){
        System.out.println("SwedishGreeting constructor.");
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
