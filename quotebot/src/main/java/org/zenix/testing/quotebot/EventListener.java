package org.zenix.testing.quotebot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageEvent;

public class EventListener {

    @EventSubscriber
    public void onMessageEvent(MessageEvent event){
        System.out.println(event.getMessage());
    }

    @EventSubscriber
    public void onReadyEvent(ReadyEvent event){
        System.out.println(event.toString());
    }
}
