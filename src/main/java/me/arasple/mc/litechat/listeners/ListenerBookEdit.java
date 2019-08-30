package me.arasple.mc.litechat.listeners;

import io.izzel.taboolib.module.inject.TListener;
import me.arasple.mc.litechat.LiteChat;
import me.arasple.mc.litechat.utils.MessageColors;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

/**
 * @author Arasple
 * @date 2019/8/15 21:18
 */
@TListener
public class ListenerBookEdit implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBookEdit(PlayerEditBookEvent e) {
        Player p = e.getPlayer();
        if (LiteChat.getSettings().getBoolean("CHAT-CONTROL.COLOR-CODE.BOOK")) {
            BookMeta meta = e.getNewBookMeta();
            meta.setPages(MessageColors.processWithPermission(p, meta.getPages()));
            e.setNewBookMeta(meta);
        }
    }

}