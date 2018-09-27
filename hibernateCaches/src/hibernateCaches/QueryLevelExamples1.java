package hibernateCaches;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryLevelExamples1 {

	public static void main(String[] args) 
	{
		SessionFactory sf =  new 	Configuration().configure("accountDetailsDTO.cfg.xml").buildSessionFactory();
		Session sn1 = sf.openSession();
		Query query = sn1.createQuery("from AccountDetailsDTO as e where e.ename='tanmay' and e.edepartment='OracleDB'");
		
		query.setCacheable(true);
		List<?> l = query.list();
		Iterator<?> it = l.iterator();
		AccountDetailsDTO acd1;
		while(it.hasNext())
		{
			acd1 = (AccountDetailsDTO) it.next();
			System.out.println(acd1.getEid()+" ");
			System.out.print(acd1.getEname()+" ");
			System.out.print(acd1.getEdepartment()+" ");
			System.out.print(acd1.getSalary()+" ");
			
			System.out.println("");
		}
		sn1.close();
		
		Session sn2 = sf.openSession();
		Query query1 = sn2.createQuery("from AccountDetailsDTO as e where e.ename='tanmay' and e.edepartment='OracleDB'");
		
		query1.setCacheable(true);
		List<?> l2 = query1.list();
		Iterator<?> it2 = l2.iterator();
		AccountDetailsDTO acd2;
		while(it2.hasNext())
		{
			acd2 = (AccountDetailsDTO) it2.next();
			System.out.println(acd2.getEid()+" ");
			System.out.print(acd2.getEname()+" ");
			System.out.print(acd2.getEdepartment()+" ");
			System.out.print(acd2.getSalary()+" ");
			
			System.out.println("");
		}
		sn2.close();
		
		
	}

}
