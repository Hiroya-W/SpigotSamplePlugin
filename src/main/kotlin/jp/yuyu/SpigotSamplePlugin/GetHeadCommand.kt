package jp.yuyu.SpigotSamplePlugin

import jp.yuyu.SpigotSamplePlugin.Util.getColored
import jp.yuyu.SpigotSamplePlugin.Util.getPlayerHead
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object GetHeadCommand : CommandExecutor{

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            if(args.isNotEmpty()){
                val id = args[0]
                @Suppress("DEPRECATION") val player = Bukkit.getOfflinePlayer(id)
                val head = getPlayerHead(player)
                sender.inventory.addItem(head)
                sender.sendMessage(getColored("&b${player.name}&fの頭を取得しました"))
            }else{
                sender.sendMessage(getColored("&c頭を取得するプレイヤーのIDを入力してください"))
            }
        }
        else{
            sender.sendMessage(getColored("&cプレイヤーからのみ実行できるコマンドです"))
        }
        return true
    }
}