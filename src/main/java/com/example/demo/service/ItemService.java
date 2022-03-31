package com.example.demo.service;

import com.example.demo.entity.Item;

import java.util.List;

public interface ItemService {
    /**
     * 获取物品列表
     *
     * @return
     */
    List<Item> getItemList();

    /**
     * 通过物品Id获取具体信息
     *
     * @param itemId
     * @return
     */
    Item getItemById(int itemId);

    /**
     * 增加物品信息
     *
     * @param item
     * @return
     */
    boolean addItem(Item item);

    /**
     * 修改物品信息
     *
     * @param item
     * @return
     */
    Item modifyItem(Item item);

    /**
     * 删除物品信息
     *
     * @param itemId
     * @return
     */
    boolean deleteItem(int itemId);

}
