
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateTaskMainFile 
{
	static AnnotationConfiguration ac = new AnnotationConfiguration().configure();
	static SessionFactory sf = ac.buildSessionFactory();
	
	public static void saveProductUserdetails()
	{
		Session sn5 = sf.openSession();
		Transaction tr5 = sn5.beginTransaction();
		
		
		
		sn5.close();
	}

	public static void main(String[] args) 
	{
		//saveCatagorySubCategory();
		//saveSubCategoryBrands();
		//saveBrandsProduct();
		//saveProductProductDatails();
		saveProductUserdetails();
		
	}

}
