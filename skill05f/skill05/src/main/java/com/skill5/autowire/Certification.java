package com.skill5.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Certification {

    @Value("C-501")
    private String id;

    @Value("Java Full Stack Certification")
    private String name;

    @Value("2026-01-21")
    private String dateOfCompletion;

    public Certification() {}

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDateOfCompletion() { return dateOfCompletion; }

    @Override
    public String toString() {
        return "Certification{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateOfCompletion='" + dateOfCompletion + '\'' +
                '}';
    }
}
