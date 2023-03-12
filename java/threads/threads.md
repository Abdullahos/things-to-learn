## What is a Thread in Java?

A thread in Java is the path followed when executing a program. All Java programs have at least one thread, known as the main thread, which is created by the Java Virtual Machine (JVM) at the program’s start, when the main() method is invoked.

The Java Virtual Machine allows an application to have multiple threads of execution running concurrently

A Java process consists of multiple threads and a Java thread is often regarded as a light-weight process.

ex:
```
Thready extends Thread {
	public void run() {
		for (int i = 0; i < 10 ; i++) {
			System.out.println(i);
		}	

	}
}
public void main (String[] args) {
	Thready threadA = new Thready();
	Thready threadB = new Thready();
	threadA.start();	// invokes run concurrently
	threadB.start();	// invokes run  concurrently
} 
```

```
output:
	0
	0
	1
	1
	2
	2
	...
```
