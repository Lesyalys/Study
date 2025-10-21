// lab13_strategy.cpp
#include <iostream>
#include <string>
#include <vector>
using namespace std;

struct Zanyatie
{
    string name, day, time;
    Zanyatie(string n, string d, string t) : name(n), day(d), time(t) {}
};

struct IPrintStrategy
{
    virtual ~IPrintStrategy() {}
    virtual void print(const Zanyatie &z) const = 0;
};
struct SimplePrint : IPrintStrategy
{
    void print(const Zanyatie &z) const override { cout << z.name << "\n"; }
};
struct FullPrint : IPrintStrategy
{
    void print(const Zanyatie &z) const override { cout << z.name << " | " << z.day << " | " << z.time << "\n"; }
};

class Raspisanie
{
    vector<Zanyatie> v;
    const IPrintStrategy *strategy;

public:
    Raspisanie() : strategy(new FullPrint()) {}
    void setStrategy(const IPrintStrategy *s) { strategy = s; }
    void add(const Zanyatie &z) { v.push_back(z); }
    void show() const
    {
        for (auto &z : v)
            strategy->print(z);
    }
};

int main()
{
    Raspisanie r;
    r.add(Zanyatie("Math", "Mon", "09:00"));
    r.add(Zanyatie("Lab", "Wed", "14:00"));
    cout << "Full:\n";
    r.show();
    SimplePrint sp;
    r.setStrategy(&sp);
    cout << "Simple:\n";
    r.show();
}
