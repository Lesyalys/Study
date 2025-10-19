#include <iostream>
#include <string>
#include "Lesson.h"
#include "LabWork.h"
#include "Lecture.h"
using namespace std;

int main()
{
    cout << "=== LABORATORY WORK 3: INHERITANCE DEMONSTRATION ===" << endl;

    cout << "\n--- Step 6: Creating objects of different classes ---" << endl;

    cout << "\n1. Creating base class object:" << endl;
    Lesson lesson1("Mathematics", "Monday", "09:00");
    lesson1.display();

    cout << "\n2. Creating LabWork object:" << endl;
    LabWork lab1("Physics Lab", "Tuesday", "10:00", "Optics", "Laser, Lenses", 90);
    lab1.display();

    cout << "\n3. Creating Lecture object:" << endl;
    Lecture lecture1("Computer Science", "Wednesday", "11:00", "Dr. Smith", "Algorithms", true);
    lecture1.display();

    // Массив указателей на базовый класс
    cout << "\n--- Step 7-8: Array of base class pointers ---" << endl;
    Lesson *lessons[5];

    lessons[0] = new Lesson("Chemistry", "Thursday", "14:00");
    lessons[1] = new LabWork("Biology Lab", "Friday", "15:00", "Microbiology", "Microscope", 120);
    lessons[2] = new Lecture("History", "Monday", "16:00", "Prof. Johnson", "Ancient Rome", false);
    lessons[3] = new LabWork("Programming Lab", "Tuesday", "13:00", "OOP", "Computers", 90);
    lessons[4] = new Lecture("Economics", "Wednesday", "10:00", "Dr. Brown", "Macroeconomics", true);

    cout << "\nDisplaying all lessons from base class array:" << endl;
    cout << "=============================================" << endl;
    for (int i = 0; i < 5; i++)
    {
        cout << i + 1 << ". ";
        lessons[i]->display();
    }

    // Массив объектов класса-наследника
    cout << "\n--- Step 9-10: Array of LabWork objects ---" << endl;
    LabWork labArray[3];

    // Инициализация массива лабораторных работ
    labArray[0] = LabWork("Chemistry Lab", "Monday", "09:00", "Organic", "Test Tubes", 60);
    labArray[1] = LabWork("Physics Lab", "Tuesday", "11:00", "Mechanics", "Pendulum", 90);
    labArray[2] = LabWork("Biology Lab", "Wednesday", "14:00", "Genetics", "Microscope", 120);

    cout << "\nDisplaying all lab works from LabWork array:" << endl;
    cout << "============================================" << endl;
    for (int i = 0; i < 3; i++)
    {
        cout << i + 1 << ". ";
        labArray[i].display();
    }

    cout << "\n--- Cleaning up memory ---" << endl;
    for (int i = 0; i < 5; i++)
    {
        delete lessons[i];
    }

    cout << "\n=== PROGRAM END ===" << endl;
    return 0;
}