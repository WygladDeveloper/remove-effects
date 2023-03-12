package cc.dreamcode.remove.effects.utilities;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

@UtilityClass
public class ChatUtilities {
    public static String colored(@NonNull String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}