package library.action;
import java.sql.Connection;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import library.db.BaseDao;
import library.model.Category;
import library.model.Author;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class categoryAction  extends ActionSupport{
	String Isbn;
	
	public String getIsbn() {
		return Isbn;
	}

	public void setIsbn(String Isbn) {
		this.Isbn = Isbn;
	}

	@SuppressWarnings("resource")
	public  String SearchBook() throws Exception{
		List<Category> Categorylist=new ArrayList<Category>();
		String name=ServletActionContext.getRequest().getParameter("name");
		String sql="select * from Author where Name="+"'"+name+"'";
		String Ai ="";
       	HttpSession session = ServletActionContext.getRequest().getSession();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            con=BaseDao.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
            	Author Author=new Author();
            	Ai=rs.getString("AuthorID");
            	Author.setAge(rs.getInt("Age"));
            	Author.setAuthorID(rs.getString("AuthorID"));
            	Author.setCountry(rs.getString("Country"));
            	Author.setName(rs.getString("Name"));
  
	            session.setAttribute("Author", Author);
            }
            
            else{
            	return "faild";
            }
            try{
	            ps=con.prepareStatement("select * from Category where AuthorID="+"'"+Ai+"'");
	            rs=ps.executeQuery();
	            while(rs.next())
	            {
	            	Category Category=new Category();
	                Category.setIsbn(rs.getString("Isbn"));
	                Category.setTitle(rs.getString("Title"));
	                Category.setAuthorID(rs.getString("AuthorID"));
	                Category.setPublisher(rs.getString("Publisher"));
	                Category.setPublishDate(rs.getString("PublishDate"));
	                Category.setPrice(rs.getFloat("Price"));
	                Categorylist.add(Category);
	            }
	            session.setAttribute("Categorylist", Categorylist); 
	            return "success";
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        finally{
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(con!=null)con.close();
        }
        return "error";
	}
	@SuppressWarnings("resource")
	public  String showBook() throws Exception{
		
		String sql="select * from Category where Isbn="+"'"+Isbn+"'";
		String Ai ="";
       	HttpSession session = ServletActionContext.getRequest().getSession();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Category> Categorylist=new ArrayList<Category>();
        try{
            con=BaseDao.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
	            while(rs.next())
	            {
	            	Ai=rs.getString("AuthorID");
	            	Category Category=new Category();
	                Category.setIsbn(rs.getString("Isbn"));
	                Category.setTitle(rs.getString("Title"));
	                Category.setAuthorID(rs.getString("AuthorID"));
	                Category.setPublisher(rs.getString("Publisher"));
	                Category.setPublishDate(rs.getString("PublishDate"));
	                Category.setPrice(rs.getFloat("Price"));
	                Categorylist.add(Category);
	            }
	            session.setAttribute("Categorylist", Categorylist); 
	            System.out.println("AuthorID: "+Ai);
	            try{
	            ps=con.prepareStatement("select * from Author where AuthorID="+"'"+Ai+"'");
	            rs=ps.executeQuery();
	            while(rs.next()){
	            	Author Author=new Author();
	            	Author.setAge(rs.getInt("Age"));
	            	Author.setAuthorID(rs.getString("AuthorID"));
	            	Author.setCountry(rs.getString("Country"));
	            	Author.setName(rs.getString("Name"));
		            session.setAttribute("Author", Author);
	            }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        finally{
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(con!=null)con.close();
        }
        return "success";
	}

	public String delCategory() throws SQLException
{
		 Connection con=null;
	     Statement ps=null;
	     ResultSet rs=null;
		try
    	{
			con=BaseDao.getConnection();
			ps=con.createStatement();
			System.out.println("Isbn: " + Isbn);
    		ps.executeUpdate("delete from Category where Isbn ="+Isbn);
    		
    	}
		catch(Exception e)
        {
            e.printStackTrace();
        }
    	finally
    	{
    		 if(rs!=null) rs.close();
             if(ps!=null) ps.close();	
    	}
		return SUCCESS;
	}
}

