<!-- 1. Дано некоторое число. Проверьте, что цифры этого числа расположены по возрастанию. -->
<?php
function isDigitsAscending($number)
{
    $str = (string) $number;

    for ($i = 1; $i < strlen($str); $i++) {
        if ($str[$i] <= $str[$i - 1]) {
            echo "false";
            return false;
        }
    }
    echo "true";
    return true;
}
isDigitsAscending(isset($argv[1]) ? $argv[1] : 1);
?>