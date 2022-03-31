package com.example.demo.dao;

import com.example.demo.entity.Item;

import java.util.List;

public interface ItemDao {
    /**
     * 列出物品列表
     *
     * @return itemList
     */
    List<Item> queryItem();

    /**
     * 根据Id列出具体物品
     *
     * @return item
     */
    Item queryItemById(int itemId);

    /**
     * 插入物品信息
     * @param item
     * @return
     */
    int insertItem(Item item);

    /**
     * 更新物品信息
     * @param item
     * @return
     */
    int updateItem(Item item);

    /**
     * 删除物品信息
     * @param itemId
     * @return
     */
    int deleteItem(int itemId);
}
