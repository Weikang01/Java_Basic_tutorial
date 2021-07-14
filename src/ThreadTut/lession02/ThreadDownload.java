package ThreadTut.lession02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ThreadDownload extends Thread{
    private String url;
    private String filePath;

    public ThreadDownload(String url, String filePath)
    {
        this.url = url;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        WebDownloader downloader = new WebDownloader();
        downloader.Download(url, filePath);
        System.out.println(url + " download completed.");
    }

    public static void main(String[] args) {
        ThreadDownload thread01 = new ThreadDownload("https://commons.apache.org/proper/commons-io/images/commons-logo.png", "a.png");
        ThreadDownload thread02 = new ThreadDownload("https://commons.apache.org/proper/commons-io/images/io-logo-white.png", "b.png");
        ThreadDownload thread03 = new ThreadDownload("https://www.apache.org/events/current-event-125x125.png", "c.png");
        thread01.start();
        thread02.start();
        thread03.start();
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
