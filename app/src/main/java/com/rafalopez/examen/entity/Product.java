package com.rafalopez.examen.entity;

import java.io.Serializable;

public class Product implements Serializable, Comparable<Product> {

    private String code;
    private String  description;
    private int stock;
    private double price;

    public Product(String code, String description, int stock, double price) {
        this.code = code;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public Product() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    /** este emtod evita duplicaod, orden aopro precio, pero quedaa le prmer elemnto d ecada
     * producto, no es ideal, debria impoelntarun comaprador segun cada codigo, si poseen el
     * mismo codigo verificar esi el precio es diferentes yquedarme con el que corresponda segun
     * criterio de preciio
     *
     * @param producto the object to be compared.
     * @return
     */
    @Override
    public  int compareTo(Product producto) {

        // verifica codigo dara 0 si existe
        int existe = this.code.compareTo(producto.code);
        // ordenamiento
        if(existe !=0 ){
            return Double.compare(this.price,producto.price);
        }
        // si existe lo desecho
        return existe;
    }
    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}