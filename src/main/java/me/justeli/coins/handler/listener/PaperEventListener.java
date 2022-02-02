package me.justeli.coins.handler.listener;

import me.justeli.coins.Coins;
import me.justeli.coins.event.PickupEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;

/** Created by Eli on September 13, 2020. */
public class PaperEventListener
        implements Listener
{
    private final Coins coins;

    public PaperEventListener (Coins coins)
    {
        this.coins = coins;
    }

    @EventHandler
    public void paperPickupEvent (PlayerAttemptPickupItemEvent event)
    {
        PickupEvent registerEvent = new PickupEvent(event.getPlayer(), event.getItem());
        this.coins.getServer().getPluginManager().callEvent(registerEvent);

        if (registerEvent.isCancelled())
        {
            event.setCancelled(true);
        }
    }
}