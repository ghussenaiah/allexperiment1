
public class Default_Constructor {

	int id;  
	String name;  
	  
	void display(){System.out.println(id+" "+name);}  
	  
	public static void main(String args[]){  
		Default_Constructor s1=new Default_Constructor();  
		Default_Constructor s2=new Default_Constructor();  
	s1.display();  
	s2.display();  
}
}
//it will print int ==>0
//it will print string==>null
//those are default values