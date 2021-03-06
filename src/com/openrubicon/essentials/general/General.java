package com.openrubicon.essentials.general;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import com.openrubicon.essentials.general.commands.Afk;
import com.openrubicon.essentials.general.commands.Compass;
import com.openrubicon.essentials.general.playerdata.AfkStatus;

import java.util.ArrayList;

public class General {

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new Afk());
        commands.add(new Compass());
        return commands;
    }

    public ArrayList<PlayerData> getPlayerData(){
        ArrayList<PlayerData> playerdata = new ArrayList<PlayerData>();
        playerdata.add(new AfkStatus());
        return playerdata;
    }

}
