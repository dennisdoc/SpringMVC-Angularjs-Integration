package simple.repository;

import org.springframework.stereotype.Repository;

import simple.model.Login;

import com.mongodb.BasicDBObject;

@Repository
public class LoginRepository extends RepositoryConnection{

	public void save(Login login){
		getCollection("login").save(getMongoObject(login));
	}
	
	public BasicDBObject getMongoObject(Login login){
		BasicDBObject simpleument = new BasicDBObject();
		simpleument.put("_id", login.getLogin());
		simpleument.put("senha", login.getSenha());
		simpleument.put("email", login.getEmail());
		return simpleument;
	}
	
}
