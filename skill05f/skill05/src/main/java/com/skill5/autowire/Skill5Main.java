package com.skill5.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Skill5Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Student student = ctx.getBean(Student.class);

        System.out.println("=== SKILL-5: Spring Autowiring using @Autowired ===");
        System.out.println("Student bean (with injected Certification):");
        System.out.println(student);
        System.out.println();
        System.out.println("Student Details:");
        System.out.println("id      = " + student.getId());
        System.out.println("name    = " + student.getName());
        System.out.println("gender  = " + student.getGender());
        System.out.println();
        System.out.println("Certification Details (Autowired):");
        System.out.println("certId  = " + student.getCertification().getId());
        System.out.println("certName= " + student.getCertification().getName());
        System.out.println("date    = " + student.getCertification().getDateOfCompletion());
    }
}
