package com.openrubicon.essentials.chat.commands;

import com.openrubicon.core.RRPGCore;
import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import com.openrubicon.essentials.chat.playerdata.IgnoredBy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/17/2017.
 */
public class Ignore extends Command {
    @Override
    public String getCommandFormat() {
        return "ignore $s";
    }

    @Override
    public ArrayList<InteractableType> getAllowedSenderTypes() {
        ArrayList<InteractableType> types = new ArrayList<InteractableType>();
        types.add(InteractableType.PLAYER);
        types.add(InteractableType.DISCORD);
        return types;
    }

    @Override
    public void handle(Interactable interactable, ArrayList<DynamicPrimitive> args) {
        Player player = ((com.openrubicon.core.api.interactables.Player)interactable).getPlayer();
        Player ignore = Bukkit.getPlayer(args.get(0).getString());

        if(ignore == null){
            player.sendMessage("That player does not exist");
            return;
        }

        RRPGCore.players.getPlayerData(ignore, IgnoredBy.class).toggleIgnoreBy(player);
        return;
    }


    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.chat.ignore";
            }
        });
        return perms;
    }
}
