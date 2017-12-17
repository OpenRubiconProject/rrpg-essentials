package com.openrubicon.essentials.locations.commands;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/17/2017.
 */
public class GetPos extends Command {
    @Override
    public String getCommandFormat() {
        return "getpos";
    }

    @Override
    public ArrayList<InteractableType> getAllowedSenderTypes() {
        ArrayList<InteractableType> types = new ArrayList<InteractableType>();
        types.add(InteractableType.PLAYER);
        return types;
    }

    @Override
    public void handle(Interactable interactable, ArrayList<DynamicPrimitive> args) {
        Player player = ((com.openrubicon.core.api.interactables.Player)interactable).getPlayer();
        Location l = player.getLocation();
        player.sendMessage("X: " + l.getBlockX() + " Y: " + l.getBlockY() + " Z: " + l.getBlockZ());
    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.locations.getpos";
            }
        });
        return perms;
    }
}
