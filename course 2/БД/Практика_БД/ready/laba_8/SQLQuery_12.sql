--12.Вывести название страны с наибольшим населением среди стран с наименьшей площадью на каждом континенте.

WITH MinAreaCountries AS (
    SELECT 
        Континент,
        MIN(Площадь) AS МинимальнаяПлощадь
    FROM 
        Страны
    GROUP BY 
        Континент
),
CountriesWithMinArea AS (
    SELECT 
        S.Название,
        S.Континент,
        S.Население,
        S.Площадь
    FROM 
        Страны S
    JOIN 
        MinAreaCountries M ON S.Континент = M.Континент AND S.Площадь = M.МинимальнаяПлощадь
)
SELECT 
    Название,
    Континент,
    Население
FROM 
    CountriesWithMinArea
WHERE 
    Население = (
        SELECT MAX(Население) 
        FROM CountriesWithMinArea
    );