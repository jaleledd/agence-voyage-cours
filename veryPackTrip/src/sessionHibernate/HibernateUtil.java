package sessionHibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Basic Hibernate helper class, handles SessionFactory, Session and Transaction. <p> Uses a static initializer to read startup options and initialize <tt>Configuration</tt> and <tt>SessionFactory</tt>. <p> This class tries to figure out if either ThreadLocal handling of the <tt>Session</tt> and <tt>Transaction</tt> should be used, for resource local transactions or BMT, or if CMT with automatic <tt>Session</tt> handling is enabled. <p> To keep your DAOs free from any of this, just call <tt>HibernateUtil.getCurrentSession()</tt> in the constructor of each DAO., The recommended way to set resource local or BMT transaction boundaries is an interceptor, or a request filter. <p> This class also tries to figure out if JNDI binding of the <tt>SessionFactory</tt> is used, otherwise it falls back to a global static variable (Singleton). <p> If you want to assign a global interceptor, set its fully qualified class name with the system (or hibernate.properties/hibernate.cfg.xml) property <tt>hibernate.util.interceptor_class</tt>. It will be loaded and instantiated on static initialization of HibernateUtil; it has to have a no-argument constructor. You can call <tt>getInterceptor()</tt> if you need to provide settings before using the interceptor. <p> Note: This class supports annotations by default, hence needs JDK 5.0 and the Hibernate Annotations library on the classpath. Change the single commented line in the source to make it compile and run on older JDKs with XML mapping files only.
 * @author  christian@hibernate.org
 */
public class HibernateUtil {
	private static Log				log					= LogFactory.getLog(HibernateUtil.class);
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch(Throwable ex) {
			log.error("Probleme lors de l'initialisation de HibernateUtil "+ex.getMessage());
			throw new ExceptionInInitializerError(ex); 
		}
	}
	
	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
}
