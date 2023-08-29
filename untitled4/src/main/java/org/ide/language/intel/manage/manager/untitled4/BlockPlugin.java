/*
 * 
 *  BLOCK PLUGIN
 */

package org.ide.language.intel.manage.manager.untitled4;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() { getServer().getPluginManager().registerEvents(this, this);

    getLogger().info("BlockPlugin has been enabled."); }  @Override
    public void onDisable() { getLogger().info("BlockPlugin has been disabled."); }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (cmd.getName().equalsIgnoreCase("BLOCK") && sender.hasPermission("blockplugin.place")) {
    if (sender instanceof org.bukkit.entity.Player) {
    org.bukkit.entity.Player player = (org.bukkit.entity.Player) sender;
    Block block = player.getLocation().getBlock().getRelative(BlockFace.UP);
    block.setType(Material.STONE);
    sender.sendMessage("You placed a Block!"); return true;
    } }   return false; } @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
    if (event.getBlockPlaced().getType() == Material.STONE) {
    event.setCancelled(true); } } }
    
