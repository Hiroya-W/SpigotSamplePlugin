package jp.yuyu.SpigotSamplePlugin

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin(){
    override fun onEnable() {
        logger.info("Plugin is Running");
    }

}