package simple.repository;

import com.mongodb.MongoClient;

public class MongoConection {
	
	private MongoClient mongoClient=new MongoClient();
	
	private static MongoConection instance=null;
	
	public static MongoConection getInstance(){
		if(instance==null){
			instance = new MongoConection();
		}
		return instance;
	}
	
	protected MongoConection(){
		
	}
	
	public MongoClient getMongoClient(){
		return mongoClient;
	}
	
}
