package one2many10;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
		co1.setForeignEmpID(8457);
		
		EmployeeTableDTO co2 = new EmployeeTableDTO();
		co2.setEmpid(98732);
		co2.setEmpName("yogendra");
		co2.setEmpAddress("dhar");
		co2.setForeignEmpID(8457);
		
		EmployeeTableDTO col3 = new EmployeeTableDTO();
		col3.setEmpid(6684536);
		col3.setEmpName("umesh");
		col3.setEmpAddress("jhabua");
		col3.setForeignEmpID(8457);
		
		Set<EmployeeTableDTO> s = new HashSet<EmployeeTableDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setEmpID(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(u);
		tr.commit();
		
	}
	
	public static void updateDepartEmployeeMain()
	{
		EmployeeTableDTO e1 = new EmployeeTableDTO();
		e1.setEmpid(23);
		e1.setEmpName("tanmay");
		e1.setEmpAddress("indore");
		e1.setForeignEmpID(8457);
		
		Transaction tr = sn.beginTransaction();
		sn.update(e1);
		tr.commit();
		
	}
	public static void main(String[] args)
	{
		//saveDepartEmployeeMain();
		updateDepartEmployeeMain();
		sn.close();
	}

}
