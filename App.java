import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        QueueManagement queue = new QueueManagement(32);

        System.out.println("How many process do you want to create? (Limit = 32)");

        // Number of process
        Scanner np = new Scanner(System.in);
        int len = np.nextInt();

        System.out.println("Now enter the process names (As you type the processes are allocated and executed):");

        for (int i = 0; i < len; i++) {
            Scanner aux = new Scanner(System.in);
            String word = aux.nextLine();
            new WordProcess(word, queue);
        }
    }
}
