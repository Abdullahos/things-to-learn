# Memory Leak

### When?
- When there's allocated memory in heap no longer used
- It blocks memory resources and degrades system performance over time.
- The application will eventually exhaust its resources, finally terminating with a fatal java.lang.OutOfMemoryError.


### The (Garbuge Collector) GC:
The garbage collector removes unreferenced objects periodically, but it never collects the objects that are still being referenced(can it be no longer unused but still referenced?)

### Symptoms of a Memory Leak
- Severe performance degradation when the application is continuously running for a long time
- OutOfMemoryError heap error in the application
- Spontaneous and strange application crashes
- The application is occasionally running out of connection objects.

### Examples:

- Unclosed Resource (finally and make sure finally itself don't throws execptions), java 7+ try with resources
- static objects once they are initialized, they are application's life time lived
- Provide appropriate overriding for toString and equals
- stay away from overriding Finalize specially when write something that takes relatively long time 


Resources:
https://www.baeldung.com/java-memory-leaks
