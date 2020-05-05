package jp.yuyu.SpigotSamplePlugin

import jp.yuyu.SpigotSamplePlugin.Main.Companion.plugin
import jp.yuyu.SpigotSamplePlugin.Util.getColored
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.scheduler.BukkitRunnable

object TimerCommand : CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val seconds = args.getOrNull(0)?.toIntOrNull()
        if(seconds == null){
            sender.sendMessage(getColored("&c秒数を入力してください"))
            return true
        }
        countDownUsingLoop(seconds)
        return true
    }

    private fun sendTitle(seconds: Int){
        Bukkit.getOnlinePlayers().forEach{ player ->
            player.sendTitle(getColored("&9&l$seconds"), "", 0, 15,0)
        }
    }

    private  fun countDownUsingLoop(seconds: Int){
        var remainSeconds = seconds
        object: BukkitRunnable(){
            override fun run(){
                if(0 < remainSeconds){
                    sendTitle(remainSeconds)
                    remainSeconds--
                }else{
                    cancel()
                }
            }
        }.runTaskTimer(plugin,0,20)

    }
}