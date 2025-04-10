--3. Вывести список стран с площадью меньше 500 кв. км. и с населением меньше
--100 тыс. чел.

DECLARE @Q FLOAT = 500000;   
DECLARE @H BIGINT = 100000;   


WITH W1 AS (
    SELECT *
    FROM Страны AS C
    WHERE C.Площадь < @Q
),

W2 AS (
    SELECT *
    FROM Страны AS C1
    WHERE C1.Население < @H
)

SELECT * FROM W1
UNION
SELECT * FROM W2
ORDER BY Площадь DESC,Население DESC;