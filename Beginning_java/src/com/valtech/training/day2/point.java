package com.valtech.training.day2;

public class point implements Distance {

	@Override
	public int calculatedistance(int a, int b) {
		// TODO Auto-generated method stub
		return   a-b;
	}
	
	public static void main(String[] args) {
		Distance d=new point();
		System.out.println(d.calculatedistance(6, 3));
	}

}
