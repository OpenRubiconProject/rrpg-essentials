package com.openrubicon.essentials;

import com.openrubicon.core.api.command.Command;
import com.openrubicon.core.api.configuration.ConfigurationProperty;
import com.openrubicon.core.api.database.interfaces.DatabaseModel;
import com.openrubicon.core.api.database.interfaces.PostDatabaseLoad;
import com.openrubicon.core.api.permission.interfaces.PermissionNode;
import com.openrubicon.core.api.recipes.interfaces.Recipe;
import com.openrubicon.core.api.scoreboard.interfaces.ScoreboardSection;
import com.openrubicon.core.api.server.players.interfaces.PlayerData;
import com.openrubicon.core.interfaces.Module;
import com.openrubicon.essentials.chat.EssentialsChat;
import com.openrubicon.essentials.cheat.EssentialsCheat;
import com.openrubicon.essentials.general.EssentialsGeneral;
import com.openrubicon.essentials.locations.EssentialsLocations;
import com.openrubicon.essentials.protect.EssentialsProtect;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Quinn on 12/12/2017.
 */
public class RRPGEssentials extends JavaPlugin implements Module {

    EssentialsChat chat = new EssentialsChat();
    EssentialsCheat cheat = new EssentialsCheat();
    EssentialsGeneral general = new EssentialsGeneral();
    EssentialsProtect protect = new EssentialsProtect();
    EssentialsLocations locations = new EssentialsLocations();


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
        return null;
    }

    @Override
    public ArrayList<PostDatabaseLoad> getPostDatabaseLoads() {
        return null;
    }

    @Override
    public ArrayList<PlayerData> getPlayerDatas() {
        ArrayList<PlayerData> data = new ArrayList<PlayerData>();
        data.add(new Homes());
        return data;
    }

    @Override
    public ArrayList<Recipe> getRecipes() {
        return null;
    }

    @Override
    public ArrayList<ScoreboardSection> getScoreboardSections() {
        return null;
    }

    @Override
    public ArrayList<PermissionNode> getPermissionNodes() {
        return null;
    }

    @Override
    public LinkedList<ConfigurationProperty> getConfigurationProperties() {
        return null;
    }

    @Override
    public String getKey() {
        return "rrpg-essentials";
    }

    @Override
    public String getOverview() {
        return "Essential server commands";
    }

    @Override
    public String getConfiguration() {
        return this.getDataFolder().getAbsolutePath();
    }
}
