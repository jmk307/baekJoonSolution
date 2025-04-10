SELECT C.AUTHOR_ID, C.AUTHOR_NAME, B.CATEGORY, SUM(A.SALES * B.PRICE)  AS TOTAL_SALES
FROM BOOK_SALES A
INNER JOIN BOOK B
ON A.BOOK_ID = B.BOOK_ID
INNER JOIN AUTHOR C
ON B.AUTHOR_ID = C.AUTHOR_ID
WHERE DATE_FORMAT(A.SALES_DATE, '%Y-%m') = '2022-01'
GROUP BY B.AUTHOR_ID, B.CATEGORY
ORDER BY 1, 3 DESC;