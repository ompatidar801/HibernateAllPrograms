package tablePerClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PaymentsMainClass {

	public static void main(String[] args)
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sn = sf.openSession();
		CreditCard cc = new CreditCard();
		cc.setPay_id(84);
		cc.setAmount(50000);
		cc.setCd_name("Visa");
		
		Cheaque ch = new Cheaque();
		ch.setPay_id(85);
		ch.setAmount(57488.45);
		ch.setCheaque_Name("SBI");
		
		Transaction tr = sn.beginTransaction();
		sn.save(cc);
		sn.save(ch);
		tr.commit();
		sn.close();
	}

}
