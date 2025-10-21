// lab5_static.cpp
#include <iostream>
#include <string>
using namespace std;

class Zanyatie
{
    string name;
    static int objCount;

public:
    Zanyatie(const string &n = "No") : name(n) { ++objCount; }
    Zanyatie(const Zanyatie &z) : name(z.name) { ++objCount; }
    ~Zanyatie() { --objCount; }
    static int getCount() { return objCount; }
    void print() const { cout << name << "\n"; }
};
int Zanyatie::objCount = 0;

class Raspisanie
{
    Zanyatie *arr[10];
    static int arrCount;

public:
    void add(Zanyatie *z) { arr[arrCount++] = z; }
    static int getArrCount() { return arrCount; }
};
int Raspisanie::arrCount = 0;

int main()
{
    cout << "Before: total zanyatiya = " << Zanyatie::getCount() << "\n";
    Zanyatie *a = new Zanyatie("Math");
    Zanyatie b("Physics");
    cout << "After create: total zanyatiya = " << Zanyatie::getCount() << "\n";
    Raspisanie r;
    r.add(a);
    r.add(&b);
    cout << "Objects in raspisanie array: " << Raspisanie::getArrCount() << "\n";
    delete a;
    cout << "After delete: total zanyatiya = " << Zanyatie::getCount() << "\n";
}
