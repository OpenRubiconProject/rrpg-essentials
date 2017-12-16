package com.openrubicon.essentials.general.commands;

import com.openrubicon.core.RRPGCore;
import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.Player;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import com.openrubicon.essentials.general.playerdata.AfkStatus;
import org.bukkit.Bukkit;

import java.util.ArrayList;

public class Afk extends Command {
    @Override
    public String getCommandFormat() {
        return "afk";
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
        AfkStatus status = RRPGCore.players.getPlayerData(((Player)interactable).getPlayer(), AfkStatus.class);
        if(status == null){
            status = new AfkStatus(true);
        }
        if(!status.isAfk){
            status.toggleAfk();
        }
        Bukkit.broadcastMessage(((Player)interactable).getPlayer().getDisplayName() + " is afk.");
    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.general.afk";
            }
        });
        return perms;
    }
}