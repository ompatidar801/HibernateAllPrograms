package hibernateCriteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class CriteriaExample4 
{

	public static void main(String[] args)
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		DetachedCriteria dc1= DetachedCriteria.forClass(TeacherDTO.class);
		dc1.add(Restrictions.eq("department", "English"));
		
		Session sn1 = sf.openSession();
		List<?> lt = dc1.getExecutableCriteria(sn1).list();
		 
		Iterator<?> itr1 = lt.iterator();
		TeacherDTO t1;
		while(itr1.hasNext())
		{
			t1 = (TeacherDTO) itr1.next();
			System.out.print(t1.getId()+" ");
			System.out.print(t1.getName()+" ");
			System.out.print(t1.getDepartment()+" ");
			System.out.print(t1.getSalary()+" ");
					
			System.out.println("");
		}
		
		sn1.close();
		Session sn2 = sf.openSession();
		List<?> lt1 = dc1.getExecutableCriteria(sn2).list();
		 
		Iterator<?> itr2 = lt1.iterator();
		while(itr2.hasNext())
		{
			t1 = (TeacherDTO) itr2.next();
			System.out.print(t1.getId()+" ");
			System.out.print(t1.getName()+" ");
			System.out.print(t1.getDepartment()+" ");
			System.out.print(t1.getSalary()+" ");
					
			System.out.println("");
		}
		sn2.close();

	}

}
