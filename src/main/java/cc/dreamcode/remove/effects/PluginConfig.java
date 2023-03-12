package cc.dreamcode.remove.effects;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import lombok.Getter;
import org.bukkit.potion.PotionEffectType;

import java.util.Set;

@Getter
public class PluginConfig extends OkaeriConfig {

    @Comment({
            "Światy na których efekty mają być nie dostępne"
    })
    private Set<String> worlds = Set.of(
            "world",
            "world_nether"
    );

    @Comment({
            "Efekty jakie mają być nie dostępne"
    })
    private Set<String> effects = Set.of(
            PotionEffectType.INCREASE_DAMAGE.getName(),
            PotionEffectType.BLINDNESS.getName()
    );
}
