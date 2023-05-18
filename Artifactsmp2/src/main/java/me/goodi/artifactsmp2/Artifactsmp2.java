package me.goodi.artifactsmp2;

import me.goodi.artifactsmp2.Artifacts.PaidArtifacts.Nuke;
import me.goodi.artifactsmp2.Artifacts.StarterArtifacts.DemonKingStaff;
import me.goodi.artifactsmp2.Artifacts.StarterArtifacts.RecallGlove;
import me.goodi.artifactsmp2.Artifacts.StarterArtifacts.ThirdEye;
import me.goodi.artifactsmp2.BukkitRunnables.RunnableArtifacts.NukeRun;
import me.goodi.artifactsmp2.BukkitRunnables.RunnableArtifacts.RecallGloveRun;
import me.goodi.artifactsmp2.BukkitRunnables.RunnableArtifacts.ThirdEyeRun;
import me.goodi.artifactsmp2.Commands.giveArtifact;
import me.goodi.artifactsmp2.PlayerListeners.FirstJoin;
import me.goodi.artifactsmp2.PlayerListeners.Gui;
import me.goodi.artifactsmp2.PlayerListeners.TexturePack;
import me.goodi.artifactsmp2.ServerListeners.ServerListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class Artifactsmp2 extends JavaPlugin {

    public static Artifactsmp2 getPlugin(){
        return plugin;
    }

    private static Artifactsmp2 plugin;

    @Override
    public void onEnable() {

        plugin = this;

        getServer().getPluginManager().registerEvents(new Nuke(), this);
        getServer().getPluginManager().registerEvents(new TexturePack(), this);
        getServer().getPluginManager().registerEvents(new DemonKingStaff(), this);
        getServer().getPluginManager().registerEvents(new FirstJoin(), this);
        getServer().getPluginManager().registerEvents(new RecallGlove(), this);
        getServer().getPluginManager().registerEvents(new ThirdEye(), this);
        getServer().getPluginManager().registerEvents(new Gui(), this);
        getServer().getPluginManager().registerEvents(new ServerListener(), this);

        getServer().getPluginCommand("giveArtifact").setExecutor(new giveArtifact());
        getServer().getPluginCommand("giveArtifact").setTabCompleter(new giveArtifact());

        BukkitTask RecallGloveRunnable = new RecallGloveRun().runTaskTimer(this, 0, 400);
        BukkitTask NukeRunnable = new NukeRun().runTaskTimer(this, 0, 10);
        BukkitTask ThirdEyeRunnable = new ThirdEyeRun().runTaskTimer(this, 0, 15);
    }
    @Override
    public void onDisable() {
    }
}
