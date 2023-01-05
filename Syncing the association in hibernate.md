## Syncing the association in hibernate

```
    public void addBook(Book book) {
        this.books.add(book);      
        book.getAuthors().add(this);
    }
    public void removeBook(Book book) {
        this.books.remove(book);
        book.getAuthors().remove(this);
    }
    public void removeBooks() {
        Iterator<Book> iterator = this.books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            book.getAuthors().remove(this);
            iterator.remove();
        }
    }
```
