package dto;

public class ProjectName
{
private int PID;
private String ProjectName;

 
public ProjectName()
{
 
}
 
public ProjectName(int PID, String ProjectName)
{
super();
this.PID = PID;
this.ProjectName = ProjectName;

}
 
public int getPID()
{
return PID;
}
 
public void setPID(int PID)
{
this.PID = PID;
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
return "ProjectName [PID=" + PID+ ", ProjectName=" + ProjectName + "]";
}
 
}