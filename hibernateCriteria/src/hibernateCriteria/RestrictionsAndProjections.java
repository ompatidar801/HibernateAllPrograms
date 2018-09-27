package hibernateCriteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class RestrictionsAndProjections 
{
	public static void likeOpe()
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		
		Criteria crt = sn.createCriteria(TeacherDTO.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("id"));
		pl.add(Projections.property("name"));
		crt.setProjection(pl);
		crt.add(Restrictions.like("department", "M%"));
		
		
		List<?> ls2 = crt.list();
		Iterator<?> itr2 = ls2.iterator();
		Object[] ob;
		System.out.println("");
		while(itr2.hasNext())
		{
			ob = (Object[]) itr2.next();
			Integer id = (Integer) ob[0];
			String name= (String) ob[1];
			
			System.out.print("ID:"+id+" Name:"+name);
					
			System.out.println("");
		}
		sn.close();
	}
	
	public static void equalConditon()
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		
		Criteria crt = sn.createCriteria(TeacherDTO.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("id"));
		pl.add(Projections.property("salary"));
		crt.setProjection(pl);
		crt.add(Restrictions.eq("name", "Manish"));
		//crt.add(Restrictions.ne("name", "Manish"));
	
		
		List<?> ls2 = crt.list();
		Iterator<?> itr2 = ls2.iterator();
		Object[] ob;
		System.out.println("");
		while(itr2.hasNext())
		{
			ob = (Object[]) itr2.next();
			Integer id = (Integer) ob[0];
			Integer salary= (Integer) ob[1];
			
			System.out.print("ID:"+id+" Salary:"+salary);
					
			System.out.println("");
		}
		sn.close();
	}
	
	public static void betweenCondition()
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		
		Criteria crt = sn.createCriteria(TeacherDTO.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("id"));
		pl.add(Projections.property("name"));
		pl.add(Projections.property("department"));
		crt.setProjection(pl);
		crt.add(Restrictions.between("salary", 20000, 50000));
		
		List<?> ls2 = crt.list();
		Iterator<?> itr2 = ls2.iterator();
		Object[] ob;
		System.out.println("");
		while(itr2.hasNext())
		{
			ob = (Object[]) itr2.next();
			Integer id = (Integer) ob[0];
			String name= (String) ob[1];
			String depart= (String) ob[2];
			
			System.out.print("ID:"+id+" Name:"+name+" Department:"+depart);
					
			System.out.println("");
		}
		sn.close();
	}
	
	public static void greaterThenCondition()
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		
		Criteria crt = sn.createCriteria(TeacherDTO.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("id"));
		pl.add(Projections.property("name"));
		pl.add(Projections.property("department"));
		crt.setProjection(pl);
		crt.add(Restrictions.ge("salary", 25000));
		crt.add(Restrictions.le("salary", 49000));
		List<?> ls2 = crt.list();
		Iterator<?> itr2 = ls2.iterator();
		Object[] ob;
		System.out.println("");
		while(itr2.hasNext())
		{
			ob = (Object[]) itr2.next();
			Integer id = (Integer) ob[0];
			String name= (String) ob[1];
			String depart= (String) ob[2];
			
			System.out.print("ID:"+id+" Name:"+name+" Department:"+depart);
					
			System.out.println("");
		}
		sn.close();
	}
	
	public static void greaterThenSize()
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		
		Criteria crt = sn.createCriteria(TeacherDTO.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("id"));
		pl.add(Projections.property("name"));
		pl.add(Projections.property("department"));
		crt.setProjection(pl);
		crt.add(Restrictions.eqProperty("name", "department"));
		//crt.add(Restrictions.le("salary", 49000));
		List<?> ls2 = crt.list();
		Iterator<?> itr2 = ls2.iterator();
		Object[] ob;
		System.out.println("");
		while(itr2.hasNext())
		{
			ob = (Object[]) itr2.next();
			
			String name= (String) ob[0];
			String depart= (String) ob[1];
			
			System.out.print(" Name:"+name+" Department:"+depart);
					
			System.out.println("");
		}
		sn.close();
	}
	
	public static void orQueryWithProjAndRestri()
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();	
		
		Criteria crt = sn.createCriteria(TeacherDTO.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("id"));
		pl.add(Projections.property("name"));
		pl.add(Projections.property("department"));
		crt.setProjection(pl);
		crt.add(Restrictions.or(
		Restrictions.like("department", "M%"),
		Restrictions.eq("id", 1)
		));
		
		List<?> ls2 = crt.list();
		Iterator<?> itr2 = ls2.iterator();
		Object[] ob;
		System.out.println("");
		while(itr2.hasNext())
		{
			ob = (Object[]) itr2.next();
			Integer id = (Integer) ob[0];
			String name= (String) ob[1];
			String depart= (String) ob[2];
			
			System.out.print("ID:"+id+" Name:"+name+" Department:"+depart);
					
			System.out.println("");
		}
		sn.close();
	}
	public static void main(String[] args) 
	{
		likeOpe();
		equalConditon();
		betweenCondition();
		greaterThenCondition();
		orQueryWithProjAndRestri();
	
	}

}
