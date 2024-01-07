/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Circular;
class Player {
    String name;
    // Các thông tin khác về người chơi

    public Player(String name) {
        this.name = name;
        // Khởi tạo thông tin khác của người chơi
    }
}

class MultiPlayerGameQueue {
    Node head;
    Node tail;

    class Node {
        Player player;
        Node next;

        public Node(Player player) {
            this.player = player;
            this.next = null;
        }
    }

    public MultiPlayerGameQueue() {
        this.head = null;
        this.tail = null;
    }

    // Thêm người chơi vào hàng đợi
    public void enqueue(Player player) {
        Node newNode = new Node(player);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Rời khỏi hàng đợi
    public void dequeue(String playerName) {
        if (head == null)
            return;

        Node current = head;
        Node previous = null;

        // Tìm người chơi cần rời khỏi hàng đợi
        do {
            if (current.player.name.equals(playerName)) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    previous.next = head;
                    tail = previous;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }

    // In danh sách người chơi trong hàng đợi
    public void printQueue() {
        if (head == null) {
            System.out.println("Hàng đợi trống");
            return;
        }
        Node current = head;
        do {
            System.out.println(current.player.name);
            current = current.next;
        } while (current != head);
    }
}

public class Main {
    public static void main(String[] args) {
        MultiPlayerGameQueue gameQueue = new MultiPlayerGameQueue();

        /* Thêm người chơi vào hàng đợi
        gameQueue.enqueue(new Player("Player1"));
        gameQueue.enqueue(new Player("Player2"));
        gameQueue.enqueue(new Player("Player3"));
          */
        
        for(int i=1; i<=3; i++){
        System.out.println("Nhập tên người chơi " + i + ": ");
        String playerName = readLine();
        gameQueue.enqueue(new Player(playerName));
        }
        
        // In ra danh sách người chơi
        System.out.println("Danh sách người chơi:");
        gameQueue.printQueue();

        /* Rời khỏi hàng đợi
        gameQueue.dequeue("Player2");
        */
                
        System.out.println("Nhập tên người chơi rời khỏi hàng đợi: ");
        String playerToRemove = readLine();
        gameQueue.dequeue(playerToRemove);

        // In lại danh sách người chơi sau khi rời khỏi hàng đợi
        System.out.println("Danh sách sau khi rời khỏi hàng đợi:");
        gameQueue.printQueue();
    }
    
    public static String readLine(){
        StringBuilder sb = new StringBuilder();
        try {
            int charCode;
            while ((charCode = System.in.read()) != '\n'){
                  if (charCode != '\r') {
                     sb.append((char) charCode);
                  }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString().trim();
    }
}
