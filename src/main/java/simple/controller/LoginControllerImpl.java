package simple.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import simple.model.Login;
import simple.service.LoginService;

@Controller
@RequestMapping(value="/api/login/")
public class LoginControllerImpl implements LoginController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5062207111413894697L;
	
	@Inject
	private LoginService service;
	
	@Override
	@RequestMapping(value="/novo", method = RequestMethod.POST,consumes={"application/xml", "application/json"})
	@ResponseStatus(value = HttpStatus.OK)
	public void save(@RequestBody String loginConteudo){
		Login login = new Login();
		JSONObject json= null;
		try {
			login = new ObjectMapper().readValue(loginConteudo, Login.class);
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}
		
		service.save(login);
	}
	
}
