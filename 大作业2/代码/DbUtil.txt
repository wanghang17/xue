package model;
 
import java.sql.Connection;
import java.sql.DriverManager;
 
public class DbUtil {
    
   
 
    private String dbUrl="jdbc:mysql://localhost:3306/mydatabase2?serverTimezone=UTC";
 
 
    private String dbUsername="wang";
    private String dbPassword="123456789";  
 
 
 
 
    private String jdbcName="com.mysql.cj.jdbc.Driver"; 
    public Connection getCon() throws Exception{
        Class.forName(jdbcName);
        Connection con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        return con;
    }
    
   
    public void closeCon(Connection con) throws Exception{
        if(con!=null){
            con.close();
        }
    }
    
    
    
    public static void main(String[] args) {
        DbUtil dbUtil=new DbUtil();
        try {
            dbUtil.getCon();
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}