

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

public class Examen_ziad_recursividad {
   
    static stack invStack(stack s1, stack s2) {
        nodeS auxNode;
        if (!s1.cnull()) {
            auxNode = s1.unstack();
            s2.stack(auxNode.c);
            invStack(s1, s2);
        } 
            return s2;
        }
        
        static void printWords(circleList l1) {
            String word;
            if (!l1.cnull() && l1.start != l1.end) {
                word = l1.actElement();
                System.out.print(" " + word + " ");
                printWords(l1);
            }
        }
        static int fact(int a) {
            if (a <= 0) {
                return 1;
            } else {
                return a * fact(a - 1);
            }
        }
        static int exp(int a, int b) {
            if (b == 0) {
                return 1;
            } else {
                return a * exp(a, b - 1);
            }   
        }
        static int plusArray(int[] array, int a) {
            if (a < 0) {
                return 0;
            }
                return array[a] + plusArray(array, a - 1);
            }
        }
