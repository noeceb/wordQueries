package driver;

import java.io.*;
import java.util.Scanner;

/**
 * Driver for the Binary Tree and Hashing Lab
 * @author Noe Cebreros
 * ID: 011176643
 * Date: 5/17/18 
 * CSCI 210 Data Structures
 * Lab 5 - Binary Tree Lab
 * @version 8.1 - NetBeans - 5/17/18
 */

public class Driver {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{

        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Scanner gettyFile = new Scanner(new File("getty.txt"));
        Xref crossreference = new Xref(pw, gettyFile);
        Hash hash = new Hash(pw);

        crossreference.printGetty();
        
        hash.getHashTable();
        hash.printHashTable();

        crossreference.readFile();
        crossreference.traverse();
        crossreference.query();

        pw.close();
    }
}

