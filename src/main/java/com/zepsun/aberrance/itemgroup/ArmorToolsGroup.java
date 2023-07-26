package com.zepsun.aberrance.itemgroup;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockBehaviour;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class ArmorToolsGroup {

    @Nullable
    private Item materialItem;

    @Nullable
    private Item swordItem;
    @Nullable
    private Item pickaxeItem;
    @Nullable
    private Item shovelItem;
    @Nullable
    private Item axeItem;
    @Nullable
    private Item hoeItem;

    @Nullable
    private Item helmetItem;
    @Nullable
    private Item chestplateItem;
    @Nullable
    private Item leggingsItem;
    @Nullable
    private Item bootsItem;

    public ArmorToolsGroup(@Nullable Item inputMaterialItem, @Nullable Item inputSwordItem, @Nullable Item inputPickaxeItem, @Nullable Item inputShovelItem,
                           @Nullable Item inputAxeItem, @Nullable Item inputHoeItem, @Nullable Item inputHelmetItem, @Nullable Item inputChestplateItem,
                           @Nullable Item inputLeggingsItem, @Nullable Item inputBootsItem) {
        materialItem = inputMaterialItem;

        swordItem = inputSwordItem;
        pickaxeItem = inputPickaxeItem;
        shovelItem = inputShovelItem;
        axeItem = inputAxeItem;
        hoeItem = inputHoeItem;

        helmetItem = inputHelmetItem;
        chestplateItem = inputChestplateItem;
        leggingsItem = inputLeggingsItem;
        bootsItem = inputBootsItem;
    }

    @Nullable
    public Item getMaterialItem() {
        return materialItem;
    }

    @Nullable
    public Item getSwordItem() {
        return swordItem;
    }

    @Nullable
    public Item getPickaxeItem() {
        return pickaxeItem;
    }

    @Nullable
    public Item getShovelItem() {
        return shovelItem;
    }

    @Nullable
    public Item getAxeItem() {
        return axeItem;
    }

    @Nullable
    public Item getHoeItem() {
        return hoeItem;
    }

    @Nullable
    public Item getHelmetItem() {
        return helmetItem;
    }

    @Nullable
    public Item getChestplateItem() {
        return chestplateItem;
    }

    @Nullable
    public Item getLeggingsItem() {
        return leggingsItem;
    }

    @Nullable
    public Item getBootsItem() {
        return bootsItem;
    }
}
