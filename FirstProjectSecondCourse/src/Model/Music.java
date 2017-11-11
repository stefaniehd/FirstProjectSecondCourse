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
public class Music extends Model.Disc {

    private final FileManager fileManager;
    private final String fileName;
    private LinkedList<String> song;

    public Music() {
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
            String music = fileManager.read(fileName);
            music += this.getId() + ";" + this.getType() + ";" + this.getName() + ";" + this.getAutor() + ";"
                    + this.getCategory() + ";" + this.getPrice() + ";" + getSongList(song) + ";" + this.getCant();
            ;
            this.fileManager.write(fileName, music);
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
            String newMusic = "";
            String[] music = fileManager.read(fileName).split("\n");
            for (int i = 0; i < music.length; i++) {
                String musicData[] = music[i].split(";");
                if (!(musicData[0].equals(this.getId()))) {
                    newMusic += music[i];
                }
                if (i != (music.length - 1)) {
                    newMusic += "\n";
                }
            }
            fileManager.write(fileName, newMusic);
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
    public LinkedList<Disc> select() {
        try {
            String[] music = fileManager.read(fileName).split("\n");
            LinkedList<Model.Disc> movieList = new LinkedList<>();
            for (int i = 0; i < music.length; i++) {
                String[] musicData = music[i].split(";");
                if (musicData.length > 7) {
                    Model.Music m = new Music();
                    m.setId(musicData[0]);
                    m.setType(musicData[1]);
                    m.setName(musicData[2]);
                    m.setAutor(musicData[3]);
                    m.setCategory(musicData[4]);
                    m.setPrice(Double.parseDouble(musicData[5]));
                    m.setSong(createSongList(musicData[6]));
                    m.setCant(Integer.parseInt(musicData[7]));
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
            String newMusic = "";
            String[] music = fileManager.read(fileName).split("\n");
            for (int i = 0; i < music.length; i++) {
                String musicData[] = music[i].split(";");
                if (!(musicData[0].equals(this.getId()))) {
                    newMusic += music[i];
                    if (i != (music.length - 1)) {
                        newMusic += "\n";
                    }
                } else {
                    newMusic += this.getId() + ";" + this.getType() + ";" + this.getName() + ";" + this.getAutor() + ";"
                            + this.getCategory() + ";" + this.getPrice() + ";" + this.getSongList(song)
                            + ";" + this.getCant();
                }
            }
            fileManager.write(fileName, newMusic);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public LinkedList<String> createSongList(String songs) {
        String[] song = songs.split(",");
        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < song.length; i++) {
            result.add(song[i]);
        }
        return result;
    }

    public String getSongList(LinkedList<String> songs) {
        String result = "";
        for (int i = 0; i < songs.size(); i++) {
            result += songs.get(i);
            if (i != (songs.size() - 1)) {
                result += ",";
            }
        }
        return result;
    }

    public LinkedList<String> getSong() {
        return song;
    }

    public void setSong(LinkedList<String> song) {
        this.song = song;
    }
}
