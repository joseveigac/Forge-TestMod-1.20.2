package net.joseveiga.testmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.joseveiga.testmod.TestMod;
import net.joseveiga.testmod.item.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if(event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level 1
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,2),
                    new ItemStack(ModItems.STRAWBERRY.get(),12),
                    10,8,0.02f));
            // Level 2
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,5),
                    new ItemStack(ModItems.CORN.get(),12),
                    6,9,0.035f));

        }
        if(event.getType() == VillagerProfession.LIBRARIAN){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(Enchantments.THORNS, 2));

            // Level 1
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,32),
                    enchantedBook,
                    2,8,0.02f));
        }
    }
    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event){
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(ModItems.SAPPHIRE_HELMET.get(),1),
                4,6,0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 14),
                new ItemStack(ModItems.SAPPHIRE_CHESTPLATE.get(),1),
                4,12,0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.SAPPHIRE_LEGGINGS.get(),1),
                4,9,0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 8),
                new ItemStack(ModItems.SAPPHIRE_BOOTS.get(),1),
                4,4,0.2f));
    }
}
