package manyToMany6;

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
	static Session sn = sf.openSession();
	public static void saveSchoolCursesMain()
	{
		SchoolDTO u = new SchoolDTO();
		u.setSchoolID(456);
		u.setSchoolName("Patidar");
		
		SchoolDTO u1 = new SchoolDTO();
		u1.setSchoolID(457);
		u1.setSchoolName("SentJourge");
		
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
		u1.setcourses(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(u);
		sn.save(u1);
		
		tr.commit();
		sn.close();
	}
	
	public static void updateSchoolCursesMain()
	{
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		CoursesDTO c1 = (CoursesDTO) s2.get(CoursesDTO.class,76);
		Set ss = c1.getSchool();
		Iterator ir = ss.iterator();
		while(ir.hasNext())
		{
			SchoolDTO v1 = (SchoolDTO) ir.next();
			v1.setSchoolName("St.Taresa");
			c1.setCourseName("Art");
			
			s2.update(c1);
		}
		tr.commit();
		s2.close();
		
	}
	
	public static void main(String[] args) 
	{
		//saveSchoolCursesMain();
		updateSchoolCursesMain();

	}

}
