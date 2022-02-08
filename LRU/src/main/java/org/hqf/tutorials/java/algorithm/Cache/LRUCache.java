
package org.hqf.tutorials.java.algorithm.Cache;

import java.util.Hashtable;
/**
基于双链表 的LRU实现:

　　传统意义的LRU算法是为每一个Cache对象设置一个计数器，每次Cache命中则给计数器+1，而Cache用完，需要淘汰旧内容，放置新内容时，就查看所有的计数器，并将最少使用的内容替换掉。

   它的弊端很明显，如果Cache的数量少，问题不会很大， 但是如果Cache的空间过大，达到10W或者100W以上，一旦需要淘汰，则需要遍历所有计算器，其性能与资源消耗是巨大的。效率也就非常的慢了。

    它的原理： 将Cache的所有位置都用双连表连接起来，当一个位置被命中之后，就将通过调整链表的指向，将该位置调整到链表头的位置，新加入的Cache直接加到链表头中。

     这样，在多次进行Cache操作后，最近被命中的，就会被向链表头方向移动，而没有命中的，而想链表后面移动，链表尾则表示最近最少使用的Cache。

     当需要替换内容时候，链表的最后位置就是最少被命中的位置，我们只需要淘汰链表最后的部分即可。

  上面说了这么多的理论， 下面用代码来实现一个LRU策略的缓存。

    我们用一个对象来表示Cache，并实现双链表，
**/
public class LRUCache {
    private int cacheSize;
    private int currentSize;

    //缓存容器
    private Hashtable nodes;
    //链表头
    private CacheNode first;
    //链表尾
    private CacheNode last;

    public LRUCache(int i) {
        currentSize = 0;
        cacheSize = i;
        nodes = new Hashtable(i);//缓存容器
    }

    /**
     * 获取缓存中对象
     * @param key
     * @return
     */
    public Object get(Object key) {
        CacheNode node = (CacheNode) nodes.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        } else {
            return null;
        }
    }

    /**
     * 添加缓存
     * @param key
     * @param value
     */
    public void put(Object key, Object value) {
        CacheNode node = (CacheNode) nodes.get(key);

        if (node == null) {
            //缓存容器是否已经超过大小.
            if (currentSize >= cacheSize) {
                //将最少使用的删除
                if (last != null) {
                    nodes.remove(last.key);
                }
                removeLast();
            } else {
                currentSize++;
            }

            node = new CacheNode();
        }
        node.value = value;
        node.key = key;
        //将最新使用的节点放到链表头，表示最新使用的.
        moveToHead(node);
        nodes.put(key, node);
    }

    /**
     * 将缓存删除
     * @param key
     * @return
     */
    public Object remove(Object key) {
        CacheNode node = (CacheNode) nodes.get(key);
        if (node != null) {
            if (null != node.prev) {
                node.prev.next = node.next;
            }
            if (null != node.next) {
                node.next.prev = node.prev;
            }
            if (node == last) {
                last = node.prev;
            }
            if (first == node) {
                first = node.next;
            }
        }
        return node;
    }

    public void clear() {
        first = null;
        last = null;
    }

    /**
     * 删除链表尾部节点
     *  表示 删除最少使用的缓存对象
     */
    private void removeLast() {
        //链表尾不为空,则将链表尾指向null. 删除连表尾（删除最少使用的缓存对象）
        if (last != null) {
            if (last.prev != null) {
                last.prev.next = null;
            } else {
                first = null;
            }
            last = last.prev;
        }
    }

    /**
     * 移动到链表头，表示这个节点是最新使用过的
     * @param node
     */
    private void moveToHead(CacheNode node) {
        if (node == first) {
            return;
        }
        if (null != node.prev) {
            node.prev.next = node.next;
        }
        if (null != node.next) {
            node.next.prev = node.prev;
        }
        if (last == node) {
            last = node.prev;
        }
        if (null != first) {
            node.next = first;
            first.prev = node;
        }
        first = node;
        node.prev = null;
        if (null == last) {
            last = first;
        }
    }

    /**
     * 链表节点
     * @author Administrator
     *
     */
    class CacheNode {
        CacheNode prev;//前一节点
        CacheNode next;//后一节点
        Object value;//值
        Object key;//键
        CacheNode() {
        }
    }
}