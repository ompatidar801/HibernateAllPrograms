package tablePerSubClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmplyeeMain {

	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sn = sf.openSession();
		
		RegularEmployee re1 = new RegularEmployee();
		re1.setEmp_id(45);
		re1.setEmp_name("Ganesh");
		re1.setSalary(50000);
		re1.setBonus(3000);
		
		ContractEmployee ce = new ContractEmployee();
		ce.setEmp_id(46);
		ce.setEmp_name("Micheal");
		ce.setPay_per_hours(4000);
		ce.setConcrate_period("two month");
		
		Transaction tr = sn.beginTransaction();
		sn.save(re1);
		sn.save(ce);
		
		tr.commit();
		sn.close();
		
	}

}
