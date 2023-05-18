package me.goodi.artifactsmp2.Utils;

import me.goodi.artifactsmp2.Artifactsmp2;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ArtifactUtil {


    public enum Artifacts {
        RECALLGLOVE,
        THIRDEYE,
        DEMONKINGSSTAFF,
        NUKE
    }



    public static void give(Player player, Artifacts name) {

        switch (name) {
            case RECALLGLOVE:
                ItemStack item = new ItemStack(Material.WOODEN_SWORD);
                ItemMeta meta = item.getItemMeta();
                PersistentDataContainer recallGlovePDC = meta.getPersistentDataContainer();
                recallGlovePDC.set(new NamespacedKey(Artifactsmp2.getPlugin(), "lvl"), PersistentDataType.INTEGER, 1);
                meta.setCustomModelData(CustomModelDataNum.RecallGlove);
                meta.setDisplayName("§fRecall Glove");
                item.setItemMeta(meta);


                player.getInventory().addItem(item);

                break;

            case THIRDEYE:
                item = new ItemStack(Material.IRON_HORSE_ARMOR);
                meta = item.getItemMeta();
                PersistentDataContainer thirdEyePDC = meta.getPersistentDataContainer();
                thirdEyePDC.set(new NamespacedKey(Artifactsmp2.getPlugin(), "lvl"), PersistentDataType.INTEGER, 1);
                meta.setCustomModelData(CustomModelDataNum.ThirdEye);
                meta.setDisplayName("§fThird Eye");
                item.setItemMeta(meta);
                player.getInventory().addItem(item);
                break;

            case DEMONKINGSSTAFF:
                item = new ItemStack(Material.STICK);
                meta = item.getItemMeta();
                PersistentDataContainer DemonKingsStaffPDC = meta.getPersistentDataContainer();
                DemonKingsStaffPDC.set(new NamespacedKey(Artifactsmp2.getPlugin(), "lvl"), PersistentDataType.INTEGER, 1);
                meta.setCustomModelData(CustomModelDataNum.DemonKingsStaff);
                meta.setDisplayName("§fDemonKingsStaff");
                item.setItemMeta(meta);
                player.getInventory().addItem(item);
                break;
            case NUKE:
                item = new ItemStack(Material.IRON_HORSE_ARMOR);
                meta = item.getItemMeta();
                meta.setCustomModelData(CustomModelDataNum.Nuke);
                meta.setDisplayName("§f§lNuke!");
                item.setItemMeta(meta);
                player.getInventory().addItem(item);
                break;

        }
    }
}
