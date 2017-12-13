package com.openrubicon.essentials.cheat;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.essentials.cheat.commands.God;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/12/2017.
 */
public class EssentialsCheat {

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new God());
        return commands;
    }
}
