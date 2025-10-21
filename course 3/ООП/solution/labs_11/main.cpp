// lab11_algorithms.cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Zanyatie
{
    string name, day, time;
    Zanyatie(string n = "", string d = "", string t = "") : name(n), day(d), time(t) {}
    void print() const { cout << name << " " << day << " " << time << "\n"; }
};

int main()
{
    vector<Zanyatie> v = {{"Math", "Mon", "09:00"}, {"Physics Lab", "Wed", "14:00"}, {"History", "Mon", "11:00"}};
    // найти первое занятие в понедельник
    auto it = find_if(v.begin(), v.end(), [](const Zanyatie &z)
                      { return z.day == "Mon"; });
    if (it != v.end())
    {
        cout << "Found Mon: ";
        it->print();
    }
    // отсортировать по имени
    sort(v.begin(), v.end(), [](const Zanyatie &a, const Zanyatie &b)
         { return a.name < b.name; });
    cout << "Sorted by name:\n";
    for (auto &z : v)
        z.print();
    return 0;
}
