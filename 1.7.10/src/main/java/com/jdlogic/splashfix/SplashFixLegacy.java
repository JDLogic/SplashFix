package com.jdlogic.splashfix;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

@Mod(modid = SplashFixLegacy.MOD_ID, name = SplashFixLegacy.MOD_NAME, version = SplashFixLegacy.MOD_VERSION,
     acceptedMinecraftVersions = SplashFixLegacy.MC_VERSION)
public class SplashFixLegacy
{
    public static final String MOD_ID = "splashfix";
    public static final String MOD_NAME = "Splash Fix";
    public static final String MOD_VERSION = "1.0";
    public static final String MC_VERSION = "[1.7.10,1.8)";

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