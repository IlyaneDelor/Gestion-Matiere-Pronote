package net.ilyane.matiere.dao;  
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import net.ilyane.matiere.models.*;  
public class UserDao {  
  
public static Connection getConnection(){  
    Connection con=null;  
    try{  

        Class.forName("com.mysql.cj.jdbc.Driver");
       
        con=DriverManager.getConnection("jdbc:mysql://localhost/gestion_matiere?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");  
    }catch(Exception e){System.out.println(e);}  
    return con;  
}  


public boolean validate(User user) throws ClassNotFoundException {
	
	boolean status = false;
	Connection con=getConnection();  
    // Step 2:Create a statement using connection object
    PreparedStatement preparedStatement;
	try {
		preparedStatement = con.prepareStatement("SELECT * FROM user WHERE username = ? and password = ?" );
	
		preparedStatement.setString(1, user.getUsername());
	    preparedStatement.setString(2, user.getPassword());

	    ResultSet rs = preparedStatement.executeQuery();
	    status = rs.next();
	    
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return status;
	
}
public int save(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"insert into user(username,password,prof,admin,name) values(?,?,?,?,?)");  
        ps.setString(1,u.getUsername());  
        ps.setString(2,u.getPassword());  
        ps.setBoolean(3,u.getProf());  
        ps.setBoolean(4,u.getAdmin());  
        ps.setString(5,u.getName());  
      
        status=ps.executeUpdate();  
        
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public int updatePassword(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update user set password=?where id=?");  
    
        ps.setString(1,u.getPassword());  
        ps.setInt(2,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
} 

public int update(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update user set username=?,password=?,prof=?,admin=?,name=? where id=?");  
        ps.setString(1,u.getUsername());  
        ps.setString(2,u.getPassword());  
        ps.setBoolean(3,u.getProf());  
        ps.setBoolean(4,u.getAdmin());  
        ps.setString(5,u.getName());  
        ps.setInt(6,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public int delete(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from user where id=?");  
        ps.setInt(1,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
public static List<User> getAllUsers(){  
    List<User> list=new ArrayList<User>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from user");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            User u=new User();  
            u.setId(rs.getInt("id"));  
            u.setUsername(rs.getString("username"));  
            u.setPassword(rs.getString("password"));  
            u.setProf(rs.getBoolean("prof"));  
            u.setAdmin(rs.getBoolean("admin"));  
            u.setName(rs.getString("name"));  
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  
public static User getUserById(int id){  
    User u=null;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from user where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new User();  
            u.setId(rs.getInt("id"));  
            u.setUsername(rs.getString("username"));  
            u.setPassword(rs.getString("password"));  
            u.setProf(rs.getBoolean("prof"));  
            u.setAdmin(rs.getBoolean("admin"));  
            u.setName(rs.getString("name"));  
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}  
}  