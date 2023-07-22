package com.tekup.soapService;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.tekup.xml.eshop.Item;

@Component
public class ItemRepository {
    private static List<Item> Items = new ArrayList<>();

    @PostConstruct
    public void initData() {
        Item Item = new Item();
        Item.setId(1);
        Item.setDescription("Toy");
        Item.setPrice(1500);
        Items.add(Item);

        Item Item2 = new Item();
        Item2.setId(2);
        Item2.setDescription("Phone");
        Item2.setPrice(4500);
        Items.add(Item2);

        Item Item3 = new Item();
        Item3.setId(3);
        Item3.setDescription("Tv");
        Item3.setPrice(2000);
        Items.add(Item3);
    }

    public Item findItem(int id) {
        for (Item item : Items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public String AddItem(int id, String description, float price) {
        for (Item item : Items) {
            if (item.getId() == id) {
                return "there is an item in DB having same ID, please verify your data";
            }
        }
        Item ItemNew = new Item();
        ItemNew.setId(id);
        ItemNew.setDescription(description);
        ItemNew.setPrice(price);
        Items.add(ItemNew);
        return "Item added to DB successfully!";
    }

    public String DeleteItem(int id) {
        for (Item item : Items) {
            if (item.getId() == id) {
                Items.remove(id);
                return "Item deleted from DB with success!";
            }
        }
        return "there is no item in DB having same ID, please verify your data";
    }
}
