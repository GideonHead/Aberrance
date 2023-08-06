package com.zepsun.aberrance.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.zepsun.aberrance.dimensiongen.ModDimensions;
import com.zepsun.aberrance.dimensiongen.portal.AbyssTeleporter;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;

import javax.swing.text.html.parser.Entity;

public class AbyssTPCommand {
    public AbyssTPCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("tpabyss").executes(this::execute));
    }

    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        BlockPos pos = player.getOnPos();

        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            ResourceKey<Level> resourcekey = player.level().dimension() == ModDimensions.ABYSS_LEVEL_KEY ?
                    Level.OVERWORLD : ModDimensions.ABYSS_LEVEL_KEY;
            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            if (portalDimension != null && !player.isPassenger()) {
                if(resourcekey == ModDimensions.ABYSS_LEVEL_KEY) {
                    player.changeDimension(portalDimension, new AbyssTeleporter(pos, true));
                } else {
                    player.changeDimension(portalDimension, new AbyssTeleporter(pos, false));
                }
            }
        }

        return 1;
    }
}
