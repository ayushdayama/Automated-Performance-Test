package performanceTest.runPerformanceTest;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import org.apache.commons.io.*;

public class performanceTestAutomate {
	
    public static void main(String[] args) throws Exception {
    	StringSelection stringSelection; Clipboard clipboard;
		String currentFileName = null, commandToExec = null, 
    			parentPath = "F:\\Load-Testing\\apache-jmeter-5.2\\bin\\Reports\\", 
    			batchFilePath = "F:\\Load-Testing\\apache-jmeter-5.2\\bin\\Reports\\DO-NOT-TOUCH.bat",
				currentPath = null;
		
		JFrame frame = new JFrame();
		int runProgram = JOptionPane.showConfirmDialog(frame, "Are you sure you want to run the program?", "Run Performance Test",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(runProgram == JOptionPane.NO_OPTION) {
			System.exit(0);
		}
		
		Runtime.getRuntime().exec("F:\\Load-Testing\\apache-jmeter-5.2\\bin\\jmeter.bat");
		Thread.sleep(7500);
		Robot robot = new Robot();
		robot.setAutoDelay(250);
    	
    	JFileChooser chooser = new JFileChooser();
    	chooser.setMultiSelectionEnabled(true);
		chooser.setCurrentDirectory(new File("F:\\Load-Testing\\apache-jmeter-5.2\\bin\\Reports\\JMX"));
		chooser.showOpenDialog(null);
		
		File[] files = chooser.getSelectedFiles();
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_X);
		robot.keyRelease(KeyEvent.VK_X);
		Thread.sleep(500);
		
		for(File allFiles : files) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_O);
			robot.keyRelease(KeyEvent.VK_O);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			currentPath = allFiles.getPath();
			stringSelection = new StringSelection(currentPath);
			clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			Thread.sleep(1200);
			robot.keyPress(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_END);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_SHIFT);
			for(int i = 1; i <= 25; i++) { robot.keyPress(KeyEvent.VK_TAB); Thread.sleep(200); }
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(500);
			for(int i = 1; i <= 5; i++) { robot.keyPress(KeyEvent.VK_BACK_SPACE); Thread.sleep(100); robot.keyRelease(KeyEvent.VK_BACK_SPACE);}
			robot.keyPress(KeyEvent.VK_2);
			robot.keyRelease(KeyEvent.VK_2);
			robot.keyPress(KeyEvent.VK_5);
			robot.keyRelease(KeyEvent.VK_5);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(500);
			for(int i = 1; i <= 5; i++) { robot.keyPress(KeyEvent.VK_BACK_SPACE); Thread.sleep(100); robot.keyRelease(KeyEvent.VK_BACK_SPACE);}
			robot.keyPress(KeyEvent.VK_5);
			robot.keyRelease(KeyEvent.VK_5);
			robot.keyPress(KeyEvent.VK_0);
			robot.keyRelease(KeyEvent.VK_0);
			
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_F4);
		robot.keyRelease(KeyEvent.VK_F4);
		robot.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(1500);
		
		File batchFile = new File(batchFilePath);
		FileOutputStream fos = new FileOutputStream(batchFile);
		DataOutputStream dos = new DataOutputStream(fos);
		
		for(int i = 1; i <= files.length; i++) {
			currentFileName = FilenameUtils.removeExtension(files[i-1].getName());
			new File("F:\\Load-Testing\\apache-jmeter-5.2\\bin\\Reports\\Results\\" + currentFileName).mkdirs();
			
			if((i-1) == 0) {
				commandToExec = "jmeter -n -t " + 
					parentPath + "JMX\\" + currentFileName + ".jmx -l " + 
					parentPath + "JTL\\" + currentFileName + ".jtl -e -o " +
					parentPath + "Results\\" + currentFileName;
			}
			else {
				commandToExec = commandToExec + " && jmeter -n -t " + 
					parentPath + "JMX\\" + currentFileName + ".jmx -l " + 
					parentPath + "JTL\\" + currentFileName + ".jtl -e -o " +
					parentPath + "Results\\" + currentFileName;
			}
		}
		dos.writeBytes(commandToExec);
		Runtime.getRuntime().exec("cmd /c start " + batchFilePath);
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_X);
		robot.keyRelease(KeyEvent.VK_X);
		Thread.sleep(500);
		dos.close();
		Thread.sleep(10000);
		new File(batchFilePath).delete();
    }
}