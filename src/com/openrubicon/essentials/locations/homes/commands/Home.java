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
public class Home extends Command {

    @Override
    public String getCommandFormat() {
        return "home $s";
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
            bukkitPlayer.sendMessage("You do not have a home to teleport to.");
            return;
        }

        Location home = playerHomes.getLocation(arrayList.get(0).getString());
        if(home != null){
            Location playerlocation = bukkitPlayer.getLocation();
            playerlocation = home;
        }

        bukkitPlayer.sendMessage("You do not have a home with that name.");
        return;
    }
}
