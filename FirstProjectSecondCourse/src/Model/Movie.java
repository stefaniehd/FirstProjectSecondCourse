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
            if (movies.length() > 0) {
                movies += "\n";
            }
            movies += this.getId() + ";" + this.getName() + ";" + this.getAutor() + ";"
                    + this.getCategory() + ";" + this.getPrice() + ";" + this.getCant()+";"+ this.getType();;
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
                    newMovies += movieData[i];
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
                m.setId(moviesData[0]);
                m.setName(moviesData[1]);
                m.setAutor(moviesData[2]);
                m.setCategory(moviesData[3]);
                m.setPrice(Integer.parseInt(moviesData[4]));
                m.setCant(Integer.parseInt(moviesData[5]));
                movieList.add(m);
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
                    newMovies += movieData[i];
                    if (i != (movies.length - 1)) {
                        newMovies += "\n";
                    }
                } else {
                    newMovies += this.getId() + ";" + this.getName() + ";" + this.getAutor() + ";"
                            + this.getCategory() + ";" + this.getPrice() + ";" + this.getCant()+";"+ this.getType();;
                }
            }
            fileManager.write(fileName, newMovies);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
