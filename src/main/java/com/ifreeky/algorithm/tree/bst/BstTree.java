package com.ifreeky.algorithm.tree.bst;

import java.util.Objects;

/**
 * @author ifreeky
 * @since 13 一月 2020
 */
public class BstTree<E extends Comparable<E>> {
    private int size;
    private BstNode root;

    public class BstNode {

        public E e;
        public BstNode left;
        public BstNode right;

        public BstNode(E e) {
            this.e = e;
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        add(root, e);
    }

    private BstNode add(BstNode node, E e) {
        if (Objects.isNull(node)) {
            size++;
            return new BstNode(e);
        }
        if (e.compareTo(node.e) < 0) {
             node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
             node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(BstNode node, E e) {
        if (Objects.isNull(node)) {
            return false;
        }
        if (node.e.compareTo(e) == 0) {
            return true;
        }else if (node.e.compareTo(e) < 0) {
            return contains(node.left, e);
        }else {
            return contains(node.right, e);
        }

    }
}

