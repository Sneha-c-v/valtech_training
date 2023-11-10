package com.valtech.training.day1;

import java.io.Serializable;

public class Point  implements Comparable<Point>,Serializable{
	public static final  Point ORIGIN=new Point();	
	static {
		ORIGIN.x=100;
		ORIGIN.y=200;
		System.out.println(ORIGIN);
	}
	 public int x;
	 public  transient int y;
	 
	 public Point() {
		 System.out.println("Point method");
	 }
	 public Point(int x,int y) {
		 System.out.println();
		 this.x=x;
		 this.y=y;
	 }
	
	 @Override
	public int hashCode() {
	// TODO Auto-generated method stub
		return toString().hashCode();
	 }
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return "X= " + x + "  Y = " + y + " Distance="+distance();
	}
	 @Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		 Point p=(Point) obj;
		 return p.x==x && p.y==y ;
		
	}
	 public double distance() {
			System.out.println("Distance in point");
			int diffx=x-ORIGIN.x;
			int diffy=y-ORIGIN.y;
			return Math.sqrt(diffx*diffx+diffy*diffy);
	 }
	 
	  public double  distance(Point other) {
		  System.out.println("distance with another  point");
		  return distance(other.x,other.y);
	  }
	 
    public double  distance( int x,int y) {
    	System.out.println("Distance in point");
    	int diffx=this.x-x;
    	int diffy=this.y-y;
		 return Math.sqrt(diffx*diffx + diffy*diffy);
	 }
	 public static void main(String[] args) {
		 Point p =new Point();
		 p.x=10;
		 p.y=10;
		 System.out.println(p.distance()); 
		 ORIGIN.x=10;
	//	 System.out.println(p.distance());
		// Point p1=new Point();
		// System.out.println(p1.distance());
		 

	}
	@Override
	public int compareTo(Point o) {
//		int res =x=o.x;
		
		return (x-o.x) == 0 ? (y-o.y): (x-o.x);
	}

} 
	