// lab12_lambda.cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Zanyatie
{
    string name, day, time;
    Zanyatie(string n, string d, string t) : name(n), day(d), time(t) {}
};

int main()
{
    vector<Zanyatie> v = {{"Math", "Mon", "09:00"}, {"Physics Lab", "Wed", "14:00"}, {"History", "Mon", "11:00"}};
    // lamba фильтр: все занятия по понедельникам
    vector<Zanyatie> monday;
    copy_if(v.begin(), v.end(), back_inserter(monday), [](const Zanyatie &z)
            { return z.day == "Mon"; });
    cout << "Monday classes:\n";
    for (auto &c : monday)
        cout << c.name << " " << c.time << "\n";
    // лямбда для преобразования: добавить префикс к имени
    for_each(v.begin(), v.end(), [](Zanyatie &z)
             { z.name = "[Class] " + z.name; });
    cout << "After transform:\n";
    for (auto &c : v)
        cout << c.name << "\n";
    return 0;
}
