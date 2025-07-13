package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "결과 반환됨!!";
            }
        };

        Future<String> future = executorService.submit(task);

        System.out.println("⏳ 작업 처리 중...");
        String result = future.get();  // 결과 대기 (blocking), throws Exception 필수
        System.out.println("📦 받은 결과: " + result);

        executorService.shutdown();


    }
}
