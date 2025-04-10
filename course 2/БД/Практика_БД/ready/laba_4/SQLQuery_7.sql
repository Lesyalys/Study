--7. Вывести свою фамилию в одной строке столько раз, сколько вам лет

DECLARE @AGE INT = 23
SELECT REPLICATE('Lysenko',@AGE) AS FIO