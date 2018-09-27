package hibernateCriteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateCriteriaExa1 {

	public static void main(String[] args) 
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		Transaction trs = sn.beginTransaction();
				
		//Query qr1 = sn.createSQLQuery("select * from Teacher ").addEntity(TeacherDTO.class);		
		//Query qr1 = sn.createQuery("from TeacherDTO ");
		//List ls1 = qr1.list();
		Criteria crt = sn.createCriteria(TeacherDTO.class);

		List<?> ls1 = crt.list();
		Iterator<?> itr1 = ls1.iterator();
		TeacherDTO t1;
		while(itr1.hasNext())
		{
			t1 = (TeacherDTO) itr1.next();
			System.out.println(t1.getId()+" ");
			System.out.print(t1.getName()+" ");
			System.out.print(t1.getDepartment()+" ");
			System.out.print(t1.getSalary()+" ");
					
			System.out.println("");
		}
		trs.commit();
		sn.close();

	}

}
