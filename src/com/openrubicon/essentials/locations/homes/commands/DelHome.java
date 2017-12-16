package com.openrubicon.essentials.locations.homes.commands;

import com.openrubicon.core.RRPGCore;
import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import com.openrubicon.essentials.locations.homes.playerdata.PlayerHomes;
import org.bukkit.entity.Player;

import java.util.ArrayList;

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
    public void handle(Interactable interactable, ArrayList<DynamicPrimitive> args) {

        Player player = ((com.openrubicon.core.api.interactables.Player)interactable).getPlayer();
        PlayerHomes playerHomes = RRPGCore.players.getPlayerData(player, PlayerHomes.class);

        if(playerHomes == null){
            //No home to delete.
            player.sendMessage("You do not have any homes set. Set a home with /sethome");
            return;
        }

        if(playerHomes.removeHome(args.get(0).getString())) {
            player.sendMessage(args.get(0).getString() + " has been deleted.");
        } else {
            player.sendMessage("You do not have a home with that name. Type /homes to see a list of your homes.");
        }

    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.homes.delhome";
            }
        });
        return perms;
    }
}
