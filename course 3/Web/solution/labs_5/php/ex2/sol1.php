<!-- Дан массив. Удалите из него элементы с заданным значением. -->
<?php
function removeValueFromArray3($array, $value)
{
    return array_diff($array, [$value]);
}
?>