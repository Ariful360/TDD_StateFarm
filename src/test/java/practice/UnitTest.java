package practice;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import org.testng.annotations.Test;

import sfarm.tdd.utils.AutoData;

public class UnitTest {

	@Test(enabled = false)
	public void unitTestAutoDataNull() {
		AutoData data = new AutoData("name", "man", "can", null);
		System.out.println(data.getZipCode());
	}
	
	@Test(enabled = false)
	public void unitTestAutoDataZeroLenght() {
		AutoData data = new AutoData("name", "man", "can", "");
		System.out.println(data.getZipCode());
	}
	
	@Test(enabled = false)
	public void system_getPropertyTest() {
		System.out.println(System.getProperty("java.home"));
	}
	
	@Test(enabled = true)
	public void folderOps() {
		File folder = new File("screenShot");
		System.out.println(folder.getAbsolutePath());
		System.out.println(folder.mkdirs());
	}
	
	@Test(enabled = false)
	public void timeUnitTest() {
		Date date = new Date();
		System.out.println(date);
		Instant time = Instant.now();
		System.out.println(time);
		System.out.println(LocalDateTime.now().plusYears(1).plusMonths(1));
		System.out.println("Test1_"+time+".png");
		SimpleDateFormat date_format = new SimpleDateFormat("MM:dd:YYYY_HH:mm:ss");
		System.out.println(date_format.format(date));
	}
}
