package hibernateCriteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class CriteriaAggregationFunctions 
{

	public static void main(String[] args) 
	{
		SessionFactory sf =  new Configuration().configure("teacherDTO.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		Transaction trs = sn.beginTransaction();
		
		/*//Query qr = sn.createSQLQuery("select count(emp_salary) from EmployeeTable");		
				/*Query qr = sn.createQuery("select count(e.id) from EmployeeDTO e");
				Query qr1 = sn.createQuery("select max(e.salary) from EmployeeDTO e");
				Query qr2 = sn.createQuery("select min(e.salary) from EmployeeDTO e");
				Query qr3 = sn.createQuery("select sum(e.salary) from EmployeeDTO e");
				Query qr4 = sn.createQuery("select avg(e.salary) from EmployeeDTO e");*/
				//Query qr5 = sn.createQuery("select count(*) from EmployeeDTO e");
				
				/*List ls = qr.list();
				System.out.println(ls.get(0));
				List ls1 = qr1.list();
				System.out.println(ls1.get(0));
				List ls2 = qr2.list();
				System.out.println(ls2.get(0));
				List ls3 = qr3.list();
				System.out.println(ls3.get(0));
				List ls4 = qr4.list();
				System.out.println(ls4.get(0));
				List ls5 = qr5.list();
				Long obj = (Long)ls5.get(0);
			
				
				System.out.println(obj);*/
				
					// Count Projection
					Criteria criteriaCount = sn.createCriteria(TeacherDTO.class);
					criteriaCount.setProjection(Projections.count("id"));
					List<?> CountList = criteriaCount.list();
					System.out.println("Count is = " + CountList.get(0));
	
		
					// Sum Projection
					Criteria criteriaSum = sn.createCriteria(TeacherDTO.class);
					criteriaSum.setProjection(Projections.sum("salary"));
					List<?> sumList = criteriaSum.list();
					System.out.println("Sum is = " + sumList.get(0));
					
					
					
					// Avg Projection
					Criteria criteriaAvg = sn.createCriteria(TeacherDTO.class);
					criteriaAvg.setProjection(Projections.avg("salary"));
					List<?> AvgList = criteriaAvg.list();
					System.out.println("Avg is = " + AvgList.get(0));
		
					// Max Projection
					Criteria criteriaMax = sn.createCriteria(TeacherDTO.class);
					criteriaMax.setProjection(Projections.max("salary"));
					List<?> maxList = criteriaMax.list();
					System.out.println("Max  is = " + maxList.get(0));

					// Min Projection
					Criteria criteriaMin = sn.createCriteria(TeacherDTO.class);
					criteriaMin.setProjection(Projections.min("id"));
					List<?> minList = criteriaMin.list();
					System.out.println("Minimum  is = " + minList.get(0));

					// rowCount Projection
					Criteria criteriaRowCount = sn.createCriteria(TeacherDTO.class);
					criteriaRowCount.setProjection(Projections.rowCount());
					List<?> rowCountList = criteriaRowCount.list();
					System.out.println("Total No of Teachers is = " + rowCountList.get(0));
					
					
		/*Iterator<?> itr2 = ls2.iterator();
		
		Object[] ob;
		System.out.println("");
		while(itr2.hasNext())
		{
			ob = (Object[]) itr2.next();
			Integer id = (Integer) ob[0];
			Long name= (Long) ob[1];
			
			System.out.print("ID:"+id+" Name:"+name);
		}*/
		
		trs.commit();
		sn.close();
	}
}
		
