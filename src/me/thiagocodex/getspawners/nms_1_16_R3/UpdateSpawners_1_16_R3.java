package me.thiagocodex.getspawners.nms_1_16_R3;

import me.thiagocodex.getspawners.Morphable;
import net.minecraft.server.v1_16_R3.BlockPosition;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import net.minecraft.server.v1_16_R3.TileEntityMobSpawner;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

public class UpdateSpawners_1_16_R3 implements Morphable {

    @Override
    public void update(Block blockPlaced, String spawnedType, int spawnCount, int minSpawnDelay, int maxSpawnDelay, boolean isBreaking, boolean isChanging) {
        BlockPosition blockPosition = new BlockPosition(blockPlaced.getX(), blockPlaced.getY(), blockPlaced.getZ());

        TileEntityMobSpawner tileEntityMobSpawner = (TileEntityMobSpawner) ((CraftWorld) blockPlaced.getWorld()).getHandle().getTileEntity(blockPosition);

        NBTTagCompound spawnerTag = tileEntityMobSpawner.b();
        NBTTagCompound spawnData = new NBTTagCompound();
        spawnData.setString("id", "minecraft:" + spawnedType.toLowerCase());
        if (minSpawnDelay == 0) {
            spawnerTag.setInt("SpawnCount", 1);
            spawnerTag.setInt("MinSpawnDelay", 201);
        } else if (minSpawnDelay == 200) {
            spawnerTag.setInt("SpawnCount", 2);
            spawnerTag.setInt("MinSpawnDelay", minSpawnDelay + 2);
            spawnerTag.setInt("MaxSpawnDelay", maxSpawnDelay - 40);
        } else if (isBreaking) {
            spawnerTag.setInt("SpawnCount", spawnCount - 1);
            spawnerTag.setInt("MinSpawnDelay", minSpawnDelay - 1);
            spawnerTag.setInt("MaxSpawnDelay", maxSpawnDelay + 40);
        } else if (isChanging) {
            spawnerTag.setInt("SpawnCount", spawnCount);
            spawnerTag.setInt("MinSpawnDelay", minSpawnDelay);
            spawnerTag.setInt("MaxSpawnDelay", maxSpawnDelay);
        } else {
            spawnerTag.setInt("SpawnCount", spawnCount + 1);
            spawnerTag.setInt("MinSpawnDelay", minSpawnDelay + 1);
            spawnerTag.setInt("MaxSpawnDelay", maxSpawnDelay - 40);
        }
        spawnerTag.set("SpawnData", spawnData);
        tileEntityMobSpawner.getSpawner().a(spawnerTag);
    }
}
