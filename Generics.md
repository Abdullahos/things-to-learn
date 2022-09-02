# Intro To Generics
Consider the following example:
```
String s = new String("s");
List list = new ArrayList<String>();
list.add(s);
String ss = list.iterator().next(); //compile error
```
that compile error is caused because there's no way the compiler can know which Object type 'll be returned from the list.
to enforce specific type:

there's workarround but it can cause other problems
```
String s = new String("s");
List list = new ArrayList<String>();
list.add(s);
String ss = (String) list.iterator().next(); //compile error
```
if the input wasn't string, then the output will not also, so it will throw exception!

the safer and better solution:
```
String s = new String("s");
List<String> list = new ArrayList<String>();
list.add(s);
String ss = list.iterator().next(); //work just fine!
```
