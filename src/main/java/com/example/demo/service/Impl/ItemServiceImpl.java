package com.example.demo.service.Impl;

import com.example.demo.dao.ItemDao;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> getItemList() {
        return itemDao.queryItem();
    }

    @Override
    public Item getItemById(int itemId) {
        int a = 1 / 0;
        return itemDao.queryItemById(itemId);
    }

    @Transactional
    @Override
    public boolean addItem(Item item) {
        if (item.getItemName() != null && !"".equals(item.getItemName())) {
            item.setCreateTime(new Date());
            item.setLastEditTime(new Date());
            try {
                int effectNum = itemDao.insertItem(item);
                if (effectNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入物品信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入物品信息失败:" + e.getMessage());
            }
        }
        throw new RuntimeException("物品信息不能为空！");
    }


    @Transactional
    @Override
    public Item modifyItem(Item item) {
        // 空值判断，主要是areaId不为空
        try {
            if (item.getItemId() != null && item.getItemId() > 0) {
                //如果ID 合法
                if ((item.getItemName() != null && !item.getItemName().trim().equals("")) || item.getPriority() != null) {
                    //更新内容不为空
                    item.setLastEditTime(new Date());
                    int row = itemDao.updateItem(item);
                    if (row < 1) {
                        throw new RuntimeException("更新商品信息失败");
                    }
                } else {
                    throw new RuntimeException("更新内容不能为空");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("更新区域信息失败:" + e.toString());
        }
        return itemDao.queryItemById(item.getItemId());
    }

    @Transactional
    @Override
    public boolean deleteItem(int itemId) {
        if (itemId > 0) {
            try {
                // 删除区域信息
                int effectedNum = itemDao.deleteItem(itemId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除物品信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除物品信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("物品Id不能为空！");
        }
    }
}
