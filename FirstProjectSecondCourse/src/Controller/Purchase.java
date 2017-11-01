/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.LinkedList;

/**
 *
 * @author pc
 */
public class Purchase {
    
      
    private Model.Purchase oPurchase;
    
    public Purchase() {
    }

    public Purchase(Model.Purchase oPurchase) {
        this.oPurchase = oPurchase;
    }
    
    
    public boolean add(){
        return  oPurchase.add();
    }
    
    public boolean update(){
        return  oPurchase.update();
    }
    
    public LinkedList<Model.Purchase> select(){
        return  oPurchase.select();
    }
    
    public boolean delete(){
        return oPurchase.delete();
    }
}
