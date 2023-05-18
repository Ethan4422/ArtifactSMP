package me.goodi.artifactsmp2.PlayerListeners;

import me.goodi.artifactsmp2.GUI.RecallGloveUPG;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class Gui implements Listener {

    @EventHandler
    public void moveItem(InventoryClickEvent e){
        if(e.getInventory().contains(RecallGloveUPG.glassGUI)){
            e.setCancelled(true);
        }
    }

}
