package simple.service;

import java.io.Serializable;

import simple.model.Login;

public interface LoginService extends Serializable{

	public void save(Login login);

}
