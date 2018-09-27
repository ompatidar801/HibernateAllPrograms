package one2many6;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SchoolCursesMain 
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	static Session sn = sf.openSession();
	public static void saveSchoolCursesMain()
	{
		SchoolDTO u = new SchoolDTO();
		u.setSchoolID(456);
		u.setSchoolName("Patidar");
		
		CoursesDTO co1 = new CoursesDTO();
		co1.setCourseID(76);
		co1.setCourseName("Maths");
		co1.setForeignCorID(456);
		
		CoursesDTO co2 = new CoursesDTO();
		co2.setCourseID(735);
		co2.setCourseName("BIO");
		co2.setForeignCorID(456);
		
		CoursesDTO col3 = new CoursesDTO();
		col3.setCourseID(65);
		col3.setCourseName("Commerce");
		col3.setForeignCorID(456);
		
		Set<CoursesDTO> s = new HashSet<CoursesDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setcourses(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(u);
		tr.commit();
		sn.close();
	}
	public static void main(String[] args) 
	{
		saveSchoolCursesMain();

	}

}
