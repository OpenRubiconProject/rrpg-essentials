package com.openrubicon.essentials.locations.teleport.commands;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.Player;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;

public class TpHere extends Command {
    @Override
    public String getCommandFormat() {
        return "tphere $s";
    }

    @Override
    public ArrayList<InteractableType> getAllowedSenderTypes() {
        ArrayList<InteractableType> types = new ArrayList<InteractableType>();
        types.add(InteractableType.PLAYER);
        return types;
    }

    @Override
    public void handle(Interactable interactable, ArrayList<DynamicPrimitive> args) {
        Player player = ((Player)interactable);
        if(Bukkit.getPlayer(args.get(0).getString()) != null){
            //Insert cooldown here if needed.

            Location location = Bukkit.getPlayer(args.get(0).getString()).getLocation();
            location = player.getPlayer().getLocation();
        } else {
            player.getPlayer().sendMessage("That player does not exist.");
        }
    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.teleport.forced.tphere";
            }
        });
        return perms;
    }
}
