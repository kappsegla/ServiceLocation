package se.iths.martin.client;

import se.iths.martin.spi.Adress;
import se.iths.martin.spi.GET;
import se.iths.martin.spi.Greetings;

import java.io.File;
import java.io.FileFilter;
import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.Set;

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

        //URLClassLoader ucl = createClassLoader(args[0]);

        ServiceLoader<Greetings> loader =
                ServiceLoader.load(Greetings.class);



        pluginHandling(loader);
    }

    private void pluginHandling(ServiceLoader<Greetings> loader) {
        Optional<Greetings> greetings =
                loader.stream()
                        .filter(g -> g.type().isAnnotationPresent(Adress.class))
                        .filter(g -> g.type().getAnnotation(Adress.class).value().equals("/hello"))
                        .map(ServiceLoader.Provider::get)
                        .findFirst();

        greetings.ifPresent(
                greetings1 -> {
                    Method[] methods = greetings1.getClass().getDeclaredMethods();
                    for (Method m : methods) {
                        if (m.isAnnotationPresent(GET.class)) {
                            try {
                                m.invoke(greetings1);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        );
    }
}
