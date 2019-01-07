package dto;

public class Manager {

	private String PID;
	private String ProjectName;
	private String Username;
	private String CategoryID;
	private String Status;

	
	 
	public  Manager()
	{
	 
	}
	 
	public  Manager(String PID,String ProjectName,String Username, String CategoryID,String Status)
	{
	super();
	
	this.PID = PID;
	this.ProjectName = ProjectName;
	this.Username = Username;
	this.CategoryID = CategoryID;
	this.Status = Status;
	
	}
	 
	public String getPID()
	{
	return PID;
	}
	 
	public void setPID(String PID)
	{
	this.PID =PID;
	}
	 
	public String getProjectName()
	{
	return ProjectName;
	}
	 
	public void setProjectName(String ProjectName)
	{
	this.ProjectName = ProjectName;
	}
	 
	public String getUsername()
	{
	return Username;
	}
	 
	public void setUsername(String Username)
	{
	this.Username = Username;
	}
	 
	
	public String getCategoryID()
	{
	return CategoryID;
	}
	 
	public void setCategoryID(String CategoryID)
	{
	this.CategoryID = CategoryID;
	}
	
	public String getStatus()
	{
	return Status;
	}
	 
	public void setStatus(String Status)
	{
	this.Status = Status;
	}
	 
	
	 
	@Override
	public String toString()
	{
	return " Manager [ PID=" + PID + ",ProjectName=" + ProjectName + ", Username=" + Username+", CategoryID=" +CategoryID+ ", Status=" + Status+  "]";
	}
	 
	
}
