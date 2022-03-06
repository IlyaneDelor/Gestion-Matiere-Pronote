package net.ilyane.matiere.dao;  
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import net.ilyane.matiere.models.*;  
public class ClassroomDao {  
  
public static Connection getConnection(){  
    Connection con=null;  
    try{  

        Class.forName("com.mysql.cj.jdbc.Driver");
       
        con=DriverManager.getConnection("jdbc:mysql://localhost/gestion_matiere?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");  
    }catch(Exception e){System.out.println(e);}  
    return con;  
}  

public int save(Classroom u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"insert into classroom(numberClass,eleve,prof,matiere) values(?,?,?,?)");  
        ps.setInt(1,u.getNumberClass());  
        ps.setString(2,u.getEleve());  
        ps.setInt(3,u.getProf());  
        ps.setInt(4,u.getMatiere());  
   
        status=ps.executeUpdate();  
        
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  


public int update(Classroom u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update classroom set numberClass=?,eleve=?,prof=?,matiere=? where id=?");  
        ps.setInt(1,u.getNumberClass());  
        ps.setString(2,u.getEleve());  
        ps.setInt(3,u.getProf());  
        ps.setInt(4,u.getMatiere());   
        ps.setInt(3,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public int delete(Classroom u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from classroom where id=?");  
        ps.setInt(1,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
public static List<Classroom> getAllClassrooms(){  
    List<Classroom> list=new ArrayList<Classroom>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from classroom");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            Classroom u=new Classroom();  
            u.setId(rs.getInt("id"));  
            u.setNumberClass(rs.getInt("numberClass"));  
            u.setEleve(rs.getString("eleve")); 
            u.setProf(rs.getInt("prof"));  
            u.setMatiere(rs.getInt("matiere"));  
            
     
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  
public static double moyenneClass(String eleve,int matiere) throws Exception{  
	double moyenne = 0;
	int temoin = 0;
	double total_eleve = 0;
	int t = 0;
	double moyenne_eleve = 0;
	
	int i ;
	
	String id_eleves[] = eleve.split(",");

	try{  
        Connection con=getConnection();  
        
        	
        		for(i =0;i<id_eleves.length;i++) {
                PreparedStatement pss=con.prepareStatement("select * from devoir where  matiere = ? AND eleve = ?" );  
                pss.setInt(1,matiere);
                pss.setInt(2,Integer.parseInt(id_eleves[i]));
                ResultSet rss=pss.executeQuery();
                
               
                while(rss.next()){
                	temoin ++;
                	
               
                	total_eleve = total_eleve + rss.getInt("note") ;
                
      
                	
                
                }
                if(temoin !=0) {
            	
            	
                moyenne_eleve = total_eleve/temoin;
            	
                moyenne = moyenne + moyenne_eleve;
                t =t +1;
          
                }
                moyenne_eleve = 0;
                total_eleve = 0;
               
                temoin = 0;
                
              
                
        }
        	
        }catch(Exception e){System.out.println(e);}

	moyenne = moyenne / t;
	

	return moyenne;
}
public static Classroom getClassroomById(int id){  
    Classroom u=null;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from classroom where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new Classroom();  
            
            u.setId(rs.getInt("id"));  
            u.setNumberClass(rs.getInt("numberClass"));  
            u.setEleve(rs.getString("eleve")); 
            u.setProf(rs.getInt("prof"));  
            u.setMatiere(rs.getInt("matiere"));  
            
            
         
           
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}  
}  