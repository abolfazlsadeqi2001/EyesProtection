# Eyes protection
It is just a simple software that inform you each 10 minutes that this time is to take the rest of your eyes

(windows users must run via --dialogly)

#you can change the working time by the following syntax(default : 600 (10 min))

	syntax:
		java -jar timer.jar -t timerPerSeconds
	example:
		java -jar timer.jar -t 600  

#you can change the number of rest parts by the following syntax (default: 10)

	syntax:
		java -jar timer.jar -n numberOfParts
	example:
		java -jar timer.jar -n 10

#you can change the during of rest time for each part (defalut : 1sec)

	syntax:
		java -jar timer.jar -d delay
	example:
		java -jar timer.jar -d 1