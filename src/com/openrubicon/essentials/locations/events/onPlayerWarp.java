package com.openrubicon.essentials.locations.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Quinn on 12/15/2017.
 */
public class onPlayerWarp extends Event {

    private static final HandlerList handlers = new HandlerList();
    Location previousLocation;
    Location locationWarpedTo;
    Player player;

    public onPlayerWarp(Player p, Location oldLocation, Location newLocaiton){
        this.player = p;
        this.previousLocation = oldLocation;
        this.locationWarpedTo = newLocaiton;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public Location getPreviousLocation(){
        return this.previousLocation;
    }

    public Location getLocationWarpedTo(){
        return this.locationWarpedTo;
    }

    public Player getPlayer(){
        return this.player;
    }

    public void invoke(){
        Bukkit.getPluginManager().callEvent(this);
    }

}
