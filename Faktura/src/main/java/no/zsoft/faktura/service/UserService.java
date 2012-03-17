package no.zsoft.faktura.service;

import no.zsoft.faktura.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public String getUser() {
		return userRepository.getUserById(3l).getName();
	}

}
