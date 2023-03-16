## What is the difference between parallel and async?

Asynchronous programming involves some calculations time-intensive tasks, which on the one hand are engaging a thread in the background but do not affect the normal flow of the program.
Parallel programming incorporates several threads to perform a task faster and so does concurrent programming.


An operation on a ParallelStream is still blocking and will wait for all the threads it spawned to finish. These threads are executed asynchronously (they don't wait for a previous one to finish), but that doesn't mean your whole code starts behaving asynchronously!

### src:
https://stackoverflow.com/questions/44945521/java-8-parallel-stream-blockingcode-possible#:~:text=An%20operation%20on%20a%20ParallelStream,whole%20code%20starts%20behaving%20asynchronously%20!

https://www.oreilly.com/library/view/learning-scala-programming/9781788392822/3b58278f-a0b6-4a32-8e14-5212f1ebe127.xhtml#:~:text=Asynchronous%20programming%20involves%20some%20calculations,and%20so%20does%20concurrent%20programming.
