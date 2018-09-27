package one2many6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
		
		CoursesDTO co2 = new CoursesDTO();
		co2.setCourseID(735);
		co2.setCourseName("BIO");
		
		CoursesDTO col3 = new CoursesDTO();
		col3.setCourseID(65);
		col3.setCourseName("Commerce");
		
		Set<CoursesDTO> s = new HashSet<CoursesDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setcourses(s);
		
		co1.setSchool(u);
		co2.setSchool(u);
		col3.setSchool(u);
		
		Transaction tr = sn.beginTransaction();
		//sn.save(u);
		sn.save(col3);
		tr.commit();
		sn.close();
	}
	public static void updateSchoolCursesMain()
	{
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		
		//for one to many
		SchoolDTO sc = (SchoolDTO) s2.get(SchoolDTO.class, 456);
		sc.setSchoolName("Patidar");
		
		Set ss  = sc.getcourses();
		Iterator itr = ss.iterator();
		while(itr.hasNext())
		{
			CoursesDTO cs2 = (CoursesDTO) itr.next();
			cs2.setCourseName("Maths");
			s2.update(cs2);
		}
		
		//for many to one
		/*CoursesDTO c1 = (CoursesDTO) s2.get(CoursesDTO.class,76);
		SchoolDTO v1 = c1.getSchool();
		v1.setSchoolName("Excellence");
		c1.setCourseName("Art");
		
		s2.update(c1);*/
		
		tr.commit();
		s2.close();
		
	}
	
	public static void main(String[] args) 
	{
		//saveSchoolCursesMain();
		updateSchoolCursesMain();

	}


}
