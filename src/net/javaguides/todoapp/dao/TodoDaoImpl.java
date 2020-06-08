package net.javaguides.todoapp.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import net.javaguides.todoapp.model.LoginBean;
import net.javaguides.todoapp.model.Todo;
import net.javaguides.todoapp.utils.JDBCUtils;

public class TodoDaoImpl implements TodoDao{

	
	
	private String INSERT_TODO_SQL = "insert into todos"+" (title, username , description , target_date,is_done ) values "+ 
	" ( ?, ?, ?, ?,?);";
	
	private String SELECT_TODO_BY_ID = "select id,title,username,description,target_date,is_done from todos where id = ?;";
	
	private String SELECT_ALL_TODOS = "select * from todos where username=?";
	
	private String DELETE_TODO_BY_ID = "delete from todos where id = ?;";
	
	private String UPDATE_TODO = "update todos set title=?,username=?,description=?,target_date=?,is_done=? where id=?;";
	
	public TodoDaoImpl() {
		
	}
	/*@Override
	public void insertTodo(Todo todo) {
	
		System.out.println(INSERT_TODO_SQL);
		
		
		try (Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TODO_SQL);) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getUsername());
            preparedStatement.setString(3, todo.getDescription());
            preparedStatement.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate()));
            preparedStatement.setBoolean(5, todo.getStatus());
            System.out.println("checking the status");
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
		
		
		
	}

	@Override
	public Todo selectTodo(long todoId) {
		
		Todo todo = null;
		
		try(Connection conn = JDBCUtils.getConnection();PreparedStatement preparedStatement = conn.prepareStatement(SELECT_TODO_BY_ID);)
		{
			preparedStatement.setLong(1, todoId);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				long id = rs.getLong("id");
                String title = rs.getString("title");
                String username = rs.getString("username");
                String description = rs.getString("description");
                LocalDate targetDate = rs.getDate("target_date").toLocalDate();
                boolean isDone = rs.getBoolean("is_done");
                todo = new Todo(id, title, username, description, targetDate, isDone);
				
			}
			
		
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return todo;
	}

	@Override
	public List<Todo> selectAllTodos(LoginBean login) {
		
		
		
		List < Todo > todos = new ArrayList < > ();
		
		try(Connection conn = JDBCUtils.getConnection();PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_TODOS);){
			
			preparedStatement.setString(1,login.getUsername());
			System.out.println(SELECT_ALL_TODOS);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
                long id = rs.getLong("id");
                String title = rs.getString("title");
                String username = rs.getString("username");
                String description = rs.getString("description");
                LocalDate targetDate = rs.getDate("target_date").toLocalDate();
                boolean isDone = rs.getBoolean("is_done");
                todos.add(new Todo(id, title, username, description, targetDate, isDone));
            }
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return todos;
	}

	@Override
	public boolean deleteTodo(long id) {
		
		
		
		boolean rowDeleted=false;
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_TODO_BY_ID);) {
            statement.setLong(1, id);
            try {
				rowDeleted = statement.executeUpdate() > 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return rowDeleted;
		
		
		
	}
	@Override
	public boolean updateTodo(Todo todo) {
		boolean rowUpdated=false;
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_TODO);) {
            statement.setString(1, todo.getTitle());
            statement.setString(2, todo.getUsername());
            statement.setString(3, todo.getDescription());
            statement.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate()));
            statement.setBoolean(5, todo.getStatus());
            statement.setLong(6, todo.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
			
			e.printStackTrace();
		}
        return rowUpdated;
	}*/
	@Override
	public void insertTodoMongo(Todo newTodo) {
		
		System.out.println("in the insert mongo db");
        MongoClient mongo = JDBCUtils.mongodbms();
		
		MongoDatabase db = mongo.getDatabase("todo");
		
		//java.util.Date date = Date.from(newTodo.getTargetDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Document  doc1 = new Document("description",newTodo.getDescription()).append("is_done", newTodo.getStatus())
                .append("username", newTodo.getUsername()).append("target",  newTodo.getTargetDate())
                .append("title", newTodo.getTitle());
		
		System.out.println(doc1);
		
		MongoCollection<Document> col1 = db.getCollection("todos");
		
		col1.insertOne(doc1);
		
		
		
	}
	@Override
	public Todo selectTodoMongo(String id) {
		
		
		System.out.println("in the selcted todo mongo");
        MongoClient mongo = JDBCUtils.mongodbms();
		
		MongoDatabase db = mongo.getDatabase("todo");
		
		
		BasicDBObject query = new BasicDBObject();
		query.put("_id",new ObjectId(id) );
		
		MongoCollection<Document> collection = db.getCollection("todos");
		
		FindIterable<Document> fi = collection.find(query);
		
		MongoCursor<Document> cursor = fi.iterator();
		
		while(cursor.hasNext())
		{
			Document doc = cursor.next();
			String date =doc.get("target").toString();
			boolean value =false;
			
			String boolval = doc.get("is_done").toString();
			
			if(boolval.equals("true"))
			{
				value=true;
			}
			
			
			String title = doc.get("title").toString();
			
			String description = doc.get("description").toString();
			
			String username = doc.get("username").toString();
			
			String idd = doc.get("_id").toString();
			
			System.out.println(id + " &&  "+idd);
			System.out.println(title);
			
			Todo newTodo = new Todo(idd,title,username,description,date,value);
			return newTodo;
			
		}
		
		
		return null;
	}
	@Override
	public List<Todo> selectAllTodosMongo(LoginBean login) {
		
		  MongoClient mongo = JDBCUtils.mongodbms();
			
		MongoDatabase db = mongo.getDatabase("todo");
		
		//MongoCollection<Document> col1 = db.getCollection("todos");
		
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("username", login.getUsername());
		
		
		MongoCollection<Document> collection =  db.getCollection("todos");
		
		FindIterable<Document> fi = collection.find(whereQuery);
		
		MongoCursor<Document> cursor = fi.iterator();
		
		List < Todo > todos = new ArrayList < > ();
		
		//FindIterable<Document> cursor = fi.iterator();
		//DBObject dbo = collection.findOne();
		
		System.out.println("in the list mongo");
		while(cursor.hasNext())
		{
			
			System.out.println(" in the has next function ");
			Document doc = cursor.next();
			
			
			
			String date =doc.get("target").toString();
			boolean value =false;
		
			String boolval = doc.get("is_done").toString();
			//System.out.println(boolval);
			if(boolval.equals("true"))
			{
				value=true;
			}
			//System.out.println(value);
			
			String title = doc.get("title").toString();
			//System.out.println(title);
			String description = doc.get("description").toString();
			//System.out.println(description);
			String username = doc.get("username").toString();
			//System.out.println(username);
			String id = doc.get("_id").toString();
			//System.out.println(id);
			
			
			
			
			Todo newTodo = new Todo(id,title,username,description,date,value);
			
		    todos.add(newTodo);
			
			
		}
		
		
		return todos;
	}
	@Override
	public boolean deleteTodoMongo(String id) {
		
		boolean deleted = false;
		
		System.out.println("in the deleted todo mongo");
        MongoClient mongo = JDBCUtils.mongodbms();
		
		MongoDatabase db = mongo.getDatabase("todo");
		
		
		BasicDBObject query = new BasicDBObject();
		query.put("_id",new ObjectId(id) );
		
		MongoCollection<Document> collection = db.getCollection("todos");
		
		DeleteResult result = collection.deleteOne(query);
		
		
		if(result.getDeletedCount()==1)
			return true;
		
		
		
		return deleted;
	}
	@Override
	public boolean updateTodoMongo(Todo todo) {
		
		
		System.out.println("in the updated function mongo");
		
		BasicDBObject query = new BasicDBObject();
		//query.put("_id", todo.getId()); // (1)

		Todo prev = selectTodoMongo(todo.getId());
		query.put("_id", new ObjectId(prev.getId())); 
		query.put("title", prev.getTitle()); 
		query.put("description", prev.getDescription()); 
		query.put("target", prev.getTargetDate().toString()); 
		query.put("username", prev.getUsername().toString());
		query.put("is_done", prev.getStatus()); 
		
		BasicDBObject newDocument = new BasicDBObject(); 
		newDocument.put("title", todo.getTitle()); 
		newDocument.put("description", todo.getDescription()); 
		newDocument.put("target", todo.getTargetDate().toString()); 
		newDocument.put("username", todo.getUsername().toString());
		newDocument.put("is_done", todo.getStatus()); 

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument); // (3)
		
		MongoClient mongo =JDBCUtils.mongodbms();
		MongoDatabase db = mongo.getDatabase("todo");
		
		System.out.println("updated document is "+newDocument);
		System.out.println("previous document is "+query);
		UpdateResult b = db.getCollection("todos").updateOne(query, updateObject);
		
		System.out.println(b);
		
		return true;
	}

	
}
