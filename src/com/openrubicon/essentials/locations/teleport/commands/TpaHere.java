package com.openrubicon.essentials.locations.teleport.commands;

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

public class TpaHere extends Command {
    @Override
    public String getCommandFormat() {
        return "tpahere $s";
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

        //Command sender wants other player to teleport to him
        //Check if other player has a pending request
        if(teleportManager.hasPending(tpto)){
            //Player has a pending request.
            player.sendMessage(tpto.getDisplayName() + " already has a pending request.");
            return;
        }
        else{
            //Add request to other player to:
            //Move other player to command sender's location
            teleportManager.addRequest(new TeleportRequest(tpto, player.getLocation(), tpto));
            player.sendMessage("Sending request.");
            tpto.sendMessage(player.getDisplayName() + " would like you to teleport to them. Type /tpaccept to accept or /tpdeny to deny.");
            return;
        }
    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.request.timed.tphere";
            }
        });
        return perms;
    }
}
