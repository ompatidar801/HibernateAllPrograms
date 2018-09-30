package m2oxmlbased;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UnivercityCollagesMain
{
	static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public static void saveUnivercityCollagesMain()
	{
		Session sn =sf.openSession();
		Univercity uni1 = new Univercity();
		uni1.setuID(9847);
		uni1.setuName("RJPV");
		
		Univercity uni2 = new Univercity();
		uni2.setuID(456);
		uni2.setuName("DAVV");
		
		Collages col1 = new Collages();
		col1.setcID(847);
		col1.setcName("LSA Collage");
		
		col1.setUnivercity(uni1);
		
		
		Transaction tr = sn.beginTransaction();
		sn.save(col1);
		col1.setUnivercity(uni2);
		sn.save(col1);
		tr.commit();
		sn.close();
		
	}
	
	public static void getUnivercityCollagesMain()
	{
		Session sn =sf.openSession();
		Query q = sn.createQuery("from Collages c");
		List l = q.list();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			Collages co = (Collages) it.next();
			System.out.println(co.getcID());
			System.out.println(co.getcName());
			Univercity u = co.getUnivercity();
			System.out.println(u.getuID());
			System.out.println(u.getuName());
			
		}
		sn.close();
	}
	
	public static void updateUnivercityCollagesMain()
	{
		Session sn = sf.openSession();
		Collages co = (Collages)  sn.get(Collages.class, 847);
		Univercity u = co.getUnivercity();
		u.setuName("MakhanLal");
		co.setcName("Daksh");
		Transaction tr = sn.beginTransaction();
		sn.save(u);
		tr.commit();
		sn.close();
	}
	
	public static void deleteUnivercityCollagesMain()
	{
		Session sn = sf.openSession();
		Collages co = (Collages)  sn.get(Collages.class, 847);
		//Univercity u = co.getUnivercity();
		Transaction tr = sn.beginTransaction();
		sn.delete(co);
		tr.commit();
		sn.close();
	}
	
	public static void main(String[] args) 
	{
		//saveUnivercityCollagesMain();
		//getUnivercityCollagesMain();
		//updateUnivercityCollagesMain();
		deleteUnivercityCollagesMain();
		
	}
}
