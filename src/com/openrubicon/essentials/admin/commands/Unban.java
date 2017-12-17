package com.openrubicon.essentials.admin.commands;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Quinn on 12/17/2017.
 */
public class Unban extends Command {

    @Override
    public String getCommandFormat() {
        return "unban $s";
    }

    @Override
    public ArrayList<InteractableType> getAllowedSenderTypes() {
        ArrayList<InteractableType> types = new ArrayList<InteractableType>();
        types.add(InteractableType.PLAYER);
        types.add(InteractableType.DISCORD);
        return types;
    }

    @Override
    public void handle(Interactable interactable, ArrayList<DynamicPrimitive> args) {
        Player playerToUnban = Bukkit.getPlayer(args.get(0).getString());
        Bukkit.getBanList(BanList.Type.NAME).pardon(playerToUnban.getDisplayName());
        return;
    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.admin.unban";
            }
        });
        return perms;
    }

}
