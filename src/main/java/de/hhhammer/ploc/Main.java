package de.hhhammer.ploc;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (args.length > 1) {
            sender.sendMessage("This command takes only one player name!");
            return false;
        }
        if (args.length < 1) {
            sender.sendMessage("Missing player name!");
            return false;
        }

        final var player = Bukkit.getPlayer(args[0]);
        if (player == null) {
            sender.sendMessage("Player not found!");
            return false;
        }

        final var location = player.getLocation();
        sender.sendMessage(location.toString());
        return true;
    }
}
