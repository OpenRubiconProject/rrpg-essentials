package com.openrubicon.essentials.cheat;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import com.openrubicon.essentials.cheat.commands.*;
import com.openrubicon.essentials.general.playerdata.AfkStatus;

import java.util.ArrayList;

public class Cheat {

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new Break());
        commands.add(new Enchant());
        commands.add(new Exp());
        commands.add(new Fly());
        commands.add(new Feed());
        commands.add(new Gamemode());
        commands.add(new Heal());
        commands.add(new Repair());
        commands.add(new Enchant());
        return commands;
    }

    public ArrayList<PlayerData> getPlayerData(){
        ArrayList<PlayerData> playerdata = new ArrayList<PlayerData>();
        return playerdata;
    }
}
