package com.jdlogic.splashfix;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

@Mod(modid = SplashFix.MOD_ID, name = SplashFix.MOD_NAME, version = SplashFix.MOD_VERSION,
     acceptedMinecraftVersions = SplashFix.MC_VERSION)
public class SplashFix
{
    public static final String MOD_ID = "splashfix";
    public static final String MOD_NAME = "Splash Fix";
    public static final String MOD_VERSION = "@VERSION@";
    public static final String MC_VERSION = "[1.8,1.13)";

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    public static class EventHandler
    {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public void onTextureStitch(TextureStitchEvent.Post event)
        {
            GL11.glFlush();
        }
    }
}