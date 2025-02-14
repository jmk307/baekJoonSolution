SELECT A.ID, IFNULL(COUNT(B.PARENT_ID), 0) AS CHILD_COUNT
FROM ECOLI_DATA A
LEFT OUTER JOIN ECOLI_DATA B
ON A.ID = B.PARENT_ID
GROUP BY A.ID, B.PARENT_ID
ORDER BY 1;