package com.ifreeky.algorithm.linked;

import javafx.util.Pair;

import java.util.Objects;

/**
 * 用单链表实现LUR链表
 * 思路：
 * 1. 新增数据时，遍历链表，如果key存在，更新value, 并移动到头节点
 * 2. 如果key不存在，且dataSize < size,添加至头节点，若 dataSize = size, 删除尾节点，添加至头节点
 * 3. 访问数据时，遍历链表，如果存在，移动到头节点，并返回
 *
 * @author ifreeky
 * @since 23 十月 2019
 */
public class LURLinkedNode<E> {

    private int size;
    private int dataSize = 0;

    private Node<Pair<String, E>> head = new Node<>(null);

    public LURLinkedNode(int size) {
        this.size = size;
    }

    public void put(String key, E value) {

        Node<Pair<String, E>> node = find(key);
        if (Objects.nonNull(node)) {
            //更新值，扔到头节点
            node.data = new Pair<>(key, value);
            node.next = head.next;
            head.next = node;
        }
        else {
            Node<Pair<String, E>> newNode = new Node<>(new Pair<>(key, value));
            if (size > dataSize) {
                dataSize ++;
                newNode.next = head.next;
                head.next = newNode;
            }else {
                removeEndNode(head);
                newNode.next = head.next;
                head.next = newNode;
            }
        }

    }

    public E get(String key) {
        Node<Pair<String, E>> node = find(key);
        if (Objects.isNull(node)){
            return null;
        }
        removeNode(head, key);
        node.next = head.next;
        head.next  = node;
        return node.data.getValue();
    }

    private  Node<Pair<String, E>> find(String key) {
        if (dataSize < 1) {
            return null;
        }
        Node<Pair<String, E>> cur = head;
        while (Objects.nonNull(cur.next)) {
            if (Objects.equals(cur.next.data.getKey(), key)) {
                return cur.next;
            }
            cur = cur.next;
        }
        return null;
    }

    private void removeEndNode(Node<Pair<String, E>> head){
        Node<Pair<String, E>> sufCur = head;
        while (Objects.nonNull(sufCur.next.next)) {
            sufCur = sufCur.next;
        }
        sufCur.next = null;
    }

    private void removeNode(Node<Pair<String, E>> head,  String key) {
        Node<Pair<String, E>> sufCur = head;
        while (Objects.nonNull(sufCur.next) && !Objects.equals(sufCur.next.data.getKey(), key)){
            sufCur = sufCur.next;
        }
        if (Objects.nonNull(sufCur.next)){
            Node<Pair<String, E>> cur =  sufCur.next;
            sufCur.next = cur.next;
            cur.next = null;
        }
    }
}
