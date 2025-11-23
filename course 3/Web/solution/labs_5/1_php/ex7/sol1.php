<!-- 1. Дан текстовый файл. Получите количество символов в нем. -->
<?php
function countCharactersInFile($filename)
{
    if (!file_exists($filename)) {
        return "Файл $filename не существует";
    }

    // содержимое файла
    $content = file_get_contents($filename);

    if ($content === false) {
        return "Ошибка при чтении файла";
    }
    return strlen($content);
}
echo countCharactersInFile(isset($argv[1]) ? $argv[1] : "");
?>