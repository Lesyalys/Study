<!-- 1.Сделайте функцию, которая вернет текущий день недели словом. -->
<?php
function getCurrentDayOfWeek()
{
    $days = [
        'воскресенье',
        'понедельник',
        'вторник',
        'среда',
        'четверг',
        'пятница',
        'суббота'
    ];

    $dayNumber = date('w');
    return $days[$dayNumber];
}
echo getCurrentDayOfWeek();
?>