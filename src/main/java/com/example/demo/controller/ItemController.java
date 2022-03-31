package com.example.demo.controller;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class ItemController {
    @Autowired
    private ItemService itemService;

    // 查询
    @RequestMapping(value = "/listitem", method = RequestMethod.GET)
    private Map<String, Object> listItem() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Item> list = itemService.getItemList();
        modelMap.put("itemList", list);
        return modelMap;
    }

    // 指定id来获取
    @RequestMapping(value = "/getitembyid", method = RequestMethod.GET)
    private Map<String, Object> getItemById(Integer itemId) {
        Map<String, Object> modelMap = new HashMap<>();
        Item item = itemService.getItemById(itemId);
        modelMap.put("item",item);
        return modelMap;
    }
    @RequestMapping(value = "/additem", method = RequestMethod.POST)
    private Map<String, Object> addItem(@RequestBody Item item) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", itemService.addItem(item));
        return modelMap;
    }

    //修改
    @RequestMapping(value = "/modifyitem", method = RequestMethod.POST)
    private Map<String, Object> updateItem(@RequestBody Item item) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", itemService.modifyItem(item));
        return modelMap;
    }

    //删除
    @RequestMapping(value = "/removeitem", method = RequestMethod.GET)
    private Map<String, Object> removeItem(Integer itemId) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", itemService.deleteItem(itemId));
        return modelMap;
    }
}
