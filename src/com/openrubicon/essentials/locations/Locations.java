package com.openrubicon.essentials.locations;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.essentials.locations.homes.commands.SetHome;
import com.openrubicon.essentials.locations.teleport.classes.TeleportManager;
import com.openrubicon.essentials.locations.teleport.classes.TeleportRequest;

import java.util.ArrayList;


public class Locations {

    public static TeleportManager teleportManager = new TeleportManager();

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new SetHome());
        return commands;
    }

}
