
public class CopyOneObjectValuesToAnotherObject1 {

	//here we copy the values but not using the constructor 
	 int id;  
	    String name;  
	    CopyOneObjectValuesToAnotherObject1(int i,String n){  
	    id = i;  
	    name = n;  
	    }  
	    CopyOneObjectValuesToAnotherObject1(){}  
	    void display(){System.out.println(id+" "+name);}  
	   
	    public static void main(String args[]){  
	    	CopyOneObjectValuesToAnotherObject1 s1 = new CopyOneObjectValuesToAnotherObject1(111,"Karan");  
	    	CopyOneObjectValuesToAnotherObject1 s2 = new CopyOneObjectValuesToAnotherObject1();  
	    s2.id=s1.id;  
	    s2.name=s1.name;  
	    s1.display();  
	    s2.display();  
	   }  
}
//Does constructor return any value?

//Ans:yes, that is current class instance 
//(You cannot use return type yet it returns a value).

