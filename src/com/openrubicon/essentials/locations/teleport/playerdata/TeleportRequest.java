package com.openrubicon.essentials.locations.teleport.playerdata;

import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Date;

/**
 * Created by Quinn on 12/14/2017.
 */
public class TeleportRequest implements PlayerData {

    Location location;
    Date expires;
    Player playerToMove;

    public TeleportRequest(){

    }

    public TeleportRequest(Player playerToMove, Location toMoveTo) {
        this.location = toMoveTo;
        this.playerToMove = playerToMove;
        this.expires = new Date((new Date().getTime() + 10000));
    }

    public void teleport(){
        Location moveMe = playerToMove.getLocation();
        moveMe = this.location;
        this.clearRequest();
        return;
    }

    public void clearRequest(){
        this.location = null;
        this.playerToMove = null;
        this.expires = null;
    }

    public boolean setTeleport(Player playerToMove, Location toMoveTo){
        //if there is no request, set one.
        if(!isRequest()){
            this.location = toMoveTo;
            this.playerToMove = playerToMove;
            //Exp
            this.expires = new Date((new Date().getTime() + 10000));
            return true;
        }
        return false;
    }

    public boolean isRequest(){
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
