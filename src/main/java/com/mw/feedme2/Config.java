package com.mw.feedme2;

import com.mw.feedme2.challenges.Collectable;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public final class Config
{
    public static int STARTING_LIVES;
    public static int WARMUP_TIME;
    public static int ROUND_TIME;

    /*
    §6 - Player
    §d - Time
    §a - Round
    §c - FeedMe
    §4 - Monster
    §e - Challenge
     */

    public static final String STR_SEPARATOR = "=====================================================";
    public static final String STR_NEW_GAME = "§6%s §fstarted a new game on §around %d";
    public static final String STR_STOP_GAME = "§6%s §fended the game on §around %d";
    public static final String STR_WARMUP_ENDS = "Warmup ends in §d%s";
    public static final String STR_ALREADY_RUNNING = "There is already a game running";
    public static final String STR_NO_RUNNING = "There is no game currently running";
    public static final String STR_PRINT_LIVES = "§6%s §f: §c";
    public static final String STR_STARTING_ROUND = "Starting §around %d§f...";
    public static final String STR_ROUND_ENDS = "The round ends in §d%s";
    public static final String STR_ROUND_OVER = "§aRound %d §fis over!";
    public static final String STR_PLAYER_FAILED = "§6%s §ffailed to complete the challenge";
    public static final String STR_ALL_SUCCEED = "All players completed the challenge";
    public static final String STR_ALL_FAILED = "All players failed the challenge. Restarting the round...";
    public static final String STR_COMPLETE = "You have §d%s §fto complete the following:";
    public static final String STR_ONE_PLAYER = "A minimum of two players is required to start a game";
    public static final String STR_WINNER = "§6%s §fis the winner!";
    public static final String STR_PAUSED = "§6%s §fpaused the game";
    public static final String STR_RESUMED = "§6%s §fresumed the game";
    public static final String STR_ALREADY_PAUSED = "The game is already paused";
    public static final String STR_ALREADY_RESUMED = "The game is already running";
    public static final String STR_UNKNOWN_PLAYER = "Couldn't find player §6%s";
    public static final String STR_SET_LIVES = "§6%s §fset §6%s§f's lives to §c%d";


    public static final ArrayList<ArrayList<ConfigCollectable>> collectableTiers = new ArrayList<>();
    public static final int[] TIER_COSTS = new int[] {15, 30, 45, 60, 75};

    public static void loadConfig()
    {
        STARTING_LIVES = 3;
        WARMUP_TIME = 120;
        ROUND_TIME = 300;

        ////////////// TIER 1 //////////////
        ArrayList<ConfigCollectable> tier1 = new ArrayList<>(List.of(
                new ConfigCollectable(new Material[]{Material.OAK_LOG},
                                      new int[]{12, 16, 20},
                                      new String[]{"Oak Logs"}),
                new ConfigCollectable(new Material[]{Material.COBBLESTONE},
                                      new int[]{48, 64},
                                      new String[]{"Cobblestone"}),
                new ConfigCollectable(new Material[]{Material.STONE},
                                      new int[]{12, 16, 20},
                                      new String[]{"Stone"}),
                new ConfigCollectable(new Material[]{Material.GRANITE, Material.DIORITE, Material.ANDESITE},
                                      new int[]{16, 24, 32},
                                      new String[]{"Granite", "Diorite", "Andesite"}),
                new ConfigCollectable(new Material[]{Material.SANDSTONE},
                                      new int[]{12, 16, 20},
                                      new String[]{"Sandstone"}),
                new ConfigCollectable(new Material[]{Material.WHITE_WOOL},
                                      new int[]{2, 3, 4, 5},
                                      new String[]{"White Wool"}),
                new ConfigCollectable(new Material[]{Material.GLASS},
                                      new int[]{12, 16, 20},
                                      new String[]{"Glass"}),
                new ConfigCollectable(new Material[]{Material.DIRT},
                                      new int[]{48, 64},
                                      new String[]{"Dirt"}),
                new ConfigCollectable(new Material[]{Material.SUGAR_CANE},
                                      new int[]{4, 6, 8},
                                      new String[]{"Sugar Cane"}),
                new ConfigCollectable(new Material[]{Material.FLETCHING_TABLE},
                                      new int[]{2, 3},
                                      new String[]{"Fletching Tables"}),
                new ConfigCollectable(new Material[]{Material.SMOKER},
                                      new int[]{2, 3},
                                      new String[]{"Smokers"}),
                new ConfigCollectable(new Material[]{Material.CAMPFIRE},
                                      new int[]{2, 3, 4},
                                      new String[]{"Campfires"}),
                new ConfigCollectable(new Material[]{Material.COOKED_BEEF, Material.COOKED_PORKCHOP,
                                                     Material.COOKED_MUTTON, Material.COOKED_CHICKEN},
                                      new int[]{4, 6, 8},
                                      new String[]{"Cooked Beef", "Cooked Porkchop",
                                                   "Cooked Mutton", "Cooked Chicken"}),
                new ConfigCollectable(new Material[]{Material.COAL},
                                      new int[]{8, 12, 16},
                                      new String[]{"Coal"}),
                new ConfigCollectable(new Material[]{Material.FLINT},
                                      new int[]{2, 3, 4},
                                      new String[]{"Flint"}),
                new ConfigCollectable(new Material[]{Material.CHARCOAL},
                                      new int[]{8},
                                      new String[]{"Charcoal"})
        ));

        ////////////// TIER 2 //////////////
        ArrayList<ConfigCollectable> tier2 = new ArrayList<>(List.of(
                new ConfigCollectable(new Material[]{Material.SPRUCE_LOG, Material.BIRCH_LOG, Material.ACACIA_LOG},
                                      new int[]{8, 12, 16},
                                      new String[]{"Spruce Logs", "Birch Logs", "Acacia Logs"}),
                new ConfigCollectable(new Material[]{Material.STONE_BRICKS, Material.CHISELED_STONE_BRICKS},
                                      new int[]{6, 8},
                                      new String[]{"Stone Bricks", "Chiseled Stone Bricks"}),
                new ConfigCollectable(new Material[]{Material.COBBLED_DEEPSLATE},
                                      new int[]{16, 24, 32},
                                      new String[]{"Cobbled Deepslate"}),
                new ConfigCollectable(new Material[]{Material.DEEPSLATE, Material.DEEPSLATE_BRICKS},
                                      new int[]{4, 6, 8},
                                      new String[]{"Deepslate", "Deepslate Bricks"}),
                new ConfigCollectable(new Material[]{Material.BRICKS},
                                      new int[]{4, 6, 8},
                                      new String[]{"Bricks"}),
                new ConfigCollectable(new Material[]{Material.PACKED_MUD},
                                      new int[]{2, 3, 4},
                                      new String[]{"Packed Mud"}),
                new ConfigCollectable(new Material[]{Material.NOTE_BLOCK},
                                      new int[]{2, 3, 4},
                                      new String[]{"Note Blocks"}),
                new ConfigCollectable(new Material[]{Material.COARSE_DIRT},
                                      new int[]{12, 16, 20},
                                      new String[]{"Coarse Dirt"}),
                new ConfigCollectable(new Material[]{Material.SNOW_BLOCK},
                                      new int[]{2, 3, 4},
                                      new String[]{"Snow Blocks"}),
                new ConfigCollectable(new Material[]{Material.TUFF},
                                      new int[]{8, 12, 16},
                                      new String[]{"Tuff"}),
                new ConfigCollectable(new Material[]{Material.KELP, Material.DRIED_KELP},
                                      new int[]{4, 6, 8},
                                      new String[]{"Kelp", "Dried Kelp"}),
                new ConfigCollectable(new Material[]{Material.HAY_BLOCK},
                                      new int[]{1},
                                      new String[]{"Hay Bale"}),
                new ConfigCollectable(new Material[]{Material.LANTERN},
                                      new int[]{2, 3, 4, 5},
                                      new String[]{"Lanterns"}),
                new ConfigCollectable(new Material[]{Material.STONECUTTER},
                                      new int[]{2, 3, 4},
                                      new String[]{"Stonecutters"}),
                new ConfigCollectable(new Material[]{Material.CARTOGRAPHY_TABLE},
                                      new int[]{2, 3, 4},
                                      new String[]{"Cartography Tables"}),
                new ConfigCollectable(new Material[]{Material.SMITHING_TABLE},
                                      new int[]{2},
                                      new String[]{"Smithing Tables"}),
                new ConfigCollectable(new Material[]{Material.GRINDSTONE},
                                      new int[]{4, 6, 8},
                                      new String[]{"Grindstones"}),
                new ConfigCollectable(new Material[]{Material.LOOM},
                                      new int[]{1},
                                      new String[]{"Loom"}),
                new ConfigCollectable(new Material[]{Material.BLAST_FURNACE},
                                      new int[]{1},
                                      new String[]{"Blast Furnace"}),
                new ConfigCollectable(new Material[]{Material.DROPPER},
                                      new int[]{2, 3, 4},
                                      new String[]{"Droppers"}),
                new ConfigCollectable(new Material[]{Material.ARMOR_STAND},
                                      new int[]{2, 3, 4},
                                      new String[]{"Armor Stands"}),
                new ConfigCollectable(new Material[]{Material.ITEM_FRAME},
                                      new int[]{2, 3, 4},
                                      new String[]{"Item Frames"}),
                new ConfigCollectable(new Material[]{Material.HOPPER},
                                      new int[]{1},
                                      new String[]{"Hopper"}),
                new ConfigCollectable(new Material[]{Material.ROTTEN_FLESH},
                                      new int[]{4, 6, 8},
                                      new String[]{"Rotten Flesh"}),
                new ConfigCollectable(new Material[]{Material.BRUSH},
                                      new int[]{2, 3},
                                      new String[]{"Brushes"}),
                new ConfigCollectable(new Material[]{Material.ARROW},
                                      new int[]{8, 12},
                                      new String[]{"Arrows"}),
                new ConfigCollectable(new Material[]{Material.CROSSBOW},
                                      new int[]{1, 2},
                                      new String[]{"Crossbows"}),
                new ConfigCollectable(new Material[]{Material.APPLE},
                                      new int[]{1, 2, 3},
                                      new String[]{"Apples"}),
                new ConfigCollectable(new Material[]{Material.CARROT, Material.POTATO, Material.BEETROOT},
                                      new int[]{4, 6, 8},
                                      new String[]{"Carrots", "Potatoes", "Beetroots"}),
                new ConfigCollectable(new Material[]{Material.COOKED_SALMON},
                                      new int[]{2, 3, 4},
                                      new String[]{"Cooked Salmon"}),
                new ConfigCollectable(new Material[]{Material.WHITE_DYE, Material.LIGHT_GRAY_DYE, Material.GRAY_DYE,
                                                     Material.BLACK_DYE, Material.RED_DYE, Material.ORANGE_DYE,
                                                     Material.YELLOW_DYE, Material.PINK_DYE},
                                      new int[]{3, 4, 5},
                                      new String[]{"White Dye", "Light Gray Dye", "Gray Dye", "Black Dye", "Red Dye",
                                                   "Orange Dye", "Yellow Dye", "Pink Dye"}),
                new ConfigCollectable(new Material[]{Material.GOLD_INGOT},
                                      new int[]{2, 3, 4},
                                      new String[]{"Gold Ingots"}),
                new ConfigCollectable(new Material[]{Material.IRON_INGOT},
                                      new int[]{2, 3, 4},
                                      new String[]{"Iron Ingots"}),
                new ConfigCollectable(new Material[]{Material.COPPER_INGOT},
                                      new int[]{8, 12, 16},
                                      new String[]{"Copper Ingots"})
        ));

        ////////////// TIER 3 //////////////
        ArrayList<ConfigCollectable> tier3 = new ArrayList<>(List.of(
                new ConfigCollectable(new Material[]{Material.MOSSY_COBBLESTONE, Material.MOSSY_STONE_BRICKS},
                                      new int[]{4, 6, 8},
                                      new String[]{"Mossy Cobblestone", "Mossy Stone Bricks"}),
                new ConfigCollectable(new Material[]{Material.AMETHYST_BLOCK},
                                      new int[]{4, 6, 8},
                                      new String[]{"Blocks of Amethyst"}),
                new ConfigCollectable(new Material[]{Material.EXPOSED_COPPER},
                                      new int[]{2, 3, 4},
                                      new String[]{"Exposed Copper"}),
                new ConfigCollectable(new Material[]{Material.TERRACOTTA},
                                      new int[]{8, 12, 16},
                                      new String[]{"Terracotta"}),
                new ConfigCollectable(new Material[]{Material.DRIPSTONE_BLOCK},
                                      new int[]{4, 6, 8},
                                      new String[]{"Dripstone Blocks"}),
                new ConfigCollectable(new Material[]{Material.MAGMA_BLOCK},
                                      new int[]{12, 16, 20},
                                      new String[]{"Magma Blocks"}),
                new ConfigCollectable(new Material[]{Material.OBSIDIAN},
                                      new int[]{2, 3, 4},
                                      new String[]{"Obsidian"}),
                new ConfigCollectable(new Material[]{Material.BONE_BLOCK},
                                      new int[]{2, 3},
                                      new String[]{"Bone Blocks"}),
                new ConfigCollectable(new Material[]{Material.BROWN_MUSHROOM, Material.RED_MUSHROOM},
                                      new int[]{4, 6, 8},
                                      new String[]{"Brown Mushrooms", "Red Mushrooms"}),
                new ConfigCollectable(new Material[]{Material.CACTUS},
                                      new int[]{8, 12, 16},
                                      new String[]{"Cactus"}),
                new ConfigCollectable(new Material[]{Material.SWEET_BERRIES},
                                      new int[]{8, 12, 16},
                                      new String[]{"Sweet Berries"}),
                new ConfigCollectable(new Material[]{Material.LILY_PAD},
                                      new int[]{8, 12, 16},
                                      new String[]{"Lily Pads"}),
                new ConfigCollectable(new Material[]{Material.SEAGRASS},
                                      new int[]{8, 12, 16},
                                      new String[]{"Seagrass"}),
                new ConfigCollectable(new Material[]{Material.MELON},
                                      new int[]{2, 3},
                                      new String[]{"Melons"}),
                new ConfigCollectable(new Material[]{Material.REPEATER},
                                      new int[]{3, 4, 5},
                                      new String[]{"Redstone Repeaters"}),
                new ConfigCollectable(new Material[]{Material.ANVIL},
                                      new int[]{1},
                                      new String[]{"Anvil"}),
                new ConfigCollectable(new Material[]{Material.GLOW_ITEM_FRAME},
                                      new int[]{1, 2, 3},
                                      new String[]{"Glow Item Frames"}),
                new ConfigCollectable(new Material[]{Material.BOOKSHELF},
                                      new int[]{2, 3},
                                      new String[]{"Bookshelves"}),
                new ConfigCollectable(new Material[]{Material.TARGET},
                                      new int[]{2, 3},
                                      new String[]{"Targets"}),
                new ConfigCollectable(new Material[]{Material.PISTON},
                                      new int[]{4, 6, 8},
                                      new String[]{"Pistons"}),
                new ConfigCollectable(new Material[]{Material.DISPENSER},
                                      new int[]{2, 3, 4},
                                      new String[]{"Dispensers"}),
                new ConfigCollectable(new Material[]{Material.JUKEBOX},
                                      new int[]{1},
                                      new String[]{"Jukebox"}),
                new ConfigCollectable(new Material[]{Material.RAIL},
                                      new int[]{32, 48},
                                      new String[]{"Rails"}),
                new ConfigCollectable(new Material[]{Material.ACTIVATOR_RAIL, Material.DETECTOR_RAIL,
                                                     Material.POWERED_RAIL},
                                      new int[]{2, 4, 6},
                                      new String[]{"Activator Rails", "Detector Rails", "Powered Rails"}),
                new ConfigCollectable(new Material[]{Material.TNT},
                                      new int[]{1},
                                      new String[]{"TNT"}),
                new ConfigCollectable(new Material[]{Material.MILK_BUCKET},
                                      new int[]{1, 2, 3},
                                      new String[]{"Milk Buckets"}),
                new ConfigCollectable(new Material[]{Material.COMPASS, Material.CLOCK},
                                      new int[]{1, 2, 3},
                                      new String[]{"Compasses", "Clocks"}),
                new ConfigCollectable(new Material[]{Material.SPYGLASS},
                                      new int[]{4, 5, 6},
                                      new String[]{"Spyglasses"}),
                new ConfigCollectable(new Material[]{Material.WRITABLE_BOOK},
                                      new int[]{2, 3},
                                      new String[]{"Book and Quills"}),
                new ConfigCollectable(new Material[]{Material.ENDER_PEARL},
                                      new int[]{2, 3, 4},
                                      new String[]{"Enderpearls"}),
                new ConfigCollectable(new Material[]{Material.GOLDEN_APPLE},
                                      new int[]{2, 3, 4},
                                      new String[]{"Golden Apples"}),
                new ConfigCollectable(new Material[]{Material.GOLDEN_CARROT},
                                      new int[]{2, 3, 4},
                                      new String[]{"Golden Carrots"}),
                new ConfigCollectable(new Material[]{Material.COOKED_RABBIT},
                                      new int[]{2, 3},
                                      new String[]{"Cooked Rabbit"}),
                new ConfigCollectable(new Material[]{Material.SPIDER_EYE},
                                      new int[]{3, 4, 5},
                                      new String[]{"Spider Eyes"}),
                new ConfigCollectable(new Material[]{Material.MUSHROOM_STEW},
                                      new int[]{1, 2, 3},
                                      new String[]{"Mushroom Stews"}),
                new ConfigCollectable(new Material[]{Material.EMERALD},
                                      new int[]{1, 2, 3, 4},
                                      new String[]{"Emeralds"}),
                new ConfigCollectable(new Material[]{Material.LAPIS_LAZULI},
                                      new int[]{16, 24, 32},
                                      new String[]{"Lapis Lazuli"}),
                new ConfigCollectable(new Material[]{Material.LIGHT_BLUE_DYE, Material.BLUE_DYE, Material.PURPLE_DYE,
                                                     Material.MAGENTA_DYE},
                                      new int[]{3, 4, 5},
                                      new String[]{"Light Blue Dye", "Blue Dye", "Purple Dye", "Magenta Dye"}),
                new ConfigCollectable(new Material[]{Material.FERMENTED_SPIDER_EYE},
                                      new int[]{1, 2, 3},
                                      new String[]{"Fermented Spider Eyes"})
        ));

        ////////////// TIER 4 //////////////
        ArrayList<ConfigCollectable> tier4 = new ArrayList<>(List.of(
                new ConfigCollectable(new Material[]{Material.JUNGLE_LOG, Material.DARK_OAK_LOG, Material.MANGROVE_LOG,
                                                     Material.CHERRY_LOG},
                                      new int[]{8, 12, 16},
                                      new String[]{"Jungle Logs", "Dark Oak Logs", "Mangrove Logs", "Cherry Logs"}),
                new ConfigCollectable(new Material[]{Material.CRIMSON_STEM, Material.WARPED_STEM},
                                      new int[]{8, 12, 16},
                                      new String[]{"Crimson Stems", "Warped Stems"}),
                new ConfigCollectable(new Material[]{Material.BAMBOO_BLOCK},
                                      new int[]{8, 12, 16},
                                      new String[]{"Blocks of Bamboo"}),
                new ConfigCollectable(new Material[]{Material.RED_SANDSTONE},
                                      new int[]{12, 16, 20},
                                      new String[]{"Red Sandstone"}),
                new ConfigCollectable(new Material[]{Material.DIAMOND},
                                      new int[]{1, 2, 3, 4},
                                      new String[]{"Diamonds"}),
                new ConfigCollectable(new Material[]{Material.NETHER_BRICKS},
                                      new int[]{32, 48, 64},
                                      new String[]{"Nether Bricks"}),
                new ConfigCollectable(new Material[]{Material.RED_NETHER_BRICKS},
                                      new int[]{4, 6, 8},
                                      new String[]{"Red Nether Bricks"}),
                new ConfigCollectable(new Material[]{Material.BASALT},
                                      new int[]{16, 20, 24},
                                      new String[]{"Basalt"}),
                new ConfigCollectable(new Material[]{Material.BLACKSTONE, Material.POLISHED_BLACKSTONE_BRICKS},
                                      new int[]{12, 16, 20},
                                      new String[]{"Blackstone", "Polished Blackstone Bricks"}),
                new ConfigCollectable(new Material[]{Material.WEATHERED_COPPER},
                                      new int[]{2, 3, 4},
                                      new String[]{"Weathered Copper"}),
                new ConfigCollectable(new Material[]{Material.CANDLE},
                                      new int[]{1, 2, 3},
                                      new String[]{"Candles"}),
                new ConfigCollectable(new Material[]{Material.ROOTED_DIRT},
                                      new int[]{4, 6, 8},
                                      new String[]{"Rooted Dirt"}),
                new ConfigCollectable(new Material[]{Material.CRYING_OBSIDIAN},
                                      new int[]{2, 3, 4},
                                      new String[]{"Crying Obsidian"}),
                new ConfigCollectable(new Material[]{Material.SOUL_SAND, Material.SOUL_SOIL},
                                      new int[]{8, 12, 16},
                                      new String[]{"Soul Sand", "Soul Soil"}),
                new ConfigCollectable(new Material[]{Material.ANCIENT_DEBRIS},
                                      new int[]{1, 2},
                                      new String[]{"Ancient Debris"}),
                new ConfigCollectable(new Material[]{Material.SHROOMLIGHT},
                                      new int[]{4, 5, 6},
                                      new String[]{"Shroomlights"}),
                new ConfigCollectable(new Material[]{Material.GLOW_BERRIES},
                                      new int[]{8, 10, 12},
                                      new String[]{"Glow Berries"}),
                new ConfigCollectable(new Material[]{Material.SEA_PICKLE},
                                      new int[]{1, 2},
                                      new String[]{"Sea Pickles"}),
                new ConfigCollectable(new Material[]{Material.HONEYCOMB},
                                      new int[]{2, 3, 4, 5},
                                      new String[]{"Honeycomb"}),
                new ConfigCollectable(new Material[]{Material.SOUL_TORCH},
                                      new int[]{8, 16, 24, 32},
                                      new String[]{"Soul Torches"}),
                new ConfigCollectable(new Material[]{Material.SOUL_CAMPFIRE},
                                      new int[]{4, 5, 6},
                                      new String[]{"Soul Campfires"}),
                new ConfigCollectable(new Material[]{Material.ENCHANTING_TABLE},
                                      new int[]{1},
                                      new String[]{"Enchanting Table"}),
                new ConfigCollectable(new Material[]{Material.BREWING_STAND},
                                      new int[]{1, 2, 3, 4},
                                      new String[]{"Brewing Stands"}),
                new ConfigCollectable(new Material[]{Material.ENDER_EYE},
                                      new int[]{1, 2, 3},
                                      new String[]{"Eyes of Ender"}),
                new ConfigCollectable(new Material[]{Material.COMPARATOR},
                                      new int[]{6, 8},
                                      new String[]{"Redstone Comparators"}),
                new ConfigCollectable(new Material[]{Material.REDSTONE_LAMP},
                                      new int[]{4, 6, 8},
                                      new String[]{"Redstone Lamps"}),
                new ConfigCollectable(new Material[]{Material.DAYLIGHT_DETECTOR},
                                      new int[]{4, 6, 8},
                                      new String[]{"Daylight Detectors"}),
                new ConfigCollectable(new Material[]{Material.OBSERVER},
                                      new int[]{8, 10, 12},
                                      new String[]{"Observers"}),
                new ConfigCollectable(new Material[]{Material.FIRE_CHARGE},
                                      new int[]{4, 5, 6},
                                      new String[]{"Fire Charges"}),
                new ConfigCollectable(new Material[]{Material.SADDLE},
                                      new int[]{1},
                                      new String[]{"Saddle"}),
                new ConfigCollectable(new Material[]{Material.SPECTRAL_ARROW},
                                      new int[]{32, 40, 48},
                                      new String[]{"Spectral Arrows"}),
                new ConfigCollectable(new Material[]{Material.COOKIE},
                                      new int[]{16, 32, 48, 64},
                                      new String[]{"Cookies"}),
                new ConfigCollectable(new Material[]{Material.CAKE},
                                      new int[]{1},
                                      new String[]{"Cake"}),
                new ConfigCollectable(new Material[]{Material.PUMPKIN_PIE},
                                      new int[]{2, 3},
                                      new String[]{"Pumpkin Pies"}),
                new ConfigCollectable(new Material[]{Material.HONEY_BOTTLE},
                                      new int[]{1},
                                      new String[]{"Honey Bottle"}),
                new ConfigCollectable(new Material[]{Material.BROWN_DYE, Material.LIME_DYE, Material.GREEN_DYE,
                                                     Material.CYAN_DYE},
                                      new int[]{3, 4, 5},
                                      new String[]{"Brown Dye", "Lime Dye", "Green Dye", "Cyan Dye"}),
                new ConfigCollectable(new Material[]{Material.MAGMA_CREAM},
                                      new int[]{4, 5, 6, 7, 8},
                                      new String[]{"Magma Creams"}),
                new ConfigCollectable(new Material[]{Material.GHAST_TEAR},
                                      new int[]{1},
                                      new String[]{"Ghast Tear"})
        ));

        ////////////// TIER 5 //////////////
        ArrayList<ConfigCollectable> tier5 = new ArrayList<>(List.of(
                new ConfigCollectable(new Material[]{Material.SEA_LANTERN},
                                      new int[]{1},
                                      new String[]{"Sea Lantern"}),
                new ConfigCollectable(new Material[]{Material.DARK_PRISMARINE},
                                      new int[]{1},
                                      new String[]{"Dark Prismarine"}),
                new ConfigCollectable(new Material[]{Material.GILDED_BLACKSTONE},
                                      new int[]{2, 3, 4},
                                      new String[]{"Gilded Blackstone"}),
                new ConfigCollectable(new Material[]{Material.END_STONE},
                                      new int[]{16, 24, 32},
                                      new String[]{"End Stone"}),
                new ConfigCollectable(new Material[]{Material.GRASS_BLOCK, Material.PODZOL, Material.MYCELIUM},
                                      new int[]{8, 12, 16},
                                      new String[]{"Grass Blocks", "Podzol", "Mycelium"}),
                new ConfigCollectable(new Material[]{Material.ICE},
                                      new int[]{8, 12, 16},
                                      new String[]{"Ice"}),
                new ConfigCollectable(new Material[]{Material.SPONGE},
                                      new int[]{1},
                                      new String[]{"Sponge"}),
                new ConfigCollectable(new Material[]{Material.OXIDIZED_COPPER},
                                      new int[]{2, 3, 4},
                                      new String[]{"Oxidized Copper"}),
                new ConfigCollectable(new Material[]{Material.ENDER_CHEST},
                                      new int[]{1},
                                      new String[]{"Ender Chest"}),
                new ConfigCollectable(new Material[]{Material.WITHER_SKELETON_SKULL},
                                      new int[]{1},
                                      new String[]{"Wither Skeleton Skull"}),
                new ConfigCollectable(new Material[]{Material.LEAD, Material.NAME_TAG},
                                      new int[]{1},
                                      new String[]{"Lead", "Name Tag"}),
                new ConfigCollectable(new Material[]{Material.GOLDEN_HORSE_ARMOR, Material.IRON_HORSE_ARMOR,
                                                     Material.DIAMOND_HORSE_ARMOR},
                                      new int[]{1},
                                      new String[]{"Golden Horse Armor", "Iron Horse Armor", "Diamond Horse Armor"}),
                new ConfigCollectable(new Material[]{Material.ENCHANTED_GOLDEN_APPLE},
                                      new int[]{1},
                                      new String[]{"Enchanted Golden Apple"}),
                new ConfigCollectable(new Material[]{Material.HEART_OF_THE_SEA},
                                      new int[]{1},
                                      new String[]{"Heart of the Sea"}),
                new ConfigCollectable(new Material[]{Material.DRAGON_BREATH},
                                      new int[]{1},
                                      new String[]{"Dragon's Breath"}),
                new ConfigCollectable(new Material[]{Material.PHANTOM_MEMBRANE},
                                      new int[]{3, 4, 5, 6},
                                      new String[]{"Phantom Membrane"}),
                new ConfigCollectable(new Material[]{Material.END_CRYSTAL},
                                      new int[]{1},
                                      new String[]{"End Crystal"}),
                new ConfigCollectable(new Material[]{Material.EXPERIENCE_BOTTLE},
                                      new int[]{2, 3, 4},
                                      new String[]{"Bottle o' Enchanting"}),
                new ConfigCollectable(new Material[]{Material.NETHERITE_INGOT},
                                      new int[]{1},
                                      new String[]{"Netherite Ingot"}),
                new ConfigCollectable(new Material[]{Material.SLIME_BALL},
                                      new int[]{1},
                                      new String[]{"Slimeball"})
        ));

        collectableTiers.add(tier1);
        collectableTiers.add(tier2);
        collectableTiers.add(tier3);
        collectableTiers.add(tier4);
        collectableTiers.add(tier5);
    }

    public static final class ConfigCollectable
    {
        Material[] material;
        int[] amount;
        String[] displayName;

        public ConfigCollectable(Material[] material, int[] amount, String[] displayName)
        {
            this.material = material;
            this.amount = amount;
            this.displayName = displayName;
        }

        public Collectable getCollectable()
        {
            Random rng = new Random();
            int material_index = rng.nextInt(material.length);

            return new Collectable(material[material_index],
                                   amount[rng.nextInt(amount.length)],
                                   displayName[material_index]);
        }
    }
}
