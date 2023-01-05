## Using Collections in ManyToMany Relation in Hibernate

it's better to use Set over List for ManyToMany relationship because of the deletion part

```
/**
*A have 3 B
 we want to delete B1
 we use List
*/
B b = getB(bId);
/**
* this will generate 
* 1- delete all the Bs Ids in A_B table that 're associated with A even if they aren't the meant to be deleted (B1,B3)
  2- reinsert the (B1, B3) in A_B table 
*
*/
a.getBs().remove(b);
```
## But if we use set
that will generate 1 delete statement targets b1 in A_B tables 
