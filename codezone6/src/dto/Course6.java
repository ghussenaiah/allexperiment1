
package dto;

public class Course6
{

private String CategoryName;

public Course6()
{
 
}
 
public Course6(String CategoryName)
{
super();

this.CategoryName = CategoryName;

}
 

 
public String getCategoryName()
{
return CategoryName;
}
 
public void setCategoryName(String CategoryName)
{
this.CategoryName = CategoryName;
}
 

 
@Override
public String toString()
{
return "Course6 [CategoryName=" + CategoryName+ "]";
}
 
}