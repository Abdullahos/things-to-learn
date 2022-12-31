# Why it's good practice to avoid unidirectional association?

let’s assume that the same Author and Book entities are involved in a unidirectional
@OneToMany association mapped, as follows:
@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
private List<Book> books = new ArrayList<>();
The missing @ManyToOne association leads to a separate junction table (author_books)
meant to manage the parent-child association, as shown in Figure

file:///home/abdullah/Pictures/Screenshots/Screenshot%20from%202022-12-31%2019-20-31.png![image](https://user-images.githubusercontent.com/51336081/210151114-dbdeeab0-ad2a-4bc0-802b-c2012a7f75cf.png)

that leads to 2 problems:
  1- more memory occupation
  2- perfomance issues in search, delete, insert
  
  in search: we have to join 3 tables instead of 2
  in inserting new parent with 2 childs for example : that's will generate 2 extras sql queries for the 3rd relation table 
