package com.openrubicon.essentials.locations.homes.playerdata;

import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import org.bukkit.Location;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/14/2017.
 */
public class PlayerHomes implements PlayerData {

    private class Home{
        Location location = null;
        String name = "";

        private Home(Location l, String s){
            this.location = l;
            this.name = s;
        }

        private String getName(){
            return this.name;
        }

        private Location getLocation(){
            return this.location;
        }
    }

    ArrayList<Home> homes;
    int capacity = 2;


    public PlayerHomes(){
        homes = new ArrayList<Home>();
    }

    public int getSize() {
        return homes.size();
    }

    public Location getLocation(String name){
        for(Home h : homes){
            if(h.getName().equals(name)){
                return h.getLocation();
            }
        }
        return null;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void setCapacity(int c){
        this.capacity = c;
    }

    public boolean addHome(Location l, String name){
        if(homes.size() < this.capacity) {
            homes.add(new Home(l, name));
            return true;
        }
        return false;
    }

    public boolean removeHome(String name) {
        for(Home h : homes){
            if(h.getName().equals(name)){
                homes.remove(h);
                return true;
            }
        }
        return false;
    }

    public String[] listHomes(){
        String[] homeList = new String[capacity];
        int i=0;
        for(Home h : homes){
           homeList[i] = h.getName();
           i++;
        }
        return homeList;
    }
}
