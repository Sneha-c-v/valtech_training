package com.valtech.training.day3;

public class Random {
	private static final char[]CHARACTERES="ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final String[]LEVELS= {"Beginner","Intermediate","Advanced"};
	private static final String[] EXPERIENCE= {"None","1-2yrs"};
	public static String GetRandomName() {
		Random random=new Random();
		int minLength=3;
		int maxLength=20;
		int length=random.nextInt(maxLength-minLength+1)+minLength;
		StringBuilder name=new StringBuilder();
		for (int i = 0; i < length; i++) { 
		int index=random.nextInt(CHARACTERES.length);
		name.append(CHARACTERES[index]);
			
		}
		return name.toString();
	}

	
	private int nextInt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}


	public static int GetRandomAge() {
		Random random=new Random();
		int minAge=18;
		int maxAge=100;
		return random.nextInt(maxAge-minAge+1)+minAge;
		}
	
	public static String getRandomLevel() {
		Random random=new Random();
		int index=random.nextInt(LEVELS.length);
		return LEVELS[index];
	}
	
	public static String getRandomExperience() {
		Random random=new Random();
		int index=random.nextInt(EXPERIENCE.length);
		return EXPERIENCE[index];
	}
	 public static void main(String[] args) {
		String name=GetRandomName();
		int age=GetRandomAge();
	String level=getRandomLevel();
	String experience=getRandomExperience();
	System.out.println("Name   : "+name);
	System.out.println("Age   : "+age);
	System.out.println("level   :"+level);
	System.out.println("Experience  :"+experience);
}}
