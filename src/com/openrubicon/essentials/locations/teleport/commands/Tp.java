package com.openrubicon.essentials.locations.teleport.commands;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.Player;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/14/2017.
 */
public class Tp extends Command {
    @Override
    public String getCommandFormat() {
        return "tp $s";
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
        if(Bukkit.getPlayer(arrayList.get(0).getString()) != null){
            //Insert cooldown here if needed.

            Location location = player.getPlayer().getLocation();
            location = Bukkit.getPlayer(arrayList.get(0).getString()).getLocation();
        } else {
            player.getPlayer().sendMessage("That player does not exist.");
        }
    }
}
