<!-- 2. Сделайте функцию, которая параметром будет получать дату, а возвращать день недели словом, соответствующий этой дате. -->
<?php
function getDayOfWeekFromDate($date)
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

    $timestamp = strtotime($date);

    if ($timestamp === false) {
        return "Неверный формат даты";
    }

    $dayNumber = date('w', $timestamp); // 0 - воскресенье, 1 - понедельник, etc.

    return $days[$dayNumber];
}
?>