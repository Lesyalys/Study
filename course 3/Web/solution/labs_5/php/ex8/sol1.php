<!-- Дан некоторый URL:... -->
<?php
$url = 'http://test.com/dir1/dir2/dir3/page.html';

$domain = parse_url($url, PHP_URL_HOST);
echo $domain;
?>