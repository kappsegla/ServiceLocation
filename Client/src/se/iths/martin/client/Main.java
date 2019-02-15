package se.iths.martin.client;

import se.iths.martin.api.Adress;
import se.iths.martin.api.Greetings;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Optional;
import java.util.Scanner;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        Main main = new Main();
        main.run(args);
    }

    private URLClassLoader createClassLoader(String fileLocation) {
        File loc = new File(fileLocation);

        File[] flist = loc.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.getPath().toLowerCase().endsWith(".jar");
            }
        });
        URL[] urls = new URL[flist.length];
        for (int i = 0; i < flist.length; i++) {
            try {
                urls[i] = flist[i].toURI().toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return new URLClassLoader(urls);
    }

    private void run(String[] args) {

        URLClassLoader ucl = createClassLoader(args[0]);

        ServiceLoader<Greetings> loader =
                ServiceLoader.load(Greetings.class, ucl);

        for (Greetings greetings: loader) {
            if( greetings.getClass().getAnnotation(Adress.class).value().equals("/v1/Greeting"))
                greetings.printYourGreeting();
        }

//          Requires java >9
//        Optional<Greetings> page = loader
//                .stream()
//                .filter(p -> p.type().isAnnotationPresent(Adress.class)
//                      &&  p.type().getAnnotation(Adress.class).value().equals("/v1/Greeting"))
//                .map(ServiceLoader.Provider::get).findFirst();


//
//        for (Greetings greetings : pages) {
//
//
//            greetings.printYourGreeting();
//            System.out.println(greetings.calculate(2, 3));
//        }
    }
}
