// lab6_operators.cpp
#include <iostream>
#include <string>
using namespace std;

class Zanyatie
{
    string name;

public:
    Zanyatie(const string &n = "Default") : name(n) {}
    void print() const { cout << name << "\n"; }
};

class Raspisanie
{
    Zanyatie *arr[10];
    int count;

public:
    Raspisanie() : count(0) {}
    // operator + adds given Zanyatie pointer
    Raspisanie &operator+(Zanyatie *z)
    {
        if (count < 10)
            arr[count++] = z;
        return *this;
    }
    // prefix ++ : add default
    Raspisanie &operator++()
    {
        if (count < 10)
            arr[count++] = new Zanyatie();
        return *this;
    }
    // postfix ++
    Raspisanie operator++(int)
    {
        Raspisanie tmp = *this;
        ++(*this);
        return tmp;
    }
    Zanyatie *operator[](int i)
    {
        if (i >= 0 && i < count)
            return arr[i];
        return nullptr;
    }
    int size() const { return count; }
    friend ostream &operator<<(ostream &os, const Raspisanie &r)
    {
        os << "Raspisanie with " << r.count << " items";
        return os;
    }
};

int main()
{
    Raspisanie r;
    Zanyatie *z1 = new Zanyatie("Math");
    r + z1; // add
    ++r;    // add default
    r++;    // add default (postfix)
    cout << r << "\n";
    for (int i = 0; i < r.size(); ++i)
        r[i]->print();
    // cleanup created defaults (in real program manage memory or use smart pointers)
    delete z1;
    return 0;
}
