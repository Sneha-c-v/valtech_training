package com.valtech.training.day2;

import com.valtech.training.spring.dividebyzeroexception;

public class Simpleinterestimpl implements Simpleinterest {
 
	private Arithmetic arithmetic;
	
	public Simpleinterestimpl(Arithmetic arithmetic) {
		this.arithmetic=arithmetic;
	}
 
	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}
 
	@Override
	public double computeInterest(int prin, int roi, int duration) {
		int result = arithmetic.mul(prin,  roi);
		result = arithmetic.mul(result, duration);
		
		try {
			return arithmetic.div(result, 100);
		} catch (dividebyzeroexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}	
	
	public static void main(String[] args) {
		Arithmetic arithmetic = new Arithmeticimpl();
		Simpleinterest si = new Simpleinterestimpl(arithmetic);
		System.out.println(si.computeInterest(200,  3, 4));
	}
 
}
 
