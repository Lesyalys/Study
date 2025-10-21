#include <iostream>
#include <string>
using namespace std;

// Дополнительный класс - Занятие
class Zanyatie
{
    string name;
    string day;
    string time;

public:
    Zanyatie() : name("NoName"), day("NoDay"), time("00:00") {}
    Zanyatie(const string &n, const string &d, const string &t) : name(n), day(d), time(t) {}

    string getName() const { return name; }
    void setName(const string &n) { name = n; }
    string getDay() const { return day; }
    string getTime() const { return time; }
    void print() const
    {
        cout << name << " | " << day << " | " << time << endl;
    }
};

// Основной класс - Расписание
class Raspisanie
{
    string schoolNumber;
    string address;
    Zanyatie arr[20];
    int count;

public:
    Raspisanie() : schoolNumber("0"), address("NoAddress"), count(0) {}
    void setSchoolNumber(const string &s) { schoolNumber = s; }
    void setAddress(const string &a) { address = a; }
    void addZanyatie(const Zanyatie &z)
    {
        if (count < 20)
            arr[count++] = z;
    }
    void print() const
    {
        cout << "Raspisanie: " << schoolNumber << ", " << address << endl;
        for (int i = 0; i < count; i++)
        {
            cout << i + 1 << ". ";
            arr[i].print();
        }
    }
};

int main()
{
    Raspisanie r;
    r.setSchoolNumber("School #10");
    r.setAddress("Lenina 1");
    r.addZanyatie(Zanyatie("Math", "Mon", "09:00"));
    r.addZanyatie(Zanyatie("Physics Lab", "Wed", "14:00"));
    r.print();
    return 0;
}
