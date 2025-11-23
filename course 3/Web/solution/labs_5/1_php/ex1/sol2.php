<!-- Дано число. Проверьте, четное оно или нет. -->
<?php
function solution1($args)
{
    echo $args % 2 == 0 ? "true" : "false";
}
solution1(isset($argv[1]) ? $argv[1] : 0);
?>