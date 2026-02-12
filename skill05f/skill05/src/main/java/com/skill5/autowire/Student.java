package com.skill5.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("S-101")
    private String id;

    @Value("Yasaswini")
    private String name;

    @Value("Female")
    private String gender;

    private final Certification certification;

    // Constructor Injection using @Autowired (required by task)
    @Autowired
    public Student(Certification certification) {
        this.certification = certification;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public Certification getCertification() { return certification; }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", certification=" + certification +
                '}';
    }
}
