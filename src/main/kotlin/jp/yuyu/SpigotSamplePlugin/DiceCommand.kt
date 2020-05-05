package jp.yuyu.SpigotSamplePlugin

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import jp.yuyu.SpigotSamplePlugin.Util.getColored
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object DiceCommand: CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val max = args.getOrNull(0)?.toIntOrNull()
        val count = args.getOrNull(1)?.toIntOrNull()
        if(max == null){
            sender.sendMessage(getColored("&cサイコロの目を整数で入力してください"))
            return true
        }
        if(max < 1){
            sender.sendMessage(getColored("&cサイコロの目は1以上を入力してください"))
            return true
        }

        if(count == null){
            sender.sendMessage(getColored("&cサイコロの数を整数で入力してください"))
            return true
        }
        if(count < 1){
            sender.sendMessage(getColored("&cサイコロの数は1以上を入力してください"))
            return true
        }
        val diceList = rollDice(max,count)
        val result = "&6${diceList.sum()}&7(${diceList.joinToString()})"
        if(sender is Player){
            val message = getColored("&b[Dice] &6${sender.displayName} &fがサイコロを振りました $result")
            sender.getNearbyEntities(10.0,10.0,10.0).forEach{ entity ->
                if(entity is Player){
                    entity.sendMessage(message)
                }
            }
            sender.sendMessage(getColored("&b[Dice] &fサイコロを振りました $result"))
        }else{
            val message = getColored("&b[Dice] &6サーバー &fがサイコロを振りました $result")
            Bukkit.broadcastMessage(message)
        }
        return true
    }

    private fun rollDice(max: Int, count: Int): List<Int>{
        val result = mutableListOf<Int>()
        for(i in 0 until count){
            result.add((1..max).random())
        }
        return result
    }
}