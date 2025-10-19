#include "Schedule.h"
#include <iostream>

Schedule::Schedule()
{
    institutionNumber = "Unknown";
    address = "Unknown";
    capacity = 3;
    size = 0;
    arr = new Lesson[capacity];
    cout << "Schedule default constructor called" << endl;
}

Schedule::Schedule(string number, string address, int capacity)
{
    this->institutionNumber = number;
    this->address = address;
    this->capacity = capacity;
    this->size = 0;
    this->arr = new Lesson[capacity];
    cout << "Schedule parameterized constructor called: " << number << endl;
}

// Конструктор копирования
Schedule::Schedule(const Schedule &other)
{
    this->institutionNumber = other.institutionNumber;
    this->address = other.address;
    this->capacity = other.capacity;
    this->size = other.size;
    this->arr = new Lesson[capacity];
    for (int i = 0; i < size; i++)
    {
        this->arr[i] = other.arr[i];
    }
    cout << "Schedule copy constructor called: " << other.institutionNumber << endl;
}

// Деструктор
Schedule::~Schedule()
{
    delete[] arr;
    cout << "Schedule destructor called: " << institutionNumber << endl;
}

string Schedule::getInstitutionNumber()
{
    return institutionNumber;
}

void Schedule::setInstitutionNumber(string number)
{
    this->institutionNumber = number;
}

string Schedule::getAddress()
{
    return address;
}

void Schedule::setAddress(string address)
{
    this->address = address;
}

void Schedule::setLesson(Lesson lesson, int i)
{
    if (i >= 0 && i < capacity)
    {
        arr[i] = lesson;
        if (i >= size)
            size = i + 1;
    }
}

Lesson Schedule::getLesson(int i)
{
    if (i >= 0 && i < size)
    {
        return arr[i];
    }
    return Lesson();
}

int Schedule::getSize() const
{
    return size;
}

int Schedule::getCapacity() const
{
    return capacity;
}

void Schedule::addLessonWithParams(string name, string day, string time)
{
    if (size < capacity)
    {
        Lesson newLesson(name, day, time);
        arr[size] = newLesson;
        size++;
        cout << "Lesson added via addLessonWithParams: ";
        newLesson.display();
        cout << endl;
    }
    else
    {
        cout << "Schedule is full! Cannot add more lessons." << endl;
    }
}

void Schedule::addCopiedLessons(const Lesson &lesson, int count)
{
    for (int i = 0; i < count && size < capacity; i++)
    {
        Lesson copiedLesson(lesson);
        arr[size] = copiedLesson;
        size++;
    }
    cout << "Added " << count << " copies of lesson: ";
    lesson.display();
    cout << endl;
}

void Schedule::displayAllLessons() const
{
    cout << "Lessons in schedule:" << endl;
    cout << "----------------------------------------" << endl;
    for (int i = 0; i < size; i++)
    {
        cout << i + 1 << ". ";
        arr[i].display();
        cout << endl;
    }
    cout << "----------------------------------------" << endl;
}

void Schedule::resizeArray(int newCapacity)
{
    if (newCapacity > capacity)
    {
        Lesson *newArr = new Lesson[newCapacity];
        for (int i = 0; i < size; i++)
        {
            newArr[i] = arr[i];
        }
        delete[] arr;
        arr = newArr;
        capacity = newCapacity;
    }
}