package differences;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AuthenticateUser
{
	static SessionFactory sessionFactory = new Configuration().configure("DifferencesDTO.cfg.xml").buildSessionFactory(); //Load Factory
	static Session s = sessionFactory.openSession();
	public static DifferencesDTO authenticate(DifferencesDTO userDto) throws Exception
	{
		 //Create Session

		Query q = s.createQuery("from DifferencesDTO where  id = ? and name = ?");
		q.setInteger(0, userDto.getId());
		q.setString(1, userDto.getName());

		List<?> list = q.list();

		if (list.size() == 1) 
		{ 
			userDto = (DifferencesDTO) list.get(0);
			System.out.println(userDto.getId());
			System.out.println(userDto.getName());
			System.out.println(userDto.getAge());
		}
		else
		{  
			throw new Exception("invalid user");
		}
		s.close();
		return userDto;		
	}
	public static void main(String[] args) throws Exception
	{
		DifferencesDTO fd = new DifferencesDTO();
		/*fd.setId(423);
		fd.setName("RohitPatidar");
		authenticate(fd);*/
		fd.setId(54);
		fd.setName("guru");
		authenticate(fd);
		
		
	}
}
