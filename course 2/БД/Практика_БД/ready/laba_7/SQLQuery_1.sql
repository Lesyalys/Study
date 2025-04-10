--1. ������� ������������ ��������� ���������� ��������, ������� ��������
--������ � �������� ������ 500 ��. ��. 
--� � �������� ������ 5 ���. ��. ��.:
DECLARE @SmallArea FLOAT = 500000;   
DECLARE @LargeArea FLOAT = 5000000;   


WITH SmallCountries AS (
    SELECT *
    FROM ������
    WHERE ������� < @SmallArea
),

LargeCountries AS (
    SELECT *
    FROM ������
    WHERE ������� > @LargeArea
)

SELECT * FROM SmallCountries
UNION
SELECT * FROM LargeCountries
ORDER BY ������� DESC;