package model;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
 
 
public class DAO {
   
    public User login(Connection con,User user) throws Exception{
        User resultUser=null;
        String sql="select * from users where usersname=? and password=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, user.getUsersname());
        pstmt.setString(2, user.getPassword());
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            resultUser=new User();
            resultUser.setUsersname(rs.getString("usersname"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }
    
  
    public boolean regist(Connection con,User user) throws Exception{
        boolean flag=false;
        PreparedStatement pstmt = null;
        String sql="INSERT INTO user(userame,password)VALUES(?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUsersname());
        pstmt.setString(2, user.getPassword());
        if (pstmt.executeUpdate() > 0) {
            flag = true;
        }
        return flag;
    }
 
}