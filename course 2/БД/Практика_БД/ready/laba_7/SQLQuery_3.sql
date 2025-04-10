--3. ������� ������ ����� � �������� ������ 500 ��. ��. � � ���������� ������
--100 ���. ���.

DECLARE @Q FLOAT = 500000;   
DECLARE @H BIGINT = 100000;   


WITH W1 AS (
    SELECT *
    FROM ������ AS C
    WHERE C.������� < @Q
),

W2 AS (
    SELECT *
    FROM ������ AS C1
    WHERE C1.��������� < @H
)

SELECT * FROM W1
UNION
SELECT * FROM W2
ORDER BY ������� DESC,��������� DESC;