package dto;

public class Course15
{

private String UserName;

 
public Course15()
{
 
}
 
public Course15( String UserName)
{
super();

this.UserName = UserName;

}
 
public String getUserName()
{
return UserName;
}
 
public void setUserName(String UserName)
{
this.UserName = UserName;
}
 

 
@Override
public String toString()
{
return "Course15 [UserName=" + UserName + "]";
}
 
}