import RPi.GPIO as GPIO
from time import sleep
import time

DIR = 20   # Direction GPIO Pin
STEP = 21  # Step GPIO Pin
CW = 1     # Clockwise Rotation
CCW = 0    # Counterclockwise Rotation
SPR = 100  # Steps per Revolution (360 / 7.5)

GPIO.setmode(GPIO.BCM)
GPIO.setup(4,GPIO.IN)
GPIO.setup(10,GPIO.IN)
GPIO.setup(DIR, GPIO.OUT)
GPIO.setup(STEP, GPIO.OUT)
GPIO.output(DIR, CW)

MODE = (14, 15, 18)   # Microstep Resolution GPIO Pins
GPIO.setup(MODE, GPIO.OUT)
RESOLUTION = {'Full': (0, 0, 0),
			  'Half': (1, 0, 0),
              '1/4': (0, 1, 0),
              '1/8': (1, 1, 0),
              '1/16': (0, 0, 1),
              '1/32': (1, 0, 1)}
GPIO.output(MODE, RESOLUTION['1/16'])

while True:
			sensor = GPIO.input(4)
			sensor1 = GPIO.input(10)
			if (sensor ==0) or (sensor1==0):
				print("car is here")
				step_count = SPR * 8
				delay = .0208 / 8
				#step_count = SP
				#delay = .0208
				print("FORWARD")
				GPIO.output(DIR, CW)
				for x in range(step_count):
					GPIO.output(STEP, GPIO.HIGH)
					sleep(delay)
					
					GPIO.output(STEP, GPIO.LOW)
					sleep(delay)
				print("REVERSE")
				sleep(4)
				GPIO.output(DIR, CCW)
				
				for x in range(step_count):
					GPIO.output(STEP, GPIO.HIGH)
					sleep(delay)
					
					GPIO.output(STEP, GPIO.LOW)
					sleep(delay)
				print("DONE")
				
				sleep(1)

			elif (sensor ==1) or (sensor1 == 1):
				print("no car")
				sleep(1)
		

			



