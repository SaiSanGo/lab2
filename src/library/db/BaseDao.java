package library.db;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.PreparedStatement;

public class BaseDao {  
	      public  static Connection conn;
    static{	
    	try {
    	      Class.forName("com.mysql.jdbc.Driver");     //¼ÓÔØMYSQL JDBCÇý¶¯³ÌÐò   
    	      //Class.forName("org.gjt.mm.mysql.Driver");
    	     System.out.println("Success loading Mysql Driver!");
         }catch(Exception e)
         {
        	 System.out.print("Error loading Mysql Driver!");
             e.printStackTrace();
         }
    }
     public static Connection getConnection()
     {
         try{
        	 conn = DriverManager.getConnection(
        	          "jdbc:mysql://127.0.0.1:3306/library","root","6574zhang");
             
         }catch(Exception e)
         {
        	 System.out.print("get data error!");
             e.printStackTrace();
         }
         return conn;
     }
   public static void closeCon(Connection conn)
   {
       try{
           
           if(conn!=null)
           {
               conn.close();
           }
       }catch(Exception e)
       {
    	   System.out.print("get data error!");
    	      e.printStackTrace();
           
       }
   }
   public static void closeCon(PreparedStatement ps)
   {
       try{
           
           if(ps!=null)
           {
               ps.close();
           }
       }catch(Exception e)
       {
           e.printStackTrace();
           
       }
   } public static void closeRs(ResultSet rs)
   {
       try{
           
           if(rs!=null)
           {
               rs.close();
           }
       }catch(Exception e)
       {
           e.printStackTrace();   
       }
   }
}
