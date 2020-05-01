package jp.yuyu.SpigotSamplePlugin

import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class Main : JavaPlugin(){
    override fun onEnable() {
        logger.info("Plugin is Running")
        server.pluginManager.registerEvents(EventListener,this)
        getCommand("hello")?.setExecutor(HelloCommand)
    }
}