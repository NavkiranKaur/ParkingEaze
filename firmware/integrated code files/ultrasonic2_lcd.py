import lcddriver
import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BCM)

display = lcddriver.lcd()

TRIG_1 = 23 
ECHO_1 = 24
TRIG_2 = 22
ECHO_2 = 27

print ("Welcome!!")
display.lcd_display_string("Welcome to ", 1)
display.lcd_display_string("ParkingEaze", 2)
time.sleep(2)
#display.lcd_display_string("Parking slots", 1)
#display.lcd_display_string("Available :2", 2)
#time.sleep(2)
display.lcd_clear()
GPIO.setup(TRIG_1,GPIO.OUT)
GPIO.setup(ECHO_1,GPIO.IN)
GPIO.setup(TRIG_2,GPIO.OUT)
GPIO.setup(ECHO_2,GPIO.IN)
avgDistance_1=0
avgDistance_2=0
vacant = ['A','B']

try:
    while True:

        GPIO.output(TRIG_1, False)
        print ("Measuring Distance")
	       
        time.sleep(2)

        GPIO.output(TRIG_1, True)
        time.sleep(0.00001)
        GPIO.output(TRIG_1, False)

        while GPIO.input(ECHO_1)==0:
          pulse_start = time.time()

        while GPIO.input(ECHO_1)==1:
          pulse_end = time.time()

        pulse_duration = pulse_end - pulse_start

        distance_1 = pulse_duration * 17150

        distance_1 = round(distance_1, 2)
        
        avgDistance_1=avgDistance_1+distance_1
		
        avgDistance_1=avgDistance_1/5
		 
 #       if avgDistance_1 < 5:
 #           display.lcd_display_string("Car is at A ", 1)
			
  #      else:
   #         display.lcd_display_string("Car is not A ", 1)
			
#for ultrasonic sensor 2	
        GPIO.output(TRIG_2, False)
 #       print ("Measuring Distance")
	       
        time.sleep(2)

        GPIO.output(TRIG_2, True)
        time.sleep(0.00001)
        GPIO.output(TRIG_2, False)

        while GPIO.input(ECHO_2)==0:
          pulse_start = time.time()

        while GPIO.input(ECHO_2)==1:
          pulse_end = time.time()

        pulse_duration = pulse_end - pulse_start

        distance_2 = pulse_duration * 17150

        distance_2 = round(distance_2, 2)
        
        avgDistance_2=avgDistance_2+distance_2
		
        avgDistance_2=avgDistance_2/5
		 
        if (avgDistance_1 < 5) and (avgDistance_2 < 5):
            display.lcd_display_string("Available 0 ", 1)
            time.sleep(2)
            display.lcd_clear()
            display.lcd_display_string("Welcome to ", 1)
            display.lcd_display_string("ParkingEaze", 2)
            time.sleep(2)
            display.lcd_clear()
			
        elif (avgDistance_1 < 5) and (avgDistance_2 > 5):
            display.lcd_display_string("Available 1", 1)
            time.sleep(2)
            display.lcd_clear()
            display.lcd_display_string("Welcome to ", 1)
            display.lcd_display_string("ParkingEaze", 2)
            time.sleep(2)
            display.lcd_clear()
        
        elif (avgDistance_1> 5) and (avgDistance_2 <5):
            display.lcd_display_string("Available 1 ", 1)
            time.sleep(2)
            display.lcd_clear()
            display.lcd_display_string("Welcome to ", 1)
            display.lcd_display_string("ParkingEaze", 2)
            time.sleep(2)
            display.lcd_clear()
            
        else:
            display.lcd_display_string("Available 2", 1)
            time.sleep(2)
            display.lcd_clear()
            display.lcd_display_string("Welcome to ", 1)
            display.lcd_display_string("ParkingEaze", 2)
            time.sleep(2)
            display.lcd_clear()

        #result = str(distance)+" cm"

#	display.lcd_disaply_string("Car has come", 2)
 #       display.lcd_display_string(result,2);

except KeyboardInterrupt: # If there is a KeyboardInterrupt (when you press ctrl+c), exit the program and cleanup
    print("Cleaning up!")
    GPIO.cleanup()
        
