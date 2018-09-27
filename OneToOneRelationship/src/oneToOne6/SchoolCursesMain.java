package oneToOne6;

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
		co1.setSchool(u);
		
		CoursesDTO co2 = new CoursesDTO();
		co2.setCourseID(735);
		co2.setCourseName("BIO");
		co2.setSchool(u1);
		
		Transaction tr = sn.beginTransaction();
		sn.save(co1);
		sn.save(co2);
		
		tr.commit();
		sn.close();
	}
	
	public static void updateSchoolCursesMain()
	{
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		CoursesDTO c1 = (CoursesDTO) s2.get(CoursesDTO.class,456);
		SchoolDTO ss = c1.getSchool();
		ss.setSchoolName("St.Taresa");
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
