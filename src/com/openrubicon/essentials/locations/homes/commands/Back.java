package com.openrubicon.essentials.locations.homes.commands;

import com.openrubicon.core.RRPGCore;
import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import com.openrubicon.essentials.locations.events.onPlayerWarp;
import com.openrubicon.essentials.locations.homes.playerdata.LastLocation;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/15/2017.
 */
public class Back extends Command {
    @Override
    public String getCommandFormat() {
        return "back";
    }

    @Override
    public ArrayList<InteractableType> getAllowedSenderTypes() {
        ArrayList<InteractableType> types = new ArrayList<InteractableType>();
        types.add(InteractableType.PLAYER);
        return types;
    }

    @Override
    public void handle(Interactable interactable, ArrayList<DynamicPrimitive> args) {
        Player p = ((Player)interactable).getPlayer();
        LastLocation lastLocation = RRPGCore.players.getPlayerData(p, LastLocation.class);
        lastLocation.goToLastLocation(p);
    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.homes.back";
            }
        });
        return perms;
    }
}
