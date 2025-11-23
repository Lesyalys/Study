<!-- Дана форма с инпутом. В инпут вводится дата.
После отправки формы определите, была уже дата в текущем году. Результат выведите в абзац. -->
<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['date'])) {
    $inputDate = $_POST['date'];
    $currentYear = date('Y');
    $inputYear = date('Y', strtotime($inputDate));

    if ($inputYear != $currentYear) {
        echo "<p>Дата $inputDate не в текущем году ($inputYear год)</p>";
    } else {
        $currentTimestamp = strtotime(date('Y-m-d'));
        $inputTimestamp = strtotime($inputDate);

        if ($inputTimestamp < $currentTimestamp) {
            echo "<p>Дата $inputDate уже прошла в этом году</p>";
        } elseif ($inputTimestamp > $currentTimestamp) {
            echo "<p>Дата $inputDate еще наступит в этом году</p>";
        } else {
            echo "<p>Дата $inputDate - это сегодня!</p>";
        }
    }
}
?>

<form method="POST">
    <input type="date" name="date" required>
    <button type="submit">Проверить</button>
</form>