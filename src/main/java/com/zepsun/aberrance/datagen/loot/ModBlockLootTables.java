package com.zepsun.aberrance.datagen.loot;

import com.zepsun.aberrance.block.ModBlocks;
import com.zepsun.aberrance.block.custom.crop.ModCropBlock;

import com.zepsun.aberrance.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.PARSNIP_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ModCropBlock.AGE, 6));
        this.add(ModBlocks.PARSNIP_CROP.get(), this.createCropDrops(ModBlocks.PARSNIP_CROP.get(), ModItems.PARSNIP.get(), ModItems.PARSNIP_SEEDS.get(), lootitemcondition$builder1));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.WINTER_WHEAT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ModCropBlock.AGE, 6));
        this.add(ModBlocks.WINTER_WHEAT_CROP.get(), this.createCropDrops(ModBlocks.WINTER_WHEAT_CROP.get(), ModItems.WINTER_WHEAT.get(), ModItems.WINTER_WHEAT_SEEDS.get(), lootitemcondition$builder2));

        LootItemCondition.Builder lootitemcondition$builder3 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ONION_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ModCropBlock.AGE, 6));
        this.add(ModBlocks.ONION_CROP.get(), this.createCropDrops(ModBlocks.ONION_CROP.get(), ModItems.ONION.get(), ModItems.ONION.get(), lootitemcondition$builder3));

        this.add(ModBlocks.ACACIA_MESQUITE_LEAVES.get(), block ->
                createSingleItemTable(ModItems.MESQUITE.get()));

        this.add(ModBlocks.SEED_MAKER.get(), block ->
                createSingleItemTable(ModBlocks.SEED_MAKER.get()));



    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }


}
