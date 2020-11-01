package me.thiagocodex.getspawners.nms_1_13_R1;

import net.minecraft.server.v1_13_R1.NBTTagCompound;
import org.bukkit.craftbukkit.v1_13_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public abstract class ItemStack_1_13_R1 {
    public static ItemStack itemStack(ItemStack itemStack, String spawnerType) {
        net.minecraft.server.v1_13_R1.ItemStack stack = CraftItemStack.asNMSCopy(itemStack);
        NBTTagCompound tag = stack.getTag() != null ? stack.getTag() : new NBTTagCompound();
        tag.setString("SpawnedType", spawnerType);
        stack.setTag(tag);
        return CraftItemStack.asCraftMirror(stack);
    }

    public static String getTag(ItemStack itemStack) {
        net.minecraft.server.v1_13_R1.ItemStack stack = CraftItemStack.asNMSCopy(itemStack);
        NBTTagCompound tag = stack.getTag() != null ? stack.getTag() : new NBTTagCompound();
        return tag.getString("SpawnedType");
    }
}
