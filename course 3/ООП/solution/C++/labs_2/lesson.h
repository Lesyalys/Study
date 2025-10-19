#pragma once
#include <string>
using namespace std;

class Lesson
{
private:
    string name;
    string day;
    string time;

public:
    Lesson();
    Lesson(string name, string day, string time);
    Lesson(const Lesson &other);

    ~Lesson();

    string getName();
    string getDay();
    string getTime();

    void setName(string name);
    void setDay(string day);
    void setTime(string time);

    void setProperties();
    void setProperties(string str1, string str2, string str3);

    void display() const;
};