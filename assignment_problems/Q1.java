class BookInventory
{
    String title;
    String author;
    int copiesAvailable;

    BookInventory(String title, String author, int copiesAvailable)
    {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry()
    {
        System.out.println(this.title + " by " + this.author + " - " + this.copiesAvailable + " copies available");
    }
}
public class Q1 
{
    public static void main(String[] args)
    {
        BookInventory book1 = new BookInventory("Clean Code", "Robert C. Martin", 3);
        BookInventory book2 = new BookInventory("Effective Java", "Joshua Bloch", 5);
        BookInventory book3 = new BookInventory("Refactoring", "Martin Fowler", 0);
        BookInventory book4 = new BookInventory("Design Patterns", "GoF", 2);
        BookInventory[] inventory = {book1, book2, book3, book4};
        for (BookInventory book : inventory) {
            book.printEntry();
        }
    }   
}
