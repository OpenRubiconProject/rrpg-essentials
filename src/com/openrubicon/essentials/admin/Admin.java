package com.openrubicon.essentials.admin;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import com.openrubicon.essentials.admin.commands.Ban;
import com.openrubicon.essentials.admin.commands.BanIP;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/17/2017.
 */
public class Admin {

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new Ban());
        commands.add(new BanIP());
        return commands;
    }

    public ArrayList<PlayerData> getPlayerData(){
        ArrayList<PlayerData> playerdata = new ArrayList<PlayerData>();
        return playerdata;
    }

    public Admin(){
    }
}
