package jp.yuyu.SpigotSamplePlugin

import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class Main : JavaPlugin(){
    override fun onEnable() {
        logger.info("Plugin is Running")
        server.pluginManager.registerEvents(EventListener,this)
        registerCommand("hello",HelloCommand)
        registerCommand("head",GetHeadCommand)
        registerCommand("dice",DiceCommand)
    }

    private fun registerCommand(label:String, executor: CommandExecutor){
        getCommand(label)?.run {
            setExecutor(executor)
            logger.info("/$label を登録しました")
        } ?: logger.severe("/$label を登録できませんでした")
    }
}