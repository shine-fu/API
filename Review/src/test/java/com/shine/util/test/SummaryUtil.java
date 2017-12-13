package com.shine.util.test;

import com.alibaba.fastjson.JSON;
import com.shine.bean.Item;
import com.shine.bean.Product;
import com.shine.util.SortUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SummaryUtil {

    @Test
    public void testSortUtil() {
        Item item1 = new Item("982", "大", "2393", "22");
        Item item2 = new Item("3451", "王", "031", "123");
        Item item3 = new Item("2351", "派", "89234", "22");
        Item item4 = new Item("932", "我", "9934", "123");
        Item item5 = null;
        Item item6 = new Item("932", "来", null, null);
        Item item7 = new Item("932", "巡", "9934", null);
        Item item8 = new Item("932", "山", null, null);
        Item item9 = new Item("932", "！！", null, "123");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        items.add(item9);
        System.out.println("1 :" + items);
        String jsonVal = JSON.toJSONString(items);
        System.out.println("2 :" + jsonVal);
        List<Product> products = SortUtil.parseAndSort(items, SortUtil.newComparator(SortUtil.COMPARATOR_WITH_NULL));
        System.out.println("3 :" + products);
        String json = JSON.toJSONString(products);
        System.out.println("4 :" + json);
        List<Product> jsonProducts = JSON.parseArray(json, Product.class);
        System.out.println("5 :" + jsonProducts);
    }
}
