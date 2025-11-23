<!-- 1.Дан текст со знаками препинаний. Получите массив предложений этого текста. -->
<?php
function getSentences($text)
{
    $sentences = preg_split('/(?<=[.!?])\s+/', $text, -1, PREG_SPLIT_NO_EMPTY);

    $sentences = array_map('trim', $sentences);
    $sentences = array_filter($sentences);

    return $sentences;
}
print_r(getSentences(isset($argv[1]) ? $argv[1] : "Привет!"));
?>