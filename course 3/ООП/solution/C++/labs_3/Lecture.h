#pragma once
#include "Lesson.h"

class Lecture : public Lesson
{
private:
    string lecturer;
    string topic;
    bool hasPresentation;

public:
    Lecture();
    Lecture(string name, string day, string time, string lecturer, string topic, bool hasPresentation);
    Lecture(const Lecture &other);

    ~Lecture();

    string getLecturer() const;
    string getTopic() const;
    bool getHasPresentation() const;

    void setLecturer(string lecturer);
    void setTopic(string topic);
    void setHasPresentation(bool hasPresentation);

    // Переопределенные методы
    void input() override;
    void display() const override;
};