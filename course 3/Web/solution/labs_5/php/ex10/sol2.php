<!-- 2. Дан текст со знаками препинаний: 'aaa bbb, ccc. Xxx - eee bbb, kkk!' Получите массив слов из такого текста. -->
<?php
function getWordsFromText($text)
{
    $cleanText = preg_replace('/[^\w\s]/u', ' ', $text);

    $words = preg_split('/\s+/', $cleanText, -1, PREG_SPLIT_NO_EMPTY);

    $words = array_filter($words, function ($word) {
        return !empty($word) && !is_numeric($word);
    });

    return array_values($words);
}
?>