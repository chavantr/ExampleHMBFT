package com.exam.hmbft;


import java.util.HashMap;
import java.util.Map;

public class MenuHelper {

    public static String[] name = {"Baati", "Bhatura", "Biryani", "Butter chicken", "Chaat", "Chana masala", "Chapati", "Daal puri", "Rice", "Jira Rice"};

    private static Map<String, Menu> menus;


    static {

        menus = new HashMap<>();

        menus.put(name[0], new Menu(1, name[0], "", 50.00, "veg",1));

        menus.put(name[1], new Menu(1, name[1], "", 50.00, "veg",1));

        menus.put(name[2], new Menu(1, name[2], "", 50.00, "veg",1));

        menus.put(name[3], new Menu(1, name[3], "", 150.00, "non-veg",1));

        menus.put(name[4], new Menu(1, name[4], "", 50.00, "veg",1));

        menus.put(name[5], new Menu(1, name[5], "", 90.00, "veg",1));

        menus.put(name[6], new Menu(1, name[6], "", 10.00, "veg",1));

        menus.put(name[7], new Menu(1, name[7], "", 50.00, "veg",1));

        menus.put(name[8], new Menu(1, name[8], "", 40.00, "veg",1));

        menus.put(name[9], new Menu(1, name[9], "", 50.00, "veg",1));

    }


    public static String[] getName() {
        return name;
    }

    public static Map<String, Menu> getMenus() {
        return menus;
    }
}
