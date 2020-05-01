package jp.yuyu.SpigotSamplePlugin

import org.bukkit.ChatColor

object Util {
    fun getColored(text: String) : String{
        return ChatColor.translateAlternateColorCodes('&',text)
    }
}