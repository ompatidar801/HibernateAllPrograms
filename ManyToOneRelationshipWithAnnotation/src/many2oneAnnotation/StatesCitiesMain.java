package many2oneAnnotation;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class StatesCitiesMain 
{
	static AnnotationConfiguration ac = new AnnotationConfiguration().configure();
	static SessionFactory sf = ac.buildSessionFactory();
	
	public static void saveStatesCitiesMain()
	{
		Session sn = sf.openSession();
		States st = new States();
		st.setStid(645);
		st.setStname("Madhya Pradesh");
		
		States st2 = new States();
		st2.setStid(854);
		st2.setStname("Gujrat");
		
		Cities ct1 = new Cities();
		ct1.setcID(978);
		ct1.setcName("Indore");
		ct1.setState(st);
		
		Cities ct2 = new Cities();
		ct2.setcID(432);
		ct2.setcName("Bhopal");
		ct2.setState(st);
		
		Cities ct3 = new Cities();
		ct3.setcID(764);
		ct3.setcName("Mandshor");
		ct3.setState(st);
		
		Cities ct4 = new Cities();
		ct4.setcID(846);
		ct4.setcName("Surat");
		ct4.setState(st2);
		
		Cities ct5 = new Cities();
		ct5.setcID(745);
		ct5.setcName("Ahmadabad");
		ct5.setState(st2);
		
		Cities ct6 = new Cities();
		ct6.setcID(438);
		ct6.setcName("Baroda");
		ct6.setState(st2);
		
		Transaction tr = sn.beginTransaction();
		sn.save(ct1);
		sn.save(ct2);
		sn.save(ct3);
		sn.save(ct4);
		sn.save(ct5);
		sn.save(ct6);
		
		tr.commit();
		sn.close();
		
	}
	
	public static void updateStatesCitiesMain()
	{
		Session sn = sf.openSession();
		Cities cs = (Cities) sn.get(Cities.class, 978);
		cs.setcName("Indore Rahega No.1");
		States st = cs.getState(); 
		st.setStname("M.P.");
		
		Transaction tr = sn.beginTransaction();
		sn.save(st);
		tr.commit();
		sn.close();
	}
	
	public static void getStatesCitiesMain()
	{
		Session sn = sf.openSession();
		
		Cities cs = (Cities) sn.get(Cities.class, 978);
		System.out.println("-------------Cities-------------");
		System.out.println("ID: "+cs.getcID());
		System.out.println("Name: "+cs.getcName());
		System.out.println("States: "+cs.getState());
		System.out.println("--------------------------------");
		
		States st = cs.getState(); 
		System.out.println("-------------States-------------");
		System.out.println("ID: "+st.getStid());
		System.out.println("Name: "+st.getStname());
		System.out.println("--------------------------------");
		
		sn.close();
	}
	
	public static void deleteStatesCitiesMain()
	{
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		Query q = sn.createQuery("from Cities c");
		List<?> l = q.list();
		Iterator<?> it = l.iterator();
		while(it.hasNext())
		{
			Cities cs = (Cities) it.next();
			//States st = cs.getState(); 
			sn.delete(cs);
		}
		tr.commit();
		sn.close();
	}
	
	public static void main(String[] args)
	{
		//saveStatesCitiesMain();
		//updateStatesCitiesMain();
		//getStatesCitiesMain();
		deleteStatesCitiesMain();
		
	}

}
