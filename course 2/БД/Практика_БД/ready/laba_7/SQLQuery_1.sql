--1. Вывести объединенный результат выполнения запросов, которые выбирают
--страны с площадью меньше 500 кв. км. 
--и с площадью больше 5 млн. кв. км.:
DECLARE @SmallArea FLOAT = 500000;   
DECLARE @LargeArea FLOAT = 5000000;   


WITH SmallCountries AS (
    SELECT *
    FROM Страны
    WHERE Площадь < @SmallArea
),

LargeCountries AS (
    SELECT *
    FROM Страны
    WHERE Площадь > @LargeArea
)

SELECT * FROM SmallCountries
UNION
SELECT * FROM LargeCountries
ORDER BY Площадь DESC;