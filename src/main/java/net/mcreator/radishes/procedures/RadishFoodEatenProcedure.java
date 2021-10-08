package net.mcreator.radishes.procedures;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.util.FoodStats;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.radishes.RadishesMod;

import java.util.Map;

public class RadishFoodEatenProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RadishesMod.LOGGER.warn("Failed to load dependency entity for procedure RadishFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) entity).getFoodStats(), (float) 4, "field_75125_b");
		}
	}
}
