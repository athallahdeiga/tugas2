/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.tugas2.controllers;

import com.spboot.tugas2.interfaces.InventoryInterface;
import com.spboot.tugas2.models.Inventory;
import static javax.swing.text.StyleConstants.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author Deiga
 */
@Controller
public class MainController {
    @Autowired
    private InventoryInterface inventoryInterface;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("list", inventoryInterface.getAll());
        return "index";
    }

    @GetMapping("/inventory/create")
    public String create(Model model) {
        
        Inventory inventory = new Inventory();
        model.addAttribute("inventory", inventory);
        
        return "create";
    }

    @PostMapping("/inventory/store")
    public String store(@ModelAttribute("inventory") Inventory inventory) {
        inventoryInterface.store(inventory);
        return "redirect:/";
    }
    
    @GetMapping("/inventory/{id}/edit")
    public String edit(@PathVariable(value = "id") long id, Model model) {
        Inventory inventory = inventoryInterface.getById(id);

        model.addAttribute("inventory", inventory);
        return "edit";
    }

    @PostMapping("/inventory/{id}/delete")
    public String delete(@PathVariable(value = "id") long id) {
        inventoryInterface.delete(id);
        return "redirect:/";
    }
}