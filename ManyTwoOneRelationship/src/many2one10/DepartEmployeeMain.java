package many2one10;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import many2one6.CoursesDTO;
import many2one6.SchoolDTO;

public class DepartEmployeeMain 
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	static Session sn = sf.openSession();
	public static void saveDepartEmployeeMain()
	{
		DepartmentsDTO u = new DepartmentsDTO();
		u.setDeptID(8457);
		u.setDeptName("Medical");
		
		EmployeeTableDTO co1 = new EmployeeTableDTO();
		co1.setEmpid(23);
		co1.setEmpName("ravi");
		co1.setEmpAddress("indore");
		co1.setParentObject(u);
		
		EmployeeTableDTO co2 = new EmployeeTableDTO();
		co2.setEmpid(98732);
		co2.setEmpName("yogendra");
		co2.setEmpAddress("dhar");
		co2.setParentObject(u);
		
		EmployeeTableDTO col3 = new EmployeeTableDTO();
		col3.setEmpid(6684536);
		col3.setEmpName("umesh");
		col3.setEmpAddress("jhabua");
		col3.setParentObject(u);
		
		Transaction tr = sn.beginTransaction();
		sn.save(co1);
		sn.save(co2);
		sn.save(col3);
		tr.commit();
		
	}
	
	public static void updateDepartEmployeeMain()
	{
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		EmployeeTableDTO c1 = (EmployeeTableDTO) s2.get(EmployeeTableDTO.class,23);
		DepartmentsDTO v1 = c1.getParentObject();
		v1.setDeptName("Electric");
		c1.setEmpName("Anay");
		c1.setEmpAddress("Goa");
		s2.update(c1);
		
		tr.commit();
		s2.close();
		
	}
	public static void main(String[] args)
	{
		//saveDepartEmployeeMain();
		updateDepartEmployeeMain();
		sn.close();
	}

}
