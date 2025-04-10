--10.������� ������ 5 ����� � ���� ���������� � ����� ����� ���������� ������
--�� ������ ����������, ���������������� �� ����������� ���� ���������� ������:

DECLARE @DATE INT

SET @DATE = 1889;

WITH FILTERYER AS (
 SELECT * 
 FROM ��������� as A
 WHERE A.���_����������_������ = @DATE),

 NO_FILTERYER AS (
	SELECT TOP 5 *
	FROM ��������� as A
	ORDER BY A.���_����������_������ ASC
	)

SELECT 
	N.*,
	CASE WHEN N.���_����������_������ = @DATE THEN '��'
	ELSE '���'
	END
FROM NO_FILTERYER as N
LEFT JOIN FILTERYER AS F ON N.��� = F.���

UNION ALL

SELECT 
	F.*
	,'��'
FROM FILTERYER AS F