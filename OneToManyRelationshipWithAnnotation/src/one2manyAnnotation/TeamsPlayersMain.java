package one2manyAnnotation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class TeamsPlayersMain 
{
	static AnnotationConfiguration ac = new AnnotationConfiguration().configure();
	static SessionFactory sf = ac.buildSessionFactory();
	public static void saveTeamsPlayersMain()
	{
		Session sn = sf.openSession();
		
		Teams t1 = new Teams();
		t1.setT_id(78564);
		t1.setT_name("India");
		
		Teams t2 = new Teams();
		t2.setT_id(7645);
		t2.setT_name("Austrelia");
		
		Players p1 = new Players();
		p1.setPid(7);
		p1.setPname("MS Dhoni");
		
		Players p2 = new Players();
		p2.setPid(18);
		p2.setPname("Virat Kohli");
		
		Players p3 = new Players();
		p3.setPid(87);
		p3.setPname("Glen Maxwell");
		
		Players p4 = new Players();
		p4.setPid(65);
		p4.setPname("Steven Smith");
		
		Set<Players> s1 = new HashSet<Players>();
		s1.add(p1);
		s1.add(p2);
		
		Set<Players> s2 = new HashSet<Players>();
		s2.add(p3);
		s2.add(p4);
		
		t1.setPlayers(s1);
		t2.setPlayers(s2);
		
		Transaction tr = sn.beginTransaction();
		sn.save(t1);
		sn.save(t2);
		
		tr.commit();
		sn.close();
		
	}
	
	public static void getTeamsPlayersMain()
	{
		Session sn = sf.openSession();
		Query qr = sn.createQuery("from Teams t");
		List<?> l = qr.list();
		Iterator<?> it = l.iterator();
		while(it.hasNext())
		{
		
			Teams t1 = (Teams) it.next();
			System.out.println("------Teams--------");
			System.out.println("ID: "+t1.getT_id());
			System.out.println("Name: "+t1.getT_name());
			System.out.println("--------------------");
			
			Set<?> pr = t1.getPlayers();
			Iterator<?> it1 = pr.iterator();
			while (it1.hasNext())
			{
				Players pl = (Players) it1.next();
				System.out.println("-------Players");
				System.out.println("ID: "+pl.getPid());
				System.out.println("Name: "+pl.getPname());
				System.out.println("Team_Name:"+pl.getFktname());
				
			}
			
		}
		sn.close();	
	}
	
	public static void updateTeamsPlayersMain()
	{
		Session sn = sf.openSession();
		Transaction tr =sn.beginTransaction();
		Query qr = sn.createQuery("from Teams t");
		List<?> l = qr.list();
		Iterator<?> it = l.iterator();
		while(it.hasNext())
		{
		
			Teams t1 = (Teams) it.next();
			Set<?> pl =  t1.getPlayers();
			Iterator<?> it1 = pl.iterator();
			while (it1.hasNext())
			{
				Players prl = (Players) it1.next();
				prl.setPname("Sachin");
				sn.update(prl);
			}
			
		}
		tr.commit();
		sn.close();
		
	}
	
	public static void deleteTeamsPlayersMain()
	{
		Session sn= sf.openSession();
		Transaction tr = sn.beginTransaction();
		
		Query qr = sn.createQuery("from Teams t");
		List<?> l = qr.list();
		Iterator<?> it = l.iterator();
		while(it.hasNext())
		{
		
			Teams t1 = (Teams) it.next();
			Set<?> pl =  t1.getPlayers();
			Iterator<?> it1 = pl.iterator();
			while (it1.hasNext())
			{
				Players prl = (Players) it1.next();
				sn.delete(t1);
			}
			
		}
		tr.commit();
		sn.close();
		
	}
	public static void main(String[] args)
	{
		//saveTeamsPlayersMain();
		//getTeamsPlayersMain();
		//updateTeamsPlayersMain();
		deleteTeamsPlayersMain();
	}
}
