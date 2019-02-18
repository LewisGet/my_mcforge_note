package com.lj.sence;

import com.lj.sence.Entity.EntityTestChickenRegistry;
/*
import com.lj.sence.Entity.TestChicken;
import com.lj.sence.Entity.render.RenderTestChicken;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
*/
import com.lj.sence.Entity.TestChickenEntity;
import com.lj.sence.Entity.render.TestChickenRender;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.common.MinecraftForge;
/*
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
*/
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod.Instance;
//import org.apache.logging.log4j.Logger;

@Mod(modid = Sence.MODID, name = Sence.NAME, version = Sence.VERSION)
public class Sence
{
    @Instance
    public static Sence instance;

    public static final String MODID = "sence";
    public static final String NAME = "lj media sence";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        EntityTestChickenRegistry.createTestChickenEntity();

        RenderingRegistry.registerEntityRenderingHandler(TestChickenEntity.class, new IRenderFactory<TestChickenEntity>() {
            @java.lang.Override
            public Render<? super TestChickenEntity> createRenderFor(RenderManager manager) {
                return new TestChickenRender(manager);
            }
        });
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new com.lj.sence.EventHandler());
    }
}
