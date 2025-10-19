#pragma once
#include <string>
#include "Lesson.h"
using namespace std;

class Schedule
{
private:
    string institutionNumber;
    string address;
    Lesson *arr; // Изменяем на указатель для динамического массива
    int capacity;
    int size;

public:
    Schedule();
    Schedule(string number, string address, int capacity = 3); // с параметрами
    Schedule(const Schedule &other);

    ~Schedule();

    string getInstitutionNumber();
    string getAddress();
    Lesson getLesson(int i);
    int getSize() const;
    int getCapacity() const;

    void setInstitutionNumber(string number);
    void setAddress(string address);
    void setLesson(Lesson lesson, int i);

    // Новые методы согласно заданию
    void addLessonWithParams(string name, string day, string time); // п.5
    void addCopiedLessons(const Lesson &lesson, int count);         // п.6

    void displayAllLessons() const;
    void resizeArray(int newCapacity);
};