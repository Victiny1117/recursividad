

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