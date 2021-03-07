![CustomRecipes Logo](images/customrecipes-logo.png)

## Compatibility

Tested on Spigot-1.16.

## Introduction

A Minecraft (Bukkit) plugin that allows creating custom recipes

## Features

The whole idea of this plugin is that YOU can add a recipe you want. For instance, to add a recipe for panda spawn egg from an egg and bamboos, you can modify the config.yaml file.

At first, add a recipe key "PandaSpawnEgg" to the "enabled-recipes" config section. You may choose any name you want for the recipe key, that is not yet present in the config file.

Then, add the recipe key definition to the end of the config file:

    PandaSpawnEgg:
      name: "Panda Spawn Egg"
      recipe:
        - BAMBOO BAMBOO BAMBOO
        - BAMBOO EGG BAMBOO
        - BAMBOO BAMBOO BAMBOO
      material: PANDA_SPAWN_EGG

### Existing Pig Spawner Recipe
![Pig Spawner](https://raw.githubusercontent.com/uprial/customrecipes/master/images/pig_spawner.png)

### Existing Eggs Recipes
![Blaze](https://raw.githubusercontent.com/uprial/customrecipes/master/images/blaze_spawn_egg.png)
![Creeper](https://raw.githubusercontent.com/uprial/customrecipes/master/images/creeper_spawn_egg.png)
![Drowned](https://raw.githubusercontent.com/uprial/customrecipes/master/images/drowned_spawn_egg.png)
![Enderman](https://raw.githubusercontent.com/uprial/customrecipes/master/images/enderman_spawn_egg.png)
![Ghast](https://raw.githubusercontent.com/uprial/customrecipes/master/images/ghast_spawn_egg.png)
![Magma Cube](https://raw.githubusercontent.com/uprial/customrecipes/master/images/magma_cube_spawn_egg.png)
![Pig](https://raw.githubusercontent.com/uprial/customrecipes/master/images/pig_spawn_egg.png)
![Ravager](https://raw.githubusercontent.com/uprial/customrecipes/master/images/ravager_spawn_egg.png)
![Shulker](https://raw.githubusercontent.com/uprial/customrecipes/master/images/shulker_spawn_egg.png)
![Skeleton](https://raw.githubusercontent.com/uprial/customrecipes/master/images/skeleton_spawn_egg.png)
![Slime](https://raw.githubusercontent.com/uprial/customrecipes/master/images/slime_spawn_egg.png)
![Spider](https://raw.githubusercontent.com/uprial/customrecipes/master/images/spider_spawn_egg.png)
![Wither Skeleton](https://raw.githubusercontent.com/uprial/customrecipes/master/images/wither_skeleton_spawn_egg.png)
![Zombie](https://raw.githubusercontent.com/uprial/customrecipes/master/images/zombie_spawn_egg.png)

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

## Related projects
* CustomNukes: [Bukkit Dev](http://dev.bukkit.org/bukkit-plugins/customnukes/), [GitHub](https://github.com/uprial/customnukes), [Spigot](https://www.spigotmc.org/resources/customnukes.68710/)
* CustomCreatures: [Bukkit Dev](http://dev.bukkit.org/bukkit-plugins/customcreatures/), [GitHub](https://github.com/uprial/customcreatures), [Spigot](https://www.spigotmc.org/resources/customcreatures.68711/)
* CustomDamage: [Bukkit Dev](http://dev.bukkit.org/bukkit-plugins/customdamage/), [GitHub](https://github.com/uprial/customdamage), [Spigot](https://www.spigotmc.org/resources/customdamage.68712/)
* CustomVillage: [Bukkit Dev](http://dev.bukkit.org/bukkit-plugins/customvillage/), [GitHub](https://github.com/uprial/customvillage/), [Spigot](https://www.spigotmc.org/resources/customvillage.69170/)
* TakeAim: [Bukkit Dev](https://dev.bukkit.org/projects/takeaim), [GitHub](https://github.com/uprial/takeaim), [Spigot](https://www.spigotmc.org/resources/takeaim.68713/)
