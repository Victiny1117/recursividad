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

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        stack Stack = new stack();
        stack Stack1 = new stack();
        circleList list = new circleList();
        int a = 0, b = 0, c = 0, d = 0, e = 0, opt0 = 0, x = 0, opt1 = 0, aux = 0, aux1 = 0;
        String word;
        System.out.println("ingrese la longitud del arreglo");
        x = read.nextInt();
        int[] numArray = new int[x];
        while (opt0 != 10) {
            System.out.println("1 para el tercer ejercicio, 2 para el segundo ejercicio, 3 para el cuarto ejercicio, 4 para el primer ejercicio");
            opt1 = read.nextInt();
            switch (opt1) {
                case 1 -> {
                    while (aux1 != 1) {
                        System.out.println("Ingrese un numero en la pila");
                        aux = read.nextInt();
                        Stack.stack(aux);
                        System.out.println("0 para ingresar un numero, 1 para invertir la pila");
                        aux1 = read.nextInt();
                    }
                    Stack1 = invStack(Stack, Stack1);
                    System.out.println("Pila invertida: ");
                    Stack1.print();
                    opt0 = 10;
                }
                case 2 -> {
                    while (aux1 != 1) {
                        System.out.println("Ingrese una palabra en la lista");
                        word = read.next();
                        list.add(word);
                        System.out.println("0 para ingresar otra palabra, 1 para mostrar la lista");
                        aux1 = read.nextInt();
                    }
                    printWords(list);
                    opt0 = 10;
                }
                case 3 -> {
                    while (aux1 != 1) {
                        System.out.println("Ingrese el numero del cual se va a sacar el factorial");
                        a = read.nextInt();
                        a = fact(a);
                        System.out.println("Ingrese el numero base de la potencia");
                        b = read.nextInt();
                        System.out.println("Ingrese el indice de la potencia");
                        c = read.nextInt();
                        b = exp(b, c);
                        d = a * b;
                        aux1 = 1;
                    }
                    System.out.println("El resultado es: " + d);
                    opt0 = 10;
                }
                case 4 -> {
                    while (aux1 != 1) {
                        System.out.println("Ingrese los valores del arreglo");
                        for (int i = 0; i < x; i++) {
                            System.out.println("Ingrese un numero");
                            numArray[i] = read.nextInt();
                        }
                        aux1 = 1;
                    }
                    e = plusArray(numArray, numArray.length - 1);
                    System.out.println(e);
                    opt0 = 10;
                }
            }
        }
    }
}
