package namedQueryPro;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class NamedQueryExample1 {

	public static void main(String[] args) 
	{
		SessionFactory sf =  new Configuration().configure("empHibernate.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		Transaction trs = sn.beginTransaction();
		
		Query qr = sn.getNamedQuery("findDetails");
		
		List<?> ls = qr.list();
		Iterator<?> itr = ls.iterator();
		EmployeeDTO emp1;
		while(itr.hasNext())
		{
			emp1 = (EmployeeDTO) itr.next();
			System.out.println(emp1.getEid()+" ");
			System.out.print(emp1.getEname()+" ");
			System.out.print(emp1.getEdepartment()+" ");
			System.out.print(emp1.getSalary()+" ");
			
			System.out.println("");
		}
		
		trs.commit();
		sn.close();

	}

}
