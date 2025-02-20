package com.jagex.runescape.rs2rsc;

import com.jagex.runescape.*;
import com.jagex.runescape.definition.EntityDefinition;
import com.jagex.runescape.Region;
import rscminus.common.JGameData;
import rscminus.game.constants.Game;

import java.util.HashMap;
import java.util.Map;

public class RSCConfig {
    public static boolean rscProtocol = true;
    public static int rscVersion = 235;
    public static int jaggrabPort = 43595; // unused, technically

    public static int DEFAULT_BRIGHTNESS = 1;

    public static char[] RSC_unicodeChars = {
            '\u20AC', '\0'/**/, '\u201A', '\u0192', '\u201E', '\u2026', '\u2020', '\u2021', '\u02C6', '\u2030',
            '\u0160', '\u2039', '\u0152', '\0'/**/, '\u017D', '\0'/**/, '\0'/**/, '\u2018', '\u2019', '\u201C',
            '\u201D', '\u2022', '\u2013', '\u2014', '\u02DC', '\u2122', '\u0161', '\u203A', '\u0153', '\0'/**/,
            '\u017E', '\u0178'
    };

    private static int[] anIntArray208;
    private static int[] anIntArray209;
    private static byte[] aByteArray210;
    public static int localServerIndex;

    public static String[] friendServers = new String[200];
    public static boolean[] questComplete = new boolean[Game.QUEST_COUNT];
    public static int[] inventoryID = new int[30];
    public static boolean[] inventoryEquipped = new boolean[30];
    public static int[] inventoryAmount = new int[30];
    public static int inventoryCount = 0;
    public static boolean inventoryUpdate = false;

    public static int playerCount;
    public static Player[] players = new Player[500];
    public static int npcCount;
    public static NPC[] npcs = new NPC[500];

    public static int[] shopItem = new int[40];
    public static int[] shopItemAmount = new int[40];
    public static int[] shopItemPrice = new int[40];
    public static int shopItemCount = 0;
    public static int shopSellPriceMod = 0;
    public static int shopBuyPriceMod = 0;
    public static int shopPriceMultiplier = 1;
    public static boolean showShop = false;

    public static int bankItemCount = 0;
    public static int bankItemMax = 0;
    public static int[] bankItem = new int[256];
    public static int[] bankItemAmount = new int[256];
    public static boolean showBank = false;

    // State
    public static boolean shopOpen = false;
    public static boolean bankOpen = false;

    private static int magicLoc = 128;
    public static int localRegionX;
    public static int localRegionY;
    public static int prevRegionX;
    public static int prevRegionY;
    public static int regionX;
    public static int regionY;
    public static int planeWidth;
    public static int planeHeight;
    public static int planeIndex;

    public static BiMap<Integer, Integer> objectIDTable = new BiMap<Integer, Integer>();
    public static BiMap<Integer, Integer> objectWallIDTable = new BiMap<Integer, Integer>();
    public static BiMap<Integer, Integer> objectWallDecorationIDTable = new BiMap<Integer, Integer>();
    private static Map<Integer, Integer> objectIDDirTable = new HashMap<Integer, Integer>();
    private static BiMap<Integer, Integer> npcIDTable = new BiMap<Integer, Integer>();
    private static BiMap<Integer, Integer> itemIDTable = new BiMap<Integer, Integer>();

    public static int[] colorConversion = new int[256];

    public static int clamp(int val, int min, int max)
    {
        if (val < min)
            return min;
        else if (val > max)
            return max;
        return val;
    }

    public static boolean RSC_CanShopTrade(int id)
    {
        boolean ret = true;

        if (id == 10) // Coins
            ret = false;

        return ret;
    }

    public static int RSC_CalculateShopValue(int id, boolean buying, int shopIndex)
    {
        int base = JGameData.itemPrice[id];
        int mod = shopBuyPriceMod;
        if (!buying)
            mod = shopSellPriceMod;

        int reduce = shopBuyPriceMod + clamp(shopPriceMultiplier * (-shopItemAmount[shopIndex] + shopItemPrice[shopIndex]), -100, 100);
        if (reduce < 10)
            reduce = 10;
        return base * reduce / 100;
    }

    public static byte[] RSC_stringToUnicode(String str) {
        int strlen = str.length();
        byte[] buf = new byte[strlen];
        for (int i = 0; i < strlen; i++) {
            char c = str.charAt(i);
            if (c > 0 && c < '\200' || c >= '\240' && c <= '\377') {
                buf[i] = (byte) c;
                continue;
            }
            if (c == '\u20AC') {
                buf[i] = -128;
                continue;
            }
            if (c == '\u201A') {
                buf[i] = -126;
                continue;
            }
            if (c == '\u0192') {
                buf[i] = -125;
                continue;
            }
            if (c == '\u201E') {
                buf[i] = -124;
                continue;
            }
            if (c == '\u2026') {
                buf[i] = -123;
                continue;
            }
            if (c == '\u2020') {
                buf[i] = -122;
                continue;
            }
            if (c == '\u2021') {
                buf[i] = -121;
                continue;
            }
            if (c == '\u02C6') {
                buf[i] = -120;
                continue;
            }
            if (c == '\u2030') {
                buf[i] = -119;
                continue;
            }
            if (c == '\u0160') {
                buf[i] = -118;
                continue;
            }
            if (c == '\u2039') {
                buf[i] = -117;
                continue;
            }
            if (c == '\u0152') {
                buf[i] = -116;
                continue;
            }
            if (c == '\u017D') {
                buf[i] = -114;
                continue;
            }
            if (c == '\u2018') {
                buf[i] = -111;
                continue;
            }
            if (c == '\u2019') {
                buf[i] = -110;
                continue;
            }
            if (c == '\u201C') {
                buf[i] = -109;
                continue;
            }
            if (c == '\u201D') {
                buf[i] = -108;
                continue;
            }
            if (c == '\u2022') {
                buf[i] = -107;
                continue;
            }
            if (c == '\u2013') {
                buf[i] = -106;
                continue;
            }
            if (c == '\u2014') {
                buf[i] = -105;
                continue;
            }
            if (c == '\u02DC') {
                buf[i] = -104;
                continue;
            }
            if (c == '\u2122') {
                buf[+i] = -103;
                continue;
            }
            if (c == '\u0161') {
                buf[i] = -102;
                continue;
            }
            if (c == '\u203A') {
                buf[i] = -101;
                continue;
            }
            if (c == '\u0153') {
                buf[i] = -100;
                continue;
            }
            if (c == '\u017E') {
                buf[i] = -98;
                continue;
            }
            if (c == '\u0178')
                buf[i] = -97;
            else
                buf[i] = '?';
        }

        return buf;
    }

    public static int method240(byte[] var1, int var2, byte[] var3, boolean var4, int var5, int var6) {
        if (var6 == 0) {
            return 0;
        } else {
            var6 += var2;
            int var7 = 0;
            if (!var4) {
                method240((byte[]) null, -4, (byte[]) null, false, -81, -40);
            }

            int var8 = var5;

            while (true) {
                byte var9 = var1[var8];
                if (var9 >= 0) {
                    ++var7;
                } else {
                    var7 = anIntArray209[var7];
                }

                int var10;
                if ((var10 = anIntArray209[var7]) < 0) {
                    var3[var2++] = (byte) (~var10);
                    if (var6 <= var2) {
                        break;
                    }

                    var7 = 0;
                }

                if ((64 & var9) == 0) {
                    ++var7;
                } else {
                    var7 = anIntArray209[var7];
                }

                if ((var10 = anIntArray209[var7]) < 0) {
                    var3[var2++] = (byte) (~var10);
                    if (var2 >= var6) {
                        break;
                    }

                    var7 = 0;
                }

                if ((var9 & 32) != 0) {
                    var7 = anIntArray209[var7];
                } else {
                    ++var7;
                }

                if ((var10 = anIntArray209[var7]) < 0) {
                    var3[var2++] = (byte) (~var10);
                    if (var2 >= var6) {
                        break;
                    }

                    var7 = 0;
                }

                if ((var9 & 16) == 0) {
                    ++var7;
                } else {
                    var7 = anIntArray209[var7];
                }

                if ((var10 = anIntArray209[var7]) < 0) {
                    var3[var2++] = (byte) (~var10);
                    if (var2 >= var6) {
                        break;
                    }

                    var7 = 0;
                }

                if ((var9 & 8) == 0) {
                    ++var7;
                } else {
                    var7 = anIntArray209[var7];
                }

                if ((var10 = anIntArray209[var7]) < 0) {
                    var3[var2++] = (byte) (~var10);
                    if (var6 <= var2) {
                        break;
                    }

                    var7 = 0;
                }

                if ((4 & var9) == 0) {
                    ++var7;
                } else {
                    var7 = anIntArray209[var7];
                }

                if ((var10 = anIntArray209[var7]) < 0) {
                    var3[var2++] = (byte) (~var10);
                    if (var2 >= var6) {
                        break;
                    }

                    var7 = 0;
                }

                if ((2 & var9) != 0) {
                    var7 = anIntArray209[var7];
                } else {
                    ++var7;
                }

                if ((var10 = anIntArray209[var7]) < 0) {
                    var3[var2++] = (byte) (~var10);
                    if (var2 >= var6) {
                        break;
                    }

                    var7 = 0;
                }

                if ((var9 & 1) == 0) {
                    ++var7;
                } else {
                    var7 = anIntArray209[var7];
                }

                if ((var10 = anIntArray209[var7]) < 0) {
                    var3[var2++] = (byte) (~var10);
                    if (var6 <= var2) {
                        break;
                    }

                    var7 = 0;
                }

                ++var8;
            }

            return -var5 + var8 - -1;
        }
    }


    public static int method241(int var1, int var2, byte[] var3, byte[] var4, int var5, int var6) {
        int var7 = 0;
        var2 += var1;

        int var8;
        for (var8 = var6 << 3; var1 < var2; ++var1) {
            int var9 = var4[var1] & 255;
            int var10 = anIntArray208[var9];
            byte var11 = aByteArray210[var9];
            if (var11 == 0) {
                throw new RuntimeException("No codeword for data value " + var9);
            }

            int var12 = var8 >> 3;
            int var13 = var8 & 7;
            var7 &= -var13 >> 31;
            int var14 = (var11 + var13 + -1 >> 3) + var12;
            var8 += var11;
            var13 += 24;
            var3[var12] = (byte) (var7 = (var7 | (var10 >>> var13)));
            if (var14 > var12) {
                ++var12;
                var13 -= 8;
                var3[var12] = (byte) (var7 = var10 >>> var13);
                if (var12 < var14) {
                    ++var12;
                    var13 -= 8;
                    var3[var12] = (byte) (var7 = var10 >>> var13);
                    if (var14 > var12) {
                        var13 -= 8;
                        ++var12;
                        var3[var12] = (byte) (var7 = var10 >>> var13);
                        if (var12 < var14) {
                            ++var12;
                            var13 -= 8;
                            var3[var12] = (byte) (var7 = var10 << -var13);
                        }
                    }
                }
            }
        }

        return (7 + var8 >> 3) - var6;
    }

    static int generateColor(int var0, int var1, int var2, int var3) {
        if (var1 >= -106) {
            generateColor(-105, -46, -65, -106);
        }

        //return -(var0 / 8) + -(var2 / 8 * 1024) + (-1 - var3 / 8 * 32);
        //return -(var0 / 8) + -(var2 / 8 * 1024) + (-1 - var3 / 8 * 32);
        int r = var2 & 0xFF;//(var2) & 0xFF;
        int g = (var3) & 0xFF;
        int b = var0 & 0xFF;//(var0) & 0xFF;
        System.out.println("rgb: " + r + ", " + g + ", " + b);
        return (r << 16) | (g << 8) | b;
    }

    public static void Start(Client client)
    {
        if (!rscProtocol)
            return;

        aByteArray210 = new byte[]{(byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 21, (byte) 22, (byte) 22, (byte) 20, (byte) 22, (byte) 22, (byte) 22, (byte) 21, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 3, (byte) 8, (byte) 22, (byte) 16, (byte) 22, (byte) 16, (byte) 17, (byte) 7, (byte) 13, (byte) 13, (byte) 13, (byte) 16, (byte) 7, (byte) 10, (byte) 6, (byte) 16, (byte) 10, (byte) 11, (byte) 12, (byte) 12, (byte) 12, (byte) 12, (byte) 13, (byte) 13, (byte) 14, (byte) 14, (byte) 11, (byte) 14, (byte) 19, (byte) 15, (byte) 17, (byte) 8, (byte) 11, (byte) 9, (byte) 10, (byte) 10, (byte) 10, (byte) 10, (byte) 11, (byte) 10, (byte) 9, (byte) 7, (byte) 12, (byte) 11, (byte) 10, (byte) 10, (byte) 9, (byte) 10, (byte) 10, (byte) 12, (byte) 10, (byte) 9, (byte) 8, (byte) 12, (byte) 12, (byte) 9, (byte) 14, (byte) 8, (byte) 12, (byte) 17, (byte) 16, (byte) 17, (byte) 22, (byte) 13, (byte) 21, (byte) 4, (byte) 7, (byte) 6, (byte) 5, (byte) 3, (byte) 6, (byte) 6, (byte) 5, (byte) 4, (byte) 10, (byte) 7, (byte) 5, (byte) 6, (byte) 4, (byte) 4, (byte) 6, (byte) 10, (byte) 5, (byte) 4, (byte) 4, (byte) 5, (byte) 7, (byte) 6, (byte) 10, (byte) 6, (byte) 10, (byte) 22, (byte) 19, (byte) 22, (byte) 14, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 21, (byte) 22, (byte) 21, (byte) 22, (byte) 22, (byte) 22, (byte) 21, (byte) 22, (byte) 22};
        anIntArray208 = new int[aByteArray210.length];
        anIntArray209 = new int[8];
        int[] var3 = new int[33];
        int var4 = 0;

        for (int var5 = 0; var5 < aByteArray210.length; ++var5) {
            byte var6 = aByteArray210[var5];
            if (var6 != 0) {
                int var7 = 1 << 32 + -var6;
                int var8 = var3[var6];
                anIntArray208[var5] = var8;
                int var9;
                int var10;
                int var11;
                int var12;

                if ((var8 & var7) == 0) {
                    var9 = var8 | var7;

                    for (var10 = -1 + var6; var10 >= 1; --var10) {
                        var11 = var3[var10];
                        if (var11 != var8) {
                            break;
                        }

                        var12 = 1 << 32 + -var10;
                        if ((var11 & var12) != 0) {
                            var3[var10] = var3[var10 - 1];
                            break;
                        }

                        var3[var10] = var11 | var12;
                    }
                }
                else
                {
                    var9 = var3[-1 + var6];
                }

                var3[var6] = var9;

                for (var10 = 1 + var6; var10 <= 32; ++var10) {
                    if (var8 == var3[var10]) {
                        var3[var10] = var9;
                    }
                }

                var11 = 0;

                for (var12 = 0; var12 < var6; ++var12) {
                    int var13 = Integer.MIN_VALUE >>> var12;
                    if ((var8 & var13) != 0) {
                        if (anIntArray209[var11] == 0) {
                            anIntArray209[var11] = var4;
                        }

                        var11 = anIntArray209[var11];
                    } else {
                        ++var11;
                    }

                    var13 >>>= 1;
                    if (var11 >= anIntArray209.length) {
                        int[] var14 = new int[2 * anIntArray209.length];

                        for (int var15 = 0; var15 < anIntArray209.length; ++var15) {
                            var14[var15] = anIntArray209[var15];
                        }

                        anIntArray209 = var14;
                    }
                }

                if (var11 >= var4)
                    var4 = var11 - -1;

                anIntArray209[var11] = ~var5;
            }
        }

        // Setup npc ids
        npcIDTable.put(0, 89); // Unicorn
        npcIDTable.put(1, 519); // Bob
        npcIDTable.put(2, 43); // Sheep
        npcIDTable.put(3, 41); // Chicken
        npcIDTable.put(4, 101); // Goblin
        npcIDTable.put(5, 0); // Hans
        npcIDTable.put(6, 81); // cow
        npcIDTable.put(7, 278); // cook
        npcIDTable.put(9, 31); // Priest
        npcIDTable.put(11, 1); // Man
        npcIDTable.put(13, 80); // Camel
        npcIDTable.put(14, 882); // Gypsy
        npcIDTable.put(15, 103); // Ghost
        npcIDTable.put(23, 59); // Giant Spider
        npcIDTable.put(28, 11); // Tramp
        npcIDTable.put(29, 47); // Rat
        npcIDTable.put(34, 61); // spider
        npcIDTable.put(35, 879); // Delrith
        npcIDTable.put(55, 520); // Shopkeeper
        npcIDTable.put(57, 172); // Darkwizard
        npcIDTable.put(60, 174); // Darkwizard
        npcIDTable.put(62, 100); // Goblin
        npcIDTable.put(63, 7); // farmer
        npcIDTable.put(65, 9); // Guard
        npcIDTable.put(66, 178); // Black Knight
        npcIDTable.put(67, 122); // Hobgoblin
        npcIDTable.put(81, 13); // Wizard
        npcIDTable.put(83, 521); // Shop Assistant
        npcIDTable.put(89, 180); // Highwayman
        npcIDTable.put(95, 494); // Banker
        npcIDTable.put(97, 755); // Morgan
        npcIDTable.put(114, 708); // Imp
        npcIDTable.put(118, 920); // Prince Ali
        npcIDTable.put(122, 915); // Leela
        npcIDTable.put(124, 743); // Ned
        npcIDTable.put(125, 922); // Aggie
        npcIDTable.put(161, 925); // Border Guard
        npcIDTable.put(162, 926); // Border Guard
        npcIDTable.put(225, 2538); // Giles
        npcIDTable.put(226, 2537); // Miles
        npcIDTable.put(227, 2536); // Niles
        npcIDTable.put(231, 805); // Master Crafter

        // Setup wall decoration object ids
        objectWallDecorationIDTable.put(27, 891);

        // Setup object ids
        objectIDTable.put(0, 1279); // Tree
        objectIDTable.put(1, 1276); // Tree
        objectIDTable.put(2, 884); // Well
        objectIDTable.put(3, 602); // Table
        objectIDTable.put(4, 1342); // Treestump
        objectIDTable.put(5, 1747); // Ladder
        objectIDTable.put(6, 133); // Ladder
        objectIDTable.put(7, 1088); // Chair
        objectIDTable.put(9, 596); // Longtable
        objectIDTable.put(10, 1097); // Throne
        objectIDTable.put(12, 404); // Gravestone
        objectIDTable.put(13, 400); // Gravestone
        objectIDTable.put(15, 417); // Bed
        objectIDTable.put(19, 409); // Altar
        objectIDTable.put(23, 1106); // Bench
        //objectIDTable.put(20, 2440); // Post
        objectIDTable.put(25, 203); // candles
        objectIDTable.put(26, 879); // fountain
        objectIDTable.put(29, 612); // Counter
        objectIDTable.put(30, 634); // Stall
        objectIDTable.put(34, 1173); // Fern
        objectIDTable.put(37, 1188); // Flower
        objectIDTable.put(38, 1163); // Mushroom
        //objectIDTable.put(54, 306); // cart
        objectIDTable.put(55, 23); // sacks
        objectIDTable.put(63, 1574); // doors
        objectIDTable.put(70, 1286); // Tree
        objectIDTable.put(72, 313); // Wheat
        objectIDTable.put(97, 2732); // fire
        objectIDTable.put(119, 2728); // Cook's Range
        objectIDTable.put(192, 42); // fish (Lure/Bait)
        objectIDTable.put(193, 44); // fish (Net/Bait)

        // Setup wall object ids
        //objectWallIDTable.put(45, 2068);
        objectWallIDTable.put(59, 1551);
        objectWallIDTable.put(60, 1552);

        // Setup object ids directions
        objectIDDirTable.put(1097, 2); // Throne
        objectIDDirTable.put(400, 2);
        objectIDDirTable.put(2068, 6);
        //objectIDDirTable.put(891, 3); // 0-3 rotation only!!!

        itemIDTable.put(0, 1420); // Iron mace
        itemIDTable.put(1, 1279); // Iron Short Sword
        itemIDTable.put(4, 1171); // Wooden Shield
        itemIDTable.put(10, 995); // Coins
        itemIDTable.put(11, 882); // Bronze Arrows
        itemIDTable.put(12, 1349); // Iron Axe
        itemIDTable.put(13, 946); // Knife
        itemIDTable.put(14, 1511); // Logs
        itemIDTable.put(16, 1059); // Leather Gloves
        itemIDTable.put(17, 1061); // Boots
        itemIDTable.put(18, 1965); // Cabbage
        itemIDTable.put(19, 1944); // Egg
        itemIDTable.put(20, 526); // Bones
        itemIDTable.put(21, 1925); // Bucket
        itemIDTable.put(28, 1203); // Iron dagger
        itemIDTable.put(71, 1293); // Iron Long Sword
        itemIDTable.put(87, 1351); // bronze Axe
        itemIDTable.put(88, 1353); // Steel Axe
        itemIDTable.put(89, 1363); // Iron battle Axe
        itemIDTable.put(90, 1365); // Steel battle Axe
        itemIDTable.put(91, 1369); // Mithril battle Axe
        itemIDTable.put(93, 1373); // Rune battle Axe
        itemIDTable.put(95, 1424); // Steel Mace
        itemIDTable.put(104, 1139); // Medium Bronze Helmet
        itemIDTable.put(108, 1155); // Large Bronze Helmet
        itemIDTable.put(113, 1103); // Bronze Chain Mail Body
        itemIDTable.put(117, 1117); // Bronze Plate Mail Body
        itemIDTable.put(124, 1173); // Bronze Square Shield
        itemIDTable.put(132, 2142); // cookedmeat
        itemIDTable.put(133, 2138); // raw chicken
        itemIDTable.put(134, 2146); // burntmeat
        itemIDTable.put(135, 1931); // pot
        itemIDTable.put(136, 1933); // flour
        itemIDTable.put(140, 1935); // jug
        itemIDTable.put(141, 1937); // water
        itemIDTable.put(142, 1993); // wine
        itemIDTable.put(144, 1735); // shears
        itemIDTable.put(145, 1737); // wool
        itemIDTable.put(147, 1739); // cow hide
        itemIDTable.put(156, 1265); // Bronze Pickaxe
        itemIDTable.put(166, 590); // tinderbox
        itemIDTable.put(167, 1755); // chisel
        itemIDTable.put(168, 2347); // hammer
        itemIDTable.put(171, 2353); // steel bar
        itemIDTable.put(181, 592); // Ashes
        itemIDTable.put(183, 1007); // Cape (red)
        itemIDTable.put(184, 577); // Wizards robe
        itemIDTable.put(185, 579); // wizardshat
        itemIDTable.put(187, 1011); // skirt (blue)
        itemIDTable.put(194, 1013); // skirt (pink)
        itemIDTable.put(195, 1015); // skirt (black)
        itemIDTable.put(201, 956); // flier
        itemIDTable.put(203, 1355); // Mithril Axe
        itemIDTable.put(204, 1357); // Adamantite Axe
        itemIDTable.put(205, 1375); // bronze battle axe
        itemIDTable.put(206, 1075); // Bronze Plate Mail Legs
        itemIDTable.put(241, 1957); // Onion
        itemIDTable.put(280, 52); // arrow shafts
        itemIDTable.put(288, 1654); // Gold necklace
        itemIDTable.put(296, 1692); // Gold Amulet
        itemIDTable.put(319, 1985); // Cheese
        itemIDTable.put(320, 1982); // Tomato
        itemIDTable.put(349, 317); // Raw Shrimp
        itemIDTable.put(375, 301); // Lobster Pot
        itemIDTable.put(376, 303); // Small fishing net
        itemIDTable.put(377, 307); // Fishing Rod
        itemIDTable.put(378, 309); // Fly Fishing Rod
        itemIDTable.put(379, 311); // Harpoon
        itemIDTable.put(381, 314); // Feather
        itemIDTable.put(401, 1127); // Rune Plate Mail Body
        itemIDTable.put(405, 1359); // rune Axe
        itemIDTable.put(406, 1093); // Rune skirt
        itemIDTable.put(407, 2803); // Rune Plate Mail top
        itemIDTable.put(420, 1540); // Anti dragon breath Shield
        itemIDTable.put(428, 1261); // Black Axe
        itemIDTable.put(504, 2132); // raw beef
        itemIDTable.put(548, 305); // Big Net
        itemIDTable.put(594, 1377); // Dragon axe
        itemIDTable.put(597, 1712); // Charged Dragonstone Amulet
        itemIDTable.put(795, 1149); // Dragon medium Helmet
        itemIDTable.put(971, 1050); // Santa's hat
        itemIDTable.put(1263, 0); // Sleeping Bag
        itemIDTable.put(1278, 1187); // Dragon Square Shield
        itemIDTable.put(1288, 1052); // Cape of legends

        for (int var7 = 0; var7 < 64; ++var7)
            colorConversion[var7] = generateColor(-(4 * var7) + 255, -114, 255 - var7 * 4, -((int) ((double) var7 * 1.75D)) + 255);

        for (int var8 = 0; var8 < 64; ++var8)
            colorConversion[var8 + 64] = generateColor(0, -124, var8 * 3, 144);

        for (int var5 = 0; var5 < 64; ++var5)
            colorConversion[128 + var5] = generateColor(0, -108, 192 - (int) ((double) var5 * 1.5D), 144 - (int) ((double) var5 * 1.5D));

        for (int var6 = 0; var6 < 64; ++var6)
            colorConversion[192 + var6] = generateColor(0, -112, -((int) (1.5D * (double) var6)) + 96, 48 + (int) (1.5D * (double) var6));

        System.out.println("using rsc protocol");
    }

    public static RSInterface getInventoryInterface()
    {
        RSInterface tab = null;
        for (int i = 0; i < RSInterface.cache.length; i++)
        {
            if (RSInterface.cache[i] == null)
                continue;
            if (RSInterface.cache[i].inventory && RSInterface.cache[i].parentID == 3213)
            {
                tab = RSInterface.cache[i];
                break;
            }
        }
        return tab;
    }

    public static RSInterface getShopInterface()
    {
        RSInterface tab = null;
        for (int i = 0; i < RSInterface.cache.length; i++)
        {
            if (RSInterface.cache[i] == null)
                continue;
            if (RSInterface.cache[i].inventoryItemId != null && RSInterface.cache[i].parentID == 3824)
            {
                tab = RSInterface.cache[i];
                break;
            }
        }
        return tab;
    }

    public static RSInterface getBankInterface()
    {
        RSInterface tab = null;
        for (int i = 0; i < RSInterface.cache.length; i++)
        {
            if (RSInterface.cache[i] == null)
                continue;
            if (RSInterface.cache[i].inventoryItemId != null && RSInterface.cache[i].parentID == 5292)
            {
                tab = RSInterface.cache[i];
                break;
            }
        }
        return tab;
    }

    public static void Update(Client client)
    {
        if (!rscProtocol)
            return;

        // Update local player
        if (Client.localPlayer != null)
            Client.localPlayer.RSC_update();

        // Update other players
        for (int i = 0; i < client.localPlayerCount; i++)
        {
            Player otherPlayer = client.players[client.localPlayers[i]];
            otherPlayer.RSC_update();
        }

        // Update npcs
        for (int i = 0; i < client.npcCount; i++)
        {
            NPC otherNPC = client.npcs[client.npcIds[i]];
            otherNPC.RSC_update();
        }

        // Update Shop
        if (showShop) {
            client.sendInterface(3824);
            RSInterface shop = getShopInterface();
            if (shop != null)
            {
                for (int i = 0; i < shopItemCount; i++) {
                    shop.inventoryItemId[i] = RSCConfig.RSC_TranslateItem(shopItem[i]) + 1;
                    shop.inventoryStackSize[i] = shopItemAmount[i];
                }

                for (int i = shopItemCount; i < shop.inventoryItemId.length; i++) {
                    shop.inventoryItemId[i] = 0;
                    shop.inventoryStackSize[i] = 0;
                }
                showShop = false;
                shopOpen = true;
            }
        }

        // Update Bank
        if (showBank) {
            client.sendInterface(5292);
            RSInterface bank = getBankInterface();
            if (bank != null) {
                int count = Math.min(bankItemCount, bankItemMax);

                for (int i = 0; i < count; i++) {
                    bank.inventoryItemId[i] = RSCConfig.RSC_TranslateItem(bankItem[i]) + 1;
                    bank.inventoryStackSize[i] = bankItemAmount[i];
                }

                for (int i = count; i < bank.inventoryItemId.length; i++) {
                    bank.inventoryItemId[i] = 0;
                    bank.inventoryStackSize[i] = 0;
                }
                showBank = false;
                bankOpen = true;
            }
        }

        // Check if bank is closed
        if (bankOpen)
        {
            if (client.openInterfaceId != 5292)
            {
                client.stream.RSC_newPacket(212);
                client.stream.RSC_finalizePacket();
                bankOpen = false;
            }
        }

        // Check if shop is closed
        if (shopOpen)
        {
            if (client.openInterfaceId != 3824)
            {
                client.stream.RSC_newPacket(166);
                client.stream.RSC_finalizePacket();
                shopOpen = false;
            }
        }

        // Update inventory
        if (inventoryUpdate) {
            RSInterface tab = getInventoryInterface();
            int count = inventoryCount;
            int length = Math.min(tab.inventoryItemId.length, inventoryID.length);

            if (tab != null) {
                for (int i = 0; i < count; i++) {
                    tab.inventoryItemId[i] = RSC_TranslateItem(inventoryID[i]) + 1;
                    tab.inventoryStackSize[i] = inventoryAmount[i];
                }

                for (int i = count; i < length; i++)
                {
                    tab.inventoryItemId[i] = -1;
                    tab.inventoryStackSize[i] = 0;
                }
            }

            client.redrawTab = true;
            inventoryUpdate = false;
        }
    }

    public static int RSC_convertXP(int xp)
    {
        return xp / 4;
    }

    public static String RSC_SanitizeMenu(String option)
    {
        if (option.equalsIgnoreCase("examine"))
            return null;
        if (option.equalsIgnoreCase("walkto"))
            return null;

        return option;
    }

    public static void RSC_selectDialogueOption(Client client, Buffer buffer, int option)
    {
        buffer.RSC_newPacket(116);
        buffer.put(option);
        buffer.RSC_finalizePacket();
        client.resetChatInterface();
    }

    public static void RSC_selectAttackStyle(Buffer buffer, int option)
    {
        if (option < 0)
            option = 0;
        else if (option > 3)
            option = 3;

        buffer.RSC_newPacket(29);
        buffer.put(option);
        buffer.RSC_finalizePacket();
    }

    public static void RSC_HandleLogin(Client client)
    {
        if (!rscProtocol)
        {
            return;
        }
        /*
            TODO:

            - Remove unused skills
            - Remove accept aid
         */

        // Initialize rsc state
        playerCount = 0;
        npcCount = 0;
        regionX = -1000;
        regionY = -1000;

        // Set settings
        client.sendConfig(166, Settings.getBrightness() + 1); // Brightness
        client.sendConfig(287, Settings.getSplitPrivateChat() ? 1 : 0); // Split private chat
        client.sendConfig(171, 0); // Chat effects

        // Set sidebar interfaces
        client.setSidebarID(0, 2423); // Combat Style
        client.setSidebarID(1, 3917); // Stats
        //client.setSidebarID(2, 638); // Quest
        client.setSidebarID(3, 3213); // Inventory
        client.setSidebarID(8, 5065); // Friends
        client.setSidebarID(10, 2449); // Logout
        client.setSidebarID(11, 4445); // Settings

        // Setup friends list
        client.friendListStatus = 2;

        getInventoryInterface().resizeInventory(4, 8);

        // Setup player actions
        client.playerActionText[0] = "Duel with";
        client.playerActionText[1] = "Trade with";
        client.playerActionText[2] = "Follow";
        client.playerActionText[3] = "Report abuse";
        client.playerActionUnpinned[0] = true;
        client.playerActionUnpinned[1] = true;
        client.playerActionUnpinned[2] = true;
        client.playerActionUnpinned[3] = true;

        Region.POWERS_OF_TWO = new int[]{1, 16, 2, 32, 4, 64, 8, 128};
    }

    public static void RSC_HandleInterface(int actionID, Client client, Buffer buffer)
    {
        switch (actionID)
        {
            case 952: // Split Private Chat (On)
                Settings.setSplitPrivateChat(true);
                break;
            case 953: // Split Private Chat (Off)
                Settings.setSplitPrivateChat(false);
                break;
            case 5452: // Brightness (Dark)
                Settings.setBrightness(0);
                break;
            case 6273: // Brightness (Normal)
                Settings.setBrightness(1);
                break;
            case 6275: // Brightness (Bright)
                Settings.setBrightness(2);
                break;
            case 6277: // Brightness (Very Bright)
                Settings.setBrightness(3);
                break;
            case 6279: // Mouse Buttons (One)
            {
                buffer.RSC_newPacket(111);
                buffer.put(2);
                buffer.put(1);
                buffer.RSC_finalizePacket();
                break;
            }
            case 6278: // Mouse Buttons (Two)
            {
                buffer.RSC_newPacket(111);
                buffer.put(2);
                buffer.put(0);
                buffer.RSC_finalizePacket();
                break;
            }
            case 2458: // Logout button
            {
                // TODO: Handle combat timer
                buffer.RSC_newPacket(102);
                buffer.RSC_finalizePacket();
                break;
            }
            case 2461: // Dialogue Option 1
            case 2471:
            case 2482:
            case 2494:
                RSC_selectDialogueOption(client, buffer, 0);
                break;
            case 2462: // Dialogue Option 2
            case 2472:
            case 2483:
            case 2495:
                RSC_selectDialogueOption(client, buffer, 1);
                break;
            case 2473: // Dialogue Option 3
            case 2484:
            case 2496:
                RSC_selectDialogueOption(client, buffer, 2);
                break;
            case 2485: // Dialogue Option 4
            case 2497:
                RSC_selectDialogueOption(client, buffer, 3);
                break;
            case 2498: // Dialogue Option 5
                RSC_selectDialogueOption(client, buffer, 4);
                break;
            case 2429: // Attack Style (Accurate)
                RSC_selectAttackStyle(buffer, 2);
                break;
            case 2432: // Attack Style (Aggressive)
                RSC_selectAttackStyle(buffer, 1);
                break;
            case 2431: // Attack Style (Controlled)
                RSC_selectAttackStyle(buffer, 0);
                break;
            case 2430: // Attack Style (Defensive)
                RSC_selectAttackStyle(buffer, 3);
                break;
            default:
            {
                System.out.println("Unhandled interface action id: " + actionID);
                break;
            }
        }
    }

    public static void RSC_loadEntityAnimation(Entity npc, int id)
    {
        // Load default animation
        npc.standAnimationId = 0x328;
        npc.standTurnAnimationId = 0x337;
        npc.walkAnimationId = 0x333;
        npc.turnAboutAnimationId = 0x334;
        npc.turnRightAnimationId = 0x335;
        npc.turnLeftAnimationId = 0x336;
        npc.RSC_attackAnimationId = 451;
    }

    public static NPC RSC_getNPC(Client client, int serverIndex, int areaX, int areaY, int direction, int id)
    {
        // Add player if it doesn't exist
        if (client.npcs[serverIndex] == null || client.npcs[serverIndex].index != serverIndex)
        {
            client.npcs[serverIndex] = new NPC();
            client.npcs[serverIndex].index = serverIndex;
            client.npcs[serverIndex].setPos(areaX, areaY, true);
            client.npcs[serverIndex].turnDirection = RSC_ConvertDirection(direction);
            client.npcs[serverIndex].currentRotation = client.npcs[serverIndex].turnDirection;
            client.npcs[serverIndex].npcDefinition = EntityDefinition.getDefinition(RSCConfig.RSC_TranslateNPC(id));
            RSC_loadEntityAnimation(client.npcs[serverIndex], id);
        }

        NPC npc = client.npcs[serverIndex];

        if (npc.waypointX[0] != areaX || npc.waypointY[0] != areaY)
            npc.setPos(areaX, areaY, false);

        npcs[npcCount++] = npc;

        return npc;
    }

    public static Player RSC_getPlayer(Client client, int serverIndex, int areaX, int areaY, int direction)
    {
        // Add player if it doesn't exist
        if (client.players[serverIndex] == null || client.players[serverIndex].index != serverIndex)
        {
            client.players[serverIndex] = new Player();
            client.players[serverIndex].index = serverIndex;
            client.players[serverIndex].setPos(areaX, areaY, true);
            client.players[serverIndex].turnDirection = RSC_ConvertDirection(direction);
            client.players[serverIndex].currentRotation = client.players[serverIndex].turnDirection;
            RSC_loadEntityAnimation(client.players[serverIndex], -1);
        }

        Player player = client.players[serverIndex];
        boolean isLocal = false;
        boolean isSelf = false;

        if (player.waypointX[0] != areaX || player.waypointY[0] != areaY)
            player.setPos(areaX, areaY, false);

        if (serverIndex == localServerIndex)
        {
            isSelf = true;
            Client.localPlayer = player;
        }

        if (!isSelf)
            players[playerCount++] = player;

        return player;
    }

    public static int RSC_TranslateObject(int objectID)
    {
        Integer val = objectIDTable.get(objectID);
        if (val == null)
        {
            val = objectWallDecorationIDTable.get(objectID);
            if (val == null)
            {
                val = objectWallIDTable.get(objectID);
                if (val == null) {
                    System.out.println("Unhandled object id: " + objectID);
                    return -1;
                }
            }
        }
        return val.intValue();
    }

    public static int RSC_TranslateObjectReverse(int objectID)
    {
        Integer val = objectIDTable.getKey(objectID);
        if (val == null)
        {
            val = objectWallDecorationIDTable.getKey(objectID);
            if (val == null)
            {
                val = objectWallIDTable.getKey(objectID);
                if (val == null) {
                    System.out.println("Unhandled reverse object id: " + objectID);
                    return -1;
                }
            }
        }
        return val.intValue();
    }

    public static int RSC_TranslateNPC(int npcID)
    {
        Integer val = npcIDTable.get(npcID);
        if (val == null)
        {
            System.out.println("Unhandled npc id: " + npcID);
            return 100;
        }
        return val.intValue();
    }

    public static int RSC_TranslateNPCReverse(int npcID)
    {
        Integer val = npcIDTable.getKey(npcID);
        if (val == null)
        {
            System.out.println("Unhandled reverse npc id: " + npcID);
            return 100;
        }
        return val.intValue();
    }

    public static int RSC_TranslateWall(int id)
    {
        switch (id)
        {
            case 1: // Stone Wall
                return 1902;
            case 6: // Metal Fence
                return 2068;
            case 4: // Stone Wall Window
                return 1902;
            case 5: // Wooden Fence
                return 65;
            case 15: // White Wall
                return 2855;
            case 16: // White Wall Window
                return 2855;
            default:
                System.out.println("Unhandled wall conversion: " + id);
                break;
        }

        return -1;
    }

    public static int RSC_TranslateItem(int itemID)
    {
        Integer val = itemIDTable.get(itemID);
        if (val == null)
        {
            System.out.println("Unhandled item id: " + itemID);
            return -1;
        }
        return val.intValue();
    }

    public static int RSC_TranslateItemReverse(int itemID)
    {
        Integer val = itemIDTable.getKey(itemID);
        if (val == null)
        {
            System.out.println("Unhandled reverse item id: " + itemID);
            return -1;
        }
        return val.intValue();
    }

    public static int RSC_TranslateEquipment(int equipID)
    {
        switch (equipID)
        {
            case 1: // Head, without beard
                return -2;
            case 2:
            case 3: // Legs, but they're always the same
            case 5:
                return -1;
            case 4:
                return -6;
            case 7: // Head, with beard
                return -3;
            case 8: // Head, without beard and bald
                return -4;

            case 12: // Boots
                return RSC_TranslateItem(17);
            case 13: // Large Bronze Helmet
                return RSC_TranslateItem(108);
            case 21: // Bronze Chain Mail Body
                return RSC_TranslateItem(113);
            case 28: // Bronze Plate Mail Body
                return RSC_TranslateItem(117);
            case 34: // Rune Plate Mail Body
                return RSC_TranslateItem(401);
            case 37: // Bronze Plate Mail Legs
                return RSC_TranslateItem(206);
            case 47: // Leather Gloves
                return RSC_TranslateItem(16);
            case 49: // Iron Sword
                return RSC_TranslateItem(71);
            case 60: // Rune Plate Mail top
                return RSC_TranslateItem(407);
            case 63: // Cape (red)
                return RSC_TranslateItem(183);
            case 70: // Medium Bronze Helmet
                return RSC_TranslateItem(104);
            case 77: // Wizards robe
                return RSC_TranslateItem(184);
            case 78: // wizardshat
                return RSC_TranslateItem(185);
            case 80: // Silver amulet
                return 1796;
            case 81: // Gold amulet
                return RSC_TranslateItem(288);
            case 82: // skirt
                return RSC_TranslateItem(187);
            case 89: // skirt
                return RSC_TranslateItem(195);
            case 90: // skirt (pink)
                return RSC_TranslateItem(194);
            case 97: // Rune skirt
                return RSC_TranslateItem(406);
            case 98: // Bronze Square Shield
                return RSC_TranslateItem(124);
            case 105: // Anti dragon breath Shield
                return RSC_TranslateItem(420);
            case 106: // Wooden Shield
                return RSC_TranslateItem(4);
            case 109: // bronze Axe
                return RSC_TranslateItem(205);
            case 110: // iron Axe
                return RSC_TranslateItem(89);
            case 114: // rune Axe
                return RSC_TranslateItem(93);
            case 117: // Iron Mace
                return RSC_TranslateItem(0);
            case 118: // Steel Mace
                return RSC_TranslateItem(95);
            case 162: // Dragon axe
                return RSC_TranslateItem(594);
            case 172: // Black amulet
                return 4677;
            case 179: // Dragon medium Helmet
                return RSC_TranslateItem(795);
            case 209: // Santa's hat
                return RSC_TranslateItem(971);
            case 225: // Dragon Square Shield
                return RSC_TranslateItem(1278);
            case 226: // Cape of legends
                return RSC_TranslateItem(1288);


            default:
                System.out.println("Unhandled equipment id: " + equipID);
                break;
        }

        return -1;
    }

    public static boolean RSC_isFemaleEquipment(int id)
    {
        switch(id)
        {
            case 60:
            case 5:
                return true;
        }

        return false;
    }

    public static boolean RSC_isWeapon(int itemID)
    {
        switch (itemID)
        {
            case 1279: // Iron Short Sword
            case 1424: // Steel Mace
            case 1420: // Iron Mace
            case 1377: // Dragon axe
            case 1351: // bronze Axe
            case 1349: // Iron Axe
            case 1353: // Steel Axe
            case 1361: // Black Axe
            case 1355: // Mithril Axe
            case 1357: // Adamantite Axe
            case 1359: // rune Axe
            case 1375: // bronze battle Axe
            case 1363: // Iron battle Axe
            case 1365: // Steel battle Axe
            case 1369: // Mithril battle Axe
            case 1373: // Rune battle Axe
            case 1203: // Iron Dagger
            case 1293: // Iron Long Sword
                return true;
        }

        return false;
    }

    public static boolean RSC_isAxe(int itemID)
    {
        switch (itemID)
        {
            case 1351: // bronze Axe
            case 1349: // Iron Axe
            case 1353: // Steel Axe
            case 1361: // Black Axe
            case 1355: // Mithril Axe
            case 1357: // Adamantite Axe
            case 1359: // rune Axe
                return true;
        }

        return false;
    }

    public static boolean RSC_isGlove(int itemID)
    {
        switch (itemID)
        {
            case 1059: // Leather Gloves
                return true;
        }

        return false;
    }

    public static boolean RSC_isAmulet(int itemID)
    {
        switch (itemID)
        {
            case 1692: // Gold Amulet
            case 1654: // Gold necklace
            case 1796: // (RS2) Silver necklace
            case 4677: // (RS2) Crystal pendant
                return true;
        }

        return false;
    }

    public static boolean RSC_isFullHelmet(int itemID)
    {
        switch (itemID)
        {
            case 1155: // bronze Axe
                return true;
        }

        return false;
    }

    public static boolean RSC_isShield(int itemID)
    {
        switch (itemID)
        {
            case 1187: // Dragon Square Shield
            case 1173: // Bronze Square Shield
            case 1540: // Anti dragon breath Shield
            case 1171: // Wooden Shield
                return true;
        }

        return false;
    }

    public static boolean RSC_isMediumHelmet(int itemID)
    {
        switch (itemID)
        {
            case 1139: // Medium Bronze Helmet
            case 1149: // Dragon medium Helmet
                return true;
        }

        return false;
    }

    public static boolean RSC_isLeg(int itemID)
    {
        switch (itemID)
        {
            case 1093: // Rune skirt
            case 1015: // skirt (black)
            case 1011: // skirt (blue)
            case 1013: // skirt (pink)
            case 1075: // Bronze Plate Mail Legs
                return true;
        }

        return false;
    }

    public static boolean RSC_isHat(int itemID)
    {
        switch (itemID)
        {
            case 1050: // Santa's hat
            case 579: // wizardshat
                return true;
        }

        return false;
    }

    public static boolean RSC_isPlatebody(int itemID)
    {
        switch (itemID)
        {
            case 2803: // Rune Plate Mail top
            case 1127: // Rune platebody
            case 1117: // Bronze Plate Mail Body
            case 577: // Wizards robe
                return true;
        }

        return false;
    }

    public static boolean RSC_isChainmail(int itemID)
    {
        switch (itemID)
        {
            case 1103: // Bronze Chain Mail Body
                return true;
        }

        return false;
    }

    public static boolean RSC_isCape(int itemID)
    {
        switch (itemID)
        {
            case 1007: // Cape (red)
            case 1052: // Cape of legends
                return true;
        }

        return false;
    }

    public static boolean RSC_isBoot(int itemID)
    {
        switch (itemID)
        {
            case 1061: // Boots
                return true;
        }

        return false;
    }

    public static int RSC_TranslateTopColor(int color)
    {
        // 1 - Black
        // 3 - Dark Blue
        // 4 - Yellow
        switch (color)
        {
            case 0: // Red
                return 6;
            case 11: // Black
                return 1;
            case 8: // Blue
                return 7;
            case 14: // White
                return 5;
            default:
                System.out.println("Unhandled top color: " + color);
                break;
        }

        return color;
    }

    public static int RSC_TranslateBottomColor(int color)
    {
        // 15 - Light blue
        switch (color)
        {
            case 4: // Light Green
                return 9;
            case 5: // Dark Green
                return 0;
            case 9: // Blue
                return 8;
            case 11: // Black
                return 2;
            case 14: // White
                return 6;
            default:
                System.out.println("Unhandled bottom color: " + color);
                break;
        }

        return color;
    }

    public static int RSC_TranslateSkinColor(int color)
    {
        // Skin colors seem to remain the same
        // TODO: Double check, until this TODO is gone, it hasn't been checked!
        return color;
    }

    public static int RSC_TranslateHairColor(int color)
    {
        // 5 - Blonde
        // 8 - Blue
        // 9 - Green
        switch (color)
        {
            case 2: // Brown
                return 0;
            case 6: // Orange
                return 10;
            case 7: // White
                return 1;
            default:
                System.out.println("Unhandled hair color: " + color);
                break;
        }

        return color;
    }

    public static int RSC_ConvertDirection(int direction)
    {
        switch (direction)
        {
            case 0: // South
                return 0;
            case 1: // Southeast
                return (int) (Math.atan2(-1, 1) * 325.949) & 0x7FF;
            case 2: // East
                return (int) (Math.atan2(-1, 0) * 325.949) & 0x7FF;
            case 3: // Northeast
                return (int) (Math.atan2(-1, -1) * 325.949) & 0x7FF;
            case 4: // North
                return (int) (Math.atan2(0, -1) * 325.949) & 0x7FF;
            case 5: // Northwest
                return (int) (Math.atan2(1, -1) * 325.949) & 0x7FF;
            case 6: // West
                return (int) (Math.atan2(1, 0) * 325.949) & 0x7FF;
            case 7: // Southwest
                return (int) (Math.atan2(1, 1) * 325.949) & 0x7FF;
            default:
                System.out.println("Unhandled rsc direction: " + direction);
                break;
        }

        return direction;
    }

    public static void RSC_PlayChatAnimation(Player player, String message)
    {
        if (!Settings.getLocalAnimations())
            return;

        // Reset Animation
        int animation = -1;

        // Thieving
        if (message.toLowerCase().startsWith("you attempt to pick") && message.toLowerCase().endsWith("pocket"))
            animation = 881;

        // Prayer
        if (message.toLowerCase().startsWith("you dig a hole in the ground"))
            animation = 827;

        // Set Animation
        if (animation != -1)
        {
            player.RSC_queuedAnimation = animation;
            player.RSC_queuedAnimationEnd = Client.tick + 150;
        }
    }

    public static void RSC_PlayItemAnimation(Player player, int itemID, int length)
    {
        int rscItemID = itemID;
        itemID = RSC_TranslateItem(itemID);

        // We don't know what item it is, we can't play an animation
        if (itemID == -1)
            return;

        // Reset Animation
        int animation = -1;

        // Cooking
        switch (itemID)
        {
            // TODO: Ok, so, if you're cooking on a range it plays 883
            case 2138: // raw chicken
            case 2132: // raw beef
                animation = 897;
                break;
        }

        // Fishing
        switch (itemID)
        {
            case 301: // Lobster Pot
                animation = 619;
                break;
            case 303: // Net
                animation = 621;
                break;
            case 305: // Big Net
                animation = 620;
                break;
            case 307: // Fishing Rod
            case 309: // Fly Fishing Rod
                animation = 622;
                break;
            case 311: // Harpoon
                animation = 618;
                break;
        }

        // Woodcutting
        switch (itemID)
        {
            case 1351: // bronze Axe
                animation = 879;
                break;
            case 1349: // Iron Axe
                animation = 877;
                break;
            case 1353: // Steel Axe
                animation = 875;
                break;
            case 1361: // Black Axe
                animation = 873;
                break;
            case 1355: // Mithril Axe
                animation = 871;
                break;
            case 1357: // Adamantite Axe
                animation = 869;
                break;
            case 1359: // rune Axe
                animation = 867;
                break;
        }

        // Firemaking
        if (itemID == 590)
            animation = 733;

        // Shearing
        if (itemID == 1735)
            animation = 893;

        // Restart Animation if it was set
        if (animation != -1)
        {
            player.RSC_queuedAnimation = animation;
            player.RSC_queuedAnimationEnd = Client.tick + 150;
        }
        else
        {
            System.out.println("Unhandled bubble animation: " + rscItemID);
        }
    }

    public static String RSC_removeChatFormatting(String str)
    {
        str = RSC_removeStringFormatting(str, '@');
        str = RSC_removeStringFormatting(str, '~');
        return str;
    }

    public static String RSC_removeStringFormatting(String str, char removeCharacter)
    {
        int pos = -1;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (c == removeCharacter)
            {
                if (pos == -1)
                {
                    pos = i;
                }
                else
                {
                    int diff = i - pos;
                    if (diff >= 4)
                    {
                        str = str.substring(0, pos) + str.substring(i + 1);
                        i -= 5;
                        pos = -1;
                    }
                    else
                    {
                        pos = i;
                    }
                }
            }
        }

        return str;
    }

    public static void RSC_sortFriendList(Client client) {
        boolean go = true;

        while (go) {
            go = false;

            for (int index = 0; index < (client.friendsCount - 1); ++index) {
                // TODO: I think this sorting also sorts based on same world or not
                if (client.friendsWorldIds[index] == 0 && client.friendsWorldIds[index + 1] != 0) {
                    String server = friendServers[index];
                    friendServers[index] = friendServers[index + 1];
                    friendServers[index + 1] = server;
                    String name = client.friendsList[index];
                    client.friendsList[index] = client.friendsList[index + 1];
                    client.friendsList[index + 1] = name;
                    int online = client.friendsWorldIds[index];
                    client.friendsWorldIds[index] = client.friendsWorldIds[index + 1];
                    client.friendsWorldIds[index + 1] = online;
                    long hash = client.friendsListAsLongs[index];
                    client.friendsListAsLongs[index] = client.friendsListAsLongs[index + 1];
                    client.friendsListAsLongs[index + 1] = hash;
                    go = true;
                }
            }
        }
        ;
    }

    public static int RSC_fixObjectDirection(int id, int direction)
    {
        if (!objectIDDirTable.containsKey(id))
            return direction;

        direction = (direction + objectIDDirTable.get(id)) % 8;
        return direction;
    }

    public static void RSC_TurnEntityDir(Entity npc, int nextAnim)
    {
        boolean wasCombat = npc.RSC_combatMode != -1;
        if (nextAnim == 9) {
            npc.RSC_combatMode = 1;
        } else if (nextAnim == 8) {
            npc.RSC_combatMode = 0;
        } else {
            npc.RSC_turnDirection = RSC_ConvertDirection(nextAnim);
            npc.RSC_combatMode = -1;
            npc.RSC_forceTurn = wasCombat;
        }
    }

    public static void RSC_MoveEntityDir(Entity npc, int nextAnim)
    {
        int x = npc.waypointX[0];
        int y = npc.waypointY[0];
        if (nextAnim == 2 || nextAnim == 1 || nextAnim == 3)
            x += 1;
        if (nextAnim == 6 || nextAnim == 5 || nextAnim == 7)
            x -= 1;
        if (nextAnim == 4 || nextAnim == 3 || nextAnim == 5)
            y += 1;
        if (nextAnim == 0 || nextAnim == 1 || nextAnim == 7)
            y -= 1;
        npc.RSC_combatMode = -1;
        npc.setPos(x, y, false);
    }

    public static int RSC_CountInventoryItem(int rscID)
    {
        int count = 0;
        for (int i = 0; i < inventoryCount; i++)
        {
            if (inventoryID[i] == rscID)
                count += inventoryAmount[i];
        }
        return count;
    }

    public static void RSC_HitEntity(Entity entity, int damage, int hp, int hpMax)
    {
        int type = -1;
        if (entity instanceof Player)
            type = 1;
        else if (entity instanceof NPC)
            type = 0;
        // Players have red hit splats in rsc
        entity.updateHitData(type, damage, Client.tick);
        entity.loopCycleStatus = Client.tick + 200;
        entity.currentHealth = hp;
        entity.maxHealth = hpMax;
    }

    public static int RSC_HandleOpcode(int opcode, Client client, Buffer buffer)
    {
        if (!rscProtocol)
            return opcode;

        int ret = -1;

        switch (opcode)
        {
            case 249:
            {
                int slot = buffer.getUnsignedByte();
                bankItem[slot] = buffer.getUnsignedLEShort();
                bankItemAmount[slot] = buffer.RSC_getUnsignedInt3();
                if (bankItemAmount[slot] == 0)
                {
                    bankItemCount--;

                    for (int index = slot; bankItemCount > index; ++index) {
                        bankItem[index] = bankItem[index + 1];
                        bankItemAmount[index] = bankItemAmount[index + 1];
                    }
                }
                else
                {
                    if (slot >= bankItemCount)
                        bankItemCount = slot + 1;
                }
                showBank = true;
                break;
            }
            case 42:
            {
                bankItemCount = buffer.getUnsignedByte();
                bankItemMax = buffer.getUnsignedByte();
                for (int i = 0; i < bankItemCount; i++)
                {
                    bankItem[i] = buffer.getUnsignedLEShort();
                    bankItemAmount[i] = buffer.RSC_getUnsignedInt3();
                }
                showBank = true;
                break;
            }
            case 203: // Close bank
            {
                showBank = false;
                bankOpen = false;
                client.clearTopInterfaces();
                break;
            }
            case 137: // Close shop
            {
                showShop = false;
                shopOpen = false;
                client.clearTopInterfaces();
                break;
            }
            case 104:
            {
                int npcCount = buffer.getUnsignedLEShort();
                for (int i = 0; i < npcCount; i++)
                {
                    int serverIndex = buffer.getUnsignedLEShort();
                    NPC npc = client.npcs[serverIndex];
                    int updateType = buffer.getUnsignedByte();
                    switch (updateType)
                    {
                        case 1:
                        {
                            int playerServerIndex = buffer.getUnsignedLEShort();
                            String message = buffer.RSC_cabbage();
                            if (npc != null)
                                client.RSC_setTextMessage(npc, message, playerServerIndex);
                            break;
                        }
                        case 2:
                        {
                            int damage = buffer.getUnsignedByte();
                            int hp = buffer.getUnsignedByte();
                            int hpMax = buffer.getUnsignedByte();
                            RSC_HitEntity(npc, damage, hp, hpMax);
                            break;
                        }
                    }
                }
                break;
            }
            case 99: // Ground Items
            {
                while (client.packetSize > buffer.position)
                {
                    if (buffer.getUnsignedByte() == 255) {
                        int x = buffer.get() >> 3;
                        int y = buffer.get() >> 3;
                    } else {
                        buffer.position--;
                        int mod = buffer.getUnsignedLEShort();
                        int x = buffer.get();
                        int y = buffer.get();

                        if (('\u8000' & mod) == 0) {
                            int rs2ID = RSCConfig.RSC_TranslateItem(mod);
                            if (rs2ID != -1)
                            {
                                System.out.println("SPAWN GROUND ITEM: " + mod + ", " + rs2ID + ", " + x + ", " + y);
                                client.RSC_spawnGroundItem(x, y, rs2ID);
                            }
                        } else {
                            mod &= 32767;
                            int rs2ID = RSCConfig.RSC_TranslateItem(mod);
                            if (rs2ID != -1) {
                                System.out.println("REMOVE GROUND ITEM: " + mod + ", " + x + ", " + y);
                                client.RSC_removeGroundItem(x, y, rs2ID);
                            }
                        }
                    }
                }
                break;
            }
            case 5:
            {
                for (int i = 0; i < Game.QUEST_COUNT; i++)
                    questComplete[i] = (buffer.get() == 1);

                //client.sendInterfaceString(663, "0"); // FREE QUESTS

                break;
            }
            case 149:
            {
                String name = buffer.RSC_readString();
                String oldName = buffer.RSC_readString();
                String server = "";
                int onlineStatus = buffer.getUnsignedByte();

                boolean loggedIn = (4 & onlineStatus) != 0;
                boolean wasAdded = false;
                int index = -1;

                if (loggedIn)
                    server = buffer.RSC_readString();

                for (int i = 0; i < client.friendsCount; i++)
                {
                    if (client.friendsList[i].equals(name))
                    {
                        index = i;
                        break;
                    }
                }

                if (index == -1)
                {
                    index = client.friendsCount++;
                    client.friendsList[index] = name;
                    client.friendsListAsLongs[index] = TextClass.nameToLong(name.trim());
                    wasAdded = true;
                }

                int prevWorldId = client.friendsWorldIds[index];
                client.friendsWorldIds[index] = loggedIn ? 10 : 0;
                friendServers[index] = server;
                RSC_sortFriendList(client);
                client.redrawTab = true;

                if (wasAdded)
                    prevWorldId = client.friendsWorldIds[index];

                if (prevWorldId == 0 && client.friendsWorldIds[index] != 0)
                    client.pushMessage(name + " has logged in.", 5, "");
                else if (prevWorldId != 0 && client.friendsWorldIds[index] == 0)
                    client.pushMessage(name + " has logged out.", 5, "");

                break;
            }
            case 87:
            {
                String sender = buffer.RSC_readString();
                String message = buffer.RSC_cabbage();
                message = RSCConfig.RSC_removeChatFormatting(message);
                client.pushMessage(message, 6, sender);
                break;
            }
            case 111:
            {
                boolean tutorial = buffer.getUnsignedByte() != 0;
                client.inTutorialIsland = tutorial;
                break;
            }
            case 53: // Inventory
            {
                inventoryCount = buffer.getUnsignedByte();
                for (int i = 0; i < inventoryCount; i++)
                {
                    int mod = buffer.getUnsignedLEShort();
                    inventoryID[i] = mod & 32767;
                    inventoryEquipped[i] = (mod / '\u8000') == 1;
                    inventoryAmount[i] = 1;
                    if (JGameData.itemStackable[inventoryID[i]])
                        inventoryAmount[i] = buffer.RSC_getUnsignedInt3();
                }
                inventoryUpdate = true;
                break;
            }
            case 123: // Inventory remove
            {
                int slot = buffer.getUnsignedByte();
                inventoryCount--;

                for (int i = slot; i < inventoryCount; i++)
                {
                    inventoryID[i] = inventoryID[i + 1];
                    inventoryAmount[i] = inventoryAmount[i + 1];
                    inventoryEquipped[i] = inventoryEquipped[i + 1];
                }
                inventoryUpdate = true;
                break;
            }
            case 90: // Inventory Slot
            {
                int i = buffer.getUnsignedByte();
                int mod = buffer.getUnsignedLEShort();
                inventoryID[i] = mod & 32767;
                inventoryEquipped[i] = (mod / '\u8000') == 1;
                inventoryAmount[i] = 1;
                if (JGameData.itemStackable[inventoryID[i]])
                    inventoryAmount[i] = buffer.RSC_getUnsignedInt3();
                inventoryUpdate = true;
                if (inventoryCount <= i)
                    inventoryCount = i + 1;
                break;
            }
            case 120:
            {
                String sender = buffer.RSC_readString();
                String senderClan = buffer.RSC_readString();
                int modStatus = buffer.getUnsignedByte();
                long unk = buffer.getLong();
                String message = buffer.RSC_cabbage();
                message = RSCConfig.RSC_removeChatFormatting(message);
                client.pushMessage(message, 7, sender);
                break;
            }
            case 240: // Settings
            {
                int cameraMode = buffer.getUnsignedByte(); // TODO: Maybe use camera mode?
                client.sendConfig(170, buffer.getUnsignedByte()); // Mouse Buttons
                int sound = buffer.getUnsignedByte();
                break;
            }
            case 79: // Local NPC
            {
                client.npcCount = npcCount;
                for (int i = 0; i < npcCount; i++)
                    client.npcIds[i] = npcs[i].index;

                npcCount = 0;
                buffer.initBitAccess();
                int npcUpdateCount = buffer.readBits(8);

                for (int i = 0; i < npcUpdateCount; i++)
                {
                    NPC npc = client.npcs[client.npcIds[i]];

                    int reqUpdate = buffer.readBits(1);
                    if (reqUpdate != 0) {
                        int updateType = buffer.readBits(1);
                        if (updateType != 0)
                        {
                            int unk = buffer.readBits(2);
                            if (unk == 3)
                                continue;
                            int nextAnim = (unk << 2) + buffer.readBits(2);
                            RSC_TurnEntityDir(npc, nextAnim);
                        }
                        else
                        {
                            int nextAnim = buffer.readBits(3);
                            RSC_MoveEntityDir(npc, nextAnim);
                            RSC_TurnEntityDir(npc, nextAnim);
                        }
                    }

                    npcs[npcCount++] = npc;
                }

                while (buffer.bitPosition + 34 < client.packetSize * 8)
                {
                    int serverIndex = buffer.readBits(12);
                    int areaX = buffer.readBits(5);
                    if (areaX > 15)
                        areaX -= 32;
                    int areaY = buffer.readBits(5);
                    if (areaY > 15)
                        areaY -= 32;
                    int otherAnim = buffer.readBits(4);
                    int type = buffer.readBits(10);

                    int npcX = localRegionX + areaX;
                    int npcY = localRegionY + areaY;

                    NPC npc = RSC_getNPC(client, serverIndex, npcX, npcY, otherAnim, type);
                    RSC_TurnEntityDir(npc, otherAnim);
                }

                buffer.finishBitAccess();
                break;
            }
            case 191: // Local Player
            {
                client.localPlayerCount = playerCount;
                for (int i = 0; i < playerCount; i++)
                    client.localPlayers[i] = players[i].index;

                buffer.initBitAccess();
                localRegionX = buffer.readBits(11);
                localRegionY = buffer.readBits(13);
                int anim = buffer.readBits(4);

                // Load region
                client.RSC_loadRegion(localRegionX, localRegionY);
                localRegionX -= client.regionX;
                localRegionY -= client.regionY;

                int localX = localRegionX;//64 + magicLoc * localRegionX;
                int localY = localRegionY;//64 + magicLoc * localRegionY;

                client.playerPositionX = localX;
                client.playerPositionY = localY;

                // Set local player
                playerCount = 0;
                Player localPlayer = RSC_getPlayer(client, localServerIndex, localX, localY, anim);
                RSC_TurnEntityDir(localPlayer, anim);

                int playerUpdateCount = buffer.readBits(8);

                for (int i = 0; i < playerUpdateCount; i++)
                {
                    Player player = client.players[client.localPlayers[i]];

                    int reqUpdate = buffer.readBits(1);
                    if (reqUpdate != 0) {
                        int updateType = buffer.readBits(1);
                        if (updateType != 0)
                        {
                            int unk = buffer.readBits(2);
                            if (unk == 3) {
                                continue;
                            }
                            int nextAnim = buffer.readBits(2) + (unk << 2);
                            RSC_TurnEntityDir(player, nextAnim);
                        }
                        else
                        {
                            int nextAnim = buffer.readBits(3);
                            RSC_MoveEntityDir(player, nextAnim);
                            RSC_TurnEntityDir(player, nextAnim);
                        }
                    }

                    players[playerCount++] = player;
                }

                while (client.packetSize * 8 > buffer.bitPosition + 24)
                {
                    int serverIndex = buffer.readBits(11);
                    int areaX = buffer.readBits(5);
                    if (areaX > 15)
                        areaX -= 32;
                    int areaY = buffer.readBits(5);
                    if (areaY > 15)
                        areaY -= 32;
                    int otherAnim = buffer.readBits(4);

                    int playerX = localX + areaX;
                    int playerY = localY + areaY;

                    Player otherPlayer = RSC_getPlayer(client, serverIndex, playerX, playerY, otherAnim);
                    RSC_TurnEntityDir(otherPlayer, otherAnim);
                }

                buffer.finishBitAccess();

                client.loadingMap = false;
                break;
            }
            case 4:
            {
                client.logout();
                break;
            }
            case 48:
            {
                while (client.packetSize > buffer.position)
                {
                    if (buffer.getUnsignedByte() == 255)
                    {
                        // Clear object?
                        int x = buffer.get() >> 3;
                        int y = buffer.get() >> 3;

                        client.RSC_removeGameObject(x, y);

                        System.out.println("Game Object Clear: " + x + ", " + y);
                    }
                    else
                    {
                        buffer.position--;
                        int id = buffer.getUnsignedLEShort();
                        int x = buffer.get();
                        int y = buffer.get();

                        client.RSC_removeGameObject(x, y);

                        if (id == 60000)
                            continue;

                        int rs2ID = RSC_TranslateObject(id);
                        if (rs2ID != -1)
                        {
                            int localX = Client.localPlayer.waypointX[0] + x;
                            int localY = Client.localPlayer.waypointY[0] + y;
                            int posX = client.regionX + localX;
                            int posY = client.regionY + localY;
                            int orientation = JGameData.getTileDirection(posX, posY);
                            orientation = RSC_fixObjectDirection(rs2ID, orientation);
                            client.RSC_spawnGameObject(localX, localY, orientation, rs2ID);
                            System.out.println("Spawning " + rs2ID + " at " + x + ", " + y);
                        }
                    }
                }
                break;
            }
            case 234:
            {
                int playerCount = buffer.getUnsignedLEShort();
                for (int i = 0; i < playerCount; i++)
                {
                    int serverIndex = buffer.getUnsignedLEShort();
                    int updateType = buffer.getUnsignedByte();
                    Player player = client.players[serverIndex];

                    switch (updateType)
                    {
                        case 0:
                        {
                            int itemID = buffer.getUnsignedLEShort();
                            if (player != null)
                                RSC_PlayItemAnimation(player, itemID, 150);
                            break;
                        }
                        case 1:
                        {
                            int mod = buffer.getUnsignedByte();
                            String message = buffer.RSC_cabbage();

                            if (player != null)
                                client.RSC_setTextMessage(player, message, localServerIndex);
                            break;
                        }
                        case 2:
                        {
                            int damage = buffer.getUnsignedByte();
                            int hp = buffer.getUnsignedByte();
                            int hpMax = buffer.getUnsignedByte();
                            if (player == Client.localPlayer) {
                                client.skillLevel[Game.STAT_HITS] = hp;
                                client.redrawTab = true;
                            }
                            RSC_HitEntity(player, damage, hp, hpMax);
                            break;
                        }
                        case 5:
                        {
                            buffer.getUnsignedLEShort();
                            String username = buffer.RSC_readString();
                            buffer.RSC_readString();

                            // Handle equipment
                            int weaponID = -1;
                            int hairID = -1;
                            int beardID = -1;
                            int legID = -1;
                            int feetID = -1;
                            int chestID = -1;
                            int armID = -1;
                            int handID = -1;
                            int amuletID = -1;
                            int shieldID = -1;
                            int genderID = 0;

                            int hatID = -1;
                            int capeID = -1;
                            int helmetID = -1;
                            int medHelmetID = -1;
                            int legArmorID = -1;
                            int chestArmorID = -1;
                            int armArmorID = -1;
                            int handArmorID = -1;
                            int feetArmorID = -1;

                            int equipCount = buffer.getUnsignedByte();
                            for (int x = 0; x < equipCount; x++) {
                                int id = buffer.getUnsignedByte();
                                if (id == 0)
                                    continue;

                                // Female
                                if (RSC_isFemaleEquipment(id))
                                {
                                    genderID = 1;
                                    legID = 70;
                                    feetID = 79;
                                    chestID = 56;
                                    handID = 68;
                                    armID = 61;
                                }

                                id = RSC_TranslateEquipment(id);
                                if (id == -1)
                                    continue;

                                if (id == -3) // Hair with beard
                                {
                                    hairID = 3;
                                    beardID = 11;
                                }
                                if (id == -4) // No hair
                                {
                                    hairID = 0;
                                    beardID = 14;
                                }
                                if (id == -6) // Long Hair
                                {
                                    hairID = 2;
                                    beardID = 14;
                                }
                                if (id == -2) // Short hair, no beard
                                {
                                    hairID = 5;
                                    beardID = 14;
                                }

                                if (RSC_isWeapon(id))
                                    weaponID = id;
                                if (RSC_isHat(id))
                                    hatID = id;
                                if (RSC_isCape(id))
                                    capeID = id;
                                if (RSC_isFullHelmet(id))
                                    helmetID = id;
                                if (RSC_isLeg(id))
                                    legArmorID = id;
                                if (RSC_isPlatebody(id))
                                {
                                    chestArmorID = id;
                                    armArmorID = id;
                                }
                                if (RSC_isChainmail(id))
                                {
                                    chestArmorID = id;
                                    armArmorID = -1;
                                }
                                if (RSC_isMediumHelmet(id))
                                    medHelmetID = id;
                                if (RSC_isGlove(id))
                                    handArmorID = id;
                                if (RSC_isBoot(id))
                                    feetArmorID = id;
                                if (RSC_isAmulet(id))
                                    amuletID = id;
                                if (RSC_isShield(id))
                                    shieldID = id;
                            }

                            if (genderID > 0)
                            {
                                if (beardID != 11)
                                    beardID = -1;

                                switch (hairID)
                                {
                                    case 0:
                                        hairID = 45;
                                        break;
                                    case 2:
                                        hairID = 48;
                                        break;
                                    case 3:
                                        // Bearded lady, do nothing
                                        break;
                                    case 5:
                                        hairID = 51;
                                    default:
                                        System.out.println("Unhandled female hair conversion: " + hairID);
                                        break;
                                }
                            }

                            int colorHair = buffer.getUnsignedByte();
                            int colorTop = buffer.getUnsignedByte();
                            int colorBottom = buffer.getUnsignedByte();
                            int colorSkin = buffer.getUnsignedByte();
                            int level = buffer.getUnsignedByte();
                            int skull = buffer.getUnsignedByte();

                            player.name = username;
                            player.npcAppearance = null;
                            player.combatLevel = level;

                            // Set colors
                            // 0 - hair
                            // 1 - top
                            // 2 - bottom
                            // 3 - feet
                            // 4 - skin
                            colorHair = RSC_TranslateHairColor(colorHair);
                            colorTop = RSC_TranslateTopColor(colorTop);
                            colorBottom = RSC_TranslateBottomColor(colorBottom);
                            colorSkin = RSC_TranslateSkinColor(colorSkin);
                            player.bodyPartColour[0] = colorHair;
                            player.bodyPartColour[1] = colorTop;
                            player.bodyPartColour[2] = colorBottom;
                            player.bodyPartColour[4] = colorSkin;

                            if (weaponID == -1)
                                weaponID = 0;
                            else
                                weaponID = 0x200 + weaponID;

                            if (legID == -1)
                                legID = 0x100 + 36;
                            else
                                legID = 0x100 + legID;

                            if (chestID == -1)
                                chestID = 0x100 + 19;
                            else
                                chestID = 0x100 + chestID;

                            if (feetID == -1)
                                feetID = 0x100 + 42;
                            else
                                feetID = 0x100 + feetID;

                            if (hairID > -1)
                                hairID = 0x100 + hairID;
                            else
                                hairID = 0;

                            if (armID == -1)
                                armID = 0x100 + 26;
                            else
                                armID = 0x100 + armID;

                            if (beardID > -1)
                                beardID = 0x100 + beardID;
                            else
                                beardID = 0;

                            if (handID == -1)
                                handID = 0x100 + 34;
                            else
                                handID = 0x100 + handID;

                            if (amuletID == -1)
                                amuletID = 0;
                            else
                                amuletID = 0x200 + amuletID;

                            if (shieldID == -1)
                                shieldID = 0;
                            else
                                shieldID = 0x200 + shieldID;

                            if (hatID > -1)
                                hatID = 0x200 + hatID;
                            else
                                hatID = 0;

                            if (capeID > -1)
                                capeID = 0x200 + capeID;
                            else
                                capeID = 0;

                            if (helmetID > -1)
                                helmetID = 0x200 + helmetID;

                            if (legArmorID > -1)
                                legArmorID = 0x200 + legArmorID;

                            if (chestArmorID > -1)
                                chestArmorID = 0x200 + chestArmorID;

                            if (medHelmetID > -1)
                                medHelmetID = 0x200 + medHelmetID;

                            if (handArmorID > -1)
                                handArmorID = 0x200 + handArmorID;

                            if (feetArmorID > -1)
                                feetArmorID = 0x200 + feetArmorID;

                            // Full helmet
                            if (helmetID != -1)
                            {
                                beardID = 0; // Remove beard
                                hairID = helmetID;
                            }

                            // Leg armor
                            if (legArmorID != -1)
                                legID = legArmorID;

                            // Chest armor
                            if (chestArmorID != -1)
                                chestID = chestArmorID;

                            // Arm armor
                            if (armArmorID != -1)
                                armID = armArmorID;

                            // Medium helmets
                            if (medHelmetID != -1)
                                hatID = medHelmetID;

                            // Hand armor
                            if (handArmorID != -1)
                                handID = handArmorID;

                            // Feet armor
                            if (feetArmorID != -1)
                                feetID = feetArmorID;

                            // Set appearance
                            player.gender = genderID; // 0 - Male
                            player.appearance[0] = hatID; // Hat
                            player.appearance[1] = capeID; // Cape
                            player.appearance[2] = amuletID; // Amulet
                            player.appearance[3] = weaponID; // Weapon
                            player.appearance[4] = chestID; // Chest
                            player.appearance[5] = shieldID; // Shield
                            player.appearance[6] = armID; // Arms
                            player.appearance[7] = legID; // Legs
                            player.appearance[8] = hairID; // Head
                            player.appearance[9] = handID; // Hands
                            player.appearance[10] = feetID; // Feet
                            player.appearance[11] = beardID; // Beard
                            player.appearanceOffset = 0L;
                            for (int slot = 0; slot < 12; slot++)
                            {
                                player.appearanceOffset <<= 4;
                                if (player.appearance[slot] >= 256) {
                                    player.appearanceOffset += player.appearance[slot] - 256;
                                }
                            }
                            if (player.appearance[0] >= 256)
                                player.appearanceOffset += player.appearance[0] - 256 >> 4;
                            if (player.appearance[1] >= 256)
                                player.appearanceOffset += player.appearance[1] - 256 >> 8;
                            for (int bodyPart = 0; bodyPart < 5; bodyPart++)
                            {
                                player.appearanceOffset <<= 3;
                                player.appearanceOffset += player.bodyPartColour[bodyPart];
                            }
                            player.appearanceOffset <<= 1;
                            player.appearanceOffset += player.gender;

                            player.visible = true;
                            break;
                        }
                        case 6:
                        {
                            String message = buffer.RSC_cabbage();
                            if (player != null)
                                client.RSC_setTextMessage(player, message, serverIndex);
                            break;
                        }
                        default:
                        {
                            System.out.println("Unknown update type: " + updateType);
                            break;
                        }
                    }
                }
                break;
            }
            case 25: // Load Area
            {
                localServerIndex = buffer.getUnsignedLEShort();
                planeWidth = buffer.getUnsignedLEShort();
                planeHeight = buffer.getUnsignedLEShort();
                planeIndex = buffer.getUnsignedLEShort();
                int planeMultiplier = buffer.getUnsignedLEShort();
                planeHeight -= planeIndex * planeMultiplier;
                client.plane = planeIndex;
                System.out.println("Load Area: " + localServerIndex + ", " + planeWidth + ", " + planeHeight + ", " + planeIndex);
                break;
            }
            case 33: // Set XP
            {
                int skill = buffer.getUnsignedByte();
                client.skillExperience[skill] = RSC_convertXP(buffer.getInt());

                client.redrawTab = true;
                break;
            }
            case 159: // Set Skill
            {
                int skill = buffer.getUnsignedByte();
                client.skillLevel[skill] = buffer.getUnsignedByte();
                client.skillMaxLevel[skill] = buffer.getUnsignedByte();
                client.skillExperience[skill] = RSC_convertXP(buffer.getInt());

                client.redrawTab = true;
                break;
            }
            case 156: // Set Stats
            {
                for (int skill = 0; skill < 18; ++skill)
                    client.skillLevel[skill] = buffer.getUnsignedByte();
                for (int skill = 0; skill < 18; ++skill)
                    client.skillMaxLevel[skill] = buffer.getUnsignedByte();
                for (int skill = 0; skill < 18; ++skill)
                    client.skillExperience[skill] = RSC_convertXP(buffer.getInt());

                int questPoints = buffer.getUnsignedByte();
                client.sendConfig(101, questPoints);

                client.redrawTab = true;
                break;
            }
            case 101: // Open Shop
            {
                shopItemCount = buffer.getUnsignedByte();
                int shopType = buffer.getUnsignedByte();
                shopSellPriceMod = buffer.getUnsignedByte();
                shopBuyPriceMod = buffer.getUnsignedByte();
                shopPriceMultiplier = buffer.getUnsignedByte();

                for (int i = 0; i < shopItem.length; i++)
                    shopItem[i] = -1;

                for (int i = 0; i < shopItemCount; i++)
                {
                    shopItem[i] = buffer.getUnsignedLEShort();
                    shopItemAmount[i] = buffer.getUnsignedLEShort();
                    shopItemPrice[i] = buffer.getUnsignedLEShort();
                }

                showShop = true;
                break;
            }
            case 252: // Close Option Menu
            {
                client.resetChatInterface();
                break;
            }
            case 245: // Option Menu
            {
                int optionCount = buffer.getUnsignedByte();
                String[] options = new String[optionCount];
                for (int i = 0; i < optionCount; i++)
                    options[i] = buffer.RSC_readString();

                int interfaceID = -1;
                int interfaceOption1 = -1;
                int interfaceOption2 = -1;
                int interfaceOption3 = -1;
                int interfaceOption4 = -1;
                int interfaceOption5 = -1;
                switch (optionCount)
                {
                    case 2:
                        interfaceID = 2459;
                        interfaceOption1 = 2461;
                        interfaceOption2 = 2462;
                        break;
                    case 3:
                        interfaceID = 2469;
                        interfaceOption1 = 2471;
                        interfaceOption2 = 2472;
                        interfaceOption3 = 2473;
                        break;
                    case 4:
                        interfaceID = 2480;
                        interfaceOption1 = 2482;
                        interfaceOption2 = 2483;
                        interfaceOption3 = 2484;
                        interfaceOption4 = 2485;
                        break;
                    case 5:
                        interfaceID = 2492;
                        interfaceOption1 = 2494;
                        interfaceOption2 = 2495;
                        interfaceOption3 = 2496;
                        interfaceOption4 = 2497;
                        interfaceOption5 = 2498;
                        break;
                    default:
                        System.out.println("Unsupported option count: " + optionCount);
                        break;
                }

                if (interfaceID != -1)
                    client.sendChatInterface(interfaceID);
                if (interfaceOption1 != -1)
                    client.sendInterfaceString(interfaceOption1, options[0]);
                if (interfaceOption2 != -1)
                    client.sendInterfaceString(interfaceOption2, options[1]);
                if (interfaceOption3 != -1)
                    client.sendInterfaceString(interfaceOption3, options[2]);
                if (interfaceOption4 != -1)
                    client.sendInterfaceString(interfaceOption4, options[3]);
                if (interfaceOption5 != -1)
                    client.sendInterfaceString(interfaceOption5, options[4]);
                break;
            }
            case 51: // Privacy Settings
            {
                int blockChat = buffer.getUnsignedByte() > 0 ? 2 : 0;
                int blockPrivate = buffer.getUnsignedByte() > 0 ? 2 : 0;
                int blockTrade = buffer.getUnsignedByte() > 0 ? 2 : 0;
                int blockDuel = buffer.getUnsignedByte() > 0 ? 2 : 0;
                client.publicChatMode = blockChat;
                client.privateChatMode = blockPrivate;
                client.tradeMode = Math.max(blockTrade, blockDuel);
                client.updateChatSettings = true;
                client.redrawChatbox = true;
                break;
            }
            case 131: // Send Message
            {
                int type = buffer.getUnsignedByte();
                int unk = buffer.getUnsignedByte();
                String message = buffer.RSC_readString();
                message = RSCConfig.RSC_removeChatFormatting(message);
                String sender = null;
                String clan = null;
                String color = null;
                if ((unk & 1) != 0)
                    sender = buffer.RSC_readString();
                if ((1 & unk) != 0)
                    clan = buffer.RSC_readString();
                if ((unk & 2) != 0)
                    color = buffer.RSC_readString();

                int rs2Type = 0;
                switch (type)
                {
                    case 7: // Duel
                        sender = message.substring(0, message.indexOf('(') - 1);
                        message = message.substring(message.indexOf('('));
                        rs2Type = 8;
                        break;
                    case 6: // Trade
                        message = "wishes to trade with you.";
                        rs2Type = 4;
                        break;
                    case 3: // Quest
                        rs2Type = 0;
                        break;
                    default:
                        System.out.println("Unhandled message type: " + type);
                        break;
                }

                client.pushMessage(message, rs2Type, sender);
                break;
            }
            default:
            {
                System.out.println("Unhandled opcode: " + opcode);
                break;
            }
        }

        return ret;
    }

    public static int RSC_ResponseCode(int responseCode)
    {
        if (!rscProtocol)
            return responseCode;

        System.out.println("login response: " + responseCode);

        // Login success
        if ((responseCode & 64) != 0)
            responseCode = 2;

        switch (responseCode)
        {
            case 4:
                responseCode = 5;
                break;
            case 7:
                responseCode = 9;
                break;
        }

        return responseCode;
    }

    public static String RSC_format(int var0, String var1, byte var2) {
        int var3 = -109 / ((-78 - var2) / 46);
        String var4 = "";

        for (int var5 = 0; var5 < var0; ++var5) {
            if (var5 >= var1.length()) {
                var4 = var4 + " ";
            } else {
                char var6 = var1.charAt(var5);
                if (var6 >= 97 && var6 <= 122) {
                    var4 = var4 + var6;
                } else if (var6 >= 65 && var6 <= 90) {
                    var4 = var4 + var6;
                } else if (var6 >= 48 && var6 <= 57) {
                    var4 = var4 + var6;
                } else {
                    var4 = var4 + '_';
                }
            }
        }

        return var4;
    }
}
