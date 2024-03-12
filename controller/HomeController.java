package kz.bitlab.springframework.springframework1.controller;

import kz.bitlab.springframework.springframework1.db.DBManager;
import kz.bitlab.springframework.springframework1.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/home")
    public String indexPage(Model model) {
        ArrayList<Item> allItems = DBManager.getAllItems();
        model.addAttribute("allItemsAttribute", allItems);
        return "items";
    }

    @GetMapping(value = "/addItemPage")
    public String addItemPage() {
        return "addItem";
    }

    @PostMapping(value = "/addItem")
    public String addItem(@RequestParam(name = "name") String itemName,
                          @RequestParam(name = "description") String itemDescription,
                          @RequestParam(name = "price") double price) {
        Item item = new Item();
        item.setName(itemName);
        item.setDescription(itemDescription);
        item.setPrice(price);
        DBManager.addItem(item);
        return "redirect:/home";
    }

    @GetMapping(value = "/details/{id}")
    public String details(@PathVariable(name = "id") Long id, Model model) {
        Item item = DBManager.getItemById(id);
        model.addAttribute("itemAtt", item);
        return "details";
    }

    @GetMapping(value = "/update/{id}")
    public String updateItemPage(@PathVariable(name = "id") Long id, Model model) {
        Item item = DBManager.getItemById(id);
        model.addAttribute("itemAtt", item);
        return "updateItem";
    }

    @PostMapping(value = "/update/{id}")
    public String updateItem(@PathVariable(name = "id") Long id,
                                @RequestParam(name = "name") String itemName,
                                @RequestParam(name = "description") String itemDescription,
                                @RequestParam(name = "price") double price) {
        Item item = DBManager.getItemById(id);
        if (item != null) {
            item.setName(itemName);
            item.setDescription(itemDescription);
            item.setPrice(price);
            DBManager.updateItem(item);
        }
        return "redirect:/home";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteItem(@PathVariable(name = "id") Long id) {
        DBManager.deleteItem(id);
        return "redirect:/home";

    }
}

