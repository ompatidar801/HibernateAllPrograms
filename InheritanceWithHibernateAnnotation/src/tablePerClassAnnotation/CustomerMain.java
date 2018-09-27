package tablePerClassAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class CustomerMain {

	public static void main(String[] args)
	{
		AnnotationConfiguration ac = new AnnotationConfiguration().configure();
		SessionFactory sf = ac.buildSessionFactory();
		Session sn = sf.openSession();
		
		RegularCustomer rc = new RegularCustomer();
		rc.setCustid(938);
		rc.setCustname("Ganpatlal");
		rc.setRepay(98659);
		
		TempCustomer tc = new TempCustomer();
		tc.setCustid(9048);
		tc.setCustname("Jackson");
		tc.setTcpay(96574);
		
		Transaction tr = sn.beginTransaction();
		sn.save(rc);
		sn.save(tc);
		tr.commit();
		sn.close();
		
	}

}
