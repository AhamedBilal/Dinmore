/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import entity.Chef;
import entity.Order;
import entity.Reception;
import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Bilal
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;
    
    static {
        try {
            File hibernateProperties = new File("settings/hibernate.properties");
            registry = new StandardServiceRegistryBuilder().loadProperties(hibernateProperties).build();
            sessionFactory=new MetadataSources(registry)
                    .addAnnotatedClass(Reception.class)
                    .addAnnotatedClass(Chef.class)
                    .addAnnotatedClass(Order.class)
                    .buildMetadata().buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println("SesstionFactory Creation Failed "+ex);
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
