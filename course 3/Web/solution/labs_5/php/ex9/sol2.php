<!-- 2.Всем ссылкам, ведущим на чужой сайт, добавьте target="_blank". -->
<?php
function addBlankTarget($html)
{
    // Регулярное выражение для поиска ссылок
    $pattern = '/<a\s+(?:[^>]*?\s+)?href=(["\'])(https?:\/\/[^\/]*?)(?!\1)[^>]*>/i';

    $result = preg_replace_callback($pattern, function ($matches) {
        $currentTag = $matches[0];

        if (strpos($currentTag, 'target=') === false) {
            return substr($currentTag, 0, -1) . ' target="_blank">';
        }

        return $currentTag;
    }, $html);

    return $result;
}
?>