package me.goodi.artifactsmp2.PlayerListeners;

import me.goodi.artifactsmp2.Artifactsmp2;
import me.goodi.artifactsmp2.Config.PlayerConfig;
import me.goodi.artifactsmp2.GUI.SelectFirstArtifact;
import me.goodi.artifactsmp2.Utils.CustomModelDataNum;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class FirstJoin implements Listener {
    PlayerConfig config = new PlayerConfig();

    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        config.playerConfig(player);
        if(config.getStarterArtifact(player).equals("PlaceHolder")) {
            SelectFirstArtifact.openSelectStarterArtifact(player);
        }

    }


    @EventHandler
    public void selectArtifact(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (config.getStarterArtifact(player).equals("PlaceHolder")) {
            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.WHITE + "Choose an artifact")) {
                if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                    if (e.getCurrentItem().getItemMeta().hasCustomModelData()) {
                        if (e.getCurrentItem().getItemMeta().getCustomModelData() == CustomModelDataNum.ThirdEye || e.getCurrentItem().getItemMeta().getCustomModelData() == CustomModelDataNum.RecallGlove || e.getCurrentItem().getItemMeta().getCustomModelData() == CustomModelDataNum.DemonKingsStaff) {
                            config.setStarterArtifact(player, Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().replace("§f", ""));
                            player.getInventory().addItem(Objects.requireNonNull(e.getCurrentItem()).clone());
                            Objects.requireNonNull(e.getClickedInventory()).close();
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void close(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        if (config.getStarterArtifact(player).equals("PlaceHolder")) {
            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.WHITE + "Choose an artifact")) {

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if(config.getStarterArtifact(player).equals("PlaceHolder")) {
                            SelectFirstArtifact.openSelectStarterArtifact(player);
                        }
                        else cancel();
                    }
                }.runTaskLater(Artifactsmp2.getPlugin(), 2L);

            }
        }
    }
}

