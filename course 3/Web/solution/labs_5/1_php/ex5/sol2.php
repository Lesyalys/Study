<!-- По заходу на страницу выведите, сколько дней осталось до Нового Года. -->
<?php
function daysUntilNewYear()
{
    $currentDate = new DateTime();
    $nextYear = (int) $currentDate->format('Y') + 1;
    $newYearDate = new DateTime("$nextYear-01-01");
    $interval = $currentDate->diff($newYearDate);

    return $interval->days;
}

$daysLeft = daysUntilNewYear();
echo "До Нового Года осталось: $daysLeft дней\n";
?>