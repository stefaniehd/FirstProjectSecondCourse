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
public class Movie extends Disc{
    
    private Model.Movie oMovie;

    public Movie() {
        oMovie = new Model.Movie();
    }

    public Movie(Model.Movie oMovie) {
        this.oMovie = oMovie;
    }

    @Override
    public boolean add() {
        return oMovie.add();
    }

    @Override
    public boolean delete() {
        return oMovie.delete();
    }

    @Override
    public LinkedList<Model.Disc> select() {
        return oMovie.select();
    }

    @Override
    public boolean update() {
        return oMovie.update();
    }
}
