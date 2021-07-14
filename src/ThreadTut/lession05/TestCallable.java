package ThreadTut.lession05;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {
    private final String url;
    private final String filePath;

    public TestCallable(String url, String filePath)
    {
        this.url = url;
        this.filePath = filePath;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader downloader = new WebDownloader();
        downloader.Download(url, filePath);
        System.out.println(url + " download completed.");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable thread01 = new TestCallable("https://commons.apache.org/proper/commons-io/images/commons-logo.png", "a.png");
        TestCallable thread02 = new TestCallable("https://commons.apache.org/proper/commons-io/images/io-logo-white.png", "b.png");
        TestCallable thread03 = new TestCallable("https://www.apache.org/events/current-event-125x125.png", "c.png");

        // Create Executor Service
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // Submit and Execute
        Future<Boolean> result1 = ser.submit(thread01);
        Future<Boolean> result2 = ser.submit(thread02);
        Future<Boolean> result3 = ser.submit(thread03);

        // Get results
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();

        // Close service
        ser.shutdownNow();
    }

}

class WebDownloader
{
    // download method
    public void Download(String url, String filePath)
    {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
