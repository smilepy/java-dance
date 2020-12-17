package com.smilepy.javadance.util;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author peiyu
 */
//单向链表，删除倒数第n个节点，返回头节点
public class Test extends TestCase {
    private class Node{
        private int value;
        private Node next;

        public Node next(){
            return this.next;
        }
        public void set(Node next){
            this.next=next;
        }
    }
    public static void Main(){
        Node head=null;
        head=deleteNth(head,5);
    }
    // 1->2->3->4
    public static Node deleteNth(Node head,int n){
        if(head==null||n<=0){
            return head;
        }

        if(head.next==null){
            if(n==1){
                head=null;
                return head;
            }
        }

        Node first=head,second=head.next();
        n=n-1;
        while(n>0&&first!=null){
            first=first.next();
            n--;
        }
        if(n==0){
            //存在至少n个节点
            while(first!=null){
                first=first.next();
                second=second.next();
            }

            second.set(second.next().next());
        }else{
            if(n==1){
                head=head.next();
            }
        }

        return head;
    }


}
