<!-- 1. Сделайте функцию, которая параметром будет принимать английское существительное в единственном числе и возвращать его во множественном числе. -->
<?php
function pluralize($word)
{
    // Исключения и особые случаи
    $exceptions = [
        'man' => 'men',
        'woman' => 'women',
        'child' => 'children',
        'person' => 'people',
        'foot' => 'feet',
        'tooth' => 'teeth',
        'goose' => 'geese',
        'mouse' => 'mice',
        'louse' => 'lice',
        'ox' => 'oxen',
        'die' => 'dice',
        'penny' => 'pence',

        // Неизменяемые существительные
        'sheep' => 'sheep',
        'deer' => 'deer',
        'fish' => 'fish',
        'species' => 'species',
        'aircraft' => 'aircraft',
        'series' => 'series',
    ];

    // исключения
    $lowerWord = strtolower($word);
    if (isset($exceptions[$lowerWord])) {
        return $exceptions[$lowerWord];
    }

    // Правила преобразования
    $rules = [
        '/(quiz)$/i' => '$1zes',
        '/([m|l])ouse$/i' => '$1ice',
        '/(matr|vert|ind)(ix|ex)$/i' => '$1ices',
        '/(x|ch|ss|sh)$/i' => '$1es',
        '/([^aeiouy]|qu)y$/i' => '$1ies',
        '/(hive)$/i' => '$1s',
        '/(?:([^f])fe|([lr])f)$/i' => '$1$2ves',
        '/sis$/i' => 'ses',
        '/([ti])um$/i' => '$1a',
        '/(buffal|tomat)o$/i' => '$1oes',
        '/(bu)s$/i' => '$1ses',
        '/(alias|status)$/i' => '$1es',
        '/(octop|vir)us$/i' => '$1i',
        '/(ax|test)is$/i' => '$1es',
        '/s$/i' => 's',
    ];

    // Применяем правила
    foreach ($rules as $pattern => $replacement) {
        if (preg_match($pattern, $word)) {
            return preg_replace($pattern, $replacement, $word);
        }
    }

    return $word . 's';
}
echo pluralize(isset($argv[1]) ? $argv[1] : '');
?>