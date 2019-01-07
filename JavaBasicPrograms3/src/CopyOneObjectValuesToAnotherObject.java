
public class CopyOneObjectValuesToAnotherObject {

	//using constructor only
	//but it not a copy constructor
	 int id;  
	    String name;  
	    CopyOneObjectValuesToAnotherObject(int i,String n){  
	    id = i;  
	    name = n;  
	    }  
	      
	    CopyOneObjectValuesToAnotherObject(CopyOneObjectValuesToAnotherObject s){  
	    id = s.id;  
	    name =s.name;  
	    }  
	    void display(){System.out.println(id+" "+name);}  
	   
	    public static void main(String args[]){  
	    	CopyOneObjectValuesToAnotherObject s1 = new CopyOneObjectValuesToAnotherObject(111,"Karan");  
	    	CopyOneObjectValuesToAnotherObject s2 = new CopyOneObjectValuesToAnotherObject(s1);  
	    s1.display();  
	    s2.display();  
	   }  
}
