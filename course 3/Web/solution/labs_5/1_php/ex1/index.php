<!-- Дано число. Проверьте, отрицательное оно или нет. Выведите об этом информацию в консоль -->
<?php
function solution1($args)
{
    echo $args < 0 ? "true" : "false";
}
solution1(isset($argv[1]) ? $argv[1] : 0);
?>