package com.ifreeky.algorithm.linked;

import java.util.Objects;

/**
 * 合并两个有序链表
 * 思路：
 * 这个题还是比较简单的，因为是两个有序链表，所以只需要比较大小，往新链表插入即可。
 * 当有一个不为空时，直接挂到新链表的尾部即可。
 * @source https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @author ifreeky
 * @since 05 一月 2020
 */
public class MergeOrderlyLinked {

    public Node<Integer> mergeOrderlyLinked(Node<Integer> firstNode, Node<Integer> secondNode) {

        Node<Integer> currentNode = new Node<>(0);
        Node<Integer> newNode = currentNode;
        while (Objects.nonNull(firstNode) && Objects.nonNull(secondNode)){

            if (firstNode.data < secondNode.data){
                newNode.next = firstNode;
                newNode = newNode.next;
                firstNode = firstNode.next;
            }else {
                newNode.next = secondNode;
                newNode = newNode.next;
                secondNode = secondNode.next;
            }

        }

        if (Objects.isNull(firstNode)){
            newNode.next = secondNode;
        }
        if (Objects.isNull(secondNode)){
            newNode.next = firstNode;
        }

        return currentNode.next;
    }
}
