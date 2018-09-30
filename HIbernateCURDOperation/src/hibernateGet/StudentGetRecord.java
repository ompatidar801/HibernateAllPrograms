package hibernateGet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class StudentGetRecord {

	public static void main(String[] args) 
	{
		/*StudentGetDTO st = new StudentGetDTO();
		
		st.setStName("Parvindar");
		st.setStAddress("Amaratsar");
		st.setStAge(26);*/
		
		SessionFactory sc = new Configuration().configure("StudentGetDTO.cfg.xml").buildSessionFactory();
		Session sn = sc.openSession();
		StudentGetDTO sg = (StudentGetDTO) sn.get(StudentGetDTO.class,1);
		System.out.println(sg.getStId());
		System.out.println(sg.getStName());
		System.out.println(sg.getStAddress());
		System.out.println(sg.getStAge());
		
		StudentGetDTO sg1 = (StudentGetDTO) sn.get(StudentGetDTO.class,3);
		System.out.println(sg1.getStId());
		System.out.println(sg1.getStName());
		System.out.println(sg1.getStAddress());
		System.out.println(sg1.getStAge());
		sn.close();

	}

}
