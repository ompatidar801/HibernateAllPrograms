package oneToOne1;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DepartmentEmployee 
{
	static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public static void saveDepartmentEmployee()
	{
		Session sn = sf.openSession();
		
		Department d = new Department();
		d.setDeptID(1);
		d.setDeptName("Electrical");
		
		Department d1 = new Department();
		d1.setDeptID(2);
		d1.setDeptName("Medical");
		
		Employee emp1 = new Employee();
		emp1.setEmpid(1);
		emp1.setEmpName("Devendra");
		emp1.setEmpAddress("NandaNagar, Indore");
		emp1.setDepart(d);
		
		Employee emp2 = new Employee();
		emp2.setEmpid(2);
		emp2.setEmpName("Ravindra");
		emp2.setEmpAddress("RajendraNagar, Indore");
		emp2.setDepart(d1);
		
		Transaction tr = sn.beginTransaction();
		sn.save(emp1);
		sn.save(emp2);
		
		tr.commit();
		sn.close();
	}
	
	public static void getDepartmentEmployee()
	{
		Session sn = sf.openSession();
		
		/*Query q=sn.createQuery("from Employee");
		List l=q.list();
		Iterator it=l.iterator();
		while(it.hasNext())
		{
			Employee emp1=(Employee)it.next();
			System.out.println(emp1.getEmpid()+"..."+emp1.getEmpName()+"..."+emp1.getEmpAddress());
			
			Department dep=emp1.getDepart();
			System.out.println(dep.getDeptID()+".."+dep.getDeptName());
		}
		*/
		
		Employee e1 = (Employee) sn.get(Employee.class, 2);
		System.out.println("-----------Employee Details---------------");
		System.out.println("ID:"+e1.getEmpid());
		System.out.println("Name:"+e1.getEmpName());
		System.out.println("Address"+e1.getEmpAddress());
		System.out.println("------------------------------------------");
		  
		Department d1 = (Department) e1.getDepart();
		System.out.println("-----------Department Details---------------");
		System.out.println("ID:"+d1.getDeptID());
		System.out.println("Name:"+d1.getDeptName());
		System.out.println("------------------------------------------");
		sn.close();
	}
	
	public static void main(String[] args) 
	{
		//saveDepartmentEmployee();
		getDepartmentEmployee();
		
	}

}
