package com.openrubicon.essentials.locations.homes.commands;

import com.openrubicon.core.RRPGCore;
import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import com.openrubicon.essentials.locations.homes.playerdata.PlayerHomes;
import org.bukkit.Location;

import java.util.ArrayList;

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
    public void handle(Interactable interactable, ArrayList<DynamicPrimitive> args) {
        org.bukkit.entity.Player player = ((org.bukkit.entity.Player)interactable).getPlayer();
        PlayerHomes playerHomes = RRPGCore.players.getPlayerData(player, PlayerHomes.class);

        if(playerHomes == null || playerHomes.getSize() == 0){
            //No home to teleport to.
            player.sendMessage("You do not have a home to teleport to.");
            return;
        }

        Location home = playerHomes.getHome(args.get(0).getString());
        if(home != null){
            Location playerlocation = player.getLocation();
            playerlocation = home;
        }

        player.sendMessage("You do not have a home with that name.");
        return;
    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.homes.home";
            }
        });
        return perms;
    }
}
