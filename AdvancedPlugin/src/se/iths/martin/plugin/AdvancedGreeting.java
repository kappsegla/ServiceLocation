package se.iths.martin.plugin;

import se.iths.martin.api.Adress;
import se.iths.martin.api.Greetings;
@Adress("/v1/Greeting")
public class AdvancedGreeting implements Greetings {

    @Override
    public void printYourGreeting() {
        System.out.println("This is crazy");
    }

    @Override
    public int calculate(int a, int b) {
        return -1;
    }
}
