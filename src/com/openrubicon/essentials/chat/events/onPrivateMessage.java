package com.openrubicon.essentials.chat.events;

import com.openrubicon.core.RRPGCore;
import com.openrubicon.essentials.chat.playerdata.LastMessageRecievedBy;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Quinn on 12/17/2017.
 */
public class onPrivateMessage extends Event {

    private static final HandlerList handlers = new HandlerList();
    String message;
    Player sentFrom;
    Player sentTo;

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Fires when a private message is sent between players
     * @param sentFrom the player the messsage was sent from
     * @param sentTo the player the message was sent to
     * @param message the message that is being sent
     */
    public onPrivateMessage(Player sentFrom, Player sentTo, String message){
        this.sentFrom = sentFrom;
        this.sentTo = sentTo;
        this.message = message;
        RRPGCore.players.getPlayerData(sentTo, LastMessageRecievedBy.class).setLastMessageFrom(sentFrom);
    }

    public Player getSentFrom(){
        return this.sentFrom;
    }

    public Player getSentTo(){
        return this.sentTo;
    }

    public String getMessage(){
        return this.message;
    }
}
