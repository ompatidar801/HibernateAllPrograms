package hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MobileTest {
	static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public static void saveWithoutHQL() {

		Session sn = sf.openSession();

		Mobile m1 = new Mobile();
		m1.setMobID(10029);
		m1.setCompany_Name("Samsung");
		m1.setModel_Name("A7");
		m1.setMobile_price(14999.00);

		Mobile m2 = new Mobile();
		m2.setMobID(10030);
		m2.setCompany_Name("Xiaomi");
		m2.setModel_Name("A1");
		m2.setMobile_price(13999.00);

		Mobile m3 = new Mobile();
		m3.setMobID(10031);
		m3.setCompany_Name("Xiaomi");
		m3.setModel_Name("Redmi Note 5 Pro");
		m3.setMobile_price(14999.00);

		Transaction tr = sn.beginTransaction();
		sn.save(m1);
		sn.save(m2);
		sn.save(m3);

		tr.commit();
		sn.close();
	}

	public static void saveWithHQL() {

		// perform insert operation in HQL We have to require one other
		// table(e.g.items)
		// without second table we can't perform insert operation in HQL
		Items i = new Items();
		i.setItemId(600);
		i.setItemName("PenDrive32");
		i.setItemPrice(750);

		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		sn.save(i);

		Query qry = sn.createQuery(
				"insert into Product(productId,proName,price) select i.itemId,i.itemName,i.itemPrice from Items i where i.itemId= ?");
		qry.setParameter(0, 600);
		int res = qry.executeUpdate();
		System.out.println("Command successfully executed....");
		System.out.println("Numer of records effected...," + res);

		tr.commit();
		sn.close();
	}

	public static void getAllInformation() {
		Session sn = sf.openSession();
		// HQL:get all information
		Query q = sn.createQuery("from Mobile m");
		List<?> l = q.list();
		Iterator<?> it = l.iterator();
		Object ob;
		while (it.hasNext()) {
			ob = (Object) it.next();
			Mobile mob1 = (Mobile) ob;

			/*
			 * Integer i1 = (Integer) mob1[0]; String s1 = (String) mob1[1];
			 * String s2 = (String) ob[2]; Double d1 = (Double) ob[3];
			 * System.out.println("ID:"+i1+"Company Name:"+s1+"Model Name:"
			 * +s2+"Mobile_price:"+d1);
			 */

			System.out.println(" ID: " + mob1.getMobID() + ", Company Name: " + mob1.getCompany_Name()
					+ ", Model Name: " + mob1.getModel_Name() + ", Mobile_price: " + mob1.getMobile_price());

		}
	}

	public static void updateWithHQL() {
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		Query q = sn.createQuery("update Mobile set model_Name= :mn where mobID= :mi");
		q.setParameter("mn", "A2");
		q.setParameter("mi", 10030);

		int status = q.executeUpdate();
		System.out.println(status);

		tr.commit();
		sn.close();
	}

	public static void deleteWithHQL() {
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		// specifying class name (Mobile) not tablename
		Query q = sn.createQuery("delete from Mobile where mobID= 10029");
		q.executeUpdate();
		tr.commit();
		sn.close();
	}

	public static void main(String[] args) {

		// saveWithoutHQL()
		// saveWithHQL();
		// updateWithHQL();
		deleteWithHQL();
		getAllInformation();

	}

}
