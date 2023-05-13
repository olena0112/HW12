import java.time.Duration;
import java.time.Instant;

public class TimerProgram {
    public static void main(String[] args) {
        Thread timerThread = new Thread(() -> {
            Instant startTime = Instant.now();
            while (true) {
                Instant currentTime = Instant.now();
                Duration duration = Duration.between(startTime, currentTime);
                System.out.println("Пройшло: " + duration.getSeconds() + " секунд");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread messageThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        timerThread.start();
        messageThread.start();
    }
}