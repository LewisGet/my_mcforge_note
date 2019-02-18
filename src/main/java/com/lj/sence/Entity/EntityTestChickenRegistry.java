package com.lj.sence.Entity;

import com.lj.sence.Sence;
import com.lj.sence.config;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityTestChickenRegistry
{
    public static void createEntity(Class<? extends Entity> entity_class, String entity_name, int egg_main_color, int egg_sub_color)
    {
        ResourceLocation registry_name = new ResourceLocation(config.mod_name + ":" + entity_name);

        //int last_global_entity_uuid = EntityRegistry.
        EntityRegistry.registerModEntity(
                registry_name,
                entity_class,
                entity_name,
                120,
                Sence.instance,
                64,
                1,
                true,
                egg_main_color,
                egg_sub_color
        );
    }

    public static void createTestChickenEntity()
    {
        createEntity(TestChickenEntity.class, "testChicken", 0, 0);
    }
}
