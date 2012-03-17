package no.zsoft.faktura.repository;

import no.zsoft.faktura.domain.User;
import no.zsoft.multitenant.security.ThreadLocalContextUtil;

import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository{
	@Autowired
	SessionFactory sessionFactory;
	
	public User getUserById(Long id){
		System.err.println("In userRepository"+ThreadLocalContextUtil.getTenantId());
		SessionBuilder tenantIdentifier = sessionFactory.withOptions().tenantIdentifier(ThreadLocalContextUtil.getTenantId());
		return (User) tenantIdentifier.openSession().get(User.class, id);
	}
	
}
