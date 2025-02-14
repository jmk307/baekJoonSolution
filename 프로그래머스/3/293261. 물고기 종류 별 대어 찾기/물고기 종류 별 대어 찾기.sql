SELECT A.ID, B.FISH_NAME, A.LENGTH
FROM FISH_INFO A
LEFT OUTER JOIN FISH_NAME_INFO B
ON A.FISH_TYPE = B.FISH_TYPE
WHERE A.LENGTH = (SELECT MAX(C.LENGTH) FROM FISH_INFO C WHERE A.FISH_TYPE = C.FISH_TYPE)
ORDER BY 1;