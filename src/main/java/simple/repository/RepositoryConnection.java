package simple.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

@Repository
public class RepositoryConnection {

	public DB getDb() {
		MongoClient mongoClient = new MongoClient();
		List<String> dbs = mongoClient.getDatabaseNames();
		for(String name : dbs){
			System.out.println(name);
		}
		return mongoClient.getDB("ballGame");
	}
	
	public DBCollection getCollection(String collection){
		return getDb().getCollection(collection);
	}
	
}
