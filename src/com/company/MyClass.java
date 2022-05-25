package com.company;

public class MyClass {
   private int number;
   private String name = "defaultd";
   final String nationality = "russian";
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
                ", nationality='" + nationality + '\'' +
                '}';
    }
}