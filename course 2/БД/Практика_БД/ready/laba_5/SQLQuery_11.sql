--11.������� ������� ����� �������� ����������� �����

DECLARE @AF VARCHAR(30) = '������';

SELECT 
AVG(CAST(LEN(C.��������)AS FLOAT)) AS 'LEN'
FROM ������ AS C
WHERE C.��������� = @AF
ORDER BY 'LEN' DESC