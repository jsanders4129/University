import turtle as gui
import time
import random as r

def preferenceBoilerplate():
	gui.screensize(500, 500)
	gui.setworldcoordinates(0, 0, 500, 500)
	gui.hideturtle()
	gui.penup()
	gui.speed(0)

def drawFrame(frame):
	# Static naming label:
	gui.goto(235, 450)
	gui.write("Current Frame: ", move = False, align = "center", font = ("Arial", 36, "normal"))

	# Dynamic frame number:
	gui.goto(335, 450)
	gui.write(frame + 1, move = False, align = "center", font = ("Arial", 36, "normal"))

def drawResult(result):
	gui.goto(250, 100)
	gui.write(result, move = False, align = "center", font = ("Arial", 36, "normal"))

def drawPins():
	# Pin distance assignment:
	pinDisplacement = 35
	pinDisplacementY = pinDisplacement / 1.25

	# First pin:
	p1 = gui.stamp()
	# Second pin, second row:
	gui.setheading(90)
	gui.forward(pinDisplacementY)
	gui.left(90)
	gui.forward(pinDisplacement/2)
	gui.right(180)
	p2 = gui.stamp()
	# Third pin:
	gui.forward(pinDisplacement)
	p3 = gui.stamp()
	# Fourth pin, third row:
	gui.setheading(90)
	gui.forward(pinDisplacementY)
	gui.left(90)
	gui.forward(pinDisplacement + pinDisplacement/2)
	p4 = gui.stamp()
	# Fifth pin:
	gui.right(180)
	gui.forward(pinDisplacement)
	p5 = gui.stamp()
	# Sixth pin:
	gui.forward(pinDisplacement)
	p6 = gui.stamp()
	# Seventh pin, fourth row:
	gui.setheading(90)
	gui.forward(pinDisplacementY)
	gui.right(90)
	gui.forward(pinDisplacement/2)
	gui.left(180)
	p7 = gui.stamp()
	# Eighth pin:
	gui.forward(pinDisplacement)
	p8 = gui.stamp()
	# Ninth pin:
	gui.forward(pinDisplacement)
	p9 = gui.stamp()
	# Tenth pin:
	gui.forward(pinDisplacement)
	p10 = gui.stamp()

	# Stamp IDs; please refer to console for this information:
	stampInformation = [p1, p2, p3, p4, p5, p6, p7, p8, p9, p10]
	print("Pin Stamp IDs: ", stampInformation)
	print("Stamp IDs may be different depending on computer configuration.")
	print("Please copy and paste values per 'Pin Stamp IDs' line in to stampReference function if pins aren't toppling.")

def initalizeShape():
	# Shape preferences:
	gui.shape("circle")
	gui.shapesize(1, 1)
	gui.color("black")

	# Create a temporary stamp to assign proceding stamps the shape of a circle:
	tStamp = gui.stamp()
	gui.clearstamp(tStamp)

def drawGame(frame):
	# Set Window and Turtle preferences.
	preferenceBoilerplate()

	# Draw the current bowler's frame.
	drawFrame(frame)

	# Initiate the stamp shape.
	initalizeShape()
	gui.goto(250, 300)

	# Draw the pins.
	drawPins()

def stampReference(frameReference):
	# All stamp IDs per frame refresh:
	if frameReference == 0:
		frame = [10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
	elif frameReference == 1:
		frame = [25, 26, 27, 28, 29, 30, 31, 32, 33, 34]
	elif frameReference == 2:
		frame = [40, 41, 42, 43, 44, 45, 46, 47, 48, 49]
	elif frameReference == 3:
		frame = [55, 56, 57, 58, 59, 60, 61, 62, 63, 64]
	elif frameReference == 4:
		frame = [70, 71, 72, 73, 74, 75, 76, 77, 78, 79]
	elif frameReference == 5:
		frame = [85, 86, 87, 88, 89, 90, 91, 92, 93, 94]
	elif frameReference == 6:
		frame = [100, 101, 102, 103, 104, 105, 106, 107, 108, 109]
	elif frameReference == 7:
		frame = [115, 116, 117, 118, 119, 120, 121, 122, 123, 124]
	elif frameReference == 8:
		frame = [130, 131, 132, 133, 134, 135, 136, 137, 138, 139]
	elif frameReference == 9:
		frame = [145, 146, 147, 148, 149, 150, 151, 152, 153, 154]
	else:
		frame = [160, 161, 162, 163, 164, 165, 166, 167, 168, 169]

	return frame

def userInputCall(toppledStamps):
	userInput = gui.textinput("Bowling Simulator", "Enter # of pins (null for random): ")

	if userInput == "":
		toppledPins = r.randint(0, 10 - toppledStamps)
		return toppledPins
	elif int(userInput) <= 10 and int(userInput) >= 0 and int(userInput) <= (10 - toppledStamps):
		toppledPins = int(userInput)
		return toppledPins
	elif int(userInput) > (10 - toppledStamps):
		toppledPins = 10 - toppledStamps
		return int(toppledPins)
	else:
		print("Please enter a valid number or null character")

def playGame():
	# Frame variable initialization:
	rollList = []
	inputList = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

	# Parent for-loop runs the total amount of frames in a bowling game:
	for frame in range(10):
		# Subframe initalization:
		gui.clear()
		drawGame(frame)
		frameReference = stampReference(frame)

		# Variable reset:
		toppledStamps = 0
		pinIterator = 0

		# User-input call:
		userInput = userInputCall(toppledStamps)

		# Child for-loop (sub-frames) runs a total of 1-2 rolls per frame
		# depending on the roller's score:
		for subFrame in range(2):
			# Special Condition for index 0:
			if frame == 0:
				# Strike Condition -- Bypass subframe 1:
				if int(userInput) == 10 and subFrame == 0:
					toppledPins = int(userInput)
					while toppledStamps < toppledPins:
						r.shuffle(frameReference)
						gui.clearstamp(frameReference[0])
						del(frameReference[0])
						time.sleep(0.1)
						toppledStamps += 1
					frameResult = "Strike"
					drawResult(frameResult)

					rollList.append(10)
					rollList.append(0)
					print("Roll List as of frame ",frame + 1, ": ", rollList)
				# Non-Strike Condition - SubFrame 0:
				elif int(userInput) < 10 and subFrame == 0:
					if int(userInput) >= 0 and int(userInput) <= 10:
						toppledPins = userInput
					while toppledStamps < toppledPins:
						r.shuffle(frameReference)
						gui.clearstamp(frameReference[0])
						del(frameReference[0])
						time.sleep(0.1)
						toppledStamps += 1
					rollList.append(toppledPins)
					print("Roll List as of frame ",frame + 1, ": ", rollList)
					# Get User Input for SubFrame 1:
					toppledPins += userInputCall(toppledStamps)
					rollList.append(toppledPins - toppledStamps)
					# SubFrame 2:
					while toppledStamps < toppledPins:
						r.shuffle(frameReference)
						gui.clearstamp(frameReference[0])
						del(frameReference[0])
						time.sleep(0.1)
						toppledStamps += 1
					print("Roll List as of frame ",frame + 1, ": ", rollList)
					# Draw Frame Result:
					if toppledPins == 10:
						frameResult = "Spare"
						drawResult(frameResult)
					else:
						frameResult = "Open Frame"
						drawResult(frameResult)
				time.sleep(0.5)
			elif frame > 0 and frame < 9:
				if int(userInput) == 10 and subFrame == 0:
					toppledPins = int(userInput)
					while toppledStamps < toppledPins:
						r.shuffle(frameReference)
						gui.clearstamp(frameReference[0])
						del(frameReference[0])
						time.sleep(0.1)
						toppledStamps += 1
					frameResult = "Strike"
					drawResult(frameResult)

					rollList.append(10)
					rollList.append(0)
					print("Roll List as of frame ",frame + 1, ": ", rollList)
				elif frame != 0 and int(userInput) != 10 and subFrame == 0:
					if int(userInput) >= 0 and int(userInput) <= 10:
						toppledPins = userInput
					while toppledStamps < toppledPins:
						r.shuffle(frameReference)
						gui.clearstamp(frameReference[0])
						del(frameReference[0])
						time.sleep(0.1)
						toppledStamps += 1
					rollList.append(toppledPins)
					print("Roll List as of frame ",frame + 1, ": ", rollList)

					toppledPins += userInputCall(toppledStamps)
					rollList.append(toppledPins - toppledStamps)

					while toppledStamps < toppledPins:
						r.shuffle(frameReference)
						gui.clearstamp(frameReference[0])
						del(frameReference[0])
						time.sleep(0.1)
						toppledStamps += 1
					print("Roll List as of frame ",frame + 1, ": ", rollList)

					if toppledPins == 10:
						frameResult = "Spare"
						drawResult(frameResult)
					else:
						frameResult = "Open Frame"
						drawResult(frameResult)
				time.sleep(0.5)
			elif frame == 9:
				if int(userInput) == 10 and subFrame == 0:
					toppledPins = int(userInput)
					while toppledStamps < toppledPins:
						r.shuffle(frameReference)
						gui.clearstamp(frameReference[0])
						del(frameReference[0])
						time.sleep(0.1)
						toppledStamps += 1
					frameResult = "Strike"
					drawResult(frameResult)

					rollList.append(10)
					rollList.append(0)
					print("Roll List as of frame ",frame + 1, ": ", rollList)
					time.sleep(0.5)
				elif frame != 0 and int(userInput) != 10 and subFrame == 0:
					if int(userInput) >= 0 and int(userInput) <= 10:
						toppledPins = userInput
					while toppledStamps < toppledPins:
						r.shuffle(frameReference)
						gui.clearstamp(frameReference[0])
						del(frameReference[0])
						time.sleep(0.1)
						toppledStamps += 1
					rollList.append(toppledPins)
					print("Roll List as of frame ",frame + 1, ": ", rollList)

					toppledPins += userInputCall(toppledStamps)
					rollList.append(toppledPins - toppledStamps)

					while toppledStamps < toppledPins:
						r.shuffle(frameReference)
						gui.clearstamp(frameReference[0])
						del(frameReference[0])
						time.sleep(0.1)
						toppledStamps += 1
					if toppledPins == 10:
						frameResult = "Spare"
						drawResult(frameResult)
					else:
						frameResult = "Open Frame"
						drawResult(frameResult)
					time.sleep(0.5)
					print("Roll List as of frame ",frame + 1, ": ", rollList)
				if rollList[18] + rollList[19] == 10 and len(rollList) < 21:
					gui.clear()
					drawGame(frame)
					frameReference = stampReference(frame+1)
					toppledStamps = 0
					pinIterator = 0
					rollList.append("")
					toppledPins = userInputCall(toppledStamps)
					while toppledStamps < toppledPins:
						r.shuffle(frameReference)
						gui.clearstamp(frameReference[0])
						del(frameReference[0])
						time.sleep(0.1)
						toppledStamps += 1
					rollList[-1] = toppledStamps
					if toppledPins == 10:
						frameResult = "Strike"
						drawResult(frameResult)
					else:
						frameResult = "Open Frame"
						drawResult(frameResult)
					print("Roll List as of frame ",frame + 1, ": ", rollList)
				time.sleep(0.5)

	userFinalScore = finalScore(rollList)

	gui.goto(230, 150)
	gui.write("Final Score: ", move = False, align = "center", font = ("Arial", 36, "normal"))
	gui.goto(320, 150)
	gui.write(userFinalScore, move = False, align = "center", font = ("Arial", 36, "normal"))

	gui.exitonclick()

def finalScore(pinlist):

	userFinalScore = 0
	frameList = []

	# This loop appends the sum of the two subframes
	# per frame into single frame indices.
	for i in range(0, len(pinlist), 2):
		# Special condition for the first index:
		if i == 0:
			if pinlist[0] == 10:
				frameList.append(pinlist[0])
			else:
				frameList.append(pinlist[0] + pinlist[1])
		# Special Condition for the last index if the last frame resulted in a
		# Strike:
		elif pinlist[-1] == 10 and len(pinlist) == 21 and pinlist[i] == 10:
			frameList.append(pinlist[-1])
		# Special Condition for the last index if the last frame resulted in a
		# Spare:
		elif pinlist[-3] + pinlist[-2] == 10 and len(pinlist) == 21 and i == 20:
			frameList.append(pinlist[-1])
		# Baseline condition:
		else:
			frameList.append(pinlist[i] + pinlist[i+1])

	unadjustedFrameList = frameList

	# Apply the bowling rules:
	for i in range(1, len(frameList)):
		# If a spare or strike was rolled in the 10th frame:
		if i == 10:
			if frameList[i] == 10:
				frameList[9] += frameList[i] + 10
				del frameList[10]
			elif frameList[i] > 0 and frameList[i] < 10:
				frameList[9] += frameList[10]
				del frameList[10]
		# Strike, base condition:
		elif frameList[i-1] == 10 and frameList[i] != 10 and pinlist[(i*2)-1] == 0 and pinlist[(i*2)-2] == 10:
			# frameList[i-1] += frameList[i]
			frameList[i-1] += frameList[i]
		# Special condition for repeated strikes in a row:
		elif frameList[i-1] == 10 and frameList[i] == 10 and pinlist[(i*2)] == 10 and pinlist[(i*2)-2] == 10:
			frameList[i-1] += frameList[i] + pinlist[(i*2)+2]
		# Spare Baseline:
		elif frameList[i-1] == 10 and pinlist[(i*2)-2] != 10:
			frameList[i-1] += pinlist[(i*2)]
		# Special Condition for repeated spares:
		elif frameList[i-1] == 10 and frameList[i] == 10 and pinlist[(i*2)] < 10 and pinlist[(i*2)] > 0:
			frameList[i-1] += frameList[i]
		# Open
		else:
			frameList[i-1] = frameList[i-1]

	for i in range(0, len(frameList)):
		userFinalScore += frameList[i]

	return userFinalScore

def main(args):
	# Initiate the game of bolwing simulator:
	playGame()

if __name__ == '__main__':
    import sys
    sys.exit(main(sys.argv))
