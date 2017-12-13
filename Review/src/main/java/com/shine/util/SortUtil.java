package com.shine.util;

import com.shine.bean.Item;
import com.shine.bean.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortUtil {

    public static final SortType ASC = SortType.ASC;
    public static final SortType DESC = SortType.DESC;
    public static final int COMPARATOR_NOT_NULL = 1;
    public static final int COMPARATOR_WITH_NULL = 2;

    private SortUtil() {

    }

    enum SortType {
        ASC, DESC;
    }

    public static <T, C extends Comparator<T>> int compare(T o1, T o2, C c, SortType type) {
        int result = 0;
        if (type == SortType.ASC) {
            result = -1;
        }
        if (type == SortType.DESC) {
            result = 1;
        }
        if (o1 != null && o2 == null)
            return result;
        else if (o1 == null && o2 == null)
            return 0;
        else if (o1 == null && o2 != null)
            return (-result);
        else return c.compare(o1, o2);
    }

    /**
     * 使用给定的比较器进行比较
     * 先将Item转换成Product，再根据比较规则进行排序
     *
     * @param itemList
     * @param comparator
     * @return
     */
    public static List<Product> parseAndSort(List<Item> itemList, Comparator<Product> comparator) {
        // 转换
        List<Product> productList = new LinkedList<>();
        for (Item i : itemList)
            productList.add(new Product(i));
        if (comparator == null) {
            Collections.sort(productList);
        } else {
            Collections.sort(productList, comparator);
        }
        return productList;
    }

    static class ProductComparator implements Comparator<Product> {
        /**
         * comparator : the priority is higher than if the
         * brand, category type is lower than the another
         *
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Product o1, Product o2) {
            int result = StringUtil.strCompare(o1.getCataType(), o2.getCataType());
            return result != 0 ? result : StringUtil.strCompare(o1.getBrandCode(), o2.getBrandCode());
        }
    }

    static class ProductWithNullComparator implements Comparator<Product> {
        private ProductComparator productComparator = new ProductComparator();

        @Override
        public int compare(Product o1, Product o2) {
            return SortUtil.compare(o1, o2, productComparator, SortUtil.SortType.DESC);
        }
    }

    public static Comparator newComparator(int type) {
        if (type == COMPARATOR_NOT_NULL) {
            return new ProductComparator();
        } else if (type == COMPARATOR_WITH_NULL) {
            return new ProductWithNullComparator();
        } else {
            return null;
        }
    }


}
