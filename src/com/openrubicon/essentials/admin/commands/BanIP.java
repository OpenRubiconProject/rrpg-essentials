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
public class BanIP extends Command {
    @Override
    public String getCommandFormat() {
        //[0] - IP to ban
        //[1] - why
        //[2] - length in hours
        return "ban $s $s $i";
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
        Player bannedBy = ((com.openrubicon.core.api.interactables.Player)interactable).getPlayer();
        String ip = args.get(0).getString();
        String reason = args.get(1).getString();
        int hours = args.get(2).getInt();
        Date expiryDate = new Date(new Date().getTime() + (hours * 60 * 60 * 100));
        Bukkit.getBanList(BanList.Type.IP).addBan(ip, reason, expiryDate, bannedBy.getDisplayName());
        return;
    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.admin.banip";
            }
        });
        return perms;
    }
}
