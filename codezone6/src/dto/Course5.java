package dto;

public class Course5
{

private String UserName;

 
public Course5()
{
 
}
 
public Course5( String UserName)
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
return "Course5 [UserName=" + UserName + "]";
}
 
}