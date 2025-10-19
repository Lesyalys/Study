#include "LabWork.h"

LabWork::LabWork() : Lesson()
{
    labTopic = "Unknown";
    equipment = "Unknown";
    duration = 0;
    cout << "LabWork default constructor called" << endl;
}

LabWork::LabWork(string name, string day, string time, string topic, string equipment, int duration)
    : Lesson(name, day, time)
{
    this->labTopic = topic;
    this->equipment = equipment;
    this->duration = duration;
    cout << "LabWork parameterized constructor called: " << name << endl;
}

// Конструктор копирования
LabWork::LabWork(const LabWork &other) : Lesson(other)
{
    this->labTopic = other.labTopic;
    this->equipment = other.equipment;
    this->duration = other.duration;
    cout << "LabWork copy constructor called: " << other.name << endl;
}

// Деструктор
LabWork::~LabWork()
{
    cout << "LabWork destructor called: " << name << endl;
}

string LabWork::getLabTopic() const
{
    return labTopic;
}

string LabWork::getEquipment() const
{
    return equipment;
}

int LabWork::getDuration() const
{
    return duration;
}

void LabWork::setLabTopic(string topic)
{
    this->labTopic = topic;
}

void LabWork::setEquipment(string equipment)
{
    this->equipment = equipment;
}

void LabWork::setDuration(int duration)
{
    this->duration = duration;
}

void LabWork::input()
{
    Lesson::input();
    cout << "Enter lab topic: ";
    getline(cin, labTopic);
    cout << "Enter equipment: ";
    getline(cin, equipment);
    cout << "Enter duration (minutes): ";
    cin >> duration;
    cin.ignore();
}

void LabWork::display() const
{
    Lesson::display();
    cout << " | Type: Lab Work | Topic: " << labTopic
         << " | Equipment: " << equipment << " | Duration: " << duration << " min" << endl;
}