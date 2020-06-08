package net.javaguides.todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import net.javaguides.todoapp.model.User;
import net.javaguides.todoapp.utils.JDBCUtils;

public class UserDao {

	/*public int registerEmployee(User employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO users"
				+ "  (first_name, last_name, username, password) VALUES "
				+ " (?, ?, ?, ?);";

		int result = 0;
		
		
		
		
		System.out.println(INSERT_USERS_SQL);
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();	

		} catch (SQLException e) {
			System.out.println("in the userdao erro function");
			// process sql exception
			JDBCUtils.printSQLException(e);
		}
		return result;
	}*/
	
	
	public int registerEmployeeMongo(User Employee)
	{
		
		System.out.println("mongo db");
		MongoClient mongo = JDBCUtils.mongodbms();
		
		MongoDatabase db = mongo.getDatabase("todo");
		
		
		Document  doc1 = new Document("first_name",Employee.getFirstName()).append("last_name", Employee.getLastName())
		                           .append("username", Employee.getUsername()).append("password", Employee.getPassword());
		
		
		MongoCollection<Document> col1 = db.getCollection("users");
		
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("username", Employee.getUsername());
		
		
		System.out.println("find the query");
		FindIterable<Document> fi = col1.find(whereQuery);
		MongoCursor<Document> cursor = fi.iterator();
		
		System.out.println("got it");
		if(cursor.hasNext())
		{ 
			return 0;
		}
		
		col1.insertOne(doc1);
		
		return 1;
		
		
		
		
		
		
		
		
		
		
	}

}
