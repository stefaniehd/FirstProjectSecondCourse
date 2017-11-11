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
public class Movie extends Model.Disc {

    private final FileManager fileManager;
    private final String fileName;

    public Movie() {
        fileManager = new FileManager();
        fileName = "disc.txt";
    }

    /**
     *
     * @return
     */
    @Override
    public boolean add() {
        try {
            String movies = fileManager.read(fileName);
            if (movies.isEmpty()) {
                movies = this.getId() + ";" + this.getType() + ";" + this.getName() + ";" + this.getAutor() + ";"
                    + this.getCategory() + ";" + this.getPrice() + ";" + this.getCant();
            }else{
                movies += this.getId() + ";" + this.getType() + ";" + this.getName() + ";" + this.getAutor() + ";"
                    + this.getCategory() + ";" + this.getPrice() + ";" + this.getCant();
            }
            this.fileManager.write(fileName, movies);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public boolean delete() {
        try {
            String newMovies = "";
            String[] movies = fileManager.read(fileName).split("\n");
            for (int i = 0; i < movies.length; i++) {
                String movieData[] = movies[i].split(";");
                if (!(movieData[0].equals(this.getId()))) {
                    newMovies += movies[i];
                }
                if (i != (movies.length - 1)) {
                    newMovies += "\n";
                }
            }
            fileManager.write(fileName, newMovies);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public LinkedList<Model.Disc> select() {
        try {
            String[] movies = fileManager.read(fileName).split("\n");
            LinkedList<Model.Disc> movieList = new LinkedList<>();
            for (int i = 0; i < movies.length; i++) {
                String[] moviesData = movies[i].split(";");
                Model.Movie m = new Movie();
                if (moviesData[1].equals("movie")) {
                    m.setId(moviesData[0]);
                    m.setType(moviesData[1]);
                    m.setName(moviesData[2]);
                    m.setAutor(moviesData[3]);
                    m.setCategory(moviesData[4]);
                    m.setPrice(Double.parseDouble(moviesData[5]));
                    m.setCant(Integer.parseInt(moviesData[6]));
                    movieList.add(m);
                }
            }
            return movieList;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public boolean update() {
        try {
            String newMovies = "";
            String[] movies = fileManager.read(fileName).split("\n");
            for (int i = 0; i < movies.length; i++) {
                String movieData[] = movies[i].split(";");
                if (!(movieData[0].equals(this.getId()))) {
                    newMovies += movies[i];
                } else {
                    newMovies += this.getId() + ";" + this.getType() + ";" + this.getName() + ";" + this.getAutor() + ";"
                            + this.getCategory() + ";" + this.getPrice() + ";" + this.getCant();
                }
                if (i != (movies.length - 1)) {
                    newMovies += "\n";
                }
            }
            fileManager.write(fileName, newMovies);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
