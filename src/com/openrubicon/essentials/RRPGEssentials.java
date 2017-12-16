package com.openrubicon.essentials;

import com.openrubicon.core.RRPGCore;
import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.configuration.ConfigurationProperty;
import com.openrubicon.core.api.database.interfaces.DatabaseModel;
import com.openrubicon.core.api.database.interfaces.PostDatabaseLoad;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.recipes.interfaces.Recipe;
import com.openrubicon.core.api.scoreboard.interfaces.ScoreboardSection;
import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import com.openrubicon.core.interfaces.Module;
import com.openrubicon.essentials.chat.Chat;
import com.openrubicon.essentials.cheat.Cheat;
import com.openrubicon.essentials.general.General;
import com.openrubicon.essentials.locations.Locations;
import com.openrubicon.essentials.locations.homes.playerdata.PlayerHomes;
import com.openrubicon.essentials.protect.Protect;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.LinkedList;


public class RRPGEssentials extends JavaPlugin implements Module {

    public static Chat chat = new Chat();
    public static Cheat cheat = new Cheat();
    public static General general = new General();
    public static Protect protect = new Protect();
    public static Locations locations = new Locations();


    @Override
    public ArrayList<DatabaseModel> getDatabaseModels() {
        return null;
    }

    @Override
    public ArrayList<Command> getCommands() {
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.addAll(general.getCommands());
        commands.addAll(protect.getCommands());
        commands.addAll(locations.getCommands());
        commands.addAll(chat.getCommands());
        commands.addAll(cheat.getCommands());
        return commands;
    }

    @Override
    public ArrayList<PostDatabaseLoad> getPostDatabaseLoads() {
        return null;
    }

    @Override
    public ArrayList<PlayerData> getPlayerDatas() {
        ArrayList<PlayerData> data = new ArrayList<PlayerData>();
        data.addAll(general.getPlayerData());
        data.addAll(protect.getPlayerData());
        data.addAll(locations.getPlayerData());
        data.addAll(chat.getPlayerData());
        data.addAll(cheat.getPlayerData());
        return data;
    }

    @Override
    public ArrayList<Recipe> getRecipes() {
        return new ArrayList<Recipe>();
    }

    @Override
    public ArrayList<ScoreboardSection> getScoreboardSections() {
        return new ArrayList<ScoreboardSection>();
    }

    @Override
    public ArrayList<PermissionNode> getPermissionNodes() {
        return new ArrayList<PermissionNode>();
    }

    @Override
    public LinkedList<ConfigurationProperty> getConfigurationProperties() {
        return new LinkedList<ConfigurationProperty>();
    }

    @Override
    public String getKey() {
        return "rrpg-essentials";
    }

    @Override
    public String getOverview() {
        return "Essential commands for server";
    }

    @Override
    public String getConfiguration() {
        return this.getDataFolder().getAbsolutePath();
    }

    @Override
    public void onLoad()
    {
        RRPGCore.modules.addModule(this);
    }
}
