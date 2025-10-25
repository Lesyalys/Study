// lab9_io.cpp
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

class Zanyatie
{
    string name, day, time;

public:
    Zanyatie(const string &n = "", const string &d = "", const string &t = "") : name(n), day(d), time(t) {}
    friend ostream &operator<<(ostream &os, const Zanyatie &z)
    // ostream ссылка на выходной поток
    {
        os << z.name << " " << z.day << " " << z.time;
        return os;
    }
    friend istream &operator>>(istream &is, Zanyatie &z)
    {
        is >> z.name >> z.day >> z.time;
        return is;
    }
};

int main()
{
    string n, w, t;
    cout << "Enter study: ";
    getline(cin, n);
    cout << "Enter Week day: ";
    getline(cin, w);
    cout << "Enter time: ";
    getline(cin, t);

    Zanyatie z1(n, w, t);
    ofstream out("z.txt");
    out << z1 << "\n";
    out.close();

    Zanyatie z2;
    ifstream in("z.txt");
    in >> z2;
    cout << z2 << "\n";
    return 0;
}
