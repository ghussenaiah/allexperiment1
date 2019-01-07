package dto;

public class Mser11 {


	private String ParameterName;
	

	
	 
	public Mser11()
	{
	 
	}
	 
	public Mser11(String ParameterName)
	{
	super();
	
	this.ParameterName = ParameterName;
	
	
	}
	 
	
	 
	public String getParameterName()
	{
	return ParameterName;
	}
	 
	public void setParameterName(String ParameterName)
	{
	this.ParameterName = ParameterName;
	}
	 
	
	
	 
	@Override
	public String toString()
	{
	return "Mser11 [ProjectName=" + ParameterName + "]";
	}
	 
	
}
