package Tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.PublicSchool;

public class Tester {
     
	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean_config.xml")) {
		PublicSchool ps = ctx.getBean("publicSchool", PublicSchool.class);
		  ps.manageAcademics();	
		  PublicSchool ps1 = ctx.getBean("publicSchool", PublicSchool.class);
		  ps1.manageAcademics();
		  System.out.println(ps.equals(ps1)+" "+ ps.getClass()+" "+ps.hashCode()+" "+ps1.getClass()+" "+ps1.hashCode());
		  System.out.println(ps==ps1);
		  System.out.println("-----------------------------------------------------------------------------------------");
		  ps.getCoachTeacher().getDailyWorkout();
		  ps1.getCoachTeacher().getDailyWorkout();
		  System.out.println(ps.getCoachTeacher().equals(ps1.getCoachTeacher())+" "+ ps.getCoachTeacher().getClass()+" "+ps.getCoachTeacher().hashCode()+" "+ps1.getCoachTeacher().getClass()+" "+ps1.getCoachTeacher().hashCode());
		  System.out.println(ps.getCoachTeacher()==ps1.getCoachTeacher());
		}
	}
}
