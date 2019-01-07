package test;



import java.lang.reflect.Constructor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import beans.Test;

public class Client {

	
	public static void main(String args[])
	{
		
		/*
		 try{
			Class c=Class.forName("beans.Test");
			Constructor con[]=c.getDeclaredConstructors();
			con[0].setAccessible(true);
	        con[0].newInstance();
			
		}
		catch(Exception e)
		{System.out.println(e);}
		*/
		
	    	
/*	 Resource r= new  ClassPathResource("resources/spring.xml");
		BeanFactory factory=new XmlBeanFactory(r);*/
				
		ApplicationContext factory=new ClassPathXmlApplicationContext("resources/spring.xml");
		
		Object o= factory.getBean("t");
		Object o1= factory.getBean("t");
		if(o==o1)
		{
			System.out.println("same object");
			System.out.println(o);
			System.out.println(o1);
		}
		else{
			System.out.println("different object");
			System.out.println(o);
			System.out.println(o1);
		}
		Test t =(Test)o;
		
		t.hello();
		
				
	}

}
