// lab15_composite.cpp
#include <iostream>
#include <vector>
#include <memory>
using namespace std;

class Component
{
public:
    virtual ~Component() {}
    virtual void print(int indent = 0) const = 0;
};
class Zanyatie : public Component
{
    string name;

public:
    Zanyatie(string n) : name(n) {}
    void print(int indent = 0) const override { cout << string(indent, ' ') << name << "\n"; }
};
class Raspisanie : public Component
{
    vector<unique_ptr<Component>> children;

public:
    void add(unique_ptr<Component> c) { children.push_back(move(c)); }
    void print(int indent = 0) const override
    {
        cout << string(indent, ' ') << "Raspisanie:\n";
        for (auto &c : children)
            c->print(indent + 2);
    }
};

int main()
{
    auto r = make_unique<Raspisanie>();
    r->add(make_unique<Zanyatie>("Math"));
    auto sub = make_unique<Raspisanie>();
    sub->add(make_unique<Zanyatie>("Lab1"));
    r->add(move(sub));
    r->print();
}
