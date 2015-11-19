package simple.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

@Repository
public class RepositoryConnection {
	
	private static RepositoryConnection instance=null;
	
	private MongoConection connection = MongoConection.getInstance();
	
	protected RepositoryConnection(){
		
	}
	
	public static RepositoryConnection construct(){
		if(instance==null){
			instance= new RepositoryConnection();
		}
		return instance;
	}
	
	public DB getDb() {
		List<String> dbs = connection.getMongoClient().getDatabaseNames();
		for(String name : dbs){
			System.out.println(name);
		}
		return connection.getMongoClient().getDB("ballGame");
	}
	
	public DBCollection getCollection(String collection){
		return getDb().getCollection(collection);
	}
	
}
