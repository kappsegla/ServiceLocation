module com.service.provider {
    exports se.iths.martin.plugin;  //Do not export...
    requires com.service.api;
    provides se.iths.martin.spi.Greetings with se.iths.martin.plugin.SwedishGreeting, se.iths.martin.plugin.EnglishGreeting;
   // provides se.iths.martin.spi.Greetings with se.iths.martin.plugin.MyProvider;
}