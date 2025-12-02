package com.robinlb.techbit;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class Main {

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        
        // Puerto del servidor
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        tomcat.setPort(Integer.valueOf(webPort));
        tomcat.getConnector(); // Necesario para Tomcat 10+

        // Ruta al contexto y a los recursos web
        String contextPath = "/TechBit";
        String docBase = new File("src/main/webapp").getAbsolutePath();

        Context context = tomcat.addWebapp(contextPath, docBase);
        System.out.println("Configuring app with basedir: " + docBase);

        // Asegurar que las clases compiladas se encuentren al ejecutar como JAR
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
        context.setResources(resources);

        // Iniciar el servidor
        tomcat.start();
        System.out.println("Servidor Tomcat embebido iniciado en el puerto: " + webPort);
        tomcat.getServer().await();
    }
}
