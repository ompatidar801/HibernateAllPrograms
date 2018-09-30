package hibernateCriteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class CriteriaProjections {

	public static void main(String[] args) 
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		Transaction trs = sn.beginTransaction();
				
		//Query qr1 = sn.createSQLQuery("select emp_id from Teacher");		
		Query qr1 = sn.createQuery("select t.name from TeacherDTO t");
		List<?> ls1 = qr1.list();
		
		Iterator<?> itr1 = ls1.iterator();
		System.out.println("");
	
		
		while(itr1.hasNext())
		{
			String name = (String) itr1.next();
			
			/*ob[0];
			String name =(String) ob[1];
			/*String department =(String) ob[2];
			Float salary = (Float) ob[3];*/
			System.out.println(" Name:"+name+" ");
			
			System.out.println("");
		}
		
		Criteria crt = sn.createCriteria(TeacherDTO.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("id"));
		pl.add(Projections.property("name"));
		
		crt.setProjection(pl);
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
			/*System.out.print(ob.get()+" ");
			 System.out.print(t2.getDepartment()+" ");
			System.out.print(t2.getSalary()+" ");*/
					
			System.out.println("");
		}
		trs.commit();
		sn.close();

	}

}
