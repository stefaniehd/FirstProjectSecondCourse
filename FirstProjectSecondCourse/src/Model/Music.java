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
public class Music extends Disc{
    
    private LinkedList<String> songs;

    public Music() {
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean add() {
        return super.add(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean delete() {
        return super.delete(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public LinkedList<Disc> select() {
        return super.select(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean update() {
        return super.update(); //To change body of generated methods, choose Tools | Templates.
    }

    public LinkedList<String> getSongs() {
        return songs;
    }

    public void setSongs(LinkedList<String> songs) {
        this.songs = songs;
    }
}
