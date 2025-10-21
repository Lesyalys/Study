// lab8_exceptions.cpp
#include <iostream>
#include <string>
#include <stdexcept>
using namespace std;

class Zanyatie
{
    string name;
    string time; // simple "HH:MM"
public:
    Zanyatie(const string &n, const string &t) : name(n)
    {
        if (t.size() != 5 || t[2] != ':')
            throw invalid_argument("Invalid time format");
        time = t;
    }
    void print() const { cout << name << " at " << time << "\n"; }
};

int main()
{
    try
    {
        Zanyatie a("Math", "09:00");
        Zanyatie b("Bad", "900"); // вызовет исключение при неверном времени
        a.print();
        b.print();
    }
    catch (const invalid_argument &e)
    {
        cout << "Exception caught: " << e.what() << "\n";
    }
    return 0;
}
