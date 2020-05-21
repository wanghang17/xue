package model;
 
public class User {
 
  private static String usersname;
  private String password;
  
  public User() {}
  
  public User(String usersname, String password) {
   this.usersname=usersname;
   this.password=password;
   
  }
  
  public static String getUsersname() {
   return usersname;
  }
  public void setUsersname(String usersname) {
   this.usersname = usersname;
  }
  public String getPassword() {
   return password;
  }
  public void setPassword(String password) {
   this.password = password;
  }
}
 