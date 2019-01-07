package dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
 
public class Database
{
public Connection getConnection() throws Exception
{
try
{
	Connection connection = null;
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
    
   connection=DriverManager.getConnection(url,"sa","Password@1");




return connection;
} catch (Exception e)
{
throw e;
}
 
}
 
}