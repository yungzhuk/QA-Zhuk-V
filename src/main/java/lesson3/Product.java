package lesson3;

import java.time.LocalDate;

//1. Создать класс "Товар" с полями: название, дата производства, производитель, страна происхождения, цена, состояние бронирования покупателем.
//Конструктор класса должен заполнять эти поля при создании объекта.
//Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.

public class Product {
    private String name;
    private LocalDate productionDate;
    private String producer;
    private String productionCountry;
    private int price;
    private boolean isReservedByCustomer;


    public Product(String name, LocalDate productionDate, String producer, String productionCountry, int price, boolean isReservedByCustomer) {
        this.name = name;
        this.productionDate = productionDate;
        this.producer = producer;
        this.productionCountry = productionCountry;
        this.price = price;
        this.isReservedByCustomer = isReservedByCustomer;
    }

    public String getName() {
        return name;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public String getProducer() {
        return producer;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public int getPrice() {
        return price;
    }

    public boolean isReservedByCustomer() {
        return isReservedByCustomer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setProductionCountry(String productionCountry) {
        this.productionCountry = productionCountry;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setReservedByCustomer(boolean reservedByCustomer) {
        isReservedByCustomer = reservedByCustomer;
    }

    public void getInformation() {
        System.out.println("Товар: название - " + getName() + ", дата производства - " + getProductionDate() + ", производитель - " + getProducer() + ", страна происхождения - " + getProductionCountry() + ", цена - " + getPrice() + ", состояние бронирования покупателем - " + isReservedByCustomer);
    }
}


