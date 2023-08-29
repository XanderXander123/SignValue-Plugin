/* 
 * 
 * PLACE BLOCK PLUGIN
 */

package org.ide.language.intel.manage.manager.untitled4;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlaceBlockPlugin extends JavaPlugin implements Listener {



    @Override public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {   if (cmd.getName().equalsIgnoreCase("placeblock") && sender instanceof Player) {
    Player player = (Player) sender;  if (args.length == 1) { String blockName = args[0].toUpperCase();
    try { Material material = Material.valueOf(blockName);
    Block block = player.getTargetBlock(null, 5); block.setType(material);
    /*
     * MESSAGES ARE BELLOW THIS, COMMANDS, ETC.
     */
    player.sendMessage("You placed a " + blockName + " block!");
    return true; } catch (IllegalArgumentException e) {
    player.sendMessage("Invalid block material. Usage: /block <block>");
    } } else { player.sendMessage("Usage: /block <block>"); } }
    return false; } @EventHandler public void onBlockPlace(BlockPlaceEvent event) {
    if (event.getBlock().getType() == Material.STONE) {  event.setCancelled(true); }
    }
}
