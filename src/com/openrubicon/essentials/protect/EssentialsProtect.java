package com.openrubicon.essentials.protect;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.essentials.protect.commands.RegionProtect;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/12/2017.
 */
public class EssentialsProtect {

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new RegionProtect());
        return commands;
    }

}
