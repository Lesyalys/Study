#include <iostream>
#include <string>
#include "Schedule.h"
#include "Lesson.h"

using namespace std;

int main()
{
    int countCopies;
    cout << "-=-=-=-=-=-=-=-=-=-=-= Step 1" << endl;
    Schedule s1;
    Schedule s2("123", "Main Campus");
    Schedule s3(s2);

    cout << "-=-=-=-=-=-=-=-=-=-=-= Step 2" << endl;
    Lesson l1;
    Lesson l2("Mathematics", "Monday", "09:00");

    cout << "-=-=-=-=-=-=-=-=-=-=-= Step 3" << endl;

    s1.addLessonWithParams("Physics", "Tuesday", "10:00");

    cout << "Enter number of copies to create: ";
    cin >> countCopies;

    // Очищ буфер после cin >>
    cin.ignore();

    s2.addCopiedLessons(l2, countCopies);

    cout << "-=-=-=-=-=-=-=-=-=-=-= End" << endl;

    return 0;
}