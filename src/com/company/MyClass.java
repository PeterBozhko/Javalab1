package com.company;

import java.util.Objects;

public class MyClass {
   private int number;
   private String name = "defaultd";
   public MyClass(){
   }
    public MyClass(int number, String name) {
        this.number = number;
        this.name = name;
    }
   public int getNumber() {
       return number;
   }
   public void setNumber(int number) {
       this.number = number;
   }
   public void setName(String name) {
       this.name = name;
   }
   private void printData(){
       System.out.println(number + name);
   }

    @Override
    public String toString() {
        return "MyClass{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return number == myClass.number && Objects.equals(name, myClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}