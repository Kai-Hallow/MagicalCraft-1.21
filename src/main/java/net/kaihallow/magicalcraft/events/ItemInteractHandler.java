package net.kaihallow.magicalcraft.events;

import net.kaihallow.magicalcraft.item.ModItems;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class ItemInteractHandler
{
    @SubscribeEvent
    public void onRightClick(PlayerInteractEvent.RightClickItem event){
        Player player = event.getEntity();
        Level level = event.getLevel();
        ItemStack heldItem = event.getItemStack();

        //check if player is looking at an entity
        if (!level.isClientSide && heldItem.getItem() == ModItems.SCEPTER.get()) {
            double reach = 5.0D;

            Vec3 eyePos = player.getEyePosition(1.0F);
            Vec3 lookVec = player.getViewVector(1.0F).normalize();
            Vec3 endVec = eyePos.add(lookVec.scale(reach));

            AABB box = new AABB(eyePos, endVec).inflate(0.5);


            List<ItemEntity> itemLookedAt = level.getEntitiesOfClass(ItemEntity.class, box);

            ItemEntity closestHit = null;
            double closestDist = Double.MAX_VALUE;

            for (ItemEntity onGround : itemLookedAt) {
                //inflation is optional, just a slight increase in radius for the item's hitbox for player view
                AABB itemBox = onGround.getBoundingBox().inflate(0.25);
                ItemStack groundStack = onGround.getItem();

                Vec3 hit = itemBox.clip(eyePos, endVec).orElse(null);

                if (hit != null) {
                    double distance = eyePos.distanceTo(hit);
                    if (distance < closestDist) {
                        closestDist = distance;
                        closestHit = onGround;
                    }
                }
            }

            if (closestHit != null) {
                ItemStack groundStack = closestHit.getItem();

                if (groundStack.getItem() == Items.BOOK){
                    closestHit.discard(); //remove item

                    ItemEntity replacement = new ItemEntity(level,
                            closestHit.getX(), closestHit.getY(), closestHit.getZ(),
                            new ItemStack(ModItems.TOME.get()));

                    level.addFreshEntity(replacement);

                }
            }
        }
    }
}
