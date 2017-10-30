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
public class User {

    private Model.User oUser;

    public User() {
    }

    public User(Model.User oUser) {
        this.oUser = oUser;
    }

    public boolean add() {
        return oUser.add();
    }

    public boolean update() {
        return oUser.update();
    }

    public LinkedList<Model.User> select() {
        return oUser.select();
    }

    public boolean delete() {
        return oUser.delete();
    }
}
