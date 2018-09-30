package curdannotationbased;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class StockMain 
{
	static AnnotationConfiguration ac = new AnnotationConfiguration().configure();
	static SessionFactory sf = ac.buildSessionFactory();
	
	public static void saveStudentCURDMain()
	{
		Session sn = sf.openSession();
		
		Stock s1 =new Stock();
		s1.setStockID("AS834");
		s1.setStockProduct("Shoes");
		
		Stock s2 = new Stock();
		s2.setStockID("DKD78");
		s2.setStockProduct("Jackets");
		
		Stock s3 = new Stock();
		s3.setStockID("KJ854");
		s3.setStockProduct("Towel");
		
		Transaction tr = sn.beginTransaction();
		sn.save(s1);
		sn.save(s2);
		sn.save(s3);
		
		tr.commit();
		sn.close();
		
	}
	
	public static void getStudentCURDMain()
	{
		Session sn = sf.openSession();
		
		Query qr = sn.createQuery("from Stock s");
		List<?> l = qr.list();
		Iterator<?> it1 = l.iterator();
		while(it1.hasNext())
		{
			Stock s1 = (Stock) it1.next();
			System.out.println("St_ID:"+s1.getStockID());
			System.out.println("St_Product:"+s1.getStockProduct());
			
		}
		sn.close();
	}
	
	public static void updateStudentCURDMain()
	{
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		
		Stock s2 = (Stock) sn.get(Stock.class, "AS834");
		s2.setStockProduct("Shocks");
		sn.update(s2);
		
		tr.commit();
		sn.close();
		
	}
	
	public static void deleteStudentCURDMain()
	{
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		Stock s2 = (Stock) sn.get(Stock.class, "AS834");
		sn.delete(s2);
		tr.commit();
		sn.close();
		
	}
	
	public static void main(String[] args) 
	{
		//saveStudentCURDMain();
		getStudentCURDMain();
		//updateStudentCURDMain();
		deleteStudentCURDMain();

	}

}
