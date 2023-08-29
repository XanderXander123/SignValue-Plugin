package pl.maccraft.regssal;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public final class RgsPlugin extends JavaPlugin implements Listener {
  
    @Override
       public void onEnable() {
       getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
            Block clickedBlock = event.getClickedBlock();
            if (clickedBlock != null && isSign(clickedBlock)) {
                Sign sign = (Sign) clickedBlock.getState();
                if (sign.getLine(0).equals(ChatColor.DARK_RED + "[sell]")) {
                    updateSignContents(sign, player);
                    }
            }
        }
    }
    private boolean isSign(Block block) {
        Material type = block.getType();
                return type.equals(Material.SIGN) || type.equals(Material.SIGN_POST) || type.equals(Material.WALL_SIGN);
    }

    private void updateSignContents(Sign sign, Player player) {
        sign.setLine(0, ChatColor.DARK_RED + "[sell]");
            sign.setLine(1, player.getName());
                sign.setLine(2, "0");
                    sign.setLine(3, ChatColor.DARK_RED + "a");
                        sign.update(); // Update the sign to reflect changes
    }
}
