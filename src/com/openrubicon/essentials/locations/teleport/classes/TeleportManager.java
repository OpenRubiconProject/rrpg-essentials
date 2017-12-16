package com.openrubicon.essentials.locations.teleport.classes;

import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/15/2017.
 */
public class TeleportManager {

    private ArrayList<TeleportRequest> teleports = new ArrayList<TeleportRequest>();

    public void addRequest(TeleportRequest tpr){
        teleports.add(tpr);
    }

    public boolean hasPending(Player p){
        for(TeleportRequest tp : teleports){
            if(tp.getSentTo().equals(p) && !tp.isExpired()){
                return true;
            }
        }
        return false;
    }

    public void removeRequest(Player p){
        if(hasPending(p)) {
            for (TeleportRequest tp : teleports) {
                if (tp.getSentTo().equals(p)) {
                    teleports.remove(tp);
                    return;
                }
            }
        }
        return;
    }

    public void teleport(Player p){
        if(hasPending(p)) {
            for (TeleportRequest tp : teleports) {
                if (tp.getSentTo().equals(p)) {
                    tp.teleport();
                    teleports.remove(tp);
                    return;
                }
            }
        }
    }

}
