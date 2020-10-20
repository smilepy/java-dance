package com.smilepy.javadance.designpattern;

import java.util.List;

/**
 * @author peiyu
 * @date 2020-10-20 16:20
 */
public class ListToTree {
    class Node{
        int id;
        int pId;
        List<Node> children;
    }

    /**
     * 将一组节点转换成一个树
     * @param nodes
     * @return
     */
    public Node listToTree(List<Node> nodes) {

    }
}
