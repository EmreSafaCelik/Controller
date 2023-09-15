# Hand Gesture Volume Controller for Android

Welcome to the Hand Gesture Volume Controller project! This Android app leverages the power of MediaPipe to allow you to control the volume of your device using simple hand gestures captured through the camera. 

## Story

The inception of this project came from a personal challenge I faced. When I had just learned to drive, I found it quite distracting and even unsafe to take my phone in hand to adjust the volume while driving. To make matters worse, the volume controller in my car was broken, rendering it unusable. I realized there had to be a safer and more intuitive way to control the volume without creating a distraction. Hence, the idea for this app was born.

## Features

### Gesture-Based Volume Control

The primary feature of this app is the gesture-based volume control, which operates by measuring the distance between your thumb and index finger. Spread your fingers to increase the volume and bring them closer to reduce the volume. This intuitive gesture ensures that you can easily control the volume without looking at the device.

### Lock and Unlock Volume Adjuster

During the development phase, I noticed a challenge; the camera would sometimes misinterpret natural gestures (like scratching my head or rubbing my nose) as attempts to adjust the volume. To mitigate this, I introduced a locking mechanism for the volume adjuster. 

To lock the volume adjuster, bring the tip of your pinky finger close to the tip of your middle finger. To unlock it, simply separate these two fingers. This feature ensures that the volume adjuster only responds to deliberate gestures, avoiding unintentional volume changes.