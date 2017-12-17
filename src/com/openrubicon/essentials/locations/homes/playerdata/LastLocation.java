package com.openrubicon.essentials.locations.homes.playerdata;

import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import com.openrubicon.essentials.locations.events.onPlayerWarp;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Created by Quinn on 12/15/2017.
 */
public class LastLocation implements PlayerData {

    private Location lastLocation;

    public LastLocation(){}
    public LastLocation(Location l){
        this.lastLocation = l;
    }

    public void goToLastLocation(Player p){
        Location currentLocation = p.getLocation();
        Location temp = currentLocation;
        currentLocation = lastLocation;
        lastLocation = temp;
        new onPlayerWarp(p, temp, currentLocation).invoke();   //invoke onPlayerWarp event
        return;
    }

    public void setLastLocation(Location l){
        this.lastLocation = l;
    }



}
