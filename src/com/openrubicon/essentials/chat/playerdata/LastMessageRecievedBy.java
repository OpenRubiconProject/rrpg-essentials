package com.openrubicon.essentials.chat.playerdata;

import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import org.bukkit.entity.Player;

/**
 * Created by Quinn on 12/17/2017.
 */
public class LastMessageRecievedBy implements PlayerData {

    private Player lastMessageFrom;

    public LastMessageRecievedBy(){

    }

    public void setLastMessageFrom(Player p){
        this.lastMessageFrom = p;
    }

    public Player getLastMessageFrom(){
        return this.lastMessageFrom;
    }

}
