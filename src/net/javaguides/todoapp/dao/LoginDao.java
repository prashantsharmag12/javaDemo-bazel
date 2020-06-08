package net.javaguides.todoapp.dao;



import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import net.javaguides.todoapp.model.LoginBean;
import net.javaguides.todoapp.utils.JDBCUtils;

public class LoginDao {
	
	/*public boolean validate(LoginBean loginBean) throws SQLException, ClassNotFoundException
	{
		
		
		boolean status=false;
		
		String query;
		query="select * from users where username = ? and password = ?;";
		Class.forName("com.mysql.jdbc.Driver");
		try(Connection conn = JDBCUtils.getConnection();PreparedStatement preparedStatement = conn.prepareStatement(query))
		{
			
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());
			
			System.out.println(preparedStatement);
			
			ResultSet rs  = preparedStatement.executeQuery();
			status=rs.next();
			
			
		}
		catch (SQLException e)
		{
			JDBCUtils.printSQLException(e);
		}
		return status;
	}*/

	public boolean validateMongo(LoginBean loginBean) {
		
		
		
		MongoClient mongo = JDBCUtils.mongodbms();
		
		MongoDatabase db = mongo.getDatabase("todo");
		
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("username", loginBean.getUsername());
		whereQuery.put("password", loginBean.getPassword());
		
        MongoCollection<Document> col = db.getCollection("users");
		
		
		FindIterable<Document> fi = col.find(whereQuery);
        MongoCursor<Document> cursor = fi.iterator();
        
        if(cursor.hasNext())
        {
        	System.out.println(whereQuery);
        	System.out.println("in the hasNest fucntion ");
        	System.out.println(cursor.next().toJson());
        	return true;
        }
        
        
		
		
		
		
		return false;
	}
	
	
	/*public static void main(String[] args)
	{
		LoginDao loginDao = new LoginDao();
		
		LoginBean loginBean = new LoginBean();
		
		loginBean.setUsername("Kana");
		loginBean.setPassword("murlli");
		
		try {
			System.out.println(loginDao.validate(loginBean));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
