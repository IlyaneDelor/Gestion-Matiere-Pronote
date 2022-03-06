package net.ilyane.matiere.dao;  
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import net.ilyane.matiere.models.*;  
public class DevoirDao {  
  
public static Connection getConnection(){  
    Connection con=null;  
    try{  

        Class.forName("com.mysql.cj.jdbc.Driver");
       
        con=DriverManager.getConnection("jdbc:mysql://localhost/gestion_matiere?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");  
    }catch(Exception e){System.out.println(e);}  
    return con;  
}  

public int save(Devoir u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"insert into devoir(name,note,eleve,matiere) values(?,?,?,?)");  
        ps.setString(1,u.getName());  
        ps.setInt(2,u.getNote()); 
        ps.setInt(3,u.getEleve()); 
        ps.setInt(4,u.getMatiere()); 
   
        status=ps.executeUpdate();  
        
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  


public int update(Devoir u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update devoir set name=?,note=?,eleve=?,matiere=? where id=?");  
        ps.setString(1,u.getName());  
        ps.setInt(2,u.getNote());  
        ps.setInt(3,u.getEleve());  
        ps.setInt(4,u.getMatiere());  
        
        ps.setInt(4,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public int delete(Devoir u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from devoir where id=?");  
        ps.setInt(1,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  

public static List<Devoir> getAllDevoirs(){  
    List<Devoir> list=new ArrayList<Devoir>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from devoir");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            Devoir u=new Devoir();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setNote(rs.getInt("note"));  
            u.setEleve(rs.getInt("eleve"));
            u.setMatiere(rs.getInt("matiere"));
     
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
} 

public static List<Devoir> getAllDevoirsByIdEleve(int id){  
    List<Devoir> list=new ArrayList<Devoir>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from devoir where eleve = ?");  
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            Devoir u=new Devoir();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setNote(rs.getInt("note"));  
            u.setEleve(rs.getInt("eleve"));
            u.setMatiere(rs.getInt("matiere"));
     
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
} 


public static double ViewDevoirsMoyennes(int id_eleve) throws Exception{  
	double moyenne = 0;
	int total_coef = 0;
	int temoin = 0;
	double total_mat = 0;

	try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from matiere" );  
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
        
        	
        	int coef = rs.getInt("coef");
        	
        	
          
                PreparedStatement pss=con.prepareStatement("select * from devoir where eleve = ? and matiere = ? " );  
                pss.setInt(1,id_eleve);
                pss.setInt(2,rs.getInt("id"));
                ResultSet rss=pss.executeQuery();
                
               
                while(rss.next()){
                	temoin ++;
                	
               
                	total_mat = total_mat + rss.getInt("note") ;
      
                	
                
                }
                if(temoin !=0) {
            	total_coef = total_coef + coef;
            	
                moyenne = moyenne + (total_mat/temoin)*coef;
                
          
                }
                
                temoin = 0;
                total_mat = 0;
               
                
        }
        	
        }catch(Exception e){System.out.println(e);}
	System.out.println(total_coef);
	moyenne = moyenne / total_coef;
	

	return moyenne;
}



public static Devoir getDevoirById(int id){  
    Devoir u=null;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from devoir where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new Devoir();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setNote(rs.getInt("note"));  
            u.setEleve(rs.getInt("eleve"));  
            u.setMatiere(rs.getInt("matiere")); 
            
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}  
}  