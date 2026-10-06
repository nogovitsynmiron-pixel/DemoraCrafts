package ru.demora.crafts;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class DemoraCrafts extends JavaPlugin implements Listener {

    // Мапа: название рецепта -> команда для выдачи легендарки
    private final Map<NamespacedKey, String> recipeCommands = new HashMap<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        registerAllRecipes();
        getLogger().info("DemoraCrafts enabled! Registered " + recipeCommands.size() + " recipes.");
    }

    private void addRecipe(String keyName, String[] pattern, Material[] ingredients, String[] letters, String giveCommand) {
        NamespacedKey key = new NamespacedKey(this, keyName);
        ItemStack result = new ItemStack(Material.PAPER);
        var meta = result.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("\u00a76" + keyName.replace("_", " ").toUpperCase());
            result.setItemMeta(meta);
        }
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(pattern);
        for (int i = 0; i < letters.length; i++) {
            recipe.setIngredient(letters[i].charAt(0), ingredients[i]);
        }
        Bukkit.addRecipe(recipe);
        recipeCommands.put(key, giveCommand);
    }

    private void registerAllRecipes() {
        // 1. Excalibur
        addRecipe("excalibur",
            new String[]{" G ","DND"," T "},
            new Material[]{Material.GOLDEN_SWORD, Material.DIAMOND, Material.NETHERITE_INGOT, Material.TOTEM_OF_UNDYING},
            new String[]{"G","D","N","T"},
            "demorahop give excalibur %player%");

        // 2. Midas Sword
        addRecipe("midas_sword",
            new String[]{" E ","Q D"," G "},
            new Material[]{Material.ENCHANTED_GOLDEN_APPLE, Material.QUARTZ, Material.DIAMOND_SWORD, Material.GOLDEN_APPLE},
            new String[]{"E","Q","D","G"},
            "demorahop give midas_sword %player%");

        // 3. Mjolnir
        addRecipe("mjolnir",
            new String[]{" L ","LCL"," R "},
            new Material[]{Material.LIGHTNING_ROD, Material.COPPER_BLOCK, Material.NETHERITE_SCRAP},
            new String[]{"L","C","R"},
            "demorahop give mjolnir %player%");

        // 4. Shadow Blade
        addRecipe("shadow_blade",
            new String[]{" C ","CAC"," D "},
            new Material[]{Material.COAL_BLOCK, Material.DIAMOND_SWORD, Material.BLACK_CANDLE},
            new String[]{"C","A","D"},
            "demorahop give shadow_blade %player%");

        // 5. Reaper Scythe
        addRecipe("reaper_scythe",
            new String[]{" W "," B ","BHB"},
            new Material[]{Material.WITHER_SKELETON_SKULL, Material.BONE, Material.DIAMOND_HOE},
            new String[]{"W","B","H"},
            "demorahop give reaper_scythe %player%");

        // 6. Dragon Katana
        addRecipe("dragon_katana",
            new String[]{" E "," D "," S "},
            new Material[]{Material.ENDER_PEARL, Material.DRAGON_EGG, Material.DIAMOND_SWORD},
            new String[]{"E","D","S"},
            "demorahop give dragon_katana %player%");

        // 7. Emerald Blade
        addRecipe("emerald_blade",
            new String[]{" G "," E "," S "},
            new Material[]{Material.GOLDEN_CARROT, Material.EMERALD_BLOCK, Material.DIAMOND_SWORD},
            new String[]{"G","E","S"},
            "demorahop give emerald_blade %player%");

        // 8. Golem Hammer
        addRecipe("golem_hammer",
            new String[]{" I "," I "," A "},
            new Material[]{Material.IRON_BLOCK, Material.LODESTONE, Material.IRON_AXE},
            new String[]{"I","L","A"},
            "demorahop give golem_hammer %player%");

        // 9. Sculk Crossbow
        addRecipe("sculk_crossbow",
            new String[]{" E "," D "," C "},
            new Material[]{Material.ECHO_SHARD, Material.DIAMOND, Material.CROSSBOW},
            new String[]{"E","D","C"},
            "demorahop give sculk_crossbow %player%");

        // 10. Artemis Bow
        addRecipe("artemis_bow",
            new String[]{" S "," D "," B "},
            new Material[]{Material.SPYGLASS, Material.DIAMOND, Material.BOW},
            new String[]{"S","D","B"},
            "demorahop give artemis_bow %player%");

        // 11. Poseidon Trident
        addRecipe("poseidon_trident",
            new String[]{" N "," D "," T "},
            new Material[]{Material.NAUTILUS_SHELL, Material.DIAMOND, Material.TRIDENT},
            new String[]{"N","D","T"},
            "demorahop give poseidon_trident %player%");

        // 12. Void Staff
        addRecipe("void_staff",
            new String[]{" R "," E "," S "},
            new Material[]{Material.END_ROD, Material.END_STONE, Material.STICK},
            new String[]{"R","E","S"},
            "demorahop give void_staff %player%");

        // 13. Lich Staff
        addRecipe("lich_staff",
            new String[]{" S "," B "," S "},
            new Material[]{Material.SOUL_SAND, Material.BONE, Material.WITHER_SKELETON_SKULL},
            new String[]{"S","B","W"},
            "demorahop give lich_staff %player%");

        // 14. Cloud Sword
        addRecipe("cloud_sword",
            new String[]{" F "," F "," S "},
            new Material[]{Material.FEATHER, Material.PHANTOM_MEMBRANE, Material.DIAMOND_SWORD},
            new String[]{"F","P","S"},
            "demorahop give cloud_sword %player%");

        // 15. Magma Club
        addRecipe("magma_club",
            new String[]{" M "," M "," S "},
            new Material[]{Material.MAGMA_BLOCK, Material.BLAZE_ROD},
            new String[]{"M","S"},
            "demorahop give magma_club %player%");

        // 16. Shrink Ray
        addRecipe("shrink_ray",
            new String[]{" R "," T "," S "},
            new Material[]{Material.REDSTONE_BLOCK, Material.REDSTONE_TORCH, Material.SPYGLASS},
            new String[]{"R","T","S"},
            "demorahop give shrink_ray %player%");

        // 17. Chainsaw Sword
        addRecipe("chainsaw_sword",
            new String[]{" I "," R "," S "},
            new Material[]{Material.IRON_BLOCK, Material.REDSTONE_BLOCK, Material.IRON_SWORD},
            new String[]{"I","R","S"},
            "demorahop give chainsaw_sword %player%");

        // 18. Wither Sickles
        addRecipe("wither_sickles",
            new String[]{" W "," N "," H "},
            new Material[]{Material.WITHER_SKELETON_SKULL, Material.NETHERITE_SCRAP, Material.DIAMOND_HOE},
            new String[]{"W","N","H"},
            "demorahop give wither_sickles %player%");

        // 19. Hypnosis Staff
        addRecipe("hypnosis_staff",
            new String[]{" T "," B "," S "},
            new Material[]{Material.TOTEM_OF_UNDYING, Material.REDSTONE_BLOCK, Material.BLAZE_ROD},
            new String[]{"T","B","S"},
            "demorahop give hypnosis_staff %player%");

        // 20. Toxic Crossbow
        addRecipe("toxic_crossbow",
            new String[]{" S "," D "," C "},
            new Material[]{Material.SPIDER_EYE, Material.DIAMOND, Material.CROSSBOW},
            new String[]{"S","D","C"},
            "demorahop give toxic_crossbow %player%");

        // 21. War Pick
        addRecipe("war_pick",
            new String[]{" P "," R "," K "},
            new Material[]{Material.PLAYER_HEAD, Material.REDSTONE_BLOCK, Material.DIAMOND_PICKAXE},
            new String[]{"P","R","K"},
            "demorahop give war_pick %player%");

        // 22. Ravager Horn
        addRecipe("ravager_horn",
            new String[]{" R "," I "," D "},
            new Material[]{Material.GOAT_HORN, Material.IRON_BLOCK, Material.DIAMOND},
            new String[]{"R","I","D"},
            "demorahop give ravager_horn %player%");

        // 23. Reinforced Elytra
        addRecipe("reinforced_elytra",
            new String[]{" N "," E "," P "},
            new Material[]{Material.NETHERITE_INGOT, Material.ELYTRA, Material.PHANTOM_MEMBRANE},
            new String[]{"N","E","P"},
            "demorahop give reinforced_elytra %player%");

        // 24. Villager Staff
        addRecipe("villager_staff",
            new String[]{" E "," G "," S "},
            new Material[]{Material.EMERALD_BLOCK, Material.GOLDEN_APPLE, Material.STICK},
            new String[]{"E","G","S"},
            "demorahop give villager_staff %player%");
    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        var recipe = event.getRecipe();
        if (recipe instanceof ShapedRecipe shaped) {
            NamespacedKey key = shaped.getKey();
            if (recipeCommands.containsKey(key)) {
                event.setCancelled(true);
                if (event.getWhoClicked() instanceof Player player) {
                    // Очищаем слот результата
                    event.getInventory().setResult(null);
                    // Удаляем ингредиенты
                    var matrix = event.getInventory().getMatrix();
                    for (int i = 0; i < matrix.length; i++) {
                        if (matrix[i] != null && matrix[i].getType() != Material.AIR) {
                            matrix[i].setAmount(matrix[i].getAmount() - 1);
                        }
                    }
                    // Выдаём легендарный предмет
                    String cmd = recipeCommands.get(key).replace("%player%", player.getName());
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    player.sendMessage("\u00a7aВы скрафтили легендарный предмет!");
                }
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // Выдаём книгу рецептов при входе
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();
        if (meta != null) {
            meta.setTitle("\u00a7e\u00a7lКнига крафтов");
            meta.setAuthor("DemoraCrafts");
            meta.addPage(
                "\u00a76\u00a7lКРАФТЫ ЛЕГЕНДАРНЫХ ПРЕДМЕТОВ\n\n" +
                "\u00a7fЭкскалибур:\n" +
                "Золотой меч, Алмаз, Незерит, Тотем\n\n" +
                "\u00a7fМеч Мидаса:\n" +
                "Зачар. зол. яблоко, Кварц, Алмаз, Зол. меч\n\n" +
                "\u00a7fМьёльнир:\n" +
                "Молниеотвод, Медный блок, Незерит. лом"
            );
            meta.addPage(
                "\u00a7fТеневой клинок:\n" +
                "Угольный блок, Свеча, Алмаз. меч\n\n" +
                "\u00a7fКоса жнеца:\n" +
                "Череп иссушителя, Кости, Алмаз. мотыга\n\n" +
                "\u00a7fКатана дракона:\n" +
                "Жемчуг Края, Драконье яйцо, Алмаз. меч"
            );
            meta.addPage(
                "\u00a7fИзумрудный клинок:\n" +
                "Зол. морковь, Блок изумрудов, Алмаз. меч\n\n" +
                "\u00a7fМолот голема:\n" +
                "Блок железа, Магнетит, Железный топор\n\n" +
                "\u00a7fСкалковый арбалет:\n" +
                "Осколок эха, Алмаз, Арбалет"
            );
            meta.addPage(
                "\u00a7fЛук Артемиды:\n" +
                "Подзорная труба, Алмаз, Лук\n\n" +
                "\u00a7fТрезубец Посейдона:\n" +
                "Раковина, Алмаз, Трезубец\n\n" +
                "\u00a7fПосох Пустоты:\n" +
                "Стержень Края, Камень Края, Палка"
            );
            meta.addPage(
                "\u00a7fПосох нежити:\n" +
                "Песок душ, Кости, Череп иссушителя\n\n" +
                "\u00a7fНебесный меч:\n" +
                "Перья, Мембрана фантома, Алмаз. меч\n\n" +
                "\u00a7fМагмовая дубина:\n" +
                "Блок магмы, Стержень ифрита"
            );
            meta.addPage(
                "\u00a7fУменьшитель:\n" +
                "Блок редстоуна, Редстоун. факел, Подзорная труба\n\n" +
                "\u00a7fМеч-бензопила:\n" +
                "Блок железа, Блок редстоуна, Железный меч\n\n" +
                "\u00a7fСерпы иссушителя:\n" +
                "Череп иссушителя, Незерит. лом, Алмаз. мотыга"
            );
            meta.addPage(
                "\u00a7fПосох гипноза:\n" +
                "Тотем, Блок редстоуна, Стержень ифрита\n\n" +
                "\u00a7fОтравленный арбалет:\n" +
                "Паучий глаз, Алмаз, Арбалет\n\n" +
                "\u00a7fВоенная кирка:\n" +
                "Голова игрока, Блок редстоуна, Алмаз. кирка"
            );
            meta.addPage(
                "\u00a7fРог разорителя:\n" +
                "Козий рог, Блок железа, Алмаз\n\n" +
                "\u00a7fУсиленные элитры:\n" +
                "Незерит, Элитры, Мембрана фантома\n\n" +
                "\u00a7fПосох жителя:\n" +
                "Блок изумрудов, Зол. яблоко, Палка"
            );
            book.setItemMeta(meta);
            player.getInventory().addItem(book);
        }
    }
}
