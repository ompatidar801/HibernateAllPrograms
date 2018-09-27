package hibernateCriteria;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class OrderByAndGroupBy 
{
	public static void orderByClause() 
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		
		Criteria cr = sn.createCriteria(TeacherDTO.class);
		cr.addOrder(Order.desc("id"));
		cr.addOrder(Order.asc("name"));
		
		List<?> ls1 = cr.list();
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
	
	public static void groupByClause() 
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		
		Criteria crt = sn.createCriteria(TeacherDTO.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.count("id"));
		pl.add(Projections.groupProperty("department"));
		
		crt.setProjection(pl);
		List<?> ls2 = crt.list();
		Iterator<?> itr2 = ls2.iterator();
		Object[] ob;
		System.out.println("");
		while(itr2.hasNext())
		{
			ob = (Object[]) itr2.next();
			Integer id = (Integer) ob[0];
			String department= (String) ob[1];
			
			System.out.print("GroupsOfID:"+id+" Department:"+department);
			/*System.out.print(ob.get()+" ");
			 System.out.print(t2.getDepartment()+" ");
			System.out.print(t2.getSalary()+" ");*/
					
			System.out.println("");
		}
	
		sn.close();
	}
	
	public static void returnLowerRecordGivenIndex()
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		Criteria crt = sn.createCriteria(TeacherDTO.class);
		crt.setFirstResult(3);
		
		List<?> ls1 = crt.list();
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
	
	public static void setResults()
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		Criteria crt = sn.createCriteria(TeacherDTO.class);
		crt.setMaxResults(2);
		
		List<?> ls1 = crt.list();
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
	
	public static void main(String[] args) 
	{
		orderByClause();
		groupByClause();
		returnLowerRecordGivenIndex();
		setResults();
	}

}
