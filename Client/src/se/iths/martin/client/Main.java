package se.iths.martin.client;

import se.iths.martin.api.Greetings;

import java.util.ServiceLoader;

public class Main {


    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {

        ServiceLoader<Greetings> loader =
                ServiceLoader.load(Greetings.class);

        for(Greetings greetings: loader){
            greetings.printYourGreeting();
            System.out.println(greetings.calculate(2,3));
        }
    }
}
