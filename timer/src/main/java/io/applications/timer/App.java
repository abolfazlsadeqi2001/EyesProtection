package io.applications.timer;

import javax.swing.JOptionPane;

import javazoom.jl.player.Player;

public class App {
	private final static String WORKING_TIME_FLAG = "-t";
	private static int timeToDelay = 10 * 60 * 1000;// TIME FOR DELAY DEFAULT 10 MINUTES (10 * 60 * 1000)

	private final static String NUMBER_OF_PARTS_FOR_REST_FLAG = "-n";
	private static int numberOfPartsOfRestFlag = 10;

	private final static String REST_DEALY_FOR_EACH_PART_FLAG = "-d";
	private static int delayForEachPartOfRestTime = 1000;

	private static final String SHOW_DIALOG_FLAG = "--dialogly";
	private static boolean isShowDialog = false;

	private static final String OS_NAME = System.getProperty("os.name");
	private static final String LINUX_OSS_SAME_NAME = "inux";
	
	private static final String SOUND_NAME = "1.mp3";
	
	private static final String VERSION_FLAG = "--version";
	private static final String VERSION = "1.2.1";

	//================================>CONSTRUCTOR
	private App(String[] args) {
		try {
			// CONFIGURE THE ARGUMENTS
			for (int i = 0; i < args.length; i++) {
				String currentArg = args[i].toLowerCase();//AFTERWARD USING EQUALS INSTEAD OF EQUALSIGNORECASE
				// SETUP THE WORKING TIME FLAG
				if (currentArg.equals(WORKING_TIME_FLAG)) {// IF WE HAVE THE TIME ARGUMENT
					if (args.length > i + 1) {// IF WE HAVE ANOTHER ONE INDEX
						timeToDelay = Integer.parseInt(args[i + 1]) * 1000;// GET THE NEXT INDEX AS TIME TO DELAY # PER SECOND
					}
				}

				// SETUP THE NUMBER OF PART OF REST FLAG
				if (currentArg.equals(NUMBER_OF_PARTS_FOR_REST_FLAG)) {
					if (args.length > i + 1) {
						numberOfPartsOfRestFlag = Integer.parseInt(args[i + 1]);
					}
				}

				// SETUP THE DELAY FOR EACH PART OF REST TIME
				if (currentArg.equals(REST_DEALY_FOR_EACH_PART_FLAG)) {
					if (args.length > i + 1) {
						delayForEachPartOfRestTime = Integer.parseInt(args[i + 1]) * 1000;
					}
				}

				// SETUP TO SHOW DIALOG FRAME
				if (currentArg.equals(SHOW_DIALOG_FLAG)) {
					isShowDialog = true;// WHEN USE THIS FLAG USING THE DIALOG TO INFROM STARTING
				}
				
				//VERSION FLAG
				if(currentArg.equals(VERSION_FLAG)) {
					System.out.println(VERSION);
					System.exit(0);
				}
			}

			if (!OS_NAME.contains(LINUX_OSS_SAME_NAME)) {// IF IT ISN'T A LINUX USING DIALOG ANYWAY
				isShowDialog = true;
			}

			while (true) {
				Thread.sleep(timeToDelay);// WAIT UNTIL DELAY TIME TO SHOW THE NOTIFICATION

				if (isShowDialog) {
					JOptionPane.showMessageDialog(null, "this time to take a rest to your eyes");
				} else {
					Runtime runtime = Runtime.getRuntime();// EXECUTE THE SHOW NOTIFICATION COMMAND
					runtime.exec("notify-send this-time-to-take-a-rest-to-your-eyes");
				}

				for (int i = 0; i < numberOfPartsOfRestFlag; i++) {// WAIT FOR NUMBER_OF_PLAYED_SOUNDS_AFTER_DELAY * DELAY_TIME_FOR_EACH_SOUND
					Thread.sleep(delayForEachPartOfRestTime);// WAIT FOR A TIME THEN PLAY
					// START PLAYING
					Player player = new Player(getClass().getResourceAsStream(SOUND_NAME));
					player.play();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//=======================>MAIN METHOD OF PROGRAM
	public static void main(String[] args) {
		new App(args);
	}
}
