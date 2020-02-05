package se.iths.martin.plugin;

import se.iths.martin.spi.GreetingProvider;
import se.iths.martin.spi.Greetings;

public class SwedishProvider implements GreetingProvider {
    @Override
    public Greetings create() {
        return new SwedishGreeting();
    }
}
