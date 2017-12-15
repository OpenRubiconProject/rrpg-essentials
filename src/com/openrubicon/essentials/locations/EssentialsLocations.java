package com.openrubicon.essentials.locations;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.essentials.locations.homes.commands.SetHome;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/12/2017.
 */
public class EssentialsLocations {

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new SetHome());
        return commands;
    }

}
