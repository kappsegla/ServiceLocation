package se.iths.martin.client;

import se.iths.martin.api.Greetings;

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

    private void run(String[] args) {

        String fileLocation = args[0];
        File loc = new File(fileLocation);

        File[] flist = loc.listFiles(new FileFilter() {
            public boolean accept(File file) {return file.getPath().toLowerCase().endsWith(".jar");}
        });
        URL[] urls = new URL[flist.length];
        for (int i = 0; i < flist.length; i++) {
            try {
                urls[i] = flist[i].toURI().toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        URLClassLoader ucl = new URLClassLoader(urls);

        ServiceLoader<Greetings> loader =
                ServiceLoader.load(Greetings.class, ucl);

        for (Greetings greetings : loader) {
            greetings.printYourGreeting();
            System.out.println(greetings.calculate(2, 3));
        }
    }
}
