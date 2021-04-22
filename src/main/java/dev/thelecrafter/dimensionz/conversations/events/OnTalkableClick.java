package dev.thelecrafter.dimensionz.conversations.events;

import dev.thelecrafter.dimensionz.conversations.utils.Conversation;
import dev.thelecrafter.dimensionz.conversations.utils.TalkableUtils;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.Objects;

public class OnTalkableClick implements Listener {

    @EventHandler
    public void onInteract(NPCRightClickEvent event) {
        event.setCancelled(true);
        if (!Conversation.IN_CONVERSATION.contains(event.getClicker())) {
            Conversation.sendPlayerConversation(event.getClicker(), event.getNPC(), Conversation.fromTalkable(Objects.requireNonNull(TalkableUtils.fromNPCId(event.getNPC().getId()))), 0);
        }
    }

}
