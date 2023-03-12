For multithreaded applications, we need to ensure a couple of rules for consistent behavior:

## Mutual Exclusion
only one thread executes a critical section at a time
## Visibility
changes made by one thread to the shared data are visible to other threads to maintain data consistency

synchronized methods and blocks provide both of the above properties at the cost of application performance.

volatile is quite a useful keyword because it can help ensure the visibility aspect of the data change without providing mutual exclusion. Thus, it's useful in the places where we're ok with multiple threads executing a block of code in parallel, but we need to ensure the visibility property.

