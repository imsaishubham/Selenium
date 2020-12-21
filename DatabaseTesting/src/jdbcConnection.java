import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host="localhost";
		String port="3306";
		Connection conn=DriverManager.getConnection("jdbc:mysql://" + host +":" + port + "/Qadbt", "root", "Shubham");
		 Statement s=conn.createStatement();
		 ResultSet rs=s.executeQuery("select * from EmployeeInfo where age=24");
		 
		 while(rs.next())
		 {
			 System.out.println(rs.getString("name"));
			 
		 }
	
	}

}
