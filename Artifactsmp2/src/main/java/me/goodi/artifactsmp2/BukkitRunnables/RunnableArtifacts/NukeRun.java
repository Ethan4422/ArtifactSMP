package me.goodi.artifactsmp2.BukkitRunnables.RunnableArtifacts;

import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class NukeRun extends BukkitRunnable {
    @Override
    public void run() {
        for(Entity entities : Bukkit.getWorld("world").getEntities()){
            if(entities.getType() == EntityType.GIANT){
                entities = (Giant) entities;
                ItemStack item = ((Giant) entities).getEquipment().getItemInMainHand();
                if(item.hasItemMeta() && item.getItemMeta().hasCustomModelData() && item.getItemMeta().getCustomModelData() == 999){
                    entities.setInvulnerable(true);
                    if(entities.isOnGround()){

                        Location loc = entities.getLocation();
                        int radius = 10;
                        for (int x = (loc.getBlockX() - radius); x <= (loc.getBlockX() + radius); x++) {
                            for (int y = (loc.getBlockY() - radius); y <= (loc.getBlockY() + radius); y++) {
                                for (int z = (loc.getBlockZ() - radius); z <= (loc.getBlockZ() + radius); z++) {
                                    Location l = new Location(loc.getWorld(), x, y, z);
                                    if (l.distance(loc) <= radius) {
                                        l.getBlock().setType(Material.AIR);
                                        l.getWorld().createExplosion(l, 1);

                                        entities.remove();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
