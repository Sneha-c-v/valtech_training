package com.valtech.training.day2;

public class outer {
	private int x;
	
	public Inner createInner() {
		
		return new Inner(); 
		}
      public static interface abc{
		}
	public abstract static class StaticInner implements abc{
		public void jumpby10(outer o)
		{
		o.x=o.x+10;
		System.out.println();
		}
		public abstract void jumpby100(outer o);
	}
	public class Inner  
	{
		public void printX()
		{
			System.out.println("X= "+ x );
		}
		public void increament() {
			x++;
		} 
	}
	public static void main(String[] args) {
		outer o=new outer();
		outer.Inner i= o.createInner();
		outer.Inner i1= o.createInner();
		System.out.println(i);
		System.out.println(i1);
		i1.increament();
		i.printX();
		new outer().createInner().printX();
		
		
		StaticInner si = new StaticInner() {

			@Override
			public void jumpby100(outer o) {
				// TODO Auto-generated method stub
				o.x=o.x+100;
			}
			
		};
		
	si.jumpby10(o);
	si.jumpby100(o);
	i.printX();
	
	}}


	