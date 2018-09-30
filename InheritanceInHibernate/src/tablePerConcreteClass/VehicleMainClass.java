package tablePerConcreteClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VehicleMainClass 
{
	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sn = sf.openSession();
		
		TwoWheeler tw = new TwoWheeler();
		tw.setId(11);
		tw.setName("Bike");
		tw.setLicenceNumber(74737846);
		tw.setSteeringHandle("Bike Steering Handle");
		
		TwoWheeler tw2 = new TwoWheeler();
		tw2.setId(12);
		tw2.setName("Scooty");
		tw2.setLicenceNumber(94578);
		tw2.setSteeringHandle("Scooty Steering Handle");
		
		FourWheeler fw = new FourWheeler();
		fw.setId(13);
		fw.setName("Car Steering Wheel");
		fw.setLicenceNumber(45930);
		
		FourWheeler fw2 = new FourWheeler();
		fw2.setId(14);
		fw2.setName("Van Steering Wheel");
		fw2.setLicenceNumber(453434);
		
		Transaction tr = sn.beginTransaction();
		sn.save(tw);
		sn.save(tw2);
		sn.save(fw);
		sn.save(fw2);
		
		tr.commit();
		sn.close();
		
	}
}
