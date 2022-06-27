package task1;

public class Main {
    public static void main(String[] args) {
        CyclicQueue<Integer> queue = new CyclicQueue<>();
        for(int i=0; i<10; i++){
            queue.add(i);
        }
        System.out.println(queue);

        for(int i=0; i<5; i++){
            queue.poll();
        }
        System.out.println(queue);

        for(int i=10; i<20; i++){
            queue.add(i);
        }
        System.out.println(queue);

        for(int i=0; i<5; i++){
            queue.poll();
        }
        System.out.println(queue);

        for(int i=20; i<100; i++){
            queue.add(i);
        }
        System.out.println(queue);
    }
}
