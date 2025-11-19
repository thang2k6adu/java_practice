#!/bin/bash

echo "Dang bien dich chuong trinh..."

mkdir -p bin

javac -d bin \
    src/exception/*.java \
    src/interfaces/*.java \
    src/model/*.java \
    src/payment/*.java \
    src/repository/*.java \
    src/Main.java

if [ $? -eq 0 ]; then
    echo "Bien dich thanh cong"
    echo ""
    echo "Dang chay chuong trinh..."
    echo ""
    
    java -cp bin src.Main
    
    echo ""
    echo "Hoan thanh"
else
    echo "Bien dich that bai"
    exit 1
fi
