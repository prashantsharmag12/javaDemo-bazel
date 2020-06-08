package net.javaguides.todoapp.utils;


import java.net.UnknownHostException;

import java.util.List;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class JDBCUtils {

	

	/*public static Connection getConnection() {
		
		
		MongoClient mongo = new MongoClient("localhost");
		
		
		MongoDatabase db = mongo.getDatabase("search-bar-blog");
		
		MongoCollection<Document> col = db.getCollection("posts");
		
		
		FindIterable<Document> fi = col.find();
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
		
		
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	public static Date getSQLDate(LocalDate date) {
		return java.sql.Date.valueOf(date);
	}

	public static LocalDate getUtilDate(Date sqlDate) {
		return sqlDate.toLocalDate();
	}*/
	
	public static MongoClient mongodbms()
	{
		/*MongoClient mongo = new MongoClient();
		return mongo;*/
	
		/*MongoClientURI mongoClientURI = new MongoClientURI("mongodb://peesu:peesu@cluster0-shard-00-00-ox90k.mongodb.net:27017,cluster0-shard-00-01-ox90k.mongodb.net:27017,cluster0-shard-00-02-ox90k.mongodb.net:27017/todo?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true");

      MongoClient mongoClient = new MongoClient(mongoClientURI);
   
  
      return mongoClient;*/
		
		//MongoClientURI uri = new MongoClientURI("mongodb://peesu:peesu@cluster0-ox90k.mongodb.net/todo?retryWrites=true");
		
		 //MongoClient mongoClient = new MongoClient(uri);
	//	 return mongoClient;
		
		//MongoClient mongoClient = MongoClients.create("mongodb+srv://admin:mypassword@cluster0-ox90k.mongodb.net/test?retryWrites=true");
		 
		 




MongoClientURI uri = new MongoClientURI(
    "mongodb://peesu:peesu@cluster0-shard-00-00-ha6dz.mongodb.net:27017,cluster0-shard-00-01-ha6dz.mongodb.net:27017,cluster0-shard-00-02-ha6dz.mongodb.net:27017/todo?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority");

MongoClient mongoClient = new MongoClient(uri);
MongoDatabase database = mongoClient.getDatabase("test");

//MongoDatabase database = mongoClient.getDatabase("test");


   return mongoClient;

   //MongoDatabase database = mongoClient.getDatabase("test");



    // MongoClient mongoClient = MongoClients.create(
    //"mongodb+srv://peesu:<peesu>@cluster0-0jbah.mongodb.net/test?retryWrites=true&w=majority");
    //MongoDatabase database = mongoClient.getDatabase("todos");
	
		
	}
	
	/*public static void main(String[] args)
	{
		
		System.out.println(mongodbms().getDB("todo").getCollection("users").getCount());
	}*/
	
}
