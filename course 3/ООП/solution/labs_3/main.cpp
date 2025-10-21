#include <iostream>
#include <string>
using namespace std;

class Zanyatie
{
    string name;
    string day;
    string time;

public:
    Zanyatie() : name("NoName"), day("NoDay"), time("00:00") {}
    Zanyatie(const string &n, const string &d, const string &t) : name(n), day(d), time(t) {}
    virtual ~Zanyatie() {}
    virtual void print() const { cout << name << " | " << day << " | " << time; }
    void setName(const string &n) { name = n; }
    string getName() const { return name; }
};

class LabWork : public Zanyatie
{
    string equipment;

public:
    LabWork() : equipment("None") {}
    LabWork(const string &n, const string &d, const string &t, const string &e) : Zanyatie(n, d, t), equipment(e) {}
    void print() const override
    {
        Zanyatie::print();
        cout << " | Lab equipment: " << equipment << "\n";
    }
};

class Lecture : public Zanyatie
{
    string topic;

public:
    Lecture() : topic("NoTopic") {}
    Lecture(const string &n, const string &d, const string &t, const string &top) : Zanyatie(n, d, t), topic(top) {}
    void print() const override
    {
        Zanyatie::print();
        cout << " | Topic: " << topic << "\n";
    }
};

int main()
{
    Zanyatie base("Generic", "Tue", "11:00");
    LabWork lw("Electronics Lab", "Thu", "15:00", "Oscilloscope");
    Lecture lec("History Lecture", "Mon", "09:00", "WW2");
    Zanyatie *arr[3] = {&base, &lw, &lec};
    for (int i = 0; i < 3; i++)
        arr[i]->print();
    // массив наследников
    LabWork labs[2] = {lw, LabWork("Chem Lab", "Wed", "12:00", "Beakers")};
    for (auto &l : labs)
        l.print();
}
