package com.zhmaka.model;

public class Car {
   private String manufacturer;
   private String engine;
   private String color;
   private int count;
   private int price;

   public Car car = new Car();
   public Car(){
       this.manufacturer = manufacturer;
       this.engine = engine;
       this.color = color;
       this.count = 1;
       this.price = (int) (Math.random() * 100);

   }



    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
