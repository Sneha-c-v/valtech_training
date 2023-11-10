package com.valtech.training.day2;

import com.valtech.training.day1.Point;

public class PointMethodimpl  implements pointmethod{

	@Override
	public Point add(Point a, Point b) {
		// TODO Auto-generated method stub
		 int x;
		 int y;
		 x=a.x+b.y;
		 y=b.x+b.y;
		Point p=new Point(x,y);
		return p;
	}

	@Override
	public Point sub(Point a, Point b) {
		// TODO Auto-generated method stub
		int x=a.x+b.y;
		int y=b.x+b.y;
		Point p=new Point(x,y);
		return p;
	}

	
	public static void main(String[] args) {
		pointmethod p=new PointMethodimpl();
		Point a=new Point(10,20);
		Point b=new Point(20,10);
		Point p1=p.add(a, b);
		System.out.println("X= "+p1.x+"Y= "+p1.y);
		Point p2=p.sub(a, b);
		System.out.println("X= "+p2.x+"Y= "+p2.y);
		System.out.println(p.distance(a, b));
	}

	@Override
	public double distance(Point a, Point b) {
		int diffx=b.x-a.x;
		int diffy=b.y-a.y;
        return Math.sqrt(diffx*diffx +diffy*diffy);
	}

}
