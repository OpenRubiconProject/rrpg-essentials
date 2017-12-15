package com.openrubicon.essentials.cheat.commands;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.interactables.enums.InteractableType;
import com.openrubicon.core.api.interactables.interfaces.Interactable;
import com.openrubicon.core.api.utility.DynamicPrimitive;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quinn on 12/14/2017.
 */
public class Break extends Command {
    @Override
    public String getCommandFormat() {
        return "break";
    }

    @Override
    public ArrayList<InteractableType> getAllowedSenderTypes() {
        ArrayList<InteractableType> types = new ArrayList<InteractableType>();
        types.add(InteractableType.PLAYER);
        return types;
    }

    @Override
    public void handle(Interactable interactable, ArrayList<DynamicPrimitive> arrayList) {
        Player player = ((Player)interactable).getPlayer();
        List<Block> blocks = player.getLineOfSight(null, 200);
        if(blocks.size() > 0){
            blocks.get(0).breakNaturally();
        }
        return;
    }
}
