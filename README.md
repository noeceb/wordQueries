# wordQueries
A cross reference listing of words

<h3> Introduction </h3>

This program builds a cross reference listing of words from the getty.txt file. It references the number of times each word appears in the document, the line number and position where each word appears allowing us to make specific word queries. To do this, we insert these words into a binary search tree. If duplicate words are inserted, it does not get inserted but a counter gets incremented. We insert a list of 27 omitted words into a hash table that should not appear in the reference listing. To do this, we create a hash function that returns a hash of a key, and insert the word into the hash location inside the hash table. The hash function does not produce any collisions. When words are to be inserted into the object binary tree, we check to see if the word appears in the hash table. If it appears in the hash table, the word is omitted out. This provides us with a simple cross reference index that allows querying.

Please look at output.txt to see an example output of the program.
