package com.openrubicon.essentials.cheat.commands;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Quinn on 12/17/2017.
 */
public class Enchant extends Command {
    @Override
    public String getCommandFormat() {
        return "enchant $s $n";
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
        Enchantment enchant = Enchantment.getByName(args.get(0).getString());
        int level = args.get(1).getInt();
        if(enchant == null){
            player.sendMessage("Invalid enchantment.");
            return;
        }
        if(player.getInventory().getItemInMainHand() == null){
            player.sendMessage("You must be holding an item to enchant.");
            return;
        }
        if(enchant.canEnchantItem(player.getInventory().getItemInMainHand())){
            player.getInventory().getItemInMainHand().addEnchantment(enchant, level);
            return;
        }
    }

    @Override
    public ArrayList<PermissionNode> getPermissions() {
        ArrayList<PermissionNode> perms = new ArrayList<PermissionNode>();
        perms.add(new PermissionNode() {
            @Override
            public String getNode() {
                return "rrpg.essentials.cheat.enchant";
            }
        });
        return perms;
    }
}
