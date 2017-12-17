package com.openrubicon.essentials.chat.commands;

import com.openrubicon.core.RRPGCore;
import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import com.openrubicon.essentials.chat.events.onPrivateMessage;
import com.openrubicon.essentials.chat.playerdata.LastMessageRecievedBy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/17/2017.
 */
public class R extends Command {
    @Override
    public String getCommandFormat() {
        return "r $s";
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
        Player player = ((com.openrubicon.core.api.interactables.Player)interactable).getPlayer();
        LastMessageRecievedBy lmrb = RRPGCore.players.getPlayerData(player, LastMessageRecievedBy.class);

        if(lmrb.getLastMessageFrom() == null){
            player.sendMessage("That player does not exist");
            return;
        }

        lmrb.getLastMessageFrom().sendMessage("[From]" + player.getDisplayName() + ": " + args.get(1).getString());
        new onPrivateMessage(player, lmrb.getLastMessageFrom(), args.get(1).getString());
        return;
    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.chat.msg";
            }
        });
        return perms;
    }
}
