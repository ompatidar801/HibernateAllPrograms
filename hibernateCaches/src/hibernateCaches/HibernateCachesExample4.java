package hibernateCaches;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateCachesExample4 {

	public static void main(String[] args) 
	{
		SessionFactory sf =  new 	Configuration().configure("accountDetailsDTO.cfg.xml").buildSessionFactory();
		Session sn1 = sf.openSession();
		for(int i=0;i<10;i++)
		{
			AccountDetailsDTO acd1 = (AccountDetailsDTO) sn1.load(AccountDetailsDTO.class, 2);
			System.out.println("ID:"+acd1.getEid()+"Name:"+acd1.getEname()+"Department:"+acd1.getEdepartment()+"Salary:"+acd1.getSalary());
			try
			{
				Thread.sleep(5000);

				AccountDetailsDTO ad = new AccountDetailsDTO();
				ad.setEid(2);
				ad.setEname("Shidhart");
				ad.setEdepartment("Spring");
				ad.setSalary(60000);
				
				Transaction trn = sn1.beginTransaction();
				
				sn1.update(ad);
				trn.commit();
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
		sn1.close();
		/*Session sn2 = sf.openSession();		
		for(int i=0;i<10;i++)
		{
			AccountDetailsDTO acd3 = (AccountDetailsDTO) sn2.load(AccountDetailsDTO.class, 7);
			System.out.println("ID:"+acd3.getEid()+"Name:"+acd3.getEname()+"Department:"+acd3.getEdepartment()+"Salary:"+acd3.getSalary());
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
		sn2.close();*/
		
	}

}
