package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0; i<5; i++){
            final int taskId = i; // 내부 클래스에서 사용하려면 final 이여야 함.

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("🔧 작업 " + taskId + " 실행 중... [Thread: " + Thread.currentThread().getName() + "]");
                    try {
                        Thread.sleep(1000); // 각 작업은 1초 소요
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("작업 " + taskId + " 완료!");
                }
            });
        }

        executorService.shutdown();
    }


}
