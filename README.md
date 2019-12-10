# ParkingEaze Project
## Build instructions
## Bipolar Stepper motor driven by Drv8825 driver on the raspberry pi broadcom platform
<img src="https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/build1img.jpg" width="500" height="500">

## Purpose
The ParkingEaze Capstone Project : The stepper motor will be able to move the barriers in the car parking in order to allow the entrance and exit of the vehicle using the rotational movement controlled by the driver and raspberry pi Broadcom.
## Table of Contents
1. [Introduction](#introduction)
2. [System Diagram](#system-Diagram)
3. [Materials](#materials)
4. [Budget](#budget)
5. [Time Commitment](#time-Commitment)
6. [Setting up Raspberry Pi](#setting-Up-Raspberry-Pi)
7. [Mechanical Assembly](#mechanical-Assembly)
8. [PCB Soldering](#pcb-Soldering)
9. [PCB Power up](#pcb-power-up)
10. [Unit Testing](#unit-Testing)
11. [Enclosure](#enclosure)
12. [Production Testing](#production-Testing)


##  Introduction
In this project,bipolar stepper motor that is Nema 17 is driven by the DRV8825 driver on the raspberry pi development platform.Here are the build instructions that demonstrates how to control bi-polar stepper motors on a Raspberry Pi in Python using a DRV-8825 stepper motor driver.

## System Diagram 
![systemdiagram](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/sysDiagram.PNG)

## Materials
- Raspberry Pi 3B+ 
- [Hdmi cable](https://www.amazon.ca/gp/product/B07BN874RP/ref=ppx_yo_dt_b_asin_title_o02_s00?ie=UTF8&psc=1)
- [Bipolar steper motor Nema 17](https://www.amazon.ca/gp/product/B07C1MVTZC/ref=ppx_yo_dt_b_asin_title_o08_s00?ie=UTF8&psc=1)
- [Drv8825 driver](https://www.amazon.ca/gp/product/B07L2TKLPW/ref=ppx_yo_dt_b_asin_title_o08_s00?ie=UTF8&psc=1)
- [12 Voltage dc power supply portable adapt3r](https://www.amazon.ca/gp/product/B06X1BJRCS/ref=ppx_yo_dt_b_asin_title_o06_s00?ie=UTF8&psc=1)
- power supply of the pi,mouse and keyboard
- 100 microFarad capacitor
- Breadboard and jumper wires (male and female)
- 40 pin male double row male to female header, 
- two 8 pins male to female headers and one 4 pin header ( all single row)
- Acrylic case for the enclosure 
- Get my Corel Draw file by clicking [here](https://github.com/NavkiranKaur/ParkingEaze/blob/master/mechanical/EnclosureFinal.cdr) for the enclosure
- 3d printed motor parts 
- Click [Here](https://github.com/NavkiranKaur/ParkingEaze/tree/master/mechanical/Nema%2017%20motor%203D%20printing%20files) to get my 3D printing files for the motor enclosure
-I suggest you to have them earlier so you could save your time instead of making them at the last end.

## Budget
- The main stuff and the materials required to build the project are listed below
The equipments that I have used from my parts kit are Jumper wires(both male and female),screw driver ,100 microFarad capacitor.I listed them here as in my budget my parts kit is mentioned,not the specific parts that I used.All the parts are bought from amazon except the parts that I already owned and the mouse,keyboard combo that is bought from Walmart.
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/CaptureBudget1.PNG)
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/Captureb2.PNG)

## Time commitment
- Overall project can be done in couple of days depends on the getting pcb made,alongwith making an enclosure for the equipments once they are built and connected.Also,depends upon the arrival of the materials for building hardware project.
In my case,I got delay in my breadboard due to not setting current voltage specifications on the driver,also made the pcb second time and also spent more time on the enclosure as it was 3D printing for the motor and my case was also big consisiting of pcb on the pi with the driver on it.So,if to be explained in more depth by knowing and being prepared what to do ,it can save much time.Breadboard can take 1 or 2 hours as to set all the voltages and making connections and based on that getting the pcb ready.Powering up take about 20 minutes and then getting the parts enclosed.

## Setting up raspberry pi
Connecting the raspberry with power supply,hdmi cable from raspberry pi to the hdmi to vga cable and that vga side to the monitor.Connecting the separate mouse and the keyboard with the pi.
Following the steps below:
1. Download [Raspbian](https://www.raspberrypi.org/downloads/) to be installed on your raspberry pi.
2. Use [SDCardFormatter](https://www.sdcard.org/downloads/formatter_4/) to format your SD card so for getting the pi to work
3. Inserting the SD card in raspberry pi and ensuring the connection all the above mentioned parts to be connected appropriately.
4. Switch on the power and finish the further setup including changing the settings.
5. Giving the commands on the terminal that require insallation like sudo updates etc,

## Mechanical Assembly
For the mechanical assembly,ensure connecting the pins and connections carefully.
Firstly the connections were made on the breadboard using the jumper wires from the driver ,raspberry pi ,stepper motor and the capacitor.I made the connections from driver to the raspberry pi ,motor and the capacitor and also used the power supply of the college. Breadboarding is just to make sure if the effectors and the components works as expected or their is a need to change some connections or if there is a damaged component.

## Wiring connections
-Raspberry pi pin 3v : DRV8825 SLEEP,DRV8825 RESET 
- Where connecting the sleep and reset together whereas connecting pi to the one of them
- Raspberry pi pin GND : DRV8825 GND1
- Raspberry pi pin GPIO21 : DRV8825 STEP
- Raspberry pi pin GPIO20 : DRV8825 DIRECTION
- Raspberry pi pin GPIO14 : DRV8825 MS1
- Raspberry pi pin GPIO15 : DRV8825 MS2
- Raspberry pi pin GPIO18 : DRV8825 MS3

ALSO IN DRV8825
-DRV8825 GROUND 1 TO BE CONNECTED WITH GROUND2 of DRV8825 itself
-In order to bind the motor wire pins with the drv8825
- Motor has two coil pairs Coil pair 1 ,coil pair 2
- Coil pair 1 includes A and C
- Coil pair 2 includes B and D
- MOTOR A WIRE PIN : DRV8825 OUT 2B
- MOTOR C WIRE  PIN: DRV8825 OUT 2A
- MOTOR B WIRE PIN : DRV8825  OUT 1A
- MOTOR D WIRE  PIN: DRV8825  OUT 1B

- MOTOR POWER SUPPLY ADAPTOR OF 12 V
- Capacitor (positive side) : DRV8825 VOLTAGE PIN : POWER SUPPLY POSITIVE (12V)
- Capacitor(negative side): DRV8825 GROUND: POWER SUPPLY GROUND

- Pin can be connected vice versa but make sure coil pair pins goes with the pair on the driver ,not interchanging if connecting a pair both pins to be connected to other driver pair itself. Don’t connect the pin in the pairs differently.

This [tutorial](https://www.rototron.info/raspberry-pi-stepper-motor-tutorial/) can also help you in depth with the required specifications.

--My breadboard design in the fritzing
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/breadboard_final.png)
<!--![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/bread2.jpg)
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/bread3.jpg) -->

- Also you need the code to run it,that i will be describing in the later steps below.

## PCB Soldering
The pcb is designed as followed by connections made and tested using the breadboard.
The pcb design is shown below designed in fritzing
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/pcb_final.png)
The pcb is made and then after it is soldered carefully
- Remember in my pcb design I put my drv8825 ground to ground connection on differnt side layer(yellow) than the soldering connecting pins (which are in orange).Make sure to keep it as same layer as other drv8825 connections.Hence ,you can see in my pcb ,i coonected an insulated red colour wire on same side where other drv8825 wires are connnected to pins.
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/IMG-1160.jpg)
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/IMG-1159.jpg)
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/IMG-1161.jpg)

## PCB Power up
- Firstly make sure any of the pcb wire is not shorted.
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/overload.jpg)

- pcb powering up 
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/motorworkpcb.jpg)
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/blogm.jpg)

The movement of my motor can be seen [here](https://github.com/NavkiranKaur/ParkingEaze/blob/master/images/IMG-0766.mov)

## Unit Testing
This is the code that i have used to run my motor in the python.
```
from time import sleep
import RPi.GPIO as GPIO

DIR = 20   # Direction GPIO Pin
STEP = 21  # Step GPIO Pin
CW = 1     # Clockwise Rotation
CCW = 0    # Counterclockwise Rotation
SPR = 100  # Steps per Revolution (360 / 7.5)

GPIO.setmode(GPIO.BCM)
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
GPIO.output(MODE, RESOLUTION['1/8'])

step_count = SPR * 32
delay = .0208 / 32
#step_count = SPR
#delay = .0208
print("FORWARD")
for x in range(step_count):
    GPIO.output(STEP, GPIO.HIGH)
    sleep(delay)
    GPIO.output(STEP, GPIO.LOW)
    sleep(delay)
print("REVERSE")
sleep(.5)
GPIO.output(DIR, CCW)
for x in range(step_count):
    GPIO.output(STEP, GPIO.HIGH)
    sleep(delay)
    GPIO.output(STEP, GPIO.LOW)
    sleep(delay)
print("DONE")
GPIO.cleanup()
```

- Getting the outputs that enable rotation of the motor
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/codeRun.jpg)
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/outputTerminal.png)

## Enclosure
- I got an acrylic white case enclosure that encloses my raspberry pi,driver drv8825 and the pcb 
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/enclosure1.jpg)

- For my motor ,i got my parts as made with 3D printing.
- Click [Here](https://www.thingiverse.com/thing:3753538) to get the website for more information to design the motor 
- I got my 3D printed parts for motor from the humber college itself 

![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/motor3.jpg)
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/motor2.jpg)

## Production Testing
It is a crucial step to ensure that the parts work correctly and perform the required functions that are neccesary to executing the building hardware.In my project,the key thing to specify the voltage on the driver and limiting the current on it .Without doing it,the motor is not able to rotate which is the main requirement from the hardware production.
- Remember during the wires connection,make sure the voltage is not on,do not remove or plug in any wire while the power supply is plugged in.





