package com.valtech.training;

import java.time.LocalDate;
import java.util.Date;

public class DateSample {

	public static void main(String[] args) {
//		index the year 1900
//		index of date starts with 1 only
//		momth index start with 0
        Date date=new Date(47,7,15);
        System.out.println(date);
        LocalDate now=LocalDate.of(1947,8,15);
        System.out.println(now);
	}

}
