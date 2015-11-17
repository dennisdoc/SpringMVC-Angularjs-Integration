package simple.util;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class MongoProjection {
	
	public static DBObject projection(List<String>campos){
		BasicDBObject simpleument = new BasicDBObject();
		for(int i=0;i<campos.size();i++){
			simpleument.put(campos.get(i), 0);
		}
		return simpleument;
	}
	
	public static DBObject projection(String campo){
		BasicDBObject simpleument = new BasicDBObject();
		simpleument.put(campo, 0);
		return simpleument;
	}
	
}
