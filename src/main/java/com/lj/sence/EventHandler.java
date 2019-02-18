package com.lj.sence;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {
        EntityPlayer player = event.getEntityPlayer();

        ITextComponent spawn_message = new TextComponentString("hello");

        player.sendMessage(spawn_message);

        EntityChicken chicken = new EntityChicken(player.world);
        chicken.copyLocationAndAnglesFrom(player);
        player.world.spawnEntity(chicken);
    }

    @SubscribeEvent
    public void chickenAttack(LivingEvent e)
    {
        Entity entity = e.getEntity();
    }
}
