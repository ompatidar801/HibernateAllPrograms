package hibernateCriteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class CriteriaRestrictionsExa
{
	public static void whereClause()
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		Query qr1 = sn.createSQLQuery("select * from Teacher where salary like '_5%' ").addEntity(TeacherDTO.class);		
		//Query qr1 = sn.createQuery("from TeacherDTO where name like '_a%'");
		List<?> ls1 = qr1.list();
		Iterator<?> itr1 = ls1.iterator();
		TeacherDTO t1;
		System.out.println("");
		while(itr1.hasNext())
		{
			t1 = (TeacherDTO) itr1.next();
			System.out.print(t1.getId()+" ");
			System.out.print(t1.getName()+" ");
			System.out.print(t1.getDepartment()+" ");
			System.out.print(t1.getSalary()+" ");
					
			System.out.println("");
		}
		sn.close();
		
	}
	public static void andQuery()
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();	
		
		Criteria crt = sn.createCriteria(TeacherDTO.class);
		crt.add(Restrictions.like("department", "M%"));
		crt.add(Restrictions.eq("id", 1));
		
		List<?> ls2 = crt.list();
		Iterator<?> itr2 = ls2.iterator();
		TeacherDTO t2;
		System.out.println("");
		while(itr2.hasNext())
		{
			t2 = (TeacherDTO) itr2.next();
			System.out.print(t2.getId()+" ");
			System.out.print(t2.getName()+" ");
			System.out.print(t2.getDepartment()+" ");
			System.out.print(t2.getSalary()+" ");
					
			System.out.println("");
		}
		sn.close();
	}
	
	public static void orQuery()
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();	
		
		Criteria crt = sn.createCriteria(TeacherDTO.class);
		crt.add(Restrictions.or(
		Restrictions.like("department", "M%"),
		Restrictions.eq("id", 1)
		));
		
		List<?> ls2 = crt.list();
		Iterator<?> itr2 = ls2.iterator();
		TeacherDTO t2;
		System.out.println("");
		while(itr2.hasNext())
		{
			t2 = (TeacherDTO) itr2.next();
			System.out.print(t2.getId()+" ");
			System.out.print(t2.getName()+" ");
			System.out.print(t2.getDepartment()+" ");
			System.out.print(t2.getSalary()+" ");
					
			System.out.println("");
		}
		sn.close();
	}
	
	public static void main(String[] args) 
	{
		whereClause();
		andQuery();
		orQuery();

	}

}
