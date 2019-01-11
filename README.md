# Grokking Algorithms by Aditya Y. Bhargava
This personal 'learning project' is based on the book mentioned in the title above. 

### Binary Search
With binary search you gues the middle number and eliminate half the remaining numbers every time.  In addition, it only works when  your list is in sorted order. For example, the names in a phone book are sorted in alphabetical order, so you can use binary search to look for a name.
 
### Selection Sort
The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.
In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.

#### Selection Sort - Arrays
Using an array means all your items are stored right next to each other in memory.  Adding new items to an array can be a big pain, this will be explained in the following example. It’s like going to a movie with your two of your friends and  finding a place to sit. So you finally found a place and the three of you can sit next to each other. However,  another friend joins you, and there’s no place for him next to you guys. So you have to move to a new spot where all of you can sit next to eachother. In this case, you need to ask your computer for a different chunk of memory that can fit four tasks.  Then you need to move all your tasks there. If another friend comes by, you’re out of room again and you all have to move a second time! What a pain. Similarly, adding new items to
an array can be a big pain. If you’re out of space and need to move to a new spot in memory every time, adding a new item will be really slow. However, in an Array you know the address of every item in your array. So it is very easy to keep jumping around. So Arrays are great if you want to read random  elements, because you can look up any element in your array instantly. 
To summarize: Arrays have fast reads and slow inserts.

#### Selection Sort - Linked lists
With linked lists, your items can be anywhere in memory. Each item stores the address of the next item in the list. It’s like a treasure hunt. You go to the first address, and it says, “ The next item can be found at address 123.” So you go to address 123, and it says, “The next item can be found at address 847,” and so on. Adding an item to a linked list is easy: you stick it anywhere in memory and store the address with the previous item.  So it’s as easy as changing what the previous elements points to. A problem occurs when you want to read the last item in a linked list. You can’t just read it, because you don’t know what address it’s at. Instead, you have to go to item #1 to get the address for item #2. Then you have to go to item #2 to get the address for item #3. And so on, until you get to the last item. Linked lists are great if you’re going to read all the items one at a time: you can read one item, follow the address to the next item, and so on. But if you’re going to keep jumping around, linked lists are terrible.

**To summarize: Linked lists have slow reads only if you are accessing random elements.
 In addition, they have fast inserts.**

### Recursion 
A recursive function calls itself.  In addition, when you write a recursive function, you have to tell it when to stop. That’s why every recursive function has two parts:
 1. The base case
 2. The recursive case

#### Recursion – the call stack
A stack has two operations push and pop. All function calls go onto the call stack. The call stack can get very large, which takes up a lot of memory.  Therefore, in certain situation you should not use recursion but tail recursion. 

### Quicksort - Divide and conquer (D&C)
Is a well-known recursive technique for solving problems.  D&C are recursive algorithms. To solve a problem using D&C there are two steps:
1. Figure out the base case. This should be the simplest possible case
2. Divide or decrease your problem until it becomes the base case. 
D&C isn’t a simple algorithm that you can apply to a problem. Instead, it’s a way to think about a problem. The binary search algorithm is a s a divide-and-conquer algorithm too. 

### Quicksort
Quicksort is a sorting algorithm. It’s, much faster than selection sort and is frequently used in real life. Quicksort works as follows. 
-	First, pick an element from the array. This element is called the pivot.
-	Secondly, find the elements smaller than the pivot and the elements larger than the pivot (i.e., called partitioning). 
Now you have the following:
-	A sub-array of all the numbers smaller than the pivot
-	The pivot
-	A sub-array of all the numbers greater than the pivot
The two sub-arrays aren’t sorted. They are just partitioned.  So the last thing you should do is call quicksort recursively on the two sub-arrays. How do you sort the sub-arrays? Well, the quicksort base case already knows how to sort arrays of two elements (the left sub-array) and empty arrays (the right sub-array). So if you call quicksort on the two sub-arrays and then combine the results, you get a sorted array

Please remember that recursive functions use something called “the call stack.” When a program calls a function, that function goes on top of the call stack. This similar to a stack of books. You add things one at a time. Then, when you are ready to take something off, you always take off the top item. I will describe you the call stack in action with the factorial function. factorial(3) is written as 3! and it is defined like this: 3! = 3 * 2 * 1. Each time the code calls this function, the function gets added to the stack. Once a function ends, it gets taken off the list and the code returns to the calling function. So when factorial(3) calls factorial(2), it's going to wait until factorial(2) ends before it can also end. Once factorial(2) ends, factorial(3) finishes its run. It's like that, but for all the functions. For an animation see https://vimeo.com/125844920

*Quicksort is unique because its speed depends on the pivot you choose.* 
When the pivot is exactly the middle element, for instance 1, 2, 3, 4, 5.  You will make less recursive calls and you will hit the base case sooner. As a result the call stack will be much shorter. So if you’re implementing quicksort, choose a random element as the pivot.  

### Hash tables 
A hash function is a function where you put in a string and you get back a number. In technical terminology we say that a hash function “maps strings to a number”.  In other words, we talk about key value pair relations. 
- The hash function consistently maps a key to the same index (i.e., place where the value is stored). 
- The hash function maps different strings to different indexes.
- The hash function knows how big your array is and only returns valid indexes. 
When you put a hash function and an array together you get a hash table. They’re also known as hash maps, maps, dictionaries, and associative arrays. And hash tables are fast! As described before you get an item from an array instantly and hash tables use an array to store the data, so they are equally fast.  You’ll probably never have to implement hash tables yourself. Any good programming language will have an implementation for hash tables. 

#### Hash tables – use cases
A phonebook is a perfect uses for hash tables since it needs this functionality:
- Add a persons name and the phone number associated with that person.
- Enter a persons name, and get the phone number associated with the name.
Hash tables are great when you want to:
- create a mapping form on thing to another
- look something up.
Another uses case will be the use a hash table as a cache. Caching is a common way to make things faster. All big websites use caching. And that data is cached in a hash!

**To recap, hashes are good for**:
- Modeling relationships from one thing to another thing
- Filtering out duplicates
- Caching/memorizing data instead of making your server do work


#### Collisions – performance of hash tables
Collision is a problem that occurs when two keys have been assigned to the same slot. A collision can occur as follows.  Suppose your array contains 26 slots. And your hash function is really simple: **it assigns a spot in the array alphabetically**. You want to put the price of apples in your hash. You get assigned the first slot. Then you want to put the price of bananas in the hash. You get assigned the second slot. Everything is going so well! But now you want to put the price of avocados in your hash. You get assigned the first slot again. Oh no! Apples have that slot already! If you store the price of avocados at that slot, you’ll overwrite the price of apples. Then the next time someone asks for the price of apples, they will get the price of avocados instead! 

**How to deal with collisions**: 
- if multiple keys map to the same slot, start a linked list at that slot. However, if the linked list gets long search through also take long. 

There are two lessons here:
- Your hash function is really important. Your hash function mapped all the keys to a single slot. Ideally, your hash function would map keys evenly all over the hash.
- If those linked lists get long, it slows down your hash table a lot. But they won’t get long if you use a good hash function!

Hash functions are important. A good hash function will give you very few collisions. So how do you pick a good hash function?  That’s coming up in the next section!

#### Performance – hash table
Please note that whatever programming language you use will have an implementation of hash tables built in. You can use the built-in hash table and assume it will have good performance. However, here we will describe the performance of hash tables in more detail.

Looking up something in a hash table takes constant time (i.e, O(1)). That means it doesn’t matter whether your hash table has 1 element or 1 billion elements. Getting something out of  a hash table will take the same amount of time. If implemented correclty hash tables are as fast as arrays at searching (getting a value at an index). And they’re as fast as linked lists at inserts and deletes. It’s the best of both worlds!
So it’s important that you don’t hit worst-case performance with hash tables. And to do that, you need to avoid collisions. To avoid collisions, you need
- **A low load factor** => number of items in a hash table / total number  of slots.

Having a load factor greater than 1 means you have more items than slots in your array. Once the load factor start to grow you need to add more slots to your hash tables. This is called resizing.  A good rule of thumb is, resize when your load factor is greater than 0.7. When resizing you create a new array that is greater in size and you reinsert all records of the previous array.  However, this resizing takes a lot of time so you don’t want to resize too often. 
- **A good hash function**

A good hash function distributes values in the array evenly. A bad hash functions groups values together and produces a lot of collisions. 

#### Hash tables – Recap
- You’ll almost never have to implement a hash table yourself.  e programming language you use should provide an implementation for you.
- You can make a hash table by combining a hash function
with an array.
- Collisions are bad. You need a hash function that minimizes collisions.
- Hash tables have really fast search, insert, and delete.
- Hash tables are good for modeling relationships from one item to another item.
- Once your load factor is greater than .07, it’s time to resize your hash table.
- Hash tables are used for caching data (for example, with a web server).
- Hash tables are great for catching duplicates.

### Graphs – breadth-first
Breadth-first is a graph algorithm. Its called breadth-first-search (BFS). It allows you to find the shortest distance between two things. Or in other words,  it allows you to solve the shortest-path problem. However, shortest distance can mean a lot of things! You can use breadth-first search to:
-	Write a checkers AI that calculates the fewest moves to victory
-	Write a spell checker (fewest edits from your misspelling to a real word)
-	Find the doctor closest to you in your network

#### Graphs – Introduction to graphs
A graph models a set of connections.  Each graph is made up of nodes and edges.
A node can be directly connected to many other nodes. Those nodes are called its neighbors. So graphs are a way to model how different things are connected to one another.  There are two types of graphs a directed graph and an undirected graph. In a directed graph the relationship is only one way. So Anuj is Bob’s neighbor, but Bob isn’t Anuj’s neighbor. In contrast, an undirected graph doesn’t have any arrows, and both nodes are each other’s neighbors.
BFS can help you to answer two questions:
1. Is there a path from node A to node B?  (e.g., Is there a mango seller in your network?)
2. What is the shortest path from node A to node B? (e.g., Who is the closets (e.g., 1st, or 2nd degree) mango seller?). 

The way breadth-first search works is that the search radiates out from the starting point. So you’ll check  first-degree connections before second-degree connections.

Queue is FIFO and a Stack is LIFO.

#### Implementing the graph 
First, you need to implement the graph in code. A graph consists of several nodes. And each node is connected to neighboring nodes. How do you express a relationship like “you -> bob”? Luckily, you know a data structure that lets you express relationships: a hash table! Remember, a hash table allows you to map a key to a value. In this case, you want to map a node to all of its neighbors.
For further implementation please look at the code.

#### Recap Bread-first search
- Breadth-first search tells you if there’s a path from A to B.
- If there’s a path, breadth-first search will find the shortest path.
- If you have a problem like “find the shortest X,” try modeling your problem as a graph, and use breadth-first search to solve.
- A directed graph has arrows, and the relationship follows the direction of the arrow (rama -> adit means “rama owes adit money”).
- Undirected graphs don’t have arrows, and the relationship goes both ways (ross - rachel means “ross dated rachel and rachel dated ross”).
- Queues are FIFO (First In, First Out).
- Stacks are LIFO (Last In, First Out).
- You need to check people in the order they were added to the search list, so the search list needs to be a queue. Otherwise, you won’t get the shortest path.
- Once you check someone, make sure you don’t check them again. Otherwise, you might end up in an infinite loop.

### Dijkstra’s algorithm 
Helps not by finding the path with the fewest segments but helps finding the fastest path instead.  In other words, you will use Dijkstra’s algorithm to go from start to finish in the shortest possible time. 
There are four steps to Dijkstra’s algorithm:
1. Find the ‘cheapest’ node. This is the node you can get to in the least amount of time.  There is no cheaper way to go to this node!
2. Check whether there’s a cheaper path to the neighbors of this node  (i.e., the cheapest). If so update their costs. 
3. Repeat until you have done this for every node in the graph. 
4. Calculate the final path.
**However, before you start, you need some setup. Make a table of the cost for each node. The cost of a node is how expensive it is to get to. You keep updating this table as the algorithm goes on.**  

In breadth-first search you find the shortest path between two points. The shortest-path meant the path with the fewest segments. However, in Dijkstra’s algorithm, you assign a number or weight to each segment. Then Dijkstra’s algorithm finds the path with the smallest total weight. 

#### Terminology
A graph with weights is called a weighted graph. In addition, a graph without weights is called an unweighted graph. To calculate the shortest path in an unweighted graph, use breadth-first search.  To calculate the shortest path in a weighted graph, use Dijkstra’s algorithm.
 Graphs can also have cycles. It means you can start at a node, travel around, and end up at the same node.  Dijkstra’s algorithm only works with directed acyclic graphs, called DAGs for short. 

Implementation
To code the algorithm you need three ‘containers’ to store information:
1. Graph ‘container’: which stores the neighbors and the costs for getting to that neighbor. It basically, stores all the edges (i.e., from, to, and the cost). 
2. Minimal Priority Queue: stores the costs (i.e., node, cost, pathVia) to go to that node from the start. The queue will be filled with the neighbors of a specific node. In addition, the queue will be ordered from lowest to highest costs each time new neighbors are added. So it  will be updated as the algorithm progresses.  This minimal priority queue is used to go through all relevant data. 
3. Visited ‘container’: which stores only the shortest cost to go to a specific node from the start. 

So that’s the setup. The implementation will look like this:
1). While we have nodes to process (i.e., Minimal Priority Queue is not empty)
2). Grab the node in the queue (i.e., the one that is closest to the start, since the queue is ordered this is always the first element in the queue)
3). If node already visited update the costs with the lowest cost, otherwise store the data as visited. 
4). Go back to 1 until the queue is empty. 

#### Recap Dijkstra’s algorithm
-	Breadth-first search is used to calculate the shortest path for an unweighted graph 
-	Dijkstra’s algorithm is used to calculate the shortest path for a weighted graph
-	Dijkstra’s algorithm works when all the weights are positive
-	If you have negative weights, use the Bellman-Ford algorithm

### Greedy Algorthims
A greedy algorithm is simple: at each step, pick the optimal move. In technical terms:
at each step you pick the locally optimal solution, and in the end you are left with the globally
optimal solution. Obviously, greedy algorithms don't always work. But they are simple to write. 
Below we will explain some greedy algorithms. 

##### Greedy Algorithm - The classroom scheduling problem
Suppose you have a classroom and want to hold as many classes here as possible. 
You get a list of classes, containing the name of the class, the start time and the end time. 
You cannot hold all the classes in there, because some of them overlap. However, you want to 
hold as many classes as possible in this classroom. In this situation you can use 'the classroom scheduling algorithm'. 
The steps are very easy:
* Pick the class that ends the soonest. This is the first class you will hold. 
* Pick the class or classes that starts after the first class. Again pick the one that ends the soonest.
This is the second class you will hold. Keep doing this till you are finished. 
 
##### Greedy Algorithm - The knapsack problem


