package one2many7;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MobileCompanyMOdels
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	static Session sn = sf.openSession();
	public static void saveMobileCompanyMOdels()
	{
		MobileCompanyDTO u = new MobileCompanyDTO();
		u.setCompanyID(958);
		u.setComName("Xiaomi");
		
		ModelsDTO co1 = new ModelsDTO();
		co1.setModelNO(444);
		co1.setModelName("A1");
		co1.setForeignComID(958);
		
		ModelsDTO co2 = new ModelsDTO();
		co2.setModelNO(555);
		co2.setModelName("Redmi4");
		co2.setForeignComID(958);
		
		ModelsDTO col3 = new ModelsDTO();
		col3.setModelNO(666);
		col3.setModelName("MiMAX");
		col3.setForeignComID(958);
		
		Set<ModelsDTO> s = new HashSet<ModelsDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setModel(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(u);
		tr.commit();
		
	}
	public static void getMobileCompanyMOdels()
	{
		MobileCompanyDTO cst1 = (MobileCompanyDTO) sn.get(MobileCompanyDTO.class,958);
		System.out.print(cst1.getCompanyID()+" ");
		System.out.print(cst1.getComName()+" ");
		
		System.out.println("");
		
		
		ModelsDTO or1 = (ModelsDTO) sn.get(ModelsDTO.class,444);
		System.out.print(or1.getModelNO()+" ");
		System.out.print(or1.getModelName()+" ");
		System.out.print(or1.getForeignComID()+" ");
		System.out.println("");
	
		ModelsDTO or2 = (ModelsDTO) sn.get(ModelsDTO.class,666);
		System.out.print(or2.getModelNO()+" ");
		System.out.print(or2.getModelName()+" ");
		System.out.print(or2.getForeignComID()+" ");
		System.out.println("");
	}
	
	public static void main(String[] args)
	{
		//saveMobileCompanyMOdels();
		getMobileCompanyMOdels();
		sn.close();
	}

}
