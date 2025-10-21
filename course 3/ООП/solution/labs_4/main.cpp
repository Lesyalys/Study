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
    Zanyatie *arr[10];

public:
    Raspisanie()
    {
        for (int i = 0; i < 10; i++)
        {
            arr[i] = nullptr;
        }
    }
    void set(int i, Zanyatie *z) { arr[i] = z; }
    void show()
    {
        for (int i = 0; i < 10; i++)
            if (arr[i] != nullptr)
                arr[i]->print();
    }
};

int main()
{
    int count;
    cout << "Enter count Lecture and LabWork lines: (max 10) ";
    cin >> count;
    if (count > 10)
    {
        cout << "\nNo more 10 plese!";
        return 0;
    }
    Raspisanie r;

    for (int i = 0; i < count; i++)
    {
        Lecture *lecture = new Lecture("Math " + to_string(i + 1), "Mon", "09:00", "Calculus " + to_string(i + 1));
        r.set(i + 1, lecture);
        lecture->print();

        LabWork *lab = new LabWork("Physics Lab " + to_string(i + 1), "Wed", "14:00", "Scope " + to_string(i + 1));
        r.set(i + 1, lab);
        lab->print();
    }
    // r.show();
    // delete l1;
    // delete lw1;
}
