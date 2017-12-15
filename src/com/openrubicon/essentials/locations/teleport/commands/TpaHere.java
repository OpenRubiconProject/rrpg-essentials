package com.openrubicon.essentials.locations.teleport.commands;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.server.players.Player;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import com.openrubicon.essentials.locations.teleport.playerdata.TeleportRequest;
import org.bukkit.Bukkit;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/14/2017.
 */
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
    public void handle(Interactable interactable, ArrayList<DynamicPrimitive> arrayList) {
        //Command sender wants another player to come to his location.

        Player player = ((Player)interactable);
        org.bukkit.entity.Player bukkitPlayer = ((com.openrubicon.core.api.interactables.Player)interactable).getPlayer();

        Player tpto = (Player) Bukkit.getPlayer(arrayList.get(0).getString());
        org.bukkit.entity.Player bukkittpto = Bukkit.getPlayer(arrayList.get(0).getString());
        TeleportRequest teleportRequest = (TeleportRequest) tpto.getData(TeleportRequest.class);

        //Check if the player was found
        if(bukkittpto == null || tpto == null){
            bukkitPlayer.sendMessage("That player does not exist.");
            return;
        }

        //Add request to:
        //Move tpto player to commandSender's location.
        if(teleportRequest.setTeleport(bukkittpto, bukkitPlayer.getLocation())){
            //If a request was sent, notify both players
            bukkitPlayer.sendMessage("Sending request.");
            bukkittpto.sendMessage(bukkitPlayer.getDisplayName() + " would like you to teleport to them. Type /tpaccept to accept or /tpdeny to deny.");
        } else {
            //If a request was not sent, notify the sending player.
            bukkitPlayer.sendMessage(bukkittpto.getDisplayName() + " already has a pending request.");
        }
    }
}
