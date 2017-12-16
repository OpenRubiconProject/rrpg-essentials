package com.openrubicon.essentials.chat;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import com.openrubicon.essentials.chat.commands.Mail;
import com.openrubicon.essentials.chat.commands.MailSend;

import java.util.ArrayList;

public class Chat {

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new Mail());
        commands.add(new MailSend());
        return commands;
    }

    public ArrayList<PlayerData> getPlayerData(){
        ArrayList<PlayerData> playerdata = new ArrayList<PlayerData>();
        return playerdata;
    }

}
