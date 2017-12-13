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

    @Override
    public ArrayList<DatabaseModel> getDatabaseModels() {
        return null;
    }

    @Override
    public ArrayList<Command> getCommands() {
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.addAll(new EssentialsGeneral().getCommands());
        commands.addAll(new EssentialsProtect().getCommands());
        commands.addAll(new EssentialsLocations().getCommands());
        commands.addAll(new EssentialsChat().getCommands());
        commands.addAll(new EssentialsCheat().getCommands());
        return null;
    }

    @Override
    public ArrayList<PostDatabaseLoad> getPostDatabaseLoads() {
        return null;
    }

    @Override
    public ArrayList<PlayerData> getPlayerDatas() {
        return null;
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
        return "rrpg-general";
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
