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
public class User {

    private String id;
    private String code;
    private String name;
    private String email;
    private String password;
    private String userName;
    private String type;
    private FileManager fileManager;
    private String fileName;

    public User() {
        fileManager = new FileManager();
        fileName = "user.txt";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean add() {
        try {
            String user = fileManager.read(fileName);
            user += this.getCode() + ";" + this.getName() + ";" + this.getCode() + ";" + this.getPassword()
                    + ";" + this.getEmail()+ ";" + this.getType() + ";" + this.getUserName();
            this.fileManager.write(fileName, user);
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
            String newUser = "";
            String[] user = fileManager.read(fileName).split("\n");
            for (int i = 0; i < user.length; i++) {
                String userData[] = user[i].split(";");
                if (!(userData[2].equals(this.getId()))) {
                    newUser += user[i];
                }
                if (i != (user.length - 1)) {
                    newUser += "\n";
                }
            }
            fileManager.write(fileName, newUser);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public LinkedList<User> select() {
        try {
            String[] user = fileManager.read(fileName).split("\n");
            LinkedList<Model.User> userList = new LinkedList<>();
            for (int i = 0; i < user.length; i++) {
                String[] userData = user[i].split(";");
                Model.User p = new User();
                p.setCode(userData[0]);
                p.setName(userData[1]);
                p.setId(userData[2]);
                p.setPassword(userData[3]);
                p.setEmail(userData[4]);
                p.setType(userData[5]);
                p.setUserName(userData[6]);
                userList.add(p);
            }
            return userList;
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
            String newUser = "";
            String[] user = fileManager.read(fileName).split("\n");
            for (int i = 0; i < user.length; i++) {
                String userData[] = user[i].split(";");
                if (!(userData[0].equals(this.getId()))) {
                    newUser += user[i];
                    if (i != (user.length - 1)) {
                        newUser += "\n";
                    }
                } else {
                    newUser +=  this.getCode() + ";" + this.getName() + ";" + this.getCode() + ";" + this.getPassword()
                    + ";" + this.getEmail()+";"+ this.getType();
                }
            }
            fileManager.write(fileName, newUser);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Model.User verifyLogin(String user, String password){
        LinkedList<Model.User> users = select();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(user)||users.get(i).getEmail().equals(user)) {
                if (users.get(i).getPassword().equals(password)) {
                    return users.get(i);
                }
            }
        }
        return null;
    }
}
