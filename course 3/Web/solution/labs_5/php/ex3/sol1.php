<!-- 1. Дано некоторое число. Проверьте, что цифры этого числа расположены по возрастанию. -->
<?php
function isDigitsAscending($number)
{
    $str = (string) $number;

    for ($i = 1; $i < strlen($str); $i++) {
        if ($str[$i] <= $str[$i - 1]) {
            return false;
        }
    }

    return true;
}
?>