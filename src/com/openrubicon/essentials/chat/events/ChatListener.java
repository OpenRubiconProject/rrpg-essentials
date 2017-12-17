package com.openrubicon.essentials.chat.events;

import com.openrubicon.core.RRPGCore;
import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import com.openrubicon.essentials.chat.commands.Mail;
import com.openrubicon.essentials.chat.commands.MailSend;
import com.openrubicon.essentials.chat.playerdata.IgnoredBy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.Set;

import static com.openrubicon.core.RRPGCore.plugin;

public class ChatListener implements Listener {

        @EventHandler
        public void onChat(AsyncPlayerChatEvent event){
                //When a player sends a chat, make sure that players who have him ignored are not recieving the message.
                //Economy Listener to create accounts for players when joining the server.
                Set<Player> recipients = event.getRecipients();
                IgnoredBy ignoredBy = RRPGCore.players.getPlayerData(event.getPlayer(), IgnoredBy.class);
                recipients.removeAll(ignoredBy.getAll());
        }

        public ChatListener(){
            Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
        }
}
