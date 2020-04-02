package pl.polsl.courier.system;

import pl.polsl.courier.system.controllers.TestController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@ApplicationPath("/")
public class CourierSystemApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        String controllersPackageName = TestController.class.getPackage().getName();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            assert classLoader != null;
            String path = controllersPackageName.replace('.', '/');
            Enumeration<URL> resources = classLoader.getResources(path);
            List<File> dirs = new ArrayList<>();
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                dirs.add(new File(resource.getFile()));
            }
            Set<Class<?>> classes = new HashSet<>();
            for (File directory : dirs)
                classes.addAll(findClasses(directory, controllersPackageName));
            return classes;
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException("Failed to load classes from controllers package '" + controllersPackageName + "'");
        }
    }

    private List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists())
            return classes;
        File[] files = directory.listFiles();
        if (files != null)
            for (File file : files)
                if (file.isDirectory() && file.getName().contains("."))
                    classes.addAll(findClasses(file, packageName + "." + file.getName()));
                else if (file.getName().endsWith(".class"))
                    classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
        return classes;
    }

}
