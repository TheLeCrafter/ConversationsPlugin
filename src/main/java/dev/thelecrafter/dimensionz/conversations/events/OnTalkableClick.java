package dev.thelecrafter.dimensionz.conversations.events;

import dev.thelecrafter.dimensionz.conversations.config.FileManager;
import dev.thelecrafter.dimensionz.conversations.utils.Conversation;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnTalkableClick implements Listener {

    @EventHandler
    public void onInteract(NPCRightClickEvent event) {
        event.setCancelled(true);
        if (!Conversation.IN_CONVERSATION.contains(event.getClicker())) {
            Conversation.sendPlayerConversation(event.getClicker(), event.getNPC(), FileManager.get().getStringList("conversations." + event.getNPC().getId()), 0);
        }
    }

}
