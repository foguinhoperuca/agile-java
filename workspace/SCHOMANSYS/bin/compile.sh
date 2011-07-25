#!/bin/bash
javac -classpath "/home/jefferson/universal/projects/lib/junit/junit4.8.2/junit-4.8.2.jarit-4.8.2.jar" *.java
if [$? -eq o]; then
    java -cp ".:/home/jefferson/universal/projects/lib/junit/junit4.8.2/junit-4.8.2.jar" junit.textui.TestRunner StudentTest
fi