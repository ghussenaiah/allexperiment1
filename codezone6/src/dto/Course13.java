package dto;

public class Course13
{

private String Month;

 
public Course13()
{
 
}
 
public Course13(String Month)
{
super();

this.Month = Month;

}
 
public String getMonth()
{
return Month;
}
 
public void setMonth(String Month)
{
this.Month = Month;
}
 

 
@Override
public String toString()
{
return "Course13 [Month=" + Month + "]";
}
 
}
