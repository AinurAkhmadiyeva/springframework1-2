package kz.bitlab.springframework.springframework1.db;

import kz.bitlab.springframework.springframework1.model.Item;

import java.util.ArrayList;
import java.util.Iterator;

public class DBManager {
    public static ArrayList<Item> itemList = new ArrayList<>();
    private static Long id = 7L;

    static {
        itemList.add(new Item(1L, "Mac Book Pro", "8GB RAM 255 GB SSD Intel Core i7", 1199.99));
        itemList.add(new Item(2L, "Mac Book Pro", "16 GB RAM 500 GB SSD Apple M1", 1499.99));
        itemList.add(new Item(3L, "Mac Book Pro", "16 GB RAM 1 GB SSD Apple M1", 1799.99));
        itemList.add(new Item(4L, "ASUS Tuf Gaming", "16 GB RAM 500 GB SSD Intel Core i7", 1299.99));
        itemList.add(new Item(5L, "HP Laser Pro", "8 GB RAM 500 GB SSD Intel Core i5", 999.99));
        itemList.add(new Item(6L, "Lenovo Legion", "32 GB RAM 512 GB SSD Intel Core i7", 1399.99));
    }

    public static ArrayList<Item> getAllItems() {
        return itemList;
    }

    public static void addItem(Item item) {
        item.setId(id);
        itemList.add(item);
        id++;
    }

    public static Item getItemById(Long id) {
        for (Item item : itemList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public static void updateItem(Item item) {
        for (int i = 0; i < itemList.size(); i++) {
            item = itemList.get(i);
            if (item.getId().equals(item.getId())) {
                itemList.set(i, item);
                return;
            }
        }
    }

    public static void deleteItem(Long id) {
        Iterator<Item> iterator = itemList.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }
}

