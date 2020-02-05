package se.iths.martin.spi;

public interface Greetings {
    void printYourGreeting();
    int calculate(int a, int b);
}

//https://javax0.wordpress.com/2018/01/10/java-9-module-services/
//java -p "Client.jar;SPI.jar;lib\Plugin.jar" -m com.service.app/se.iths.martin.client.Main .\lib