--12.������� ������ ���������, �� ������� �� ������ �������� � ��������� ����.

DECLARE @START_DATE DATE = '2015-06-05';
DECLARE @END_DATE DATE = '2015-06-10';

SELECT 
    S.���_�����
    ,S.�������
FROM 
    ������� S
WHERE 
    NOT EXISTS (
        SELECT 1 
        FROM ������� E 
        WHERE E.���_����� = S.���_�����
        AND E.���� BETWEEN @START_DATE AND @END_DATE
    )
ORDER BY 
    S.�������;