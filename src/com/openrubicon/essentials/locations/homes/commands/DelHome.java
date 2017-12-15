package com.openrubicon.essentials.locations.homes.commands;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.server.players.Player;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import com.openrubicon.essentials.locations.homes.playerdata.PlayerHomes;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/14/2017.
 */
public class DelHome extends Command {
    @Override
    public String getCommandFormat() {
        return "delhome $s";
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

        if(playerHomes == null){
            //No home to delete.
            bukkitPlayer.sendMessage("You do not have any homes set. Set a home with /sethome");
            return;
        }

        if(playerHomes.removeHome(arrayList.get(0).getString())) {
            bukkitPlayer.sendMessage(arrayList.get(0).getString() + " has been deleted.");
        } else {
            bukkitPlayer.sendMessage("You do not have a home with that name. Type /homes to see a list of your homes.");
        }

    }
}
