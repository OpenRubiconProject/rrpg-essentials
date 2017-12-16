package com.openrubicon.essentials.protect;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import com.openrubicon.essentials.protect.commands.RegionProtect;

import java.util.ArrayList;


public class Protect {

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new RegionProtect());
        return commands;
    }

    public ArrayList<PlayerData> getPlayerData(){
        ArrayList<PlayerData> playerdata = new ArrayList<PlayerData>();
        return playerdata;
    }

}
