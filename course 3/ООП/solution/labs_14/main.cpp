// lab14_factory.cpp
#include <iostream>
#include <string>
#include <memory>
using namespace std;

class Zanyatie
{
public:
    virtual ~Zanyatie() {}
    virtual void print() const = 0;
};
class Lecture : public Zanyatie
{
    string topic;

public:
    Lecture(const string &t) : topic(t) {}
    void print() const override { cout << "Lecture: " << topic << "\n"; }
};
class LabWork : public Zanyatie
{
    string eq;

public:
    LabWork(const string &e) : eq(e) {}
    void print() const override { cout << "Lab: " << eq << "\n"; }
};

unique_ptr<Zanyatie> makeZanyatie(const string &type, const string &param)
{
    if (type == "lecture")
        return make_unique<Lecture>(param);
    if (type == "lab")
        return make_unique<LabWork>(param);
    return nullptr;
}

int main()
{
    auto a = makeZanyatie("lecture", "Linear Algebra");
    auto b = makeZanyatie("lab", "Chemistry Kit");
    a->print();
    b->print();
}
