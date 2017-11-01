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
public class Music extends Disc{
    
    private Model.Music oMusic;

    public Music() {
    }

    public Music(Model.Music oMusic) {
        this.oMusic = oMusic;
    }

    @Override
    public boolean add() {
        return oMusic.add();
    }

    @Override
    public boolean delete() {
        return oMusic.delete();
    }

    @Override
    public LinkedList<Model.Disc> select() {
        return oMusic.select();
    }

    @Override
    public boolean update() {
        return oMusic.update();
    }
}
