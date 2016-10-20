package com.maxt28;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode listr;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = l1.val + l2.val;
        int addNumber = value / 10;
        ListNode result = new ListNode(value % 10);
        listr = result;
        l1 = l1.next;
        l2 = l2.next;
        createExtraElement(l1, l2, addNumber);

        for (; isNotEmpty(l1) || isNotEmpty(l2); ) {
            value = 0;
            if (isNotEmpty(l1)) {
                value += l1.val;
                l1 = l1.next;
            }
            if (isNotEmpty(l2)) {
                value += l2.val;
                l2 = l2.next;
            }
            value += addNumber;
            createNext(listr, value % 10);
            addNumber = value / 10;
            createExtraElement(l1, l2, addNumber);
        }
        return result;
    }

    void createExtraElement(ListNode l1, ListNode l2, int addNumber) {
        if ((!isNotEmpty(l1) && !isNotEmpty(l2)) && addNumber != 0) {
            createNext(listr, addNumber);
        }
    }

    void createNext(ListNode list, int value) {
        list.next = new ListNode(value);
        listr = list.next;
    }

    boolean isNotEmpty(ListNode list) {
        return (list != null);
    }
}