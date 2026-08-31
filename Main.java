import java.util.*;

public class Main {
    static LinkedList<Integer> list = new LinkedList<>();

    static void create(Scanner s) {
        System.out.print("Enter number of nodes: ");
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            list.add(s.nextInt());
        }

        System.out.println(list.isEmpty()
                ? "Linked List was not created."
                : "Linked List created successfully.");
        display();
    }

    static void display() {
        System.out.println(list.isEmpty() ? "Linked List is empty." : list);
    }

    static void menu(Scanner s) {
        while (true) {
            System.out.println("""
                    
                    1. Display
                    2. Insert Beginning
                    3. Insert End
                    4. Insert Position
                    5. Delete Beginning
                    6. Delete End
                    7. Delete Position
                    8. Search
                    9. Count
                    10. Reverse
                    11. Exit
                    """);

            System.out.print("Choice: ");
            int c = s.nextInt();

            switch (c) {
                case 1 -> display();

                case 2 -> {
                    System.out.print("Value: ");
                    list.addFirst(s.nextInt());
                    display();
                }

                case 3 -> {
                    System.out.print("Value: ");
                    list.addLast(s.nextInt());
                    display();
                }

                case 4 -> {
                    System.out.print("Position: ");
                    int p = s.nextInt();
                    System.out.print("Value: ");
                    int v = s.nextInt();

                    if (p >= 1 && p <= list.size() + 1)
                        list.add(p - 1, v);
                    else
                        System.out.println("Invalid position.");

                    display();
                }

                case 5 -> {
                    if (!list.isEmpty()) {
                        System.out.println("Deleted: " + list.removeFirst());
                        display();
                    } else System.out.println("List is empty.");
                }

                case 6 -> {
                    if (!list.isEmpty()) {
                        System.out.println("Deleted: " + list.removeLast());
                        display();
                    } else System.out.println("List is empty.");
                }

                case 7 -> {
                    System.out.print("Position: ");
                    int p = s.nextInt();

                    if (p >= 1 && p <= list.size())
                        System.out.println("Deleted: " + list.remove(p - 1));
                    else
                        System.out.println("Invalid position.");

                    display();
                }

                case 8 -> {
                    System.out.print("Value: ");
                    int v = s.nextInt();
                    int p = list.indexOf(v);

                    System.out.println(p == -1
                            ? "Value not found."
                            : "Found at position: " + (p + 1));
                }

                case 9 -> System.out.println("Number of nodes: " + list.size());

                case 10 -> {
                    Collections.reverse(list);
                    display();
                }

                case 11 -> {
                    System.out.println("Program ended.");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        create(s);
        menu(s);
        s.close();
    }
}
