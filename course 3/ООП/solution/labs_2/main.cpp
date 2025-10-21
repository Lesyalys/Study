#include <iostream>
#include <string>
using namespace std;

class Zanyatie
{
    string name;
    string day;
    string time;

public:
    Zanyatie() : name("NoName"), day("NoDay"), time("00:00") { cout << "Zanyatie: default ctor\n"; }
    Zanyatie(const string &n, const string &d, const string &t) : name(n), day(d), time(t) { cout << "Zanyatie: param ctor\n"; }
    Zanyatie(const Zanyatie &other) : name(other.name), day(other.day), time(other.time) { cout << "Zanyatie: copy ctor\n"; }
    ~Zanyatie() { cout << "Zanyatie: dtor for " << name << "\n"; }
    void print() const { cout << name << " " << day << " " << time << "\n"; }
};

class Raspisanie
{
    string num;
    string addr;
    Zanyatie arr[3];
    int count;

public:
    Raspisanie() : num("0"), addr("NoAddr"), count(0) { cout << "Raspisanie: default ctor\n"; }
    Raspisanie(const string &n, const string &a) : num(n), addr(a), count(0) { cout << "Raspisanie: param ctor\n"; }
    Raspisanie(const Raspisanie &r) : num(r.num), addr(r.addr), count(r.count)
    {
        for (int i = 0; i < count; i++)
            arr[i] = r.arr[i];
        cout << "Raspisanie: copy ctor\n";
    }
    ~Raspisanie() { cout << "Raspisanie: dtor\n"; }
    void addByParams(const string &n, const string &d, const string &t)
    {
        if (count < 3)
            arr[count++] = Zanyatie(n, d, t);
    }
    void addCopies(const Zanyatie &z, int k)
    {
        for (int i = 0; i < k && count < 10; i++)
            arr[count++] = Zanyatie(z);
    }
    void print()
    {
        cout << num << ", " << addr << "\n";
        for (int i = 0; i < count; i++)
            arr[i].print();
    }
};

int main()
{
    Raspisanie r("10", "Lenina 1");
    r.addByParams("Programming", "Mon", "10:00");
    Zanyatie lab("Lab work", "Fri", "13:00");
    r.addCopies(lab, 2);
    r.print();
}
