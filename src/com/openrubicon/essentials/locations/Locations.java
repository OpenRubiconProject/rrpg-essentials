package com.openrubicon.essentials.locations;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.essentials.locations.homes.commands.*;
import com.openrubicon.essentials.locations.teleport.classes.TeleportManager;
import com.openrubicon.essentials.locations.teleport.classes.TeleportRequest;
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
        return commands;
    }

}
