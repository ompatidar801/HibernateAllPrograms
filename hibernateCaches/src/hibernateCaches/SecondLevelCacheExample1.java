package hibernateCaches;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCacheExample1 {

	public static void main(String[] args)
	{
		SessionFactory sf =  new Configuration().configure("accountDetailsDTO.cfg.xml").buildSessionFactory();
		Session sn1 = sf.openSession();
		AccountDetailsDTO acd1 = (AccountDetailsDTO) sn1.load(AccountDetailsDTO.class, 2);
		System.out.println("ID:"+acd1.getEid()+"Name:"+acd1.getEname()+"Department:"+acd1.getEdepartment()+"Salary:"+acd1.getSalary());
		
		sn1.close();
		long startTime = System.nanoTime();
		//code
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns");

		Session sn2 = sf.openSession();
		AccountDetailsDTO acd2 = (AccountDetailsDTO) sn2.load(AccountDetailsDTO.class, 2);
		System.out.println("ID:"+acd2.getEid()+"Name:"+acd2.getEname()+"Department:"+acd2.getEdepartment()+"Salary:"+acd2.getSalary());
		
		sn2.close();
		long startTime1 = System.nanoTime();
		//code
		long endTime1 = System.nanoTime();
		System.out.println("Took "+(endTime1 - startTime1) + " ns");

	}

}
