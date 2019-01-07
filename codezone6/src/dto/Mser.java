package dto;

public class Mser {

	private int PID;
	private String ProjectName;
	private String Status;

	
	 
	public Mser()
	{
	 
	}
	 
	public Mser(int PID, String ProjectName, String Status)
	{
	super();
	this.PID = PID;
	this.ProjectName = ProjectName;
	this.Status = Status;
	
	}
	 
	public int getPID()
	{
	return PID;
	}
	 
	public void setPID(int PID)
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
	return "Mser [ PID=" + PID + ",ProjectName=" + ProjectName + ", status=" + Status+ "]";
	}
	 
	
}
