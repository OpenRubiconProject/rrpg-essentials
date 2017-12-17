package com.openrubicon.essentials.chat.playerdata;

import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import org.bukkit.entity.Player;

import java.util.Set;

/**
 * Created by Quinn on 12/17/2017.
 */
public class IgnoredBy implements PlayerData {

    private Set<Player> ignoredBy;

    public IgnoredBy(){
        this.ignoredBy = null;
    }

    /**
     * Toggles if a player is ignored or not
     * @param wantsIgnored The player that wants to ignore the other
     */
    public void toggleIgnoreBy(Player wantsIgnored){
        if(ignoredBy.contains(wantsIgnored)) {
            ignoredBy.remove(wantsIgnored);
            wantsIgnored.sendMessage("Player is no longer ignored.");
            return;
        }
        ignoredBy.add(wantsIgnored);
        wantsIgnored.sendMessage("Player ignored.");
        return;
    }

    public Set<Player> getAll(){
        return this.ignoredBy;
    }

}
