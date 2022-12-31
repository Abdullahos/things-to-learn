# Why it's good practice to avoid unidirectional association? Credits for Spring Boot Persistence Best Practices_ Optimize Java Persistence Performance in Spring Boot Applications 2020

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

  Persisting a New Book of an Existing Author
Since Joana Nimar has just published a new book, we have to add it to the book table.
This time, the service-method looks as follows:
@Transactional
public void insertNewBook() {
    Author author = authorRepository.fetchByName("Joana Nimar");
    Book book = new Book();
    book.setIsbn("004-JN");
    book.setTitle("History Details");
    author.addBook(book); // use addBook() helper
    authorRepository.save(author);
}
Calling this method and focusing on SQL INSERT statements results in the following
output:
INSERT INTO book (isbn, title)
  VALUES (?, ?)
Binding:[004-JN, History Details]
-- the following DML statements don't appear in bidirectional @OneToMany
DELETE FROM author_books
WHERE author_id = ?
Binding:[1]
INSERT INTO author_books (author_id, books_id)
  VALUES (?, ?)
Binding:[1, 1]
INSERT INTO author_books (author_id, books_id)
  VALUES (?, ?)
Binding:[1, 2]
INSERT INTO author_books (author_id, books_id)
  VALUES (?, ?)
12Chapter 1
Associations
Binding:[1, 3]
INSERT INTO author_books (author_id, books_id)
  VALUES (?, ?)
