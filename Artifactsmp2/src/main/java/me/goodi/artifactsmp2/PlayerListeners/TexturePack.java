package me.goodi.artifactsmp2.PlayerListeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TexturePack implements Listener {

    private final String url = "https://www.dropbox.com/sh/sgolyr6yz2fsyui/AAA-Aer1tyAa40xEkhdPenVma?dl=0".replace("dl=0", "dl=1");


    @EventHandler
    public void join(PlayerJoinEvent e){
        e.getPlayer().setResourcePack(url);
    }

}
