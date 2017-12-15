package com.openrubicon.essentials.locations.teleport.commands;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.Player;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import com.openrubicon.essentials.locations.teleport.playerdata.TeleportRequest;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/14/2017.
 */
public class TpAccept extends Command {
    @Override
    public String getCommandFormat() {
        return "tpaccept";
    }

    @Override
    public ArrayList<InteractableType> getAllowedSenderTypes() {
        ArrayList<InteractableType> types = new ArrayList<InteractableType>();
        types.add(InteractableType.PLAYER);
        return types;
    }

    @Override
    public void handle(Interactable interactable, ArrayList<DynamicPrimitive> arrayList) {
        com.openrubicon.core.api.server.players.Player player = ((com.openrubicon.core.api.server.players.Player)interactable);
        org.bukkit.entity.Player bukkitPlayer = ((com.openrubicon.core.api.interactables.Player)interactable).getPlayer();

        TeleportRequest teleportRequest = player.getData(TeleportRequest.class);
        //Check if player has any pending teleport requests
        if(teleportRequest == null || !teleportRequest.isRequest()){
            bukkitPlayer.sendMessage("No pending teleports.");
            return;
        }

        //If there is a request, perform teleport.
        teleportRequest.teleport();
        return;
    }
}
