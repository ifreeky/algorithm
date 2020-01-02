package com.ifreeky.algorithm.test.linked;

import com.ifreeky.algorithm.linked.Node;
import com.ifreeky.algorithm.linked.ReverseLinkedNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author teng.dang
 * @since 02 一月 2020
 */
public class ReverseLinkedNodeTest {

    @Test
    public void testReverseList() {
        test0Node();
        test1Node();
        test2Node();
        test3Node();
        test4Node();
    }


    public void test0Node() {
        ReverseLinkedNode reverseLinkedNode = new ReverseLinkedNode();
        Assert.assertNull(reverseLinkedNode.reverseList(null));
    }

    public void test1Node() {
        Node<Integer> head = new Node<>(1);
        ReverseLinkedNode reverseLinkedNode = new ReverseLinkedNode();
        Assert.assertEquals(1, (int) reverseLinkedNode.reverseList(head).data);
    }

    public void test2Node() {
        ReverseLinkedNode reverseLinkedNode = new ReverseLinkedNode();
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        Node<Integer> reverseList = reverseLinkedNode.reverseList(head);
        Assert.assertTrue(reverseList.data == 2 && reverseList.next.data == 1);

    }

    public void test3Node() {
        ReverseLinkedNode reverseLinkedNode = new ReverseLinkedNode();
        Node<Integer> head = new Node<>(1);
        Node<Integer> node1 = new Node<>(2);
        node1.next = new Node<>(3);
        head.next = node1;
        Node<Integer> reverseList = reverseLinkedNode.reverseList(head);
        Assert.assertTrue(reverseList.data == 3 && reverseList.next.data == 2 && reverseList.next.next.data == 1);
    }

    public void test4Node() {
        ReverseLinkedNode reverseLinkedNode = new ReverseLinkedNode();
        Node<Integer> head = new Node<>(1);
        Node<Integer> node1 = new Node<>(2);
        Node<Integer> node2 = new Node<>(3);

        node2.next = new Node<>(4);
        node1.next = node2;
        head.next = node1;

        Node<Integer> reverseList = reverseLinkedNode.reverseList(head);
        Assert.assertTrue(reverseList.data == 4 && reverseList.next.data == 3 && reverseList.next.next.data == 2 && reverseList.next.next.next.data == 1);
    }
}
