package com.openrubicon.essentials.general;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.essentials.general.commands.Afk;
import com.openrubicon.essentials.general.commands.Compass;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/12/2017.
 */
public class EssentialsGeneral {

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new Afk());
        commands.add(new Compass());
        return commands;
    }

}
