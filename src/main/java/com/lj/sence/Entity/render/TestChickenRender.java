package com.lj.sence.Entity.render;

import com.lj.sence.Entity.TestChickenEntity;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class TestChickenRender extends RenderLiving<TestChickenEntity>
{
    public TestChickenRender(RenderManager manager)
    {
        super(manager, new ModelChicken(), 1.0f);
    }

    @Nullable
    @java.lang.Override
    protected ResourceLocation getEntityTexture(TestChickenEntity entity) {
        return new ResourceLocation("minecraft", "textures/entity/chicken.png");
    }
}
