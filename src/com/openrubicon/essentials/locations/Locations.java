package com.openrubicon.essentials.locations;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import com.openrubicon.essentials.locations.admin.commands.Jail;
import com.openrubicon.essentials.locations.admin.commands.SetJail;
import com.openrubicon.essentials.locations.admin.commands.SetSpawn;
import com.openrubicon.essentials.locations.commands.Depth;
import com.openrubicon.essentials.locations.commands.GetPos;
import com.openrubicon.essentials.locations.homes.commands.*;
import com.openrubicon.essentials.locations.homes.playerdata.LastLocation;
import com.openrubicon.essentials.locations.homes.playerdata.PlayerHomes;
import com.openrubicon.essentials.locations.teleport.classes.TeleportManager;
import com.openrubicon.essentials.locations.teleport.commands.*;

import java.util.ArrayList;


public class Locations {

    public static TeleportManager teleportManager = new TeleportManager();

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new Tp());
        commands.add(new Tpa());
        commands.add(new TpAccept());
        commands.add(new TpaHere());
        commands.add(new TpDeny());
        commands.add(new TpHere());

        commands.add(new Back());
        commands.add(new SetHome());
        commands.add(new DelHome());
        commands.add(new TpHere());
        commands.add(new Home());
        commands.add(new Homes());

        commands.add(new Depth());
        commands.add(new GetPos());

        commands.add(new Jail());
        commands.add(new SetJail());
        commands.add(new SetSpawn());
        return commands;
    }

    public ArrayList<PlayerData> getPlayerData(){
        ArrayList<PlayerData> playerdata = new ArrayList<PlayerData>();
        playerdata.add(new LastLocation());
        playerdata.add(new PlayerHomes());
        return playerdata;
    }

}
