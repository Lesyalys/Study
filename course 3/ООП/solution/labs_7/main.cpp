// lab7_templates.cpp
#include <iostream>
#include <vector>
#include <string>
using namespace std;

// шаблонный контейнер-обёртку для хранения Zanyati
template <typename T>
class SimpleContainer
{
    vector<T> data;

public:
    void add(const T &v) { data.push_back(v); }
    size_t size() const { return data.size(); }
    const T &get(size_t i) const { return data.at(i); }
};

class Zanyatie
{
    string name;

public:
    Zanyatie(const string &n = "No") : name(n) {}
    string getName() const { return name; }
};

int main()
{
    SimpleContainer<Zanyatie> sc;
    sc.add(Zanyatie("Math"));
    sc.add(Zanyatie("Physics Lab"));
    for (size_t i = 0; i < sc.size(); ++i)
        cout << sc.get(i).getName() << "\n";
}
