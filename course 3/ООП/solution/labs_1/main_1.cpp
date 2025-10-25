#include <iostream>
#include <string>
using namespace std;

class ISound
{
public:
    virtual void sound() const = 0;
};

class Max : public ISound
{
    void sound() const override
    {
        cout << "ГРОМКИЙ ЗВУК!!!\n";
    }
};

class Min : public ISound
{
    void sound() const override
    {
        cout << "тихий звук...\n";
    }
};

class Context
{
    ISound *is;

public:
    void Setstategy(ISound *s) { is = s; }
    void play() { is->sound(); }
};

int main()
{
    Max ma;
    Min mi;
    Context c;
    c.Setstategy(&mi);
    c.play();

    c.Setstategy(&ma);
    c.play();
}