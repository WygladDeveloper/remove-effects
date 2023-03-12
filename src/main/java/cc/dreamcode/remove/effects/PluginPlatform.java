package cc.dreamcode.remove.effects;

import cc.dreamcode.remove.effects.exception.BukkitPluginException;
import cc.dreamcode.remove.effects.task.EffectsCheckTask;
import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import eu.okaeri.configs.yaml.bukkit.serdes.SerdesBukkit;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public abstract class PluginPlatform extends JavaPlugin {
    private PluginConfig config;

    @Override
    public void onEnable() {
        try {
            this.config = ConfigManager.create(PluginConfig.class, (it) -> {
                it.withConfigurer(new YamlBukkitConfigurer(), new SerdesBukkit());
                it.withBindFile("config.yml");
                it.withRemoveOrphans(true);
                it.saveDefaults();
                it.load(true);
            });

            new EffectsCheckTask(this);
        } catch (Exception e) {
            throw new BukkitPluginException("An error was caught when plugin are starting...", e, this);
        }

        this.getLogger().info(String.format("Active version: v%s - Author: %s", getDescription().getVersion(), getDescription().getAuthors()));
    }

    public void runAsync(@NonNull Runnable runnable) {
        this.getServer().getScheduler().runTaskAsynchronously(this, runnable);
    }
}