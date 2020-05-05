package jp.yuyu.SpigotSamplePlugin

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.OfflinePlayer
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

object Util {
    fun getColored(text: String) : String{
        return ChatColor.translateAlternateColorCodes('&',text)
    }

    fun getPlayerHead(player : OfflinePlayer) : ItemStack{
        val head = ItemStack(Material.PLAYER_HEAD)
        val meta = head.itemMeta
        if(meta is SkullMeta){
            meta.owningPlayer = player
            head.itemMeta = meta
        }
        return head
    }
}