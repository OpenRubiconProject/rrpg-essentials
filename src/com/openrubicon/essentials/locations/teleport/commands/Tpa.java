package com.openrubicon.essentials.locations.teleport.commands;

import com.openrubicon.core.RRPGCore;
import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import com.openrubicon.essentials.RRPGEssentials;
import com.openrubicon.essentials.locations.teleport.classes.TeleportManager;
import com.openrubicon.essentials.locations.teleport.classes.TeleportRequest;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Tpa extends Command {
    @Override
    public String getCommandFormat() {
        return "tpa $s";
    }

    @Override
    public ArrayList<InteractableType> getAllowedSenderTypes() {
        ArrayList<InteractableType> types = new ArrayList<InteractableType>();
        types.add(InteractableType.PLAYER);
        return types;
    }

    @Override
    public void handle(Interactable interactable, ArrayList<DynamicPrimitive> args) {
        TeleportManager teleportManager = RRPGEssentials.locations.teleportManager;
        Player player = ((Player)interactable).getPlayer();
        Player tpto = Bukkit.getPlayer(args.get(0).getString());

        //Check if requested player was found
        if(tpto == null){
            player.sendMessage("That player does not exist.");
            return;
        }

        //Command sender wants to go to another player.
        //Check if there is a pending teleport:
        if(teleportManager.hasPending(tpto)){
            //Player has a pending request.
            player.sendMessage(tpto.getDisplayName() + " already has a pending request.");
            return;
        }
        else{
            //Add request to:
            //Move commandSender to TpTo's Location
            teleportManager.addRequest(new TeleportRequest(player, tpto.getLocation(), tpto));
            player.sendMessage("Sending request.");
            tpto.sendMessage(player.getDisplayName() + " would like to teleport to you. Type /tpaccept to accept or /tpdeny to deny.");
            return;
        }
    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.teleport.request.tpa";
            }
        });
        return perms;
    }
}
