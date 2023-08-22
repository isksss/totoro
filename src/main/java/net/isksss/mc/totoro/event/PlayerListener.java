package net.isksss.mc.totoro.event;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent event){
        Player player = event.getPlayer();
        Location playerLocation = player.getLocation();

        if (!event.isSneaking()){
            return;
        }

        for (int x=-3;x<4;x++){
            for (int z=-3;z<4;z++){
                for(int y=-1;y<2;y++){
                    Block block = playerLocation.clone().add(x,y,z).getBlock();
                    BlockData blockData = block.getBlockData();
                    if (blockData instanceof Ageable ageable){
                        int currentAge = ageable.getAge();
                        if (currentAge < ageable.getMaximumAge()){
                            ageable.setAge(currentAge + 1);
                            block.setBlockData(ageable);
                        }
                    }
                }
            }
        }
    }
}
