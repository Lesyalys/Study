#pragma once
#include "Lesson.h"

class LabWork : public Lesson
{
private:
    string labTopic;
    string equipment;
    int duration; // в минутах

public:
    LabWork();
    LabWork(string name, string day, string time, string topic, string equipment, int duration);
    LabWork(const LabWork &other);

    ~LabWork();

    string getLabTopic() const;
    string getEquipment() const;
    int getDuration() const;

    void setLabTopic(string topic);
    void setEquipment(string equipment);
    void setDuration(int duration);

    // Переопределенные методы
    void input() override;
    void display() const override;
};