package qa.automation.api.old.methods;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import qa.automation.api.last.REQUEST;

public class Process_REQ {

	public void start_server() throws IOException {
		String loc = System.getProperty("user.dir");
		String path="cmd /c start "+ loc+File.separator+"start_server.bat";
		Runtime rn=Runtime.getRuntime();
		Process pr=rn.exec(path);
	}
	
	public void open_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
				+ "browser-drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver obj = new ChromeDriver();
		obj.manage().window().maximize();
		obj.get(new REQUEST().base_Url + "/posts");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		obj.quit();
	}
}
