package hibernateCaches;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateCachesExample5
{

	public static void main(String[] args) 
	{
		SessionFactory sf =  new 	Configuration().configure("accountDetailsDTO.cfg.xml").buildSessionFactory();
		Session sn1 = sf.openSession();
		Transaction trn = sn1.beginTransaction();
		AccountDetailsDTO ad = new AccountDetailsDTO();
		for(int i=0;i<10;i++)
		{
			ad = (AccountDetailsDTO) sn1.load(AccountDetailsDTO.class, 2);
			System.out.println("ID: "+ad.getEid()+" Name: "+ad.getEname()+" Department: "+ad.getEdepartment()+" Salary: "+ad.getSalary());
			
			ad.setEid(2);
			ad.setEname("Samir");
			ad.setEdepartment("Servlet");
			ad.setSalary(44000);
			sn1.update(ad);
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			
		}
		
		trn.commit();
		sn1.close();
			

			
	}

}
