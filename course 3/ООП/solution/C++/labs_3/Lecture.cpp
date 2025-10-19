#include "Lecture.h"

Lecture::Lecture() : Lesson()
{
    lecturer = "Unknown";
    topic = "Unknown";
    hasPresentation = false;
    cout << "Lecture default constructor called" << endl;
}

Lecture::Lecture(string name, string day, string time, string lecturer, string topic, bool hasPresentation)
    : Lesson(name, day, time)
{
    this->lecturer = lecturer;
    this->topic = topic;
    this->hasPresentation = hasPresentation;
    cout << "Lecture parameterized constructor called: " << name << endl;
}

Lecture::Lecture(const Lecture &other) : Lesson(other)
{
    this->lecturer = other.lecturer;
    this->topic = other.topic;
    this->hasPresentation = other.hasPresentation;
    cout << "Lecture copy constructor called: " << other.name << endl;
}

// Деструктор
Lecture::~Lecture()
{
    cout << "Lecture destructor called: " << name << endl;
}

string Lecture::getLecturer() const
{
    return lecturer;
}

string Lecture::getTopic() const
{
    return topic;
}

bool Lecture::getHasPresentation() const
{
    return hasPresentation;
}

void Lecture::setLecturer(string lecturer)
{
    this->lecturer = lecturer;
}

void Lecture::setTopic(string topic)
{
    this->topic = topic;
}

void Lecture::setHasPresentation(bool hasPresentation)
{
    this->hasPresentation = hasPresentation;
}

void Lecture::input()
{
    Lesson::input();
    cout << "Enter lecturer: ";
    getline(cin, lecturer);
    cout << "Enter lecture topic: ";
    getline(cin, topic);
    cout << "Has presentation? (1 - yes, 0 - no): ";
    cin >> hasPresentation;
    cin.ignore();
}

void Lecture::display() const
{
    Lesson::display();
    cout << " | Type: Lecture | Lecturer: " << lecturer
         << " | Topic: " << topic << " | Presentation: " << (hasPresentation ? "Yes" : "No") << endl;
}