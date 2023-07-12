package com.zepsun.zecrops.datagen.loot;

import com.zepsun.zecrops.block.ModBlocks;
import com.zepsun.zecrops.block.crop.ModCropBlock;

import com.zepsun.zecrops.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
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
        this.add(ModBlocks.WINTER_WHEAT_CROP.get(), this.createCropDrops(ModBlocks.WINTER_WHEAT_CROP.get(), ModItems.WINTER_WHEAT.get(), ModItems.WINTER_WHEAT_SEEDS.get(), lootitemcondition$builder1));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
