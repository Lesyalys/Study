<!-- Дан массив. Удалите из него элементы с заданным значением. -->
<?php
function removeValueFromArray3($array, $value)
{
    echo "array: " . implode(', ', $array) . " value: " . $value . "\n";
    $result = array_diff($array, [$value]);
    echo "result: " . implode(', ', $result) . "\n";
    return $result;
}

removeValueFromArray3([1, 2, 3, 4, 5], isset($argv[1]) ? $argv[1] : 0);
?>