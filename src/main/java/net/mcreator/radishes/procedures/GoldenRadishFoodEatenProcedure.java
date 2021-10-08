package net.mcreator.radishes.procedures;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.util.FoodStats;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.radishes.RadishesMod;

import java.util.Map;

public class GoldenRadishFoodEatenProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RadishesMod.LOGGER.warn("Failed to load dependency entity for procedure GoldenRadishFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 4800, (int) 0, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 200, (int) 1, (false), (false)));
		if (entity instanceof PlayerEntity) {
			ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) entity).getFoodStats(),
					(float) (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getSaturationLevel() : 0) + 9),
					"field_75125_b");
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getFoodStats()
					.setFoodLevel((int) (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getFoodLevel() : 0) + 7));
	}
}
