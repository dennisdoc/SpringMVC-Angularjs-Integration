package simple.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

import simple.model.Login;
import simple.repository.LoginRepository;
import simple.service.LoginService;

@Named
@Component
public class LoginServiceImpl implements LoginService{
	
	@Inject
	private LoginRepository repository;
	
	@Override
	public void save(Login login) {
		repository.save(login);
	}

}
