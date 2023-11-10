package com.valtech.training.day1;

import java.io.Serializable;

public class Point3D extends Point implements Serializable {
	public static final  Point3D ORIGIN=new Point3D();
	private  transient int z;
	
	public Point3D()
	{}
	
	public Point3D(int x,int y,int z) {
		super(x,y);
		System.out.println ("in act of point 3d");
		this.z=z;
		
	}
	@Override
	public boolean equals(Object obj) {
		
		 Point3D p=(Point3D) obj;
		 return p.x==x && p.y==y  && p.z==z;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "X="+x+" Y="+y+" Z="+z+"";
	}
	public double distance(Point3D p) {
		return distance(p.x,p.y,p.z);
	}
	public double distance(int x,int y,int z) {
		int diffx=this.x-x;
		int diffy=this.y-y;
		int diffz=this.y-y;
		return Math.sqrt(diffx*diffx + diffy*diffy+ diffz*diffz);
	}
	@Override
	public double distance() {
		System.out.println("point 3d distance");
		return Math.sqrt(x*x + y*y +z*z);
	}
	
	public static void main(String[] args) {
		ORIGIN.x=30;
	    System.out.println(Point.ORIGIN.distance());
	    System.out.println(ORIGIN.distance());
		//Point p=new Point3D();
		Point3D p=new Point3D(20,20,30);
		p.distance();
		p=new Point3D();
		p.distance();
	}
	}


