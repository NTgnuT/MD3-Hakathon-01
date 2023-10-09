package HKT;

import java.util.Scanner;

public class MainBook {
    public static Scanner scanner = new Scanner(System.in);

    static Book [] books = new Book[100];

    static int index = 3;

    static {
        books[0] = new Book("Book1", "Nguyễn A", "Sách văn học", 10000, 25000, true );
        books[1] = new Book("Book2", "Nguyễn B", "Sách toán học", 12000, 23000, true );
        books[2] = new Book("Book3", "Nguyễn C", "Sách tiếng anh", 15000, 32000, true );
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("***** Menu *****");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.println("====================");
            System.out.println("Nhập lựa chọn của bạn (1-7)");

            int choise = Integer.parseInt(scanner.nextLine());
            handleSelect(choise);
        }


    }

    private static void handleSelect(int choise) {
        switch (choise) {
            case 1:
                addNewBook();
                break;
            case 2:
                showAllBook();
                break;
            case 3:
                shortBook();
                break;
            case 4:
                deleteBook();
                break;
            case 5:
                searchBook();
                break;
            case 6:
                changeInfoBook();
                break;
            case 7:
            System.exit(0);
                break;
            default:
                System.err.println("Không có lựa chọn này");
                break;
        }
    }

    private static void changeInfoBook() {
        System.out.println("Nhập ID book bạn muốn sửa: ");
        int idChange = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if (books[i].getBookId() == idChange) {
                books[i].displayData();
                books[i].inputData();
            }
        }
        System.out.println("Sửa thông tin sách thành công");
    }

    private static void searchBook() {
        System.out.println("Nhập tên hoặc mô tả về sách bạn muốn tìm kiếm: ");
        String searchName = scanner.nextLine();
        for (int i = 0; i < index; i++) {
            if (books[i].getBookName().toLowerCase().contains(searchName.toLowerCase())
                    || books[i].getDescription().toLowerCase().contains(searchName.toLowerCase())) {
                books[i].displayData();
            }
        }
    }

    private static void deleteBook() {
        System.out.println("Nhập mã sách bạn muốn xóa: ");
        int idDelete = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if (books[i].getBookId() == idDelete) {
                for (int j = 0; j < index; j++) {
                    books[j] = books[j+1];
                }
            }
            index--;
            break;
        }
        System.out.println("Xóa thành công");
        showAllBook();
    }

    private static void shortBook() {


        for (int i = 0; i < index - 1; i++) {
            for (int j = i + 1; j < index ; j++) {
                if (books[i].getInterest() > books[j].getInterest()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        showAllBook();
    }

    private static void addNewBook() {
        System.out.println("Nhập số sách bạn muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.inputData();
            books[index++] = book;
        }
    }

    private static void showAllBook() {
        for (int i = 0; i < index; i++) {
            books[i].displayData();
        }
        System.out.println("===================");
    }
}
