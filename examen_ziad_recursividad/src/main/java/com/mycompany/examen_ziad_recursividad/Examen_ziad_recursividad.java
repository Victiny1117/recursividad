

package com.mycompany.examen_ziad_recursividad;
import java.util.Scanner;

class nodeCL {
    String word;
    nodeCL next;
    public nodeCL(String word) {
        this.word = word;
        this.next = null;
    }
    
}

class nodeS {
    int c;
    nodeS next;

    nodeS(int c) {
        this.c = c;
    }

}

class stack {
    nodeS top = null;

    void stack(int c) {
        nodeS newN = new nodeS(c);
        newN.next = top;
        top = newN;
    }

    nodeS unstack() {
        if (top == null) {
            return null;
        }
        nodeS nUnstacked = top;
        top = top.next;
        return nUnstacked;
    }

    boolean cnull() {
        return top == null;
    }
    
    void print() {
        nodeS act = top;
        while (act != null) {
            System.out.println(act.c);
            act = act.next;
        }
        
    }
}

class circleList {
    nodeCL start = null;
    nodeCL end = null;
   
    void add(String word) {
        nodeCL nNode = new nodeCL(word);
        if (start == null) {
            start = nNode;
            end = nNode;
            nNode.next = start;
        } else {
            end.next = nNode;
            end = nNode;
            end.next = start;
        }
    }
       
        String actElement() {
            nodeCL act = null;
         if (start != null && act != start) {
            act = start;
               start = act.next;
        }  
        return act.word;
        }
        
    boolean cnull() {
        return start == null;
    }
}