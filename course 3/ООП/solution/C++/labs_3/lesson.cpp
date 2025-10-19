#include "Lesson.h"

Lesson::Lesson()
{
    name = "Unknown";
    day = "Unknown";
    time = "Unknown";
    cout << "Lesson default constructor called" << endl;
}

Lesson::Lesson(string name, string day, string time)
{
    this->name = name;
    this->day = day;
    this->time = time;
    cout << "Lesson parameterized constructor called: " << name << endl;
}

// Конструктор копирования
Lesson::Lesson(const Lesson &other)
{
    this->name = other.name;
    this->day = other.day;
    this->time = other.time;
    cout << "Lesson copy constructor called: " << other.name << endl;
}

// Деструктор
Lesson::~Lesson()
{
    cout << "Lesson destructor called: " << name << endl;
}

string Lesson::getName() const
{
    return name;
}

string Lesson::getDay() const
{
    return day;
}

string Lesson::getTime() const
{
    return time;
}

void Lesson::setName(string name)
{
    this->name = name;
}

void Lesson::setDay(string day)
{
    this->day = day;
}

void Lesson::setTime(string time)
{
    this->time = time;
}

void Lesson::input()
{
    cout << "Enter lesson name: ";
    getline(cin, name);
    cout << "Enter day: ";
    getline(cin, day);
    cout << "Enter time: ";
    getline(cin, time);
}

void Lesson::display() const
{
    cout << "Lesson: " << name << " | Day: " << day << " | Time: " << time;
}