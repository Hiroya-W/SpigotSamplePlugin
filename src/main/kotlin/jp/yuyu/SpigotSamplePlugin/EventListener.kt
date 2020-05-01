package jp.yuyu.SpigotSamplePlugin

import jp.yuyu.SpigotSamplePlugin.Util.getColored
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent


object EventListener : Listener{
   @EventHandler
   fun on(e:PlayerJoinEvent){
       val p = e.player
       e.joinMessage = getColored("&b${p.displayName}&fがサーバーに入りました")
   }

    @EventHandler
    fun en(e: PlayerQuitEvent){
        val p = e.player
        e.quitMessage = getColored("&b${p.displayName}&fがサーバーを出ました")
    }


}