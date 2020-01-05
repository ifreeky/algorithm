package com.ifreeky.algorithm.test.linked;

import com.ifreeky.algorithm.linked.MergeOrderlyLinked;
import com.ifreeky.algorithm.linked.Node;
import org.junit.Assert;
import org.junit.Test;

/**
 * 合并两个有序链表
 *
 * @author ifreeky
 * @since 05 一月 2020
 */
public class MergeOrderlyLinkedTest {

    @Test
    public void testMergeOrderlyLinked() {
        test01();
        test02();
        test03();
        test04();
        test05();
    }

    private void test01() {
        MergeOrderlyLinked mergeOrderlyLinked = new MergeOrderlyLinked();
        Assert.assertNull(mergeOrderlyLinked.mergeOrderlyLinked(null, null));
    }

    private void test02() {
        MergeOrderlyLinked mergeOrderlyLinked = new MergeOrderlyLinked();
        Node<Integer> firstNode = new Node<>(1);
        Assert.assertEquals(1, (int) mergeOrderlyLinked.mergeOrderlyLinked(firstNode, null).data);
    }

    private void test03() {
        MergeOrderlyLinked mergeOrderlyLinked = new MergeOrderlyLinked();
        Node<Integer> secondNode = new Node<>(1);
        Assert.assertEquals(1, (int) mergeOrderlyLinked.mergeOrderlyLinked(null, secondNode).data);
    }

    private void test04() {
        MergeOrderlyLinked mergeOrderlyLinked = new MergeOrderlyLinked();
        Node<Integer> firstNode = new Node<>(1);
        Node<Integer> secondNode = new Node<>(1);
        Node<Integer> newNode = mergeOrderlyLinked.mergeOrderlyLinked(firstNode, secondNode);
        Assert.assertEquals(1, (int) newNode.data);
        Assert.assertEquals(1, (int) newNode.next.data);
    }

    private void test05() {
        MergeOrderlyLinked mergeOrderlyLinked = new MergeOrderlyLinked();
        Node<Integer> firstNode = new Node<>(1);
        Node<Integer> firstNode2 = new Node<>(2);
        Node<Integer> firstNode3 = new Node<>(3);
        firstNode3.next = new Node<>(4);
        firstNode2.next = firstNode3;
        firstNode.next = firstNode2;

        Node<Integer> secondNode = new Node<>(1);
        Node<Integer> secondNode2 = new Node<>(2);
        Node<Integer> secondNode3 = new Node<>(2);
        secondNode3.next = new Node<>(6);
        secondNode2.next = firstNode3;
        secondNode.next = firstNode2;

        Node<Integer> newNode = mergeOrderlyLinked.mergeOrderlyLinked(firstNode, secondNode);
        Assert.assertEquals(1, (int) newNode.data);
        Assert.assertEquals(1, (int) newNode.next.data);
        Assert.assertEquals(2, (int) newNode.next.next.data);
        Assert.assertEquals(2, (int) newNode.next.next.next.data);
        Assert.assertEquals(2, (int) newNode.next.next.next.next.data);
        Assert.assertEquals(3, (int) newNode.next.next.next.next.next.data);
        Assert.assertEquals(4, (int) newNode.next.next.next.next.next.next.data);
        Assert.assertEquals(6, (int) newNode.next.next.next.next.next.next.next.data);

    }

}
