package controller;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import model.DAO;
import model.DbUtil;
import model.User;
@WebServlet(name="Regist",urlPatterns = { "/Regist.action" })
public class RegistServlet extends HttpServlet{
 
    @Override
    protected void doGet(HttpServletRequest req,
      HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
      HttpServletResponse resp) throws ServletException, IOException {
    
    
        
        String usersname=req.getParameter("usersname");
        
        String password=req.getParameter("password");
        
        DbUtil db= new DbUtil();
        User user=new User(usersname,password);
        DAO dao=new DAO();
        try {
            
            Connection con=db.getCon();
            
            if(dao.regist(con,user)) {
                resp.sendRedirect("login.jsp");
            }else {
                resp.sendRedirect("regist.jsp");
       
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}