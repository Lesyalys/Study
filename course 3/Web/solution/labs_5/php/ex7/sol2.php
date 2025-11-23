<!-- 2. Дана форма с текстареа и кнопкой. Юзер вводит текст в форму. После отправки формы запишите введенный текст в какой-нибудь файл. -->

<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['text'])) {
    $userText = trim($_POST['text']);

    if (!empty($userText)) {
        $filename = 'user_data.txt';

        //дату и время к тексту
        $timestamp = date('Y-m-d H:i:s');
        $dataToSave = "[$timestamp]\n$userText\n" . str_repeat('-', 50) . "\n";

        //в файл
        if (file_put_contents($filename, $dataToSave, FILE_APPEND | LOCK_EX)) {
            echo "<p style='color: green;'>Текст успешно сохранен в файл $filename</p>";
        } else {
            echo "<p style='color: red;'>Ошибка при сохранении текста</p>";
        }
    } else {
        echo "<p style='color: orange;'>Пожалуйста, введите текст</p>";
    }
}
?>

<form method="POST">
    <textarea name="text" rows="5" cols="50" placeholder="Введите ваш текст..."></textarea><br><br>
    <button type="submit">Сохранить в файл</button>
</form>