package lt.viko.eif.esemasko.movie_critic_system.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * This class has one method: getSessionFactory
 *
 * @version 1.0
 * @since 1.0
 */
public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    /**
     * Constructor for HibernateUtil class.
     */
    private HibernateUtil() {


    }

    /**
     * This is a getSessionFactory method
     * <p>
     * This method returns a Hibernate SessionFactory instance, which is responsible for creating and managing Session instances in a Hibernate application.
     *
     * @return returns SessionFactory instance variable.
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                registry = new StandardServiceRegistryBuilder().configure().build();

                MetadataSources sources = new MetadataSources(registry);

                Metadata metadata = sources.getMetadataBuilder().build();

                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

}
