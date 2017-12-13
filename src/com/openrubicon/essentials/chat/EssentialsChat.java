package com.openrubicon.essentials.chat;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.essentials.chat.commands.Mail;
import com.openrubicon.essentials.chat.commands.MailSend;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/12/2017.
 */
public class EssentialsChat {

    public ArrayList<Command> getCommands(){
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new Mail());
        commands.add(new MailSend());
        return commands;
    }

}
