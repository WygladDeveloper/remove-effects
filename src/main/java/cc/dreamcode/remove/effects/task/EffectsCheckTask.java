package cc.dreamcode.remove.effects.task;

import cc.dreamcode.remove.effects.PluginPlatform;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class EffectsCheckTask extends BukkitRunnable {

    private final PluginPlatform platform;

    public EffectsCheckTask(PluginPlatform platform) {
        this.platform = platform;
        this.runTaskTimerAsynchronously(platform, 10L, 10L);
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (this.platform.getConfig().getWorlds().contains(player.getWorld().getName())) {
                for (String effect : this.platform.getConfig().getEffects()) {
                    PotionEffectType potionEffectType = PotionEffectType.getByName(effect);
                    if (potionEffectType == null) {
                        this.platform.getLogger().warning("Nie znaleziono efektu o nazwie: " + effect);
                        return;
                    }
                    player.removePotionEffect(potionEffectType);
                }
            }
        }
    }
}