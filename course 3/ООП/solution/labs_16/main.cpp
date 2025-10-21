// lab16_mvc.cpp
#include <iostream>
#include <string>
#include <vector>
using namespace std;

// Model
class ScheduleModel
{
    vector<string> items;

public:
    void add(const string &s) { items.push_back(s); }
    const vector<string> &getAll() const { return items; }
};

// View
class ScheduleView
{
public:
    void print(const ScheduleModel &m) const
    {
        cout << "--- Schedule View ---\n";
        for (auto &s : m.getAll())
            cout << s << "\n";
    }
};

// Controller
class ScheduleController
{
    ScheduleModel &model;
    ScheduleView &view;

public:
    ScheduleController(ScheduleModel &mo, ScheduleView &v) : model(mo), view(v) {}
    void addItem(const string &s)
    {
        model.add(s);
        view.print(model);
    }
};

int main()
{
    ScheduleModel model;
    ScheduleView view;
    ScheduleController ctrl(model, view);
    ctrl.addItem("Math Mon 09:00");
    ctrl.addItem("Physics Lab Wed 14:00");
}
