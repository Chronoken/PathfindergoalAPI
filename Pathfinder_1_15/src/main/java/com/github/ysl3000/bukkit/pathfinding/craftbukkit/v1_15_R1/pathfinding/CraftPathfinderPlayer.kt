package com.github.ysl3000.bukkit.pathfinding.craftbukkit.v1_15_R1.pathfinding

import com.github.ysl3000.bukkit.pathfinding.AbstractPathfinderPlayer
import net.minecraft.server.v1_15_R1.EntityPlayer
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer
import org.bukkit.entity.Player

class CraftPathfinderPlayer private constructor(ep: EntityPlayer) :
        AbstractPathfinderPlayer(
                player = { ep.bukkitEntity },
                relativeMotionX = { ep.mot.x },
                relativeMotionY = { ep.mot.y },
                relativeMotionZ = { ep.mot.z },
                relativeMotionYaw = { ep.yaw },
                relativeMotionPitch = { ep.pitch },
                relativeMotionForward = { ep.az },
                relativeMotionSideward = { ep.ba },
                jump = { ep.mot.y > STILL }
        ) {
    constructor(player: Player) : this((player as CraftPlayer).handle)

    companion object {
        private const val STILL = -0.0784000015258789
    }
}