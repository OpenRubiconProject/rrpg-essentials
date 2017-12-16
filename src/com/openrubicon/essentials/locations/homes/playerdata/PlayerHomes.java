package com.openrubicon.essentials.locations.homes.playerdata;

import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import org.bukkit.Location;

import java.util.ArrayList;

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

    private ArrayList<Home> homes;
    private int capacity = 2;


    public PlayerHomes(){
        homes = new ArrayList<Home>();
    }

    public int getSize() {
        return homes.size();
    }

    public Location getHome(String name){
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

    public ArrayList<String> listHomes(){
        ArrayList<String> homeList = new ArrayList<String>();
        for(Home h : homes){
           homeList.add(h.getName());
        }
        return homeList;
    }
}
