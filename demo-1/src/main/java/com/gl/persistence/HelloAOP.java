package com.gl.persistence;

import org.springframework.stereotype.Component;

@Component
public class HelloAOP {
	
	public void printMessage(String name)
	{
		System.out.println("Hello "+name);
	}

	public void printFibonacci()
	{
		int no1=0;
		int no2=1;
		System.out.print(no1+" ");
		while(no2<=100)
		{
			System.out.print(no2+" ");
			no1=no2+no1;
			no2=no1-no2;
		}
	}
}
