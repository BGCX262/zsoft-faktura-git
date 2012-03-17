package no.zsoft.faktura;

import no.zsoft.faktura.domain.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from "/applicationContext.xml" and "/applicationContext-test.xml"
//in the root of the classpath
@ContextConfiguration(locations={"/data-access-config3.xml"})
public class HibernateTest {
	
//	@Autowired
//	DataSource dataSource;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Test
	public void test(){
//		Assert.assertNotNull(dataSource);
		Session session = sessionFactory.withOptions().tenantIdentifier("ims").openSession();
		
		User user=new User();
		user.setId(4L);
		user.setName("Kwwwhr");
//		hibernateTemplate.saveOrUpdate(user);
		session.save(user);
		session.flush();
		session.close();
		
	}
	
}
