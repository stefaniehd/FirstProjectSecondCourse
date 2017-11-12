/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Util.FileManager;
import java.util.LinkedList;

/**
 *
 * @author pc
 */
public class Purchase {

    private String id;
    private String purchaseNum;
    private String userName;
    private String dni;
    private String email;
    private String disc;
    private int cant;
    private String date;
    private String type;
    private String category;

    private final FileManager fileManager;
    private final String fileName;

    public Purchase() {
        fileManager = new FileManager();
        fileName = "purchase.txt";
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    public String getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(String purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getUser() {
        return userName;
    }

    public void setUser(String user) {
        this.userName = user;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public boolean add() {
        try {
            String purchase = fileManager.read(fileName);
            if (purchase.length() > 0) {
                purchase += "\n";
            }
            purchase += this.getId() + ";" + this.getUser() + ";" + this.getDisc() + ";" + this.getPurchaseNum()
                    +";"+this.getType()+";"+this.getCategory();
            this.fileManager.write(fileName, purchase);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public boolean delete() {
        try {
            String newPurchase = "";
            String[] purchase = fileManager.read(fileName).split("\n");
            for (int i = 0; i < purchase.length; i++) {
                String purchaseData[] = purchase[i].split(";");
                if (!(purchaseData[0].equals(this.getId()))) {
                    newPurchase += purchaseData[i];
                }
                if (i != (purchase.length - 1)) {
                    newPurchase += "\n";
                }
            }
            fileManager.write(fileName, newPurchase);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public LinkedList<Purchase> select() {
        try {
            String[] purchase = fileManager.read(fileName).split("\n");
            LinkedList<Model.Purchase> purchaselist = new LinkedList<>();
            for (int i = 0; i < purchase.length; i++) {
                String[] purchaseData = purchase[i].split(";");
                Model.Purchase p = new Purchase();
                p.setUserName(purchaseData[0]);
                p.setDni(purchaseData[1]);
                p.setEmail(purchaseData[2]);
                p.setDisc(purchaseData[3]);
                p.setCant(Integer.parseInt(purchaseData[4]));
                p.setDate(purchaseData[5]);
                p.setType(purchaseData[6]);
                p.setCategory(purchaseData[7]);
                purchaselist.add(p);
            }
            return purchaselist;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @return
     */
    public boolean update() {
        try {
            String newPurchase = "";
            String[] purchase = fileManager.read(fileName).split("\n");
            for (int i = 0; i < purchase.length; i++) {
                String purchaseData[] = purchase[i].split(";");
                if (!(purchaseData[0].equals(this.getId()))) {
                    newPurchase += purchaseData[i];
                    if (i != (purchase.length - 1)) {
                        newPurchase += "\n";
                    }
                } else {
                    newPurchase += this.getId() + ";" + this.getUser() + ";"
                            + this.getDisc() + ";" + this.getPurchaseNum();
                }
            }
            fileManager.write(fileName, newPurchase);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
