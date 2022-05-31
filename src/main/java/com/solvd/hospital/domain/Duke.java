package com.solvd.hospital.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Duke {

    private String language;
    private int age;

    public Duke() {
    }

    public Duke(String language, int age) {
        this.language = language;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Duke{" +
                "language='" + language + '\'' +
                ", age=" + age +
                '}';
    }
}
