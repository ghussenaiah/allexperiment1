


	class B{  
		ThisPassedInConstructor obj;  
		  B(ThisPassedInConstructor obj){  
		    this.obj=obj;  
		    //here obj is instance of class B
		    //that can be assigned from another class ThisPassedInConstructor
		    //observe here local and instance obejetc name same that y we are 
		    //using this keyword.
		  }  
		  void display(){  
		    System.out.println(obj.data);//using data member of A4 class  
		  }  
		}  
		  
		class ThisPassedInConstructor{  
		  int data=10;  
		  ThisPassedInConstructor(){  
		   B b=new B(this);  
		   b.display();  
		  }  
		  public static void main(String args[]){  
			  ThisPassedInConstructor a=new ThisPassedInConstructor();  
		  }  
}
//We can pass the this keyword in the constructor also.
//It is useful if we have to use one object in multiple classes
