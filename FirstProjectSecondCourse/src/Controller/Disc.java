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
public class Disc {
    
    private Model.Disc disc;
    
    public Disc() {
        disc = new Model.Disc();
    }

    public Disc(Model.Disc disc) {
        this.disc = disc;
    }
    
    public boolean add(){
        return true;
    }
    
    public boolean update(){
        return true;
    }
    
    public LinkedList<Model.Disc> select(){
        return new LinkedList<>();
    }
    
    public boolean delete(){
        return true;
    }
    
    public void buy(Model.User u, int cant){
        disc.buy(u, cant);
    }
    
    public void order(Model.User u, int cant){
        disc.order(u, cant);
    }
}
