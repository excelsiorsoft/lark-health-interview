**Take Home Assignment**

**Task**

Given a stream of items, represented as one item at a time, be able to print the top 3 occurances at any time within a window of 3 items, ordered by frequency count in descending order.
    
          A B B C A
           |_____| // line 14     
    
     i.e.:
        
         A -> 1 A
         B -> 1 A, 1 B // ties can be in any order
         B -> 2 B, 1 A // ordered by frequency count in descending order
         C -> 2 B, 1 C // the first A is now outside the sliding window
         A -> 1 B, 1 A, 1 C
    
    
    const print = function() {
      console.log("test print")
    }
    
    const add = function(item) {
      console.log("test add()")  
    
    }
    
    add("A")
    print()
    add("B")
    print()
    add("B")
    print()
    add("C")
    print()
    add("A")
    print()
    
    