package partie2;

import java.io.File;

public class Memory {
	private File f;
	private int freeSpace;
	public Memory() {
		f = new File("D:\\");
		freeSpace = (int) (f.getFreeSpace()/1000000000.00);
	}
	
	//getter
	public int getFreeSpace() {
		return freeSpace;
	}
	
	
	
	/*System.out.println("Printing the total space");
		 System.out.println(f.getTotalSpace() +" bytes");
		 System.out.println(f.getTotalSpace()/1000.00 +" Kilobytes");
		 System.out.println(f.getTotalSpace()/1000000.00 +" Megabytes");
		 System.out.println(f.getTotalSpace()/1000000000.00 +" Gigabytes");
		 System.out.println("----------------------------");
		 System.out.println("Printing the free space");
		 System.out.println(f.getFreeSpace() +" bytes");
		 System.out.println(f.getFreeSpace()/1000.00 +" Kilobytes");
		 System.out.println(f.getFreeSpace()/1000000.00 +" Megabytes");
		 System.out.println(f.getFreeSpace()/1000000000.00 +" Gigabytes");*/

}
