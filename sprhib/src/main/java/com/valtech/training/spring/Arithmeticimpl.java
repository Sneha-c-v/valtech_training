package com.valtech.training.spring;

public   class Arithmeticimpl implements Arithmetic1 {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		return a*b;
	}

	@Override
	public int div(int a, int b) throws dividebyzeroexception {
		if (b==0) {
			throw new dividebyzeroexception("zero cannot  be used as denominator");
		}
		return a/b;
	}
	public static void main(String[] args) {
		Arithmetic1 a=new Arithmeticimpl();
		System.out.println(a.add(2, 3));
		System.out.println(a.sub(2, 3));
		System.out.println(a.mul(2, 3));
		try {
			System.out.println(a.div(2, 0));
		} catch (dividebyzeroexception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("seen always");
		}
	}

}
