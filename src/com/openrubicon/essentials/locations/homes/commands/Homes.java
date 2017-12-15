package com.openrubicon.essentials.locations.homes.commands;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.server.players.Player;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import com.openrubicon.essentials.locations.homes.playerdata.PlayerHomes;
import org.bukkit.Location;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/14/2017.
 */
public class Homes extends Command {


    @Override
    public String getCommandFormat() {
        return "homes";
    }

    @Override
    public ArrayList<InteractableType> getAllowedSenderTypes() {
        ArrayList<InteractableType> types = new ArrayList<InteractableType>();
        types.add(InteractableType.PLAYER);
        return types;
    }

    @Override
    public void handle(Interactable interactable, ArrayList<DynamicPrimitive> arrayList) {
        Player player = ((Player)interactable);
        org.bukkit.entity.Player bukkitPlayer = ((com.openrubicon.core.api.interactables.Player)interactable).getPlayer();
        PlayerHomes playerHomes = (PlayerHomes) player.getData(PlayerHomes.class);

        if(playerHomes == null || playerHomes.getSize() == 0){
            //No home to teleport to.
            bukkitPlayer.sendMessage("You do not have any homes.");
            return;
        }

        String[] homeNames = playerHomes.listHomes();
        String concat = new String();
        for(String home : homeNames){
                concat += home + ", ";
        }
        //remove the last comma from the string.
        concat.substring(0, concat.length() - 3);

        bukkitPlayer.sendMessage("Homes: " + concat);
        return;
    }

}
