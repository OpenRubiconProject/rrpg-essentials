package com.openrubicon.essentials.cheat;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.essentials.cheat.commands.*;

import java.util.ArrayList;

public class Cheat {

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new Break());
        commands.add(new Feed());
        commands.add(new Gamemode());
        commands.add(new Heal());
        commands.add(new Repair());
        return commands;
    }
}
