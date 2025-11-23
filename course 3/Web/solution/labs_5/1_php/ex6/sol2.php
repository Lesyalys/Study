<?php
$arr = [
    ['href' => 'page1.html', 'text' => 'text1'],
    ['href' => 'page2.html', 'text' => 'text2'],
    ['href' => 'page3.html', 'text' => 'text3'],
];

echo "<ul>\n";
foreach ($arr as $item) {
    echo "\t<li><a href=\"{$item['href']}\">{$item['text']}</a></li>\n";
}
echo "</ul>";
?>