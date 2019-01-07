package dto;

public class Course14
{

private String ProjectName;

 
public Course14()
{
 
}
 
public Course14( String ProjectName)
{
super();

this.ProjectName = ProjectName;

}
 
public String getProjectName()
{
return ProjectName;
}
 
public void setProjectName(String ProjectName)
{
this.ProjectName = ProjectName;
}
 

 
@Override
public String toString()
{
return "Course14[ProjectName=" + ProjectName + "]";
}
 
}