package many2one6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import many2one.CustomerDTO;
import many2one.VendorDTO;

public class SchoolCursesMain 
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	public static void saveSchoolCursesMain()
	{
		Session sn = sf.openSession();
		SchoolDTO u = new SchoolDTO();
		u.setSchoolID(456);
		u.setSchoolName("Patidar");
		
		CoursesDTO co1 = new CoursesDTO();
		co1.setCourseID(76);
		co1.setCourseName("Maths");
		co1.setParentObject(u);
		
		CoursesDTO co2 = new CoursesDTO();
		co2.setCourseID(735);
		co2.setCourseName("BIO");
		co2.setParentObject(u);
		
		CoursesDTO col3 = new CoursesDTO();
		col3.setCourseID(65);
		col3.setCourseName("Commerce");
		col3.setParentObject(u);
		
		Transaction tr = sn.beginTransaction();
		sn.save(co1);
		sn.save(co2);
		sn.save(col3);
		tr.commit();
		sn.close();
	}
	
	public static void updateSchoolCursesMain()
	{
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		CoursesDTO c1 = (CoursesDTO) s2.get(CoursesDTO.class,76);
		SchoolDTO v1 = c1.getParentObject();
		v1.setSchoolName("Excellence");
		c1.setCourseName("Art");
		
		s2.update(c1);
		
		tr.commit();
		s2.close();
		
	}
	
	public static void main(String[] args) 
	{
		//saveSchoolCursesMain();
		updateSchoolCursesMain();

	}

}
