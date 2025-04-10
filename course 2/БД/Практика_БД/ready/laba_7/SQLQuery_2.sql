--2. ������� ������ ����� � �������� ������ 1 ���. ��. ��., ��������� ������
--� ���������� ������ 100 ���. ���.:

DECLARE @Q FLOAT = 1000000;   
DECLARE @H BIGINT = 10000000;   


WITH W1 AS (
    SELECT *
    FROM ������ AS C
    WHERE C.������� > @Q
),

W2 AS (
    SELECT *
    FROM ������ AS C1
    WHERE C1.��������� < @H
)

SELECT * FROM W1
EXCEPT
SELECT * FROM W2
ORDER BY ������� DESC,��������� DESC;