package se.iths.martin.plugin;

import se.iths.martin.spi.GreetingProvider;
import se.iths.martin.spi.Greetings;

public class Provider implements GreetingProvider {
    @Override
    public Greetings create() {
        return new AdvancedGreeting();
    }
}
