package tablePerSubClassAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class VehicleMain 
{
	public static void main(String[] args) 
	{
		AnnotationConfiguration ac = new AnnotationConfiguration().configure();
		SessionFactory sf = ac.buildSessionFactory();
		Session sn = sf.openSession();

		TwoWheeler tw1 = new TwoWheeler();
		tw1.setVehId(8457);
		tw1.setVehName("Honda Navi");
		tw1.setSteering("handle");
		tw1.setPrice("56000");
		
		TwoWheeler tw2 = new TwoWheeler();
		tw2.setVehId(436);
		tw2.setVehName("pulsar");
		tw2.setSteering("handle");
		tw2.setPrice("80000");
		
		FourWheeler fw1 = new FourWheeler();
		fw1.setVehId(875);
		fw1.setVehName("Avanti");
		fw1.setSteering("wheel");
		fw1.setPrice(3000000);
		
		FourWheeler fw2 = new FourWheeler();
		fw2.setVehId(843);
		fw2.setVehName("Safari");
		fw2.setSteering("wheel");
		fw2.setPrice(2500000);
		
		Transaction tr = sn.beginTransaction();
		sn.save(tw1);
		sn.save(tw2);
		sn.save(fw1);
		sn.save(fw2);
		tr.commit();
		sn.close();
		
	}
	
	
}
