#include "Lesson.h"
#include <iostream>

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

Lesson::Lesson(const Lesson &other)
{
    this->name = other.name;
    this->day = other.day;
    this->time = other.time;
    cout << "Lesson copy constructor called: " << other.name << endl;
}

Lesson::~Lesson()
{
    cout << "Lesson destructor called: " << name << endl;
}

string Lesson::getName()
{
    return name;
}

void Lesson::setName(string name)
{
    this->name = name;
}

string Lesson::getDay()
{
    return day;
}

void Lesson::setDay(string day)
{
    this->day = day;
}

string Lesson::getTime()
{
    return time;
}

void Lesson::setTime(string time)
{
    this->time = time;
}

void Lesson::setProperties()
{
    string str;
    cout << " Lesson name:" << endl;
    getline(cin, str);
    this->setName(str);
    cout << " Day of week:" << endl;
    getline(cin, str);
    this->setDay(str);
    cout << " Time:" << endl;
    getline(cin, str);
    this->setTime(str);
}

void Lesson::setProperties(string str1, string str2, string str3)
{
    this->setName(str1);
    this->setDay(str2);
    this->setTime(str3);
}

void Lesson::display() const
{
    cout << name << " | " << day << " | " << time;
}