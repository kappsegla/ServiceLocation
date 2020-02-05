package se.iths.martin.plugin;

import se.iths.martin.spi.Greetings;

public class MyProvider {
    public static Greetings provider(){
        System.out.println("SwedishGreeting provider.");
        return new SwedishGreeting();
    }
}
