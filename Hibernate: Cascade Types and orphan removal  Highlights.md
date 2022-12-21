# Cascade Types: 
ALL, PERSIST, MERGE, REMOVE, REFRESH & DETACH
  
we will focus on Cascade: All & Remove And orphanRemoval
## All: 
```
CascadeType.ALL propagates all operations from a parent to a child entity.
```
## Remove:
```
CascadeType.REMOVE propagates the remove operation from parent to child entity. 
```

## Imagin we have a simple social app with this requirements:

1- when we delete post, its comments should be deleted too
2- Ability to delete post throw its parent post
3- when we update a post itself, no need to re-assign its comments


solutions:
1- we can use orphanRemoval = true so when the post deleted its comments became with no parent(orphan), so we tell hibernate to delete them
2- we can use cascade.REMOVE to be able to do something like that:
  ```
  post.comments.remove(comment);
  ```
3- we shall not use Cascade.ALL when we updating just the post itself (not its comments)
imaging update request like this:

{
 id, 
 postText
}

we didn't send the comments, so then java recieve that request, an Post Object will be created with no association to the presisted comments
in other words with null or empty list depends on the implementation, so if we use cascade.All with this structure,
that's will overwrite the already persisted comments.
```
    class Post{
    /*
       truncated...
    */
    @OneToMany(
            mappedBy = "unit",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private List<PostComments> comments = new ArrayList<>();
    
```
