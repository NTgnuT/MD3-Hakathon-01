package HKT;

import java.util.Scanner;

public class Book {
    private int bookId;

    private String bookName;

    private String author;

    private String description;

    private double importPrice;

    private double exportPrice;

    private float interest;

    private boolean bookStatus;

    private static int count = 1;

    public Book() {
        this.bookId = Book.count++;
    }

    public Book(String bookName, String author, String description, double importPrice, double exportPrice, boolean bookStatus) {
        this.bookId = Book.count++;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sách: ");
        while (true) {
            this.bookName = scanner.nextLine();
            if (bookName.isEmpty()) {
                System.err.println("Tên sách không được để trống");
            } else {
                break;
            }
        }

        System.out.println("Nhập tên tác giả: ");
        while (true) {
            this.author = scanner.nextLine();
            if (author.isEmpty()) {
                System.err.println("Tên tác giả không được để trống");
            } else {
                break;
            }
        }

        System.out.println("Nhập mô tả về sách: ");
        while (true) {
            this.description = scanner.nextLine();
            if (description.isEmpty()) {
                System.err.println("Mô tả không được để trống");
            } else if (description.length() < 10) {
                System.err.println("Mô tả không được ít hơn 10 ký tự");
            } else {
                break;
            }
        }

        System.out.println("Nhập giá nhập: ");
        while (true) {
            this.importPrice = Double.parseDouble(scanner.nextLine());
            if (importPrice < 0) {
                System.err.println("Giá nhập phải lớn hơn 0");
            } else {
                break;
            }
        }

        System.out.println("Nhập giá xuất: ");
        while (true) {
            this.exportPrice = Double.parseDouble(scanner.nextLine());
            if (exportPrice < 1.2 * importPrice) {
                System.err.println("Giá bán phải lớn hơn 1.2 lần giá nhập");
            } else {
                break;
            }
        }

        System.out.println("Nhập trạng thái: ");
        this.bookStatus = Boolean.parseBoolean(scanner.nextLine());

    }

    public double calInteres () {
        interest = (float) (exportPrice - importPrice);
        return interest;
    }

    public void displayData() {
        System.out.println(
                "Book{" +
                        "bookId=" + bookId +
                        ", bookName='" + bookName + '\'' +
                        ", author='" + author + '\'' +
                        ", description='" + description + '\'' +
                        ", importPrice=" + importPrice +
                        ", exportPrice=" + exportPrice +
                        ", interest=" + calInteres() +
                        ", bookStatus=" + bookStatus +
                        '}'
        );
    }
}
