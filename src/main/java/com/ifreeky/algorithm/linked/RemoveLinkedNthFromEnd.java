package com.ifreeky.algorithm.linked;

import java.util.Objects;

/**
 * 删除链表的倒数第N个节点
 * 思路
 * <p>
 * 1. 这道题的关键在于找到需要删除的节点，将指向其的next指针指向下一个节点即可。
 * 2. 最容易想到的方法是遍历整个链表，获取常盾，根据需要删除的节点位置结算出需要删除的节点位置，然后操作删除即可，时间负责度为 2O(n).
 * 3. 第二种思路，采取快慢指针的方式，让快指针先向前移动n次（既需要删除的第倒数n个节点），然后两个指针同时移动，当快指针指向链表末尾时，慢指针指向的位置变为需要删除的节点。
 * </p>
 *
 * @author ifreeky
 * @source https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @since 07 一月 2020
 */
public class RemoveLinkedNthFromEnd {

    public Node<Integer> removeLinkedNthFromEnd(Node<Integer> head, int n) {
        if (Objects.isNull(head) || n <= 0) {
            return head;
        }

        Node<Integer> dummy = new Node<>(0);
        dummy.next = head;
        Node<Integer> fast = dummy;
        Node<Integer> slow = dummy;

        for (int i = 0; i <= n ; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
