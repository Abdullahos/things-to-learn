## Cascading types best practice in @ManyToMany
it's usually better not to use cascade.All or cascade.remove in manyToMany.
imagine the following:
```
 A ---> B
        ^
        |
 C------
 ^ ---- D
```
deleting **A** doesn't mean we want **B** to be deleted too, as the existence of **B** have a meaning without the existence of **A**
the same for Cascade.All as it implicity includes removal

the same applies for ManyToOne
