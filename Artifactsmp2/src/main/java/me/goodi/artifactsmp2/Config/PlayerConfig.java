package me.goodi.artifactsmp2.Config;

import me.goodi.artifactsmp2.Utils.ArtifactUtil;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerConfig {


    public void playerConfig(Player player) {
        File f = new File("plugins/Artifactsmp2/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.addDefault("Name", player.getName());
        yml.addDefault("StarterArtifact", "PlaceHolder");
        yml.options().copyDefaults(true);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStarterArtifact(Player player) {
        File f = new File("plugins/Artifactsmp2/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getString("StarterArtifact");
    }

    public void setStarterArtifact(Player player, String artifact) {
        File f = new File("plugins/Artifactsmp2/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("StarterArtifact", artifact);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
