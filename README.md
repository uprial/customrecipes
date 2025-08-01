![CustomRecipes Logo](images/customrecipes-logo.png)

## Compatibility

Tested on Spigot-1.16, 1.19, 1.20, 1.20.6, 1.21.

## Introduction

A Minecraft (Bukkit) plugin that allows to create your own fully customizable recipes; presets: craft a mob spawner, many spawn eggs, etc.

## Features

The whole idea of this plugin is that YOU can add a recipe you want.

For instance, to add a recipe for spawner, you can modify the config.yaml file.

At first, add a recipe key "Spawner" to the "enabled-recipes" config section. You may choose any name you want for the recipe key, that is not yet present in the config file.

Then, add the recipe key definition to the end of the config file:

    Spawner:
      recipe:
        - PORKCHOP CLOCK PORKCHOP
        - CLOCK DIAMOND_BLOCK CLOCK
        - IRON_BLOCK CLOCK IRON_BLOCK
      material: SPAWNER

The recipe will look like:
![Spawner](https://raw.githubusercontent.com/uprial/customrecipes/master/images/spawner.png)

### Existing Spawn Eggs Recipes
![Armadillo](https://raw.githubusercontent.com/uprial/customrecipes/master/images/armadillo_spawn_egg.png)
![Bee](https://raw.githubusercontent.com/uprial/customrecipes/master/images/bee_spawn_egg.png)
![Blaze](https://raw.githubusercontent.com/uprial/customrecipes/master/images/blaze_spawn_egg.png)
![Breeze](https://raw.githubusercontent.com/uprial/customrecipes/master/images/breeze_spawn_egg.png)
![Cod](https://raw.githubusercontent.com/uprial/customrecipes/master/images/cod_spawn_egg.png)
![Cow](https://raw.githubusercontent.com/uprial/customrecipes/master/images/cow_spawn_egg.png)
![Creeper](https://raw.githubusercontent.com/uprial/customrecipes/master/images/creeper_spawn_egg.png)
![Drowned](https://raw.githubusercontent.com/uprial/customrecipes/master/images/drowned_spawn_egg.png)
![Elder Guardian](https://raw.githubusercontent.com/uprial/customrecipes/master/images/elder_guardian_spawn_egg.png)
![Enderman](https://raw.githubusercontent.com/uprial/customrecipes/master/images/enderman_spawn_egg.png)
![Evoker](https://raw.githubusercontent.com/uprial/customrecipes/master/images/evoker_spawn_egg.png)
![Ghast](https://raw.githubusercontent.com/uprial/customrecipes/master/images/ghast_spawn_egg.png)
![Glow Squid](https://raw.githubusercontent.com/uprial/customrecipes/master/images/glow_squid_spawn_egg.png)
![Magma Cube](https://raw.githubusercontent.com/uprial/customrecipes/master/images/magma_cube_spawn_egg.png)
![Panda](https://raw.githubusercontent.com/uprial/customrecipes/master/images/panda_spawn_egg.png)
![Parrot](https://raw.githubusercontent.com/uprial/customrecipes/master/images/parrot_spawn_egg.png)
![Phantom](https://raw.githubusercontent.com/uprial/customrecipes/master/images/phantom_spawn_egg.png)
![Pig](https://raw.githubusercontent.com/uprial/customrecipes/master/images/pig_spawn_egg.png)
![Pillager](https://raw.githubusercontent.com/uprial/customrecipes/master/images/pillager_spawn_egg.png)
![Pufferfish](https://raw.githubusercontent.com/uprial/customrecipes/master/images/pufferfish_spawn_egg.png)
![Rabbit](https://raw.githubusercontent.com/uprial/customrecipes/master/images/rabbit_spawn_egg.png)
![Ravager](https://raw.githubusercontent.com/uprial/customrecipes/master/images/ravager_spawn_egg.png)
![Salmon](https://raw.githubusercontent.com/uprial/customrecipes/master/images/salmon_spawn_egg.png)
![Sheep](https://raw.githubusercontent.com/uprial/customrecipes/master/images/sheep_spawn_egg.png)
![Shulker](https://raw.githubusercontent.com/uprial/customrecipes/master/images/shulker_spawn_egg.png)
![Skeleton](https://raw.githubusercontent.com/uprial/customrecipes/master/images/skeleton_spawn_egg.png)
![Slime](https://raw.githubusercontent.com/uprial/customrecipes/master/images/slime_spawn_egg.png)
![Spider](https://raw.githubusercontent.com/uprial/customrecipes/master/images/spider_spawn_egg.png)
![Squid](https://raw.githubusercontent.com/uprial/customrecipes/master/images/squid_spawn_egg.png)
![Tropical Fish](https://raw.githubusercontent.com/uprial/customrecipes/master/images/tropical_fish_spawn_egg.png)
![Turtle](https://raw.githubusercontent.com/uprial/customrecipes/master/images/turtle_spawn_egg.png)
![Vindicator](https://raw.githubusercontent.com/uprial/customrecipes/master/images/vindicator_spawn_egg.png)
![Warden](https://raw.githubusercontent.com/uprial/customrecipes/master/images/warden_spawn_egg.png)
![Wither Skeleton](https://raw.githubusercontent.com/uprial/customrecipes/master/images/wither_skeleton_spawn_egg.png)
![Zombie](https://raw.githubusercontent.com/uprial/customrecipes/master/images/zombie_spawn_egg.png)

### Existing Other Recipes
![Sponge](https://raw.githubusercontent.com/uprial/customrecipes/master/images/sponge.png)
![Prismarine](https://raw.githubusercontent.com/uprial/customrecipes/master/images/prismarine.png)

## Commands

`customrecipes reload` - reload config from disk

## Permissions

* Access to 'reload' command:
`customrecipes.reload` (default: op)

## Configuration
[Default configuration file](src/main/resources/config.yml)

## Author
I will be happy to add some features or fix bugs. My mail: uprial@gmail.com.

## Useful links
* [Project on GitHub](https://github.com/uprial/customrecipes/)
* [Project on Bukkit Dev](https://dev.bukkit.org/projects/custom-recipes)
* [Project on Spigot](https://www.spigotmc.org/resources/customrecipes.89435/)
* [TODO list](TODO.md)

## Related projects
* CustomBazookas: [Bukkit Dev](https://legacy.curseforge.com/minecraft/bukkit-plugins/custombazookas/) [GitHub](https://github.com/uprial/custombazookas), [Spigot](https://www.spigotmc.org/resources/custombazookas.124997/)
* CustomCreatures: [Bukkit Dev](http://dev.bukkit.org/bukkit-plugins/customcreatures/), [GitHub](https://github.com/uprial/customcreatures), [Spigot](https://www.spigotmc.org/resources/customcreatures.68711/)
* CustomNukes: [Bukkit Dev](http://dev.bukkit.org/bukkit-plugins/customnukes/), [GitHub](https://github.com/uprial/customnukes), [Spigot](https://www.spigotmc.org/resources/customnukes.68710/)
* CustomVillage: [Bukkit Dev](http://dev.bukkit.org/bukkit-plugins/customvillage/), [GitHub](https://github.com/uprial/customvillage/), [Spigot](https://www.spigotmc.org/resources/customvillage.69170/)
* MasochisticSurvival: [Bukkit Dev](https://legacy.curseforge.com/minecraft/bukkit-plugins/masochisticsurvival/), [GitHub](https://github.com/uprial/masochisticsurvival/), [Spigot](https://www.spigotmc.org/resources/masochisticsurvival.124943/)
* TakeAim: [Bukkit Dev](https://dev.bukkit.org/projects/takeaim), [GitHub](https://github.com/uprial/takeaim), [Spigot](https://www.spigotmc.org/resources/takeaim.68713/)
