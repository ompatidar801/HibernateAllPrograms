package hibernateUpdate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CustomerRecordUpdate {

	public static void main(String[] args)
	{
		CustomerDTO cst = new CustomerDTO();
		cst.setCstId(2);
		cst.setCstName("Ravi");
		cst.setCstAddress("indore");
		cst.setCstAge(56);
		
		SessionFactory sc = new Configuration().configure("customerHibernate.cfg.xml").buildSessionFactory();
		Session sn = sc.openSession();
		Transaction trn = sn.beginTransaction();
		
		sn.update(cst);
		trn.commit();
		sn.close();
		
	}

}
