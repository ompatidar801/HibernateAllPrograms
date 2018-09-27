package hibernateGetList;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateGet.*;

public class GetAllRecordInTable {

	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure("StudentGetDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		
		Query q = sn.createQuery("from StudentGetDTO");
		List l = q.list();
		Iterator i = l.iterator();
		StudentGetDTO sgdto ;
		
		System.out.println("");
		while(i.hasNext())
		{
				sgdto = (StudentGetDTO) i.next();
				System.out.print(sgdto.getStId()+" ");
				System.out.print(sgdto.getStName()+" ");
				System.out.print(sgdto.getStAddress()+" ");
				System.out.print(sgdto.getStAge()+" ");
				System.out.println("");
		}
		sn.close();
	}

}
