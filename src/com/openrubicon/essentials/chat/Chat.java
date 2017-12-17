package com.openrubicon.essentials.chat;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import com.openrubicon.essentials.chat.commands.*;
import com.openrubicon.essentials.chat.events.ChatListener;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/17/2017.
 */
public class Chat {

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new Mail());
        commands.add(new MailSend());
        commands.add(new Ignore());
        commands.add(new Msg());
        commands.add(new Nick());
        commands.add(new R());
        return commands;
    }

    public ArrayList<PlayerData> getPlayerData(){
        ArrayList<PlayerData> playerdata = new ArrayList<PlayerData>();
        return playerdata;
    }

    public Chat(){
        new ChatListener();
    }

}
