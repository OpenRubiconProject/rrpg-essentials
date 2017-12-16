package com.openrubicon.essentials.locations.teleport.classes;

import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Date;

public class TeleportRequest implements PlayerData {

    private Location location;
    private Date expires;
    private Player playerToMove;
    private Player sentTo;

    public TeleportRequest(){

    }

    /**
     * Creates a new teleport request
     * @param playerToMove The player that is getting moved
     * @param toMoveTo The location to move the player to
     * @param sentTo The player that is being sent the teleport request
     */
    public TeleportRequest(Player playerToMove, Location toMoveTo, Player sentTo) {
        this.location = toMoveTo;
        this.playerToMove = playerToMove;
        this.sentTo = sentTo;
        this.expires = new Date((new Date().getTime() + 10000));
    }

    /**
     * Performs the teleportation
     */
    public void teleport(){
        //If the expiry date hasn't past, teleport the player
        if(isExpired()) {
            Location moveMe = playerToMove.getLocation();
            moveMe = this.location;
            this.clearRequest();
            return;
        }
        return;
    }

    /**
     * Gets the player the request was sent to
     * @return Player the request was sent to
     */
    public Player getSentTo(){
        return this.sentTo;
    }

    /**
     * Clears the teleport request
     */
    public void clearRequest(){
        this.location = null;
        this.playerToMove = null;
        this.expires = null;
    }

    /**
     * Set the teleportation information
     * @param playerToMove  The player to move
     * @param toMoveTo  The location to move to
     * @param sentTo    The player the request is sent to
     * @return
     */
    public boolean setTeleport(Player playerToMove, Location toMoveTo, Player sentTo){
        //if there is no request, set one.
        if(!isExpired()){
            this.location = toMoveTo;
            this.playerToMove = playerToMove;
            this.sentTo = sentTo;
            //Exp
            this.expires = new Date((new Date().getTime() + 10000));
            return true;
        }
        return false;
    }

    /**
     * Check if the teleport request has expired
     * @return If the teleport request has expired
     */
    public boolean isExpired(){
        //If the request has expired, remove the request
        if(expires == null){
            return false;
        }
        //if the expiry date has past, clear it and return true
        if(expires.before(new Date())){
            clearRequest();
            return false;
        }
        //If there is still an active expiry date, then a request is active.
        return true;
    }

}
