package hibernateDelete;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerRecordDelete {

	public static void main(String[] args) 
	{
		CustomerDeleteDTO cdd = new CustomerDeleteDTO();
		cdd.setCstId(5);
	/*	cdd.setCstName("Shubham");
		cdd.setCstAddress("Sagwal");
		cdd.setCstAge(30);  */
		
		SessionFactory sc = new Configuration().configure("customerDeleteDTO.cfg.xml").buildSessionFactory();
		Session sn = sc.openSession();
		Transaction trn = sn.beginTransaction();
		
		sn.delete(cdd);
		trn.commit();
		sn.close();
	}

}
