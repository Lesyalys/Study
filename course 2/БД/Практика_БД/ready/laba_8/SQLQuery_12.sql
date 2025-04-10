--12.������� �������� ������ � ���������� ���������� ����� ����� � ���������� �������� �� ������ ����������.

WITH MinAreaCountries AS (
    SELECT 
        ���������,
        MIN(�������) AS ������������������
    FROM 
        ������
    GROUP BY 
        ���������
),
CountriesWithMinArea AS (
    SELECT 
        S.��������,
        S.���������,
        S.���������,
        S.�������
    FROM 
        ������ S
    JOIN 
        MinAreaCountries M ON S.��������� = M.��������� AND S.������� = M.������������������
)
SELECT 
    ��������,
    ���������,
    ���������
FROM 
    CountriesWithMinArea
WHERE 
    ��������� = (
        SELECT MAX(���������) 
        FROM CountriesWithMinArea
    );