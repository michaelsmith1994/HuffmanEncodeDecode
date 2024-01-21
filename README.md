# Huffman Coding Program (HuffmanEncodeDecode)

This Java program demonstrates Huffman coding, a lossless data compression algorithm. It allows you to encode and decode text using Huffman codes and provides information about character frequencies, encoded strings, compression ratio, and more.

## Usage

1. Clone the repository or download the `HuffMan_Coding.java` file.
2. Compile and run the program using Java:
javac HuffMan_Coding.java
java HuffMan_Coding
3. You will be prompted to enter a text string that you want to encode.
4. The program will display character frequencies, Huffman codes, the encoded string, and the decoded string.
5. It also calculates the compression ratio by comparing the original size (in bits) with the encoded size (in bits).

## Sample Output

Here's an example of the program output:

Type something you would like to encode...

How you doing

Character: ' ' Frequency: 15.384616

Character: 'd' Frequency: 7.692308

Character: 'u' Frequency: 7.692308

Character: 'w' Frequency: 7.692308

Character: 'g' Frequency: 7.692308

Character: 'H' Frequency: 7.692308

Character: 'y' Frequency: 7.692308

Character: 'i' Frequency: 7.692308

Character: 'n' Frequency: 7.692308

Character: 'o' Frequency: 23.076923

encoded is: 100

d encoded is: 1100

u encoded is: 001

w encoded is: 1101

g encoded is: 000

H encoded is: 1011

y encoded is: 1010

i encoded is: 1110

n encoded is: 1111

o encoded is: 01

Huffman Encoded String: 101101110110010100100110011000111101111000

Decoded String: How you doing

Original Size (bits): 104

Encoded Size (bits): 42

Compression Ratio: 2.4761904761904763

## Implementation

### Huffman Coding Algorithm

Huffman coding is a widely used data compression technique that assigns variable-length binary codes to characters based on their frequencies within the input text. The core steps of the Huffman coding algorithm implemented in this program are as follows:

1. **Character Frequency Analysis**: The program starts by analyzing the input text and creating a frequency map that records how often each character appears. This map is essential for building the Huffman tree.

2. **Priority Queue**: To build the Huffman tree, the program uses a priority queue (min heap) to keep track of characters and their frequencies. Characters with lower frequencies have higher priority.

3. **Huffman Tree Construction**: The program constructs the Huffman tree by repeatedly combining two nodes with the lowest frequencies into a new node. This process continues until there is only one node left, which becomes the root of the Huffman tree.

4. **Huffman Code Generation**: After building the Huffman tree, the program generates unique binary codes for each character based on their positions in the tree. Characters closer to the root have shorter codes.

5. **Encoding**: The input text is encoded by replacing each character with its corresponding Huffman code. The entire encoded string is generated.

6. **Decoding**: To decode the encoded string, the program traverses the Huffman tree from the root using each binary digit in the encoded string. When it reaches a leaf node, it identifies the corresponding character and appends it to the decoded string. This process continues until the entire encoded string is decoded.

### Compression Ratio Calculation

The program calculates the compression ratio by comparing the size (in bits) of the original text with the size of the encoded text. The compression ratio is the ratio of the original size to the encoded size. A higher compression ratio indicates more effective compression.

### Customization

You can use this program as a starting point for experimenting with Huffman coding. Feel free to modify the code to work with different data types or improve the efficiency of the algorithm. You can also integrate it into larger projects where data compression is required.
## Author

- Michael Smith
Feel free to use and modify this code for your own purposes.
