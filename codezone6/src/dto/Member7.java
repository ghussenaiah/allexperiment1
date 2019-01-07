package dto;

public class Member7 {

	
	private String CategoryID;
	private String CategoryName;
	private String Dt;
    private String Status;
	 
	public Member7()
	{
	 
	}
	 
	public Member7( String CategoryID, String CategoryName,String Status,String Dt)
	{
	super();
	
	this.CategoryID = CategoryID;
	this.CategoryName = CategoryName;
	this.Status=Status;
	this.Dt = Dt;
	
	}
	 
	
	public String getCategoryID()
	{
	return CategoryID;
	}
	 
	public void setCategoryID(String CategoryID)
	{
	this.CategoryID = CategoryID;
	}
	 
	public String getCategoryName()
	{
	return CategoryName;
	}
	 
	public void setCategoryName(String CategoryName)
	{
	this.CategoryName = CategoryName;
	}
	 
	public String getDt()
	{
	return Dt;
	}
	public void setDt(String Dt)
	{
	this.Dt = Dt;
	}
	 
	public void setStatus(String Status)
	{
	this.Status = Status;
	}
	public String getStatus()
	{
	return Status;
	}
	 
	
	
	 
	@Override
	public String toString()
	{
	return "Member7 [ CategoryID=" + CategoryID + ", CategoryName=" + CategoryName+", Status=" +Status+",Dt=" + Dt+"]";
	}
	 
	
}
