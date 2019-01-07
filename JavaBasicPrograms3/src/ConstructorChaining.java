
public class ConstructorChaining {

	
	  int id;  
	    String name;  
	    String city;  
	      
	    ConstructorChaining(int id,String name){  
	    this.id = id;  
	    this.name = name;  
	    }  
	    ConstructorChaining(int id,String name,String city){  
	    this(id,name);//now no need to initialize id and name  
	    this.city=city;  
	    }  
	    void display(){System.out.println(id+" "+name+" "+city);}  
	      
	    public static void main(String args[]){  
	    	ConstructorChaining e1 = new ConstructorChaining(111,"karan");  
	    	ConstructorChaining e2 = new ConstructorChaining(222,"Aryan","delhi");  
	    e1.display();  
	    e2.display();  
	   }  
}
