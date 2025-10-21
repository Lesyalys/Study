// lab10_containers.cpp
#include <iostream>
#include <vector>
#include <list>
#include <set>
#include <algorithm>
#include <string>
using namespace std;

struct Zanyatie
{
    string name;
    string day;
    string time;
    Zanyatie(const string &n = "No", const string &d = "No", const string &t = "00:00") : name(n), day(d), time(t) {}
    bool operator<(const Zanyatie &other) const { return name < other.name; } // для set
    void print() const { cout << name << " | " << day << " | " << time << "\n"; }
};

int main()
{
    // vector
    vector<Zanyatie> v;
    v.emplace_back("Math", "Mon", "09:00");
    v.emplace_back("Physics", "Wed", "11:00");
    // list
    list<Zanyatie> l;
    l.emplace_back("Chemistry", "Tue", "10:00");
    // set
    set<Zanyatie> s;
    s.insert(Zanyatie("Biology", "Thu", "13:00"));
    // Просмотр
    cout << "Vector:\n";
    for (auto &x : v)
        x.print();
    cout << "List:\n";
    for (auto &x : l)
        x.print();
    cout << "Set:\n";
    for (auto &x : s)
        x.print();
    // Сортировка вектора по времени (простая)
    sort(v.begin(), v.end(), [](const Zanyatie &a, const Zanyatie &b)
         { return a.time < b.time; });
    cout << "Sorted Vector by time:\n";
    for (auto &x : v)
        x.print();
    return 0;
}