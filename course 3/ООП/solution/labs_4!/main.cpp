// lab4_polymorphism.cpp
#include <iostream>
#include <string>
using namespace std;

class Zanyatie
{
protected:
    string name, day, time;

public:
    Zanyatie(const string &n = "No", const string &d = "No", const string &t = "00:00") : name(n), day(d), time(t) {}
    virtual ~Zanyatie() {}
    virtual void print() const = 0; // чисто виртуальная
};

class LabWork : public Zanyatie
{
    string equipment;

public:
    LabWork(const string &n, const string &d, const string &t, const string &e) : Zanyatie(n, d, t), equipment(e) {}
    void print() const override { cout << "Lab: " << name << " " << day << " " << time << " | Eq: " << equipment << "\n"; }
};

class Lecture : public Zanyatie
{
    string topic;

public:
    Lecture(const string &n, const string &d, const string &t, const string &top) : Zanyatie(n, d, t), topic(top) {}
    void print() const override { cout << "Lecture: " << name << " " << day << " " << time << " | Topic: " << topic << "\n"; }
};

class Raspisanie
{
    Zanyatie *arr[5];

public:
    void set(int i, Zanyatie *z) { arr[i] = z; }
    void show()
    {
        for (int i = 0; i < 5; i++)
            if (arr[i])
                arr[i]->print();
    }
};

int main()
{
    Lecture *l1 = new Lecture("Math", "Mon", "09:00", "Calculus");
    LabWork *lw1 = new LabWork("Physics Lab", "Wed", "14:00", "Scope");
    Raspisanie r;
    r.set(0, l1);
    r.set(1, lw1);
    r.show();
    delete l1;
    delete lw1;
}
