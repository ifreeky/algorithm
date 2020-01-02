package com.ifreeky.algorithm.linked;

/**
 * 翻转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 思路：
 * 1. 设原链表为 null -> 1 -> 2 -> 3 -> null, 则翻转后为 null -> 3 -> 2 -> 1 -> null
 * 2. 翻转第一个节点，因为链表的后继指针只有一个，所以可得：null <- 1 <- 2 3-> null
 * 3. 下一次翻转：null <- 1 <-2 <- 3 <- null
 * 在这个过程中，需要一个记录最新头节点的指针，一个记录翻转位置的指针（翻转过程中链表会断掉）
 *
 * @author ifreeky
 * @since 02 一月 2020
 */
public class ReverseLinkedNode {

    public Node<Integer> reverseList(Node<Integer> head) {
        Node<Integer>  pre = null;
        Node<Integer> next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head  = next;
        }
        return pre;
    }
}
