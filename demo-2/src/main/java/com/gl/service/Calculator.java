package com.gl.service;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	public int product(int a,int b)
	{
		return a*b;
	}
	
	public float product(int a,float b)
	{
		return a*b;
	}

}
