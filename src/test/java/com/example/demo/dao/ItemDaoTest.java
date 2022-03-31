package com.example.demo.dao;


import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.example.demo.entity.Item;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
public class ItemDaoTest {
    @Autowired
    private ItemDao itemDao;

    @Before
    public void testQueryItem() {
        List<Item> itemList = itemDao.queryItem();
        // 验证预期值和实际值是否相符
        log.info("list={}",itemList);
        assertEquals(3, itemList.size());
    }

    @Test
    public void queryItemById() {
        Item item = itemDao.queryItemById(1);
        assertEquals("珍珠奶茶",item.getItemName());
    }

    @Test
    public void testInsertItem() {
        Item item = new Item();
        item.setItemName("芒果沙冰");
        item.setPriority(6);
        int effectNum = itemDao.insertItem(item);
        assertEquals(1,effectNum);
    }

    @Test
    public void testUpdateItem() {
        Item item = new Item();
        item.setPriority(2);
        item.setItemId(3);
        item.setLastEditTime(new Date());
        int effectNum = itemDao.updateItem(item);
        assertEquals(1,effectNum);
    }

    @Test
    public void testDeleteItem() {
        int effectNum = itemDao.deleteItem(3);
        assertEquals(1,effectNum);
    }
}