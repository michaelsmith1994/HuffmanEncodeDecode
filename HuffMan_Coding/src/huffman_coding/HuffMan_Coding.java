/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman_coding;

import java.util.*;

public class HuffMan_Coding {   
    public static void main(String[] args) {
        int n = 5;
        Scanner newObject = new Scanner(System.in);
        System.out.println("Type something you would like to encode...");
        String someString = newObject.nextLine();

        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        //String someString = "Hello my name is slim shady.";
        char[] charArray2 = someString.toCharArray();
        float Array2length = charArray2.length; 
        for (char c : charArray2){
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Priority Queue
        PriorityQueue<HF_Node> pq = new PriorityQueue<>(new NodeComparator());
        
        // Populate the priority queue using the frequency map
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            HF_Node newNode = new HF_Node();
            newNode.ch = entry.getKey();
            newNode.freq = entry.getValue();
            newNode.left = null;
            newNode.right = null;
            pq.add(newNode);
        }

        // Display the frequency of each character
        frequencyMap.entrySet().forEach((entry) -> {
            System.out.println("Character: '" + entry.getKey() + "' Frequency: " + (entry.getValue()/Array2length*100));
        });

        HF_Node rootNode = null;
        while (pq.size() > 1) {
            HF_Node firstMin = pq.peek();
            pq.poll();

            HF_Node secMin = pq.peek();
            pq.poll();

            HF_Node newNode = new HF_Node();

            newNode.freq = firstMin.freq+secMin.freq;
            newNode.ch = '-';
            newNode.left = firstMin;
            newNode.right = secMin;
            rootNode = newNode;
            pq.add(newNode);
        }
        for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            printHFCode(rootNode, entry.getKey(), "");
        }

        // Assemble the Huffman codes in the order of the input string
        StringBuilder huffmanEncodedString = new StringBuilder();
        for (char c : someString.toCharArray()) {
            huffmanEncodedString.append(getHFCode(rootNode, c, ""));
        }

        System.out.println("Huffman Encoded String: " + huffmanEncodedString.toString());

        String decodedString = decodeHuffman(rootNode, huffmanEncodedString.toString());
        System.out.println("Decoded String: " + decodedString);
        
        //The following segments of code help determine the compression benefits of using huffman to store data, comparing bits before and after. 
        int originalSize = someString.length() * 8;
        int encodedSize = huffmanEncodedString.length();
        double compressionRatio = (double) originalSize / encodedSize;

        System.out.println("Original Size (bits): " + originalSize);
        System.out.println("Encoded Size (bits): " + encodedSize);
        System.out.println("Compression Ratio: " + compressionRatio);
    }

private static String getHFCode(HF_Node root, char reqChar, String str) {
    if (root == null) return ""; // Return empty string for null nodes

    if (root.left == null && root.right == null && root.ch != '-') {
        if (root.ch == reqChar) {
            return str; // Return the Huffman code
        }
        return ""; // Return empty string if character does not match
    }

    // Recursively search for the character
    return getHFCode(root.left, reqChar, str + "0") + getHFCode(root.right, reqChar, str + "1");
}

//This method prints the corresponding binary sequence for the character location on the tree. EX: A encoded is 1010 
private static void printHFCode(HF_Node root, char reqChar, String str) {
    if (root == null) return; // Check for null to avoid NullPointerException

    // Check if it's a leaf node and not the placeholder character '-'
    if (root.left == null && root.right == null && root.ch != '-') {
        if (root.ch == reqChar) {
            System.out.println(reqChar + " encoded is: " + str);
        }
        return;
    }

    printHFCode(root.left, reqChar, str + "0");
    printHFCode(root.right, reqChar, str + "1");
}

private static String decodeHuffman(HF_Node root, String encodedString) {
    StringBuilder decodedString = new StringBuilder();
    HF_Node current = root;

    for (int i = 0; i < encodedString.length(); i++) {
        if (encodedString.charAt(i) == '0') {
            current = current.left; // Move to left child
        } else {
            current = current.right; // Move to right child
        }

        // Check if it's a leaf node
        if (current.left == null && current.right == null) {
            decodedString.append(current.ch); // Append the character
            current = root; // Go back to the root for next character
        }
    }

    return decodedString.toString();
}

}

class NodeComparator implements Comparator<HF_Node>{ // to compare on the basis of freq field of HF_Node
public int compare(HF_Node a, HF_Node b){
return a.freq - b.freq;
}
}