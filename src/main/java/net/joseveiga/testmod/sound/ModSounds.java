package net.joseveiga.testmod.sound;

import net.joseveiga.testmod.TestMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TestMod.MOD_ID);

    public static final RegistryObject<SoundEvent> METAL_DETECTOR_FOUND_ORE = registerSoundEvent("metal_detector_found_ore");

    public static final RegistryObject<SoundEvent> SOUND_ISMAEL_GRITO = registerSoundEvent("ismael_grito");
    public static final RegistryObject<SoundEvent> SOUND_ISMAEL_COME = registerSoundEvent("ismael_come");

    public static final RegistryObject<SoundEvent> SOUND_BLOCK_BREAK = registerSoundEvent("sound_block_break");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_STEP = registerSoundEvent("sound_block_step");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_FALL = registerSoundEvent("sound_block_fall");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_PLACE = registerSoundEvent("sound_block_place");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_HIT = registerSoundEvent("sound_block_hit");


    public static final ForgeSoundType SOUND_BLOCK_SOUNDS = new ForgeSoundType(1f,1f,
            ModSounds.SOUND_BLOCK_BREAK, SOUND_BLOCK_STEP, SOUND_BLOCK_PLACE, SOUND_BLOCK_HIT, SOUND_BLOCK_FALL);

    public static final ForgeSoundType ISMAEL_BLOCK_SOUNDS = new ForgeSoundType(1f,1f,
            ModSounds.SOUND_ISMAEL_GRITO, SOUND_ISMAEL_COME, SOUND_ISMAEL_COME, SOUND_ISMAEL_GRITO, SOUND_ISMAEL_COME);


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(TestMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
