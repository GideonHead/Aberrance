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

        this.add(ModBlocks.KYANITE_ORE.get(), block ->
                createSingleItemTable(ModItems.RAW_KYANITE.get()));
        this.add(ModBlocks.KYANITE_ORE_DEEPSLATE.get(), block ->
                createSingleItemTable(ModItems.RAW_KYANITE.get()));
        this.add(ModBlocks.KYANITE_ORE_END.get(), block ->
                createSingleItemTable(ModItems.RAW_KYANITE.get()));
        this.add(ModBlocks.KYANITE_ORE_NETHER.get(), block ->
                createSingleItemTable(ModItems.RAW_KYANITE.get()));

        this.add(ModBlocks.RUDANIUM_ORE.get(), block ->
                createSingleItemTable(ModItems.RAW_RUDANIUM.get()));
        this.add(ModBlocks.RUDANIUM_ORE_DEEPSLATE.get(), block ->
                createSingleItemTable(ModItems.RAW_RUDANIUM.get()));
        this.add(ModBlocks.RUDANIUM_ORE_END.get(), block ->
                createSingleItemTable(ModItems.RAW_RUDANIUM.get()));
        this.add(ModBlocks.RUDANIUM_ORE_NETHER.get(), block ->
                createSingleItemTable(ModItems.RAW_RUDANIUM.get()));

        this.add(ModBlocks.WILD_ONION_PLANT.get(), block ->
                createSingleItemTable(ModItems.ONION.get()));
        this.add(ModBlocks.WILD_WINTER_WHEAT_PLANT.get(), block ->
                createSingleItemTable(ModItems.WINTER_WHEAT.get()));
        this.add(ModBlocks.WILD_PARSNIP_PLANT.get(), block ->
                createSingleItemTable(ModItems.PARSNIP.get()));


        this.dropSelf(ModBlocks.CREPE_MYRTLE_STAIRS.get());
        this.add(ModBlocks.CREPE_MYRTLE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CREPE_MYRTLE_SLAB.get()));
        this.dropSelf(ModBlocks.CREPE_MYRTLE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CREPE_MYRTLE_LOG.get());
        this.dropSelf(ModBlocks.CREPE_MYRTLE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CREPE_MYRTLE_WOOD.get());
        this.dropSelf(ModBlocks.CREPE_MYRTLE_PLANKS.get());
        this.dropSelf(ModBlocks.CREPE_MYRTLE_SAPLING.get());
        this.dropSelf(ModBlocks.CREPE_MYRTLE_COMPOST.get());
        this.add(ModBlocks.CREPE_MYRTLE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.CREPE_MYRTLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.CREPE_MYRTLE_TRAPDOOR.get());
        this.add(ModBlocks.CREPE_MYRTLE_DOOR.get(), block ->
                createDoorTable(ModBlocks.CREPE_MYRTLE_DOOR.get()));
        this.dropSelf(ModBlocks.CREPE_MYRTLE_BUTTON.get());
        this.dropSelf(ModBlocks.CREPE_MYRTLE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.CREPE_MYRTLE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.CREPE_MYRTLE_FENCE.get());

        this.dropSelf(ModBlocks.LIVE_OAK_STAIRS.get());
        this.dropSelf(ModBlocks.LIVE_OAK_LOG.get());
        this.dropSelf(ModBlocks.LIVE_OAK_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_LIVE_OAK_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_LIVE_OAK_WOOD.get());
        this.dropSelf(ModBlocks.LIVE_OAK_PLANKS.get());
        this.dropSelf(ModBlocks.LIVE_OAK_SAPLING.get());
        this.add(ModBlocks.LIVE_OAK_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.LIVE_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.LIVE_OAK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIVE_OAK_SLAB.get()));
        this.dropSelf(ModBlocks.LIVE_OAK_TRAPDOOR.get());
        this.add(ModBlocks.LIVE_OAK_DOOR.get(), block ->
                createDoorTable(ModBlocks.LIVE_OAK_DOOR.get()));
        this.dropSelf(ModBlocks.LIVE_OAK_BUTTON.get());
        this.dropSelf(ModBlocks.LIVE_OAK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.LIVE_OAK_FENCE_GATE.get());
        this.dropSelf(ModBlocks.LIVE_OAK_FENCE.get());

        this.dropSelf(ModBlocks.BROADLEAF_STAIRS.get());
        this.dropSelf(ModBlocks.BROADLEAF_LOG.get());
        this.dropSelf(ModBlocks.BROADLEAF_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_BROADLEAF_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_BROADLEAF_WOOD.get());
        this.dropSelf(ModBlocks.BROADLEAF_PLANKS.get());
        this.dropSelf(ModBlocks.BROADLEAF_SAPLING.get());
        this.add(ModBlocks.BROADLEAF_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.BROADLEAF_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.BROADLEAF_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BROADLEAF_SLAB.get()));
        this.dropSelf(ModBlocks.BROADLEAF_TRAPDOOR.get());
        this.add(ModBlocks.BROADLEAF_DOOR.get(), block ->
                createDoorTable(ModBlocks.BROADLEAF_DOOR.get()));
        this.dropSelf(ModBlocks.BROADLEAF_BUTTON.get());
        this.dropSelf(ModBlocks.BROADLEAF_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.BROADLEAF_FENCE_GATE.get());
        this.dropSelf(ModBlocks.BROADLEAF_FENCE.get());

        this.dropSelf(ModBlocks.BROADLEAF_PLANKS.get());

        this.dropSelf(ModBlocks.WHITE_COBBLESTONE.get());
        this.dropSelf(ModBlocks.WHITE_COBBLESTONE_WALL.get());
        this.dropSelf(ModBlocks.WHITE_STONE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.WHITE_STONE_BRICKS.get());
        this.dropSelf(ModBlocks.WHITE_STONE.get());
        this.dropSelf(ModBlocks.WHITE_STONE_WALL.get());
        this.dropSelf(ModBlocks.WHITE_STONE_STAIRS.get());
        this.add(ModBlocks.WHITE_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WHITE_STONE_SLAB.get()));
        this.dropSelf(ModBlocks.WHITE_COBBLESTONE_STAIRS.get());
        this.add(ModBlocks.WHITE_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WHITE_COBBLESTONE_SLAB.get()));
        this.dropSelf(ModBlocks.WHITE_STONE_BRICK_STAIRS.get());
        this.add(ModBlocks.WHITE_STONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WHITE_STONE_BRICK_SLAB.get()));

        this.dropSelf(ModBlocks.COBBLESTONE_CASE.get());
        this.dropSelf(ModBlocks.ACACIA_MESQUITE_SAPLING.get());
        this.dropSelf(ModBlocks.KYANITE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_KYANITE_BLOCK.get());
        this.dropSelf(ModBlocks.RUDANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_RUDANIUM_BLOCK.get());

        this.dropSelf(ModBlocks.STARVED_SOUL_SOIL.get());

        this.dropSelf(ModBlocks.SOUL_SEDIMENT.get());
        this.dropSelf(ModBlocks.STARVED_SOUL_GRASS.get());
        this.dropSelf(ModBlocks.STARVED_SOUL_GRASS_BLOCK.get());
        this.dropSelf(ModBlocks.STARVED_STEM.get());
        this.dropSelf(ModBlocks.STARVED_HYPHAE.get());
        this.dropSelf(ModBlocks.STARVED_FUNGUS.get());
        this.dropSelf(ModBlocks.STARVED_SPORE.get());

        this.dropSelf(ModBlocks.MURDEROUS_SOUL_GRASS.get());
        this.dropSelf(ModBlocks.MURDEROUS_SOUL_SOIL.get());



    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }


}
