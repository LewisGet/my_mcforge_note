package com.lj.sence;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

public class EventHandler {

    public static KeyBinding function_key;

    public EventHandler () {

        KeyBinding keyInput = new KeyBinding("test", Keyboard.KEY_V, "test2");

        ClientRegistry.registerKeyBinding(keyInput);

        function_key = keyInput;
    }

    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {
        EntityPlayer player = event.getEntityPlayer();

        ITextComponent spawn_message = new TextComponentString("hello");

        player.sendMessage(spawn_message);

        EntityChicken chicken = new EntityChicken(player.world) {
            @java.lang.Override
            public void onUpdate() {
                super.onUpdate();

                Logger logs = LogManager.getLogger("update");

                // 建立一個一次性使用的 class 且包含著原本本質的物件。
                // 這樣就無須想要特定修改的物件，就寫一個獨立的實體
                // 比如只想要叫一隻殭屍，而且這血量特別多 (這情形也可以直接設定參數)
                // 但如果類似，我想叫出這殭屍，但他不攻擊人類。就需要這樣寫法了。
                logs.info("this message send by modifies class at create it.");
            }
        };

        chicken.copyLocationAndAnglesFrom(player);
        player.world.spawnEntity(chicken);
    }

    @SubscribeEvent
    public void playerEvent(LivingEvent e)
    {
        Entity entity = e.getEntity();

        if (entity == null)
        {
            return;
        }

        String name = entity.getName();

        // player name is for dev
        if (name.contains("LewisJang") || name.contains("Player"))
        {
            // do something
        }
    }

    @SubscribeEvent
    public void inputEvent(InputEvent.KeyInputEvent e)
    {
        Logger logs = LogManager.getLogger("input event");
        logs.info(function_key.isKeyDown());
    }
}
