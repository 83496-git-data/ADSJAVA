package com.sunbeam.tester;

import org.hibernate.SessionFactory;
import static com.sunbeam.utils.HibernateUtils.getFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			System.out.println("Hibernate up n running .....");
			for(int i =1 ; i<=3;i++) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
