import RPi.GPIO as GPIO
from time import sleep

GPIO.setmode(GPIO.BCM)
GPIO.setup(4,GPIO.IN)


while True:
    sensor = GPIO.input(4)
    if sensor ==1:
        print("Parking Slot Available")
        sleep(1)

    elif sensor ==0:
        print("Parking Slot filled")
		sleep(1)