package com.openrubicon.essentials.locations.teleport.commands;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import com.openrubicon.essentials.RRPGEssentials;
import com.openrubicon.essentials.locations.teleport.classes.TeleportManager;
import com.openrubicon.essentials.locations.teleport.classes.TeleportRequest;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TpDeny extends Command {
    @Override
    public String getCommandFormat() {
        return "tpdeny";
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
        TeleportManager teleportManager = RRPGEssentials.locations.teleportManager;

        //Check if player has any pending teleport requests
        if(!teleportManager.hasPending(player)){
            player.sendMessage("No pending teleports.");
            return;
        }

        //If there is a request, deny it.
        teleportManager.removeRequest(player);
        return;
    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.teleport.request.tpdeny";
            }
        });
        return perms;
    }
}
