<!-- Дана некоторая строка. Найдите позицию первого нуля в строке. -->
<?php
function findFirstZeroPositionShort($string)
{
    return ($pos = strpos($string, '0')) === false ? "Нулей в строке нет" : $pos;
}
?>