package me.goodi.artifactsmp2.Commands;

import me.goodi.artifactsmp2.Utils.ArtifactUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class giveArtifact implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(sender.isOp()){
                if(args.length  == 1) {
                    switch (ArtifactUtil.Artifacts.valueOf(args[0].toUpperCase())) {
                        case RECALLGLOVE:
                            ArtifactUtil.give(player, ArtifactUtil.Artifacts.RECALLGLOVE);
                            break;
                        case THIRDEYE:
                            ArtifactUtil.give(player, ArtifactUtil.Artifacts.THIRDEYE);
                            break;
                        case DEMONKINGSSTAFF:
                            ArtifactUtil.give(player, ArtifactUtil.Artifacts.DEMONKINGSSTAFF);
                            break;
                        case NUKE:
                            ArtifactUtil.give(player, ArtifactUtil.Artifacts.NUKE);
                            break;
                    }
                }
                else {
                    player.sendMessage("/giveartifact [ArtiFact]");
                }
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender.isOp()){
            if(args.length == 1){
                List<String> cmd = new ArrayList<>();

                cmd.add("RECALLGLOVE");
                cmd.add("THIRDEYE");
                cmd.add("DEMONKINGSSTAFF");
                cmd.add("NUKE");

                final List<String> completions = new ArrayList<>();

                StringUtil.copyPartialMatches(args[0], cmd, completions);


                return completions;
            }
        }
        return null;
    }
}