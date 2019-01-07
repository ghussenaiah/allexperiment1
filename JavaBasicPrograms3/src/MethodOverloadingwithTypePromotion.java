
public class MethodOverloadingwithTypePromotion {
	 void sum(int a,long b){System.out.println(a+b);}  
	  void sum(int a,int b,int c){System.out.println(a+b+c);}  
	  
	  public static void main(String args[]){  
		  MethodOverloadingwithTypePromotion obj=new MethodOverloadingwithTypePromotion();  
	  obj.sum(20,20);//now second int literal will be promoted to long  
	  obj.sum(20,20,20);
	  
	  //small values are passed through the large data type but reverse is
	  //not possible

}
}
