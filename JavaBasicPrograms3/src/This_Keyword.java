
public class This_Keyword {

	int id;  
    String name;  
      
    This_Keyword(int id,String name){  
    this.id = id;  
    this.name = name; 
    //if instance and local variable are different then this is not
    //required.
    }  
    void display(){System.out.println(id+" "+name);}  
    public static void main(String args[]){  
    	This_Keyword s1 = new This_Keyword(111,"Karan");  
    	This_Keyword s2 = new This_Keyword(222,"Aryan");  
    s1.display();  
    s2.display();  
}
}
