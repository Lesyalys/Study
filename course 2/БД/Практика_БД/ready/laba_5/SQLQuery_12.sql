--12.������� ������ �����������, 
--� ������� ������� ��������� ����� ����� � ���������� ����� 1 ���. ���. ������ ��� 30 ���. �� ��. ��

DECLARE @COUNTH BIGINT = 1000000;
DECLARE @MIN_DENSITY INT = 30;

SELECT 
    C.���������
FROM 
    ������ AS C
WHERE 
    C.��������� >= @COUNTH
GROUP BY 
    C.���������
HAVING 
    AVG(C.��������� * 1.0 / NULLIF(C.�������, 0)) > @MIN_DENSITY;