--Выбор всех столбцов таблицы, сгрупированных по длинне фамилий

SELECT COUNT(*) AS 'ALL'
FROM Список_жильцов AS C
GROUP BY (LEN(FIO))

