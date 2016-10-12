package library.db;
import library.model.Category;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.struts2.ServletActionContext;
import library.db.BaseDao;
public class categoryDao{
	public static List<Category> getCategory() throws Exception{
		List<Category> list=new ArrayList<Category>();
		String sql="select * from Category";
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            con=BaseDao.getConnection();
            ps=con.prepareStatement(sql);
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
                list.add(Category);
            }
       }
        finally{
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(con!=null)con.close();
        }
       return list;
       }
		
}