package se.iths.martin.plugin;

import se.iths.martin.spi.Greetings;

public class EnglishGreeting implements Greetings {

    public EnglishGreeting() {
        System.out.println("EnglishGreeting constructor.");
    }

    @Override
    public void printYourGreeting() {
        System.out.println("English Hello!");
    }

    @Override
    public int calculate(int a, int b) {
        return a*b;
    }
}
