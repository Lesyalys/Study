--11.Вывести среднюю длину названии Африканских стран

DECLARE @AF VARCHAR(30) = 'Африка';

SELECT 
AVG(CAST(LEN(C.Название)AS FLOAT)) AS 'LEN'
FROM Страны AS C
WHERE C.Континент = @AF
ORDER BY 'LEN' DESC