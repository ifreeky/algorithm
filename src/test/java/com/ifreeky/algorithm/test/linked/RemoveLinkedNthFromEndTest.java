package com.ifreeky.algorithm.test.linked;

import com.ifreeky.algorithm.linked.Node;
import com.ifreeky.algorithm.linked.RemoveLinkedNthFromEnd;
import org.junit.Test;

/**
 * @author ifreeky
 * @since 08 一月 2020
 */
public class RemoveLinkedNthFromEndTest {

    @Test
    public void TestRemoveLinkedNthFromEnd(){
       test0Node();
       test1Node();
    }

    public void test0Node() {
        RemoveLinkedNthFromEnd end = new RemoveLinkedNthFromEnd();
        end.removeLinkedNthFromEnd(null, 1);
    }

    public void test1Node() {
        Node<Integer> head = new Node<>(1);
        RemoveLinkedNthFromEnd end = new RemoveLinkedNthFromEnd();
        end.removeLinkedNthFromEnd(head, 1);
    }

    public void test2Node() {
        RemoveLinkedNthFromEnd end = new RemoveLinkedNthFromEnd();
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);

    }

    public void test3Node() {
        RemoveLinkedNthFromEnd end = new RemoveLinkedNthFromEnd();
        Node<Integer> head = new Node<>(1);
        Node<Integer> node1 = new Node<>(2);
        node1.next = new Node<>(3);
        head.next = node1;
    }

    public void test4Node() {
        RemoveLinkedNthFromEnd end = new RemoveLinkedNthFromEnd();
        Node<Integer> head = new Node<>(1);
        Node<Integer> node1 = new Node<>(2);
        Node<Integer> node2 = new Node<>(3);

        node2.next = new Node<>(4);
        node1.next = node2;
        head.next = node1;

    }
}
