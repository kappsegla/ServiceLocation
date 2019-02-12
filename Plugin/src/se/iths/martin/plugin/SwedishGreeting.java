package se.iths.martin.plugin;

import se.iths.martin.api.Greetings;

public class SwedishGreeting implements Greetings {
    @Override
    public void printYourGreeting() {
        System.out.println("Sweden says Hej!");
    }

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
