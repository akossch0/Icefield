package Main;

import Prototype.*;
//import Skeleton.*;

import java.awt.*;
import java.io.*;

class Main
{

    public static void main(String[] args) {
        TestCases t = new TestCases();
        t.LoadTests();
        t.ListOutTests();
        Prototype proto = new Prototype();
    }
}