/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.tugas2.interfaces;

import com.spboot.tugas2.models.Inventory;
import java.util.List;

/**
 *
 * @author Deiga
 */
public interface InventoryInterface {
    List<Inventory> getAll();
    void store(Inventory inventory);
    Inventory getById(long id);
    void delete(long id);
}