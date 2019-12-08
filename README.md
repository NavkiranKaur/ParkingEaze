# ParkingEaze Project
## Build instructions
## Bipolar Stepper motor driven by Drv8825 driver on the raspberry pi broadcom platform
<img src="https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/build1img.jpg" width="500" height="500">

## Table of Contents
1. [Introduction](#introduction)
2. [Purpose](#purpose)
3. [System Diagram](#system-Diagram)
4. [Materials](#materials)
5. [Budget](#budget)
6. [Time Commitment](#time-Commitment)
7. [Setting up Raspberry Pi](#setting-Up-Raspberry-Pi)
8. [Hardware Testing](#hardware-Testing)
9. [Mechanical Assembly](#mechanical-Assembly)
10. [PCB Soldering](#pcb-Soldering)
11. [PCB Power up](#pcb-power-up)
12. [Unit Testing](#unit-Testing)
13. [Production Testing](#production-Testing)
14. [Resources](#resources)

##  Introduction
In this project,bipolar stepper motor that is Nema 17 is driven by the DRV8825 driver on the raspberry pi development platform.Here are the build instructions that demonstrates how to control bi-polar stepper motors on a Raspberry Pi in Python using a DRV-8825 stepper motor driver.

## Purpose
The ParkingEaze Capstone Project : The stepper motor will be able to move the barriers in the car parking in order to allow the entrance and exit of the vehicle using the rotational movement controlled by the driver and raspberry pi Broadcom.

## System Diagram 
![systemdiagram](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/sysDiagram.PNG)

## Materials
- Raspberry Pi 3B+,Hdmi cable,power supply of the pi,SD card , mouse and keyboard
- 12 Voltage dc power supply portable adaptor
- Bipolar steper motor Nema 17
- Drv8825 driver
- 100 microFarad capacitor
- Breadboard and jumper wires (male and female)
- 40 pin male double row male to female header, 
- two 8 pins male to female headers and one 4 pin header ( all single row)
- Acrylic case for the enclosure 
- 3d printed motor parts

## Budget
- The main stuff and the materials required to build the project are listed below
The equipments that I have used from my parts kit are Jumper wires(both male and female),screw driver ,100 microFarad capacitor.I listed them here as in my budget my parts kit is mentioned,not the specific parts that I used.
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/CaptureBudget1.PNG)
![capture](https://raw.githubusercontent.com/NavkiranKaur/ParkingEaze/master/images/Captureb2.PNG)

## Time commitment
- Overall project can be done in couple of days depends on the getting pcb made,alongwith making an enclosure for the equipments once they are built and connected.Also,depends upon the arrival of the materials for building hardware project.
In my case,I got delay in my breadboard due to not setting current voltage specifications on the driver,also made the pcb second time and also spent more time on the enclosure as it was 3D printing for the motor and my case was also big consisiting of pcb on the pi with the driver on it.So,if to be explained in more depth by knowing and being prepared what to do ,it can save much time.Breadboard can take 1 or 2 hours as to set all the voltages and making connections and based on that getting the pcb ready.Powering up take about 20 minutes and then getting the parts enclosed.

## Setting up the raspberry pi
Connecting the raspberry with power supply,hdmi cable from raspberry pi to the hdmi to vga cable and that vga side to the monitor.Connecting the separate mouse and the keyboard with the pi.
Following the steps below:
1. Download [Raspbian](https://www.raspberrypi.org/downloads/) to be installed on your raspberry pi.
2. Use [SDCardFormatter](https://www.sdcard.org/downloads/formatter_4/) to format your SD card so for the getting the pi to work
3. Inserting the SD card in raspberry pi and ensuring the connection all the above mentioned parts to be connected appropriately.
4. Switch on the power and finish the further setup including changing the settings.
5. Giving the commands on the terminal that require insallation like sudo updates etc,




