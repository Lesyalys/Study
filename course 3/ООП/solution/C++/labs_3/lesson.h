#pragma once
#include <string>
#include <iostream>
using namespace std;

class Lesson
{
protected:
    string name;
    string day;
    string time;

public:
    Lesson();
    Lesson(string name, string day, string time);
    Lesson(const Lesson &other);

    // Деструктор
    virtual ~Lesson();

    string getName() const;
    string getDay() const;
    string getTime() const;

    void setName(string name);
    void setDay(string day);
    void setTime(string time);

    virtual void input();
    virtual void display() const;
};