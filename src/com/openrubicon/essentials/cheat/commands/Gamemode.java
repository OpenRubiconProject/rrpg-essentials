package com.openrubicon.essentials.cheat.commands;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/15/2017.
 */
public class Gamemode extends Command {
    @Override
    public String getCommandFormat() {
        return "gamemode $s";
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
        GameMode gm;
        switch(args.get(0).getString().toLowerCase()){
            case "survival":
                gm = GameMode.SURVIVAL;
                break;
            case "creative":
                gm = GameMode.CREATIVE;
                break;
            case "adventure":
                gm = GameMode.ADVENTURE;
                break;
            case "spectator":
                gm = GameMode.SPECTATOR;
                break;
            default:
                player.sendMessage("That gamemode does not exist");
                return;
        }

        if(gm == null){
            return;
        }
        player.setGameMode(gm);
    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.cheat.gamemode";
            }
        });
        return perms;
    }
}
