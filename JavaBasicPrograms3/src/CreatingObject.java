
public class CreatingObject {

	
	
		 int rollno;  
		 String name;  
		 //above are the instance variable
		  
		 void insertRecord(int r, String n){  //method  
		  rollno=r;  
		  name=n;  
		  //here r and n are local variable
		  //if both are same use this keyword
		  //this.rollno=rollno;  
		  //this.name=name;
		 }  
		  
		 void displayInformation(){System.out.println(rollno+" "+name);}//method  
		  
		 public static void main(String args[]){  
			 CreatingObject s1=new CreatingObject();  
			 CreatingObject s2=new CreatingObject();  
		  
		  s1.insertRecord(111,"Karan");  
		  s2.insertRecord(222,"Aryan");  
		  
		  s1.displayInformation();  
		  s2.displayInformation();  
		  
		 }  
		}  

