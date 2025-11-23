<!-- Дана некоторая строка. Найдите позицию первого нуля в строке. -->
<?php
function findFirstZeroPositionShort($string)
{
    $pos = strpos($string, '0');
    return $pos === false ? "Нулей в строке нет" : $pos;
}

$result = findFirstZeroPositionShort(isset($argv[1]) ? $argv[1] : "");
echo $result . "\n";
?>