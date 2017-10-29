/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.LinkedList;

/**
 *
 * @author pc
 */
public class Disc {

    private String id;
    private String name;
    private String autor;
    private String category;
    private double price;
    private int cantidad;
    
    public Disc() {
    }
    
    /**
     * 
     * @return 
     */
    public boolean add(){
        return true;
    }
    
    /**
     * 
     * @return 
     */
    public boolean delete(){
        return true;
    }
    
    /**
     * 
     * @return 
     */
    public boolean update(){
        return true;
    }
    
    /**
     * 
     * @return 
     */
    public LinkedList<Model.Disc> select(){
        return new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
