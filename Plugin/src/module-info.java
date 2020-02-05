module com.service.provider {
    exports se.iths.martin.plugin;
    requires com.service.api;
    provides se.iths.martin.spi.Greetings with se.iths.martin.plugin.SwedishGreeting;
}