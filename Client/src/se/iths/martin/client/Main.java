package se.iths.martin.client;

import se.iths.martin.spi.Greetings;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ServiceLoader;

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
            greetings.printYourGreeting();
        }
//        for (Greetings greetings: loader) {
//            greetings.printYourGreeting();
//        }
//
//      //  loader.reload();
//        for (Greetings greetings: loader) {
//            greetings.printYourGreeting();
//        }
        //if( greetings.getClass().getAnnotation(Adress.class).value().equals("/v1/Greeting"))

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
