package hibernateTask;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateTaskMainFile 
{
	static AnnotationConfiguration ac = new AnnotationConfiguration().configure();
	static SessionFactory sf = ac.buildSessionFactory();
	
	public static void saveCatagorySubCategory()
	{
		Session sn = sf.openSession();
		
		Categories cat1 = new Categories();
		cat1.setCatID(754);
		cat1.setCatName("Electronic");
		
		Categories cat2 = new Categories();
		cat2.setCatID(755);
		cat2.setCatName("Clothes");
		
		SubCategories sbcat1 = new SubCategories();
		sbcat1.setSubCatID(501);
		sbcat1.setSubCatName("Mobiles & Accessories");
		
		SubCategories sbcat2 = new SubCategories();
		sbcat2.setSubCatID(502);
		sbcat2.setSubCatName("Computers & Accessories");
		
		SubCategories sbcat3 = new SubCategories();
		sbcat3.setSubCatID(503);
		sbcat3.setSubCatName("Mens");
		
		SubCategories sbcat4 = new SubCategories();
		sbcat4.setSubCatID(504);
		sbcat4.setSubCatName("Womens");
		
		Set<SubCategories> s1  = new HashSet<SubCategories>();
		s1.add(sbcat1);
		s1.add(sbcat2);
		
		Set<SubCategories> s2 = new HashSet<SubCategories>();
		s2.add(sbcat3);
		s2.add(sbcat4);
		
		cat1.setSubCategaries(s1);
		cat2.setSubCategaries(s2);
		
		sn.save(cat1);
		sn.save(cat2);
		
		Transaction tr = sn.beginTransaction();
		tr.commit();
		sn.close();
	}
	
	public static void saveSubCategoryProduct()
	{
		Session sn = sf.openSession();
		
		
		sn.close();
		
	}
	
	public static void main(String[] args) 
	{
		saveCatagorySubCategory();

	}

}
