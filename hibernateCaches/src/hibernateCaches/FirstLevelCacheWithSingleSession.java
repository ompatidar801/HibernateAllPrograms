package hibernateCaches;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCacheWithSingleSession
{
	public static void main(String[] args) 
	{
		SessionFactory sf =  new Configuration().configure("accountDetailsDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		AccountDetailsDTO acd1 = (AccountDetailsDTO) sn.load(AccountDetailsDTO.class, 2);
		System.out.println("ID:"+acd1.getEid()+"Name:"+acd1.getEname()+"Department:"+acd1.getEdepartment()+"Salary:"+acd1.getSalary());
		long startTime = System.nanoTime();
		//code
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns");

		AccountDetailsDTO acd2 = (AccountDetailsDTO) sn.load(AccountDetailsDTO.class, 2);
		System.out.println("ID:"+acd2.getEid()+"Name:"+acd2.getEname()+"Department:"+acd2.getEdepartment()+"Salary:"+acd2.getSalary());
		long startTime1 = System.nanoTime();
		//code
		long endTime1 = System.nanoTime();
		System.out.println("Took "+(endTime1 - startTime1) + " ns");
		sn.close();
		
	}
}
