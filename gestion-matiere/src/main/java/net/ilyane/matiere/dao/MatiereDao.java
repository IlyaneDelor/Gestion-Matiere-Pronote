package net.ilyane.matiere.dao;  
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import net.ilyane.matiere.models.*;  
public class MatiereDao {  
  
public static Connection getConnection(){  
    Connection con=null;  
    try{  

        Class.forName("com.mysql.cj.jdbc.Driver");
       
        con=DriverManager.getConnection("jdbc:mysql://localhost/gestion_matiere?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");  
    }catch(Exception e){System.out.println(e);}  
    return con;  
}  

public int save(Matiere u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"insert into matiere(name,coef) values(?,?)");  
        ps.setString(1,u.getName());  
        ps.setInt(2,u.getCoef());  
   
        status=ps.executeUpdate();  
        
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  


public int update(Matiere u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update matiere set name=?,coef=? where id=?");  
        ps.setString(1,u.getName());  
        ps.setInt(2,u.getCoef());  
        ps.setInt(3,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public int delete(Matiere u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from matiere where id=?");  
        ps.setInt(1,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
public static List<Matiere> getAllMatieres(){  
    List<Matiere> list=new ArrayList<Matiere>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from matiere");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            Matiere u=new Matiere();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setCoef(rs.getInt("coef"));  
     
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  
public static Matiere getMatiereById(int id){  
    Matiere u=null;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from matiere where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new Matiere();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setCoef(rs.getInt("coef"));  
            
         
           
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}  
}  