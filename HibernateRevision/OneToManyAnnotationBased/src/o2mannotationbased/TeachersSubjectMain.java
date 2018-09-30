package o2mannotationbased;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class TeachersSubjectMain 
{
	static AnnotationConfiguration ac = new AnnotationConfiguration().configure(); 
	static SessionFactory sf = ac.buildSessionFactory();
	public static void saveTeachersSubjectMain()
	{
		Session sc = sf.openSession();
		
		Teachers tc = new Teachers();
		tc.settID(11);
		tc.settName("Santosh");
		
		Subject sb = new Subject();
		sb.setSubID(756);
		sb.setSubName("Physics");
		
		Subject sb1 = new Subject();
		sb1.setSubID(757);
		sb1.setSubName("Chemistry");
		
		Subject sb2 = new Subject();
		sb2.setSubID(758);
		sb2.setSubName("English");
		
		Set<Subject> s1 = new HashSet<Subject>();
		s1.add(sb);
		s1.add(sb1);
		s1.add(sb2);
		
		tc.setSubject(s1);
		Transaction tr = sc.beginTransaction();
		sc.save(tc);
		tr.commit();
		sc.close();
	}
	
	public static void getTeachersSubjectMain()
	{
		Session sc = sf.openSession();
		Teachers tr = (Teachers) sc.get(Teachers.class, 11);
		System.out.println("======Teachers=Details=======");
		System.out.println("tID:"+tr.gettID());
		System.out.println("tName:"+tr.gettName());
		System.out.println("=============================");
		
		Set<?> s2 = tr.getSubject();
		Iterator<?> it1 = s2.iterator();
		while(it1.hasNext())
		{
			Subject sb3 = (Subject) it1.next();
			System.out.println("======Subject=Details=======");
			System.out.println("sID:"+sb3.getSubID());
			System.out.println("sName:"+sb3.getSubName());
			System.out.println("Teachers:"+sb3.getFKtId());
			System.out.println("=============================");
			
		}
		sc.close();
	}
	
	public static void updateTeachersSubjectMain()
	{
		Session sc = sf.openSession();
		Transaction tr1 = sc.beginTransaction();
		Teachers tr = (Teachers) sc.get(Teachers.class, 11);
		Set<?> s2 = tr.getSubject();
		Iterator<?> it1 = s2.iterator();
		while(it1.hasNext())
		{
			Subject sb3 = (Subject) it1.next();
			sb3.setSubName("ram");
			sc.update(sb3);
			
		}
		tr1.commit();
		sc.close();
	}
	
	public static void deleteTeachersSubjectMain()
	{
		Session sc = sf.openSession();
		Transaction tr1 = sc.beginTransaction();
		Teachers tr = (Teachers) sc.get(Teachers.class, 11);
		Set<?> s2 = tr.getSubject();
		Iterator<?> it1 = s2.iterator();
		while(it1.hasNext())
		{
			Subject sb3 = (Subject) it1.next();
			sc.delete(tr);
		}
		tr1.commit();
		sc.close();
	}
	
	public static void main(String[] args)
	{
		saveTeachersSubjectMain();
		//getTeachersSubjectMain();
		//updateTeachersSubjectMain();
		//deleteTeachersSubjectMain();
	}
}