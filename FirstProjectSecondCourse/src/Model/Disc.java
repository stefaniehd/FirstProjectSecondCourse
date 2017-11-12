/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Util.Email;
import Util.FileManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author pc
 */
public class Disc {

    private String type;
    private String id;
    private String name;
    private String autor;
    private String category;
    private double price;
    private int cant;
    private FileManager fileManager;

    public Disc() {
        fileManager = new FileManager();
    }

    /**
     *
     */
    public void buy(Model.User u, int cant) {
        try {
            String purchase = fileManager.read("purchase.txt");
            purchase += u.getName() + ";" + u.getId() + ";" + u.getEmail() + ";" + this.getName() + ";" + cant + ";" + getDate()
                    +";"+this.getType()+";"+this.getCategory();
            this.fileManager.write("purchase.txt", purchase);
            updateCant(cant);
            sendEmail(u);
        } catch (Exception ex) {
        }
    }
    
    private void sendEmail(Model.User u){
        Util.Email e = new Email();
        e.setMessage("Hi " + u.getName() + "\nWe are proud of you, and we want to give you a great expirience here."
                + "\n\nSo we let you know that your purchase was succesfully\nYou bougth the disc called " + this.getName() +
                "\nHave a nice day and enjoy your new disc");
        e.setEmailtTo(u.getEmail());
        e.setSubject("New Disc");
        e.send();
    }

    private String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private void updateCant(int cant) {
        String newMusic = "";
        String[] music = fileManager.read("disc.txt").split("\n");
        for (int i = 0; i < music.length; i++) {
            String musicData[] = music[i].split(";");
            if (!(musicData[0].equals(this.getId()))) {
                newMusic += music[i];
            } else {
                musicData[musicData.length - 1] = String.valueOf(this.getCant() - cant);
                for (int j = 0; j < musicData.length; j++) {
                    newMusic += musicData[j];
                    if (j != musicData.length - 1) {
                        newMusic += ";";
                    }
                }
            }
            if (i != (music.length - 1)) {
                newMusic += "\n";
            }
        }
        fileManager.write("disc.txt", newMusic);
    }

    /**
     *
     */
    public void order(Model.User u, int cant) {
        try {
            String purchase = fileManager.read("order.txt");
            purchase += u.getName() + ";" + u.getId() + ";" + u.getEmail() + ";" + this.getName() + ";" + cant + ";" 
                    + getDate()+";"+this.getType()+";"+this.getCategory();
            this.fileManager.write("order.txt", purchase);
            updateCant(cant);
            sendEmail(u);
        } catch (Exception ex) {
        }
    }

    /**
     *
     * @return
     */
    public boolean add() {
        return true;
    }

    /**
     *
     * @return
     */
    public boolean delete() {
        return true;
    }

    /**
     *
     * @return
     */
    public boolean update() {
        return true;
    }

    /**
     *
     * @return
     */
    public LinkedList<Model.Disc> select() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

}
